package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class TakeoutGoodsDAO extends DAO {
	private static TakeoutGoodsDAO tDAO = null;
	
	private TakeoutGoodsDAO() {
		
	}
	
	public static TakeoutGoodsDAO getInstance() {
		if (tDAO == null) {
			tDAO = new TakeoutGoodsDAO();
		}
		return tDAO;
	}
	
	// 출고상품 등록
	public void insert(DealInfo info) {
		try {
			connection();
			String sql = "INSERT INTO take_out_goods (product_id, product_amount) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
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
	
	// 출고 내역 존재 여부
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			String sql = "SELECT COUNT(*) AS count FROM take_out_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt("count") > 0) {
					isSelected = true;
				}
			}
			connection();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return isSelected;
	}
	
	// 단건 조회 출고 수량
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connection();
			String sql = "SELECT NVL(SUM(product_amount), 0) as amount FROM take_out_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				amount = rs.getInt("amount");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return amount;
	}
	
	//현재 출고 내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount"
					+ " FROM take_out_goods t JOIN products p"
					+ " ON t.product_id = p.product_id"
					+ " ORDER BY t.deal_date";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductAmount(rs.getInt("product_amount"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				
				list.add(info);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	
	// 해당 날짜 출고 내역
	public List<DealInfo> selectAll(Date date) {
		List<DealInfo> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount"
					+ "FROM take_out_goods t JOIN products p"
					+ "WHERE deal_date = ? "
					+ "ON t.product_id = p.product_id"
					+ "ORDER BY t.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductAmount(rs.getInt("product_amount"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				
				list.add(info);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	
	// 해당 상품 출고 내역
	public List<DealInfo> selectAll(int productId) {
		List<DealInfo> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount"
					+ "FROM take_out_goods t JOIN products p"
					+ "WHERE product_id = ? "
					+ "ON t.product_id = p.product_id"
					+ "ORDER BY t.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductAmount(rs.getInt("product_amount"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				
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
