package com.yedam.app.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class BookDAO extends DAO{
	// 싱글톤
	private static BookDAO bDAO = null;
	private BookDAO() {
		
	}
	
	public static BookDAO getInstance() {
		if (bDAO == null) {
			bDAO = new BookDAO();
		}
		
		return bDAO;
	}
	
	// 전체조회
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT * FROM bookrefo ORDER BY book_name";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setCanBorrow(rs.getInt("can_borrow"));
				
				list.add(book);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	
	// 단건 조회
	public Book selectOne(String productName) {
		Book book = null;
		try {
			connection(); 
			String sql = "SELECT * FROM bookrefo WHERE book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setBookContent(rs.getString("book_content"));
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setCanBorrow(rs.getInt("can_borrow"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
			
		}
		
		return book;
		
	}
	
	// 특정 글자 포함 내용 검색
	public List<Book> selectContent(String bookContent) {
		List<Book> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT * FROM bookrefo WHERE book_content LIKE '%" + bookContent + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Book book = new Book();
				book.setBookContent(rs.getString("book_content"));
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setCanBorrow(rs.getInt("can_borrow"));
				
				list.add(book);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
			
		}
		return list;
	}
	
	// 대여가능한 책들의 정보 출력
	public List<Book> canBorrow() {
		List<Book> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT * FROM bookrefo WHERE can_borrow = 0";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookContent(rs.getString("book_content"));
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setCanBorrow(rs.getInt("can_borrow"));
				list.add(book);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	
	
	// 책 대여
	public void updateBorrowBook(String bookName) {
		try {
			connection(); 
			String sql = "UPDATE bookrefo SET can_borrow = ? WHERE book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1); // 1대여불가능(대여중)
			pstmt.setString(2, bookName);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 대여되었습니다.");
			} else {
				System.out.println("정상적으로 대여되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	
	// 책 반납
	public void updateReturnBook(String bookName) {
		try {
			connection(); 
			String sql = "UPDATE bookrefo SET can_borrow = ? WHERE book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0); // 0대여가능
			pstmt.setString(2, bookName);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 반납되었습니다.");
			} else {
				System.out.println("정상적으로 반납되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	// 책 등록
	public void insertBook(Book book) {
		try {
			connection();
			String sql = "INSERT INTO bookrefo (book_name, book_writer, book_content) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	// 종료
	
}
