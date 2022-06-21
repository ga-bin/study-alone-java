package com.yedam.app.deal;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class ReceivingGoodsDAO extends DAO {
	private static ReceivingGoodsDAO rDAO = null;
	
	private ReceivingGoodsDAO() {
		
	}
	
	public static ReceivingGoodsDAO getInstance() {
		if (rDAO == null) {
			rDAO = new ReceivingGoodsDAO();
		} 
		return rDAO;
	}
	
	public void insert(DealInfo info) {
		try {
			connection();
			String sql = "INSERT INTO receiving_goods (product_id, product_amount) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않 았습니다.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	
	// 입고 내역 존재 유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connection();
			String sql = "SELECT COUNT(*) AS count FROM receiving_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				if (rs.getInt("count") > 0) {
					isSelected = true;
				}
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return isSelected;
	}
	
	// 입고 수량
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connection();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return amount;
	}
}
