package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.MasterUser;



public class RegisterDao {
	public boolean insert(MasterUser newUser) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO m_user (user_mail,user_pw,user_name) "
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 空文字列ではなくnullを入れることになってる
			//user_mail
			if (newUser.getUser_mail() != null && !newUser.getUser_mail().equals("")) {
				pStmt.setString(1, newUser.getUser_mail());
			} else {
				pStmt.setString(1, null);
			}
			//user_pw
			if (newUser.getUser_pw() != null && !newUser.getUser_pw().equals("")) {
				pStmt.setString(2, newUser.getUser_pw());
			} else {
				pStmt.setString(2, null);
			}
			//user_name
			if (newUser.getUser_name() != null && !newUser.getUser_name().equals("")) {
				pStmt.setString(4, newUser.getUser_name());
			} else {
				pStmt.setString(4, null);
			}

			// SQL文を実行する　何行登録されたか（1じゃなきゃおかしい）
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
