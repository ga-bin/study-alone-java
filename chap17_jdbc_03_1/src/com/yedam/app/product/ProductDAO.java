package com.yedam.app.product;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.common.Info;

public class ProductDAO extends DAO {
	// 싱글톤
	private static ProductDAO productDAO = null;

	private ProductDAO() {

	}

	public static ProductDAO getInstance() {
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	// 상품 입력받아서 넣기
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductAmount());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 상품 입력받아서 업데이트 하기 - 가격
	// 어떤제품 업데이트할지 받기
	// 가격업데이트하기
	// 상품명 업데이트하기

	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price = ?, WHERE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setString(2, product.getProductName());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void update(Product product, Info info) {
		try {
			connect();
			String sql = "UPDATE product SET product_name = ? WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getProductName());
			pstmt.setString(2, product.getProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
	}

	// 상품 입력받아서 삭제하기
	public void delete(String productName) {
		try {
			connect();
			String sql = "DELETE FROM productName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public Product selectOne(int productId) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT FROM product WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductAmount(rs.getInt("product_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}

	public Product selectOne(String productName) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name = " + productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}

	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				
				list.add(product);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
				disconnect();
		}
	
		return list;
		
	}

}
