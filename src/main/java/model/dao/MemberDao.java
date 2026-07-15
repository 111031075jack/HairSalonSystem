package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.Member;
import model.util.DBUtil;

public class MemberDao {

	// === Singleton 單例模式 ===
	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	/**
	 * 會員註冊
	 * */
	public void register(Member member) {
		String sql = """
				insert into member(username, password)
				values(?, ?)
				""";
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	/**
	 * 登入
	 * */
	public Member login(String username, String password) {
		String sql = """
				select id, username, password, create_time from member where username = ?
				""";
		
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, username);
			
			try(ResultSet rs = pstmt.executeQuery()){
				
				// 1. 查無該使用者
				while(!rs.next()) {
					return null;
				}
				
				// 2. 密碼比對錯誤
				if(!password.equals(rs.getString("password"))) {
					return null;
				}
				
				// 3. 登入成功將 member 物件回傳
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setCreateTime(rs.getDate("create_time"));
				
				return member;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 查詢所有會員資料
	 * */
	
	
	
	
}
