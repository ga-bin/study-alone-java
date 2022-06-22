package com.yedam.app.members;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class MemberDAO extends DAO {
	// 싱글톤
	private static MemberDAO mDAO = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if (mDAO == null) {
		mDAO = new MemberDAO();
		}
		return mDAO;
	}

	
	// CRUD
	public Member selectOne(Member member) {
		Member loginInfo = null;
		try {
			connection();
			String sql = "SELECT * FROM members WHERE member_id = '" + member.getMemberId() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				// rs.next가 돌아간다는 것은 아이디는 존재
				if (rs.getString("member_password").equals(member.getMemberPassword())) {
					// 비밀번호 일치 -> 로그인 성공
					member.setMemberRole(rs.getInt("member_role"));
					loginInfo = new Member();
					loginInfo.setMemberId(rs.getString("member_id"));
					loginInfo.setMemberPassword(rs.getString("member_password"));
					loginInfo.setMemberRole(rs.getInt("member_role"));
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					member = null;
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
 	} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return loginInfo;
		// 나중에 반환되는 값이 null인지에 따라서 로그인 여부 확인하는 메소드 만들 것
	}
}
