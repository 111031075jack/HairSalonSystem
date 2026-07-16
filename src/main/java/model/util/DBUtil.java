package model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/hairsalonsystem?useSSL=false&serverTimeZone=Asia/Taipei";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345678";
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 動態載入 driver
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
	public static void main(String[] args) {
	    try (Connection conn = getConnection()) {
	        System.out.println("資料庫連線成功！");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}