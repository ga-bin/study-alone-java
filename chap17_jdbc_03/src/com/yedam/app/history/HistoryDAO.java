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
	
	// CRUD
	
	// 등록
	public void insert(History history) {
		try {
			connect();
			String sql = "INSERT INTO product_history VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
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
	
	// 수정 - 입고, 출고는 건드리지 않고 단순히 수량만 수정만 하는것으로
	public void update(History history) {
		try {
			connect();
			String sql = "UPDATE product_history SET product_amount = ? where product_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 삭제
	public void deleteOne(int productId) {
		try {
			connect();
			String sql = "DELETE FROM productId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 입고삭제
//	public void deleteInput(History history) {
//		try {
//			connect();
//			String sql = "DELETE FROM history "
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//	}
//	
//	// 출고삭제
//	public void delteOutput(History history) {
//		
//	}
	// 단건조회 - 각 상품에 대한 입고
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("sum");
				// rs.getInt(1), rs.getInt("SUM(product_amount)")
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	// 단건조회 - 각 상품에 대한 출고
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
				// rs.getInt(1), rs.getInt("SUM(product_amount)")
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	// 전체조회 - 전체 상품의 각 재고
	public Map selectAll() {
		Map<Integer, Integer> list = new HashMap<>();
		// 입고량 - 출고량
		try {
			connect();
			// 각 제품에 대한 입고량 출고량 전부 가지고옴
			String sql = "SELECT product_id, product_category, SUM(product_amount) as amount FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			while (rs.next()) {
				// 입고량은 입고량대로 출고량은 출고량대로 분리하는 작업
				int category = rs.getInt("product_category");
				if (category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("amount"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}
			}
			
			Set<Integer> keySet = inList.keySet();
			for (int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if(outAmount != null) {
					list.put(key, (inAmount - outAmount));
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
