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

//ログイン処理
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

//プロフィール情報を取得する処理
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
			String sql = "select * from m_user where user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);


			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			user = new MasterUser(
				//値を１つずつセットする
				rs.getString("user_id"),
				rs.getString("user_name"),
				rs.getString("user_pf"),
				rs.getString("user_img"),
				rs.getString("user_img") //ueda
				);

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

//プロフィールを変更する処理
	public boolean update(MasterUser prof_bf ,MasterUser prof_af) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE m_user SET user_img = ?, user_name = ?, user_pf = ? WHERE user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			//number
			if (prof_af.getUser_img() != null && !prof_af.getUser_img().equals("")) {
				pStmt.setString(1, prof_af.getUser_img());
			} else {
				pStmt.setString(1, prof_bf.getUser_img());
			}
			//name
			if (prof_af.getUser_name() != null && !prof_af.getUser_name().equals("")) {
				pStmt.setString(2, prof_af.getUser_name());
			} else {
				pStmt.setString(2, prof_bf.getUser_name());
			}
			//kana
			if (prof_af.getUser_pf() != null && !prof_af.getUser_pf().equals("")) {
				pStmt.setString(3, prof_af.getUser_pf());
			} else {
				pStmt.setString(3, prof_bf.getUser_pf());
			}

			pStmt.setString(4, prof_af.getUser_id());

			// SQL文を実行する
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
