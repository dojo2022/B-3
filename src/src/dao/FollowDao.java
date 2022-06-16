package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MasterUser;

public class FollowDao {
	//フォロー一覧を返すメソッドFollowUser
	//user_idが引数
	public List<MasterUser> FollowUser(String user_id) {
		if (user_id == null) { return null; }
		Connection conn = null;
		List<MasterUser> followList = new ArrayList<MasterUser>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する(変更済み）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(pStmtの意味は、コンパイルされた(実行可能な)SQL文)
			// SQLを使いたいときは必ずpStmtをつけると思っといていい!
			// 【検索項目】アイコン画像・ユーザー名・プロフィール文

			//フォロー一覧
			String FollowUser = "SELECT user_name,user_pf,user_img "
					+ "WHERE t_follow.follow_id = m_user.user_id "
					+ "AND t_follow.user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(FollowUser);


			// SQL文を完成させる　？に入る言葉(paramに入る言葉)をデータベースから取り出す
			// 1，2，3は何番目の'？'か
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する(変更なし)
			ResultSet rs = pStmt.executeQuery();

			// 結果表(rs)をコレクション(Follow)にコピーする
			while (rs.next()) {
				followList.add(
					new MasterUser(
						"",
						"",
						"",
						rs.getString("user_name"),
						rs.getString("user_pf"),
						rs.getString("user_img"),
						""
					)
				);
			}
		}
		//e は例外exceptionの"e"
		catch (SQLException e) {
			e.printStackTrace();
			followList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			followList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					followList = null;
				}
			}
		}
		return followList;
	}

	//フォロワー一覧を返すメソッドFollowerUser
	//user_idが引数
	public List<MasterUser> FollowerUser(String user_id) {
		if (user_id == null) { return null; }
		Connection conn = null;
		List<MasterUser> followList = new ArrayList<MasterUser>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する(変更済み）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(pStmtの意味は、コンパイルされた(実行可能な)SQL文)
			// SQLを使いたいときは必ずpStmtをつけると思っといていい!
			// 【検索項目】アイコン画像・ユーザー名・プロフィール文

			//フォロワー一覧
			String FollowerUser = "SELECT user_name,user_pf,user_img "
					+ "WHERE t_follow.user_id = m_user.user_id "
					+ "AND t_follow.follow_id = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(FollowerUser);

			// SQL文を完成させる　？に入る言葉(paramに入る言葉)をデータベースから取り出す
			// 1，2，3は何番目の'？'か

				pStmt2.setString(1,user_id);

			// SQL文を実行し、結果表を取得する(変更なし)
			ResultSet rs = pStmt2.executeQuery();

			// 結果表(rs)をコレクション(Follow)にコピーする
			while (rs.next()) {
				followList.add(
					new MasterUser(
						"",
						"",
						"",
						rs.getString("user_name"),
						rs.getString("user_pf"),
						rs.getString("user_img"),
						""
					)
				);
			}
		}
		//e は例外exceptionの"e"
		catch (SQLException e) {
			e.printStackTrace();
			followList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			followList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					followList = null;
				}
			}
		}

		// 結果を返す
		return followList;
	}
}
