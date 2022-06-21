package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ReceivingGoodsDAO extends DAO {
	// 싱글톤
	private static ReceivingGoodsDAO rDAO = null;
	
	private ReceivingGoodsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ReceivingGoodsDAO getInstance() {
		if (rDAO == null) {
			rDAO = new ReceivingGoodsDAO();
		}
		return rDAO;
	}
	
	// 테이블 구조상 수정과 삭제 불가(기본키 설정 안해서 같은 구조의 행이 여러개 들어올 수 있기 때문)
	// 테이블에서 수정과 삭제를 염두해두는 경우 무조건 기본키를 만들어줘야한다.
	
	// 등록
	public void insert(DealInfo info) {
		try {
			connection();
			String sql = "INSERT INTO reciving_goods (product_id, product_amount) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0 ) {
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
	
	// 단건조회 - 입고내역 존재유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connection();
			String sql = "SELECT COUNT(*) AS count FROM receiving_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				// count함수는 값이 없어도 무조건 0이들어감
				if(rs.getInt("count") > 0) {
				isSelected = true;
				}
			}
		} catch(SQLException e) {
			
		} finally {
			disconnection();
		}
		return isSelected;
	}
	
	// 단건조회 - 입고수량 
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connection();
			String sql = "SELECT NVL(SUM(product_amount), 0) AS sum FROM receiving_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				amount = rs.getInt("sum");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return amount;
	}
	
	// 전체조회 - 현재까지 입고된 내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount"
					+ "FROM receiving_goods r JOIN products p"
					+ "ON p.product_id = r.product_id"
					+ "ORDER BY r.deal_date";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				
				list.add(info);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	
		return list;
	}
	// 전체조회 - 해당 날짜에 입고된 내역
	public List<DealInfo> selectAll(Date dealDate) {
		List<DealInfo> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount"
					+ "FROM receiving_goods r JOIN products p"
					+ "WHERE deal_date = ? " 
					+ "ON p.product_id = r.product_id"
					+ "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, dealDate);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				
				list.add(info);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	
 	// 전체조회 - 해당 제품의 입고된 내역
	public List<DealInfo> selectAll(int productId) {
		List<DealInfo> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount"
					+ "FROM receiving_goods r JOIN products p"
					+ "WHERE product_id = ? "
					+ "ON p.product_id = r.product_id"
					+ "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				
				list.add(info);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	
		return list;
	}
	
}

