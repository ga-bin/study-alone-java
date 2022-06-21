package com.yedam.app.history;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO {
	// 싱글톤
	private static HistoryDAO historyDAO = null;
	
	private HistoryDAO() {
		
	}
	
	public static HistoryDAO getInstance() {
		if (historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}
	
	public void insert(History history) {
		try {
			connect();
			String str = "INSERT INTO product_history VALUES (?,?,?)";
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public void update(History history) {
		try {
			connect();
			String str = "UPDATE product_history SET product_amount = ?, WHERE product_id = ?";
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
			int result = pstmt.executeUpdate();
			
			if (result > 0 ) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
	}
	
	public void delete(int productId) {
		try {
			connect();
			String str = "DELETE FROM productId = ?" + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(str);
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
	}
	
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("sum");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
		return result;
	}
	
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id = ? AND product_category = 2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("sum");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
		return result;
	}
	
	// 전체 상품의 각 재고
	public Map selectAll() {
		// map<product_id, product_amount>
		Map<Integer, Integer> list = new HashMap<>();
		try {
			connect();
			String sql = "SELECT product_id, product_category, SUM(product_amount) as amount FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			
			while(rs.next()) {
				int category = rs.getInt("product_category");
				if (category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("product_amount"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("product_amount"));	
				}
			}
			
			Set<Integer> keySet = inList.keySet();
			for (int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if (outAmount != null) {
					list.put(key, inAmount-outAmount);
				} else {
					list.put(key, inAmount);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
