package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private Integer id;
	private String username;
	private String password;
	private String name;       // 💡 新增：顧客姓名（預約與顯示用）
	private String phone;      // 💡 新增：顧客電話（聯絡用）
	private String email;      // 💡 新增：電子信箱（可選）

	// 💡 建議將 createTime 改成 createdAt，這樣命名能更直覺地對應資料庫的 created_at 欄位
	private Date createdAt;
}
