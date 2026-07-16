package model.dao;

import model.entity.Member;
import model.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				insert into members(username, password, name, phone, email)
				values(?, ?, ?, ?, ?)
				""";
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());

			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	/**
	 * 會員登入
	 * 登入成功後，會返回包含「完整個人資料」的 Member 物件
	 * */
	public Member login(String username, String password) {
		// 💡 查詢欄位更新：表名改為 members，時間改為 created_at，並多查詢 name, phone, email
		String sql = """
				select id, username, password, name, phone, email, created_at from members where username = ?
				""";
		
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, username);

			try(ResultSet rs = pstmt.executeQuery()){
				
				// 1. 查無該使用者
				if(!rs.next()) {
					return null;
				}
				
				// 2. 密碼比對錯誤（如果密碼不符合，回傳 null 代表登入失敗）
				if(!password.equals(rs.getString("password"))) {
					return null;
				}
				
				// 3. 登入成功，將資料庫的所有欄位值打包進 Member 物件中
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setCreatedAt(rs.getTimestamp("created_at"));

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
