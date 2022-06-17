package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import model.LoginUser;
import model.MasterUser;

/**
 * Servlet implementation class MasterUserDao
 */
@WebServlet("/MasterUserDao")
public class MasterUserDao extends HttpServlet {
	public LoginUser isLoginOK(String id,String pw) {
		Connection conn = null;
		LoginUser user = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select user_id from m_user where user_mail = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2,pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			if (rs.next()) {
				user = new LoginUser(rs.getString("user_id"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 結果を返す
		return user;
	}

	public MasterUser selectOne(String user_id) {
		MasterUser user = null;
		//ここで上のログイン同様、１行のMasterUserデータを取得する
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select user_id from m_user where user_mail = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);


			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			if (rs.next()) {
				user = new MasterUser();
				//値を１つずつセットする
				user.setUser_id(rs.getString("user_id"));



			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 結果を返す
		return user;
	}
}
