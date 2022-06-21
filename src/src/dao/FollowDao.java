package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Follow;
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
			String FollowUser = "SELECT t_follow.follow_id as user_id "
					+ ",user_name,user_pf,user_img FROM m_user,t_follow "
					+ "WHERE t_follow.follow_id = m_user.user_id "
					+ "AND t_follow.user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(FollowUser);

			// SQL文を完成させる　？に入る言葉(paramに入る言葉)をデータベースから取り出す
			// 1，2，3は何番目の'？'か
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する(変更なし)
			ResultSet rs = pStmt.executeQuery();

			// 結果表(rs)をコレクション(followList)にコピーする
			while (rs.next()) {
				followList.add(
					new MasterUser(
						rs.getString("user_id"),
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
//フォローの人数を返すメソッドfollowcount
	public int Followcount(String user_id) {

		Connection conn = null;
		int count=0;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する(変更済み）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(pStmtの意味は、コンパイルされた(実行可能な)SQL文)
			// SQLを使いたいときは必ずpStmtをつけると思っといていい!
			//フォロー一覧
			String FollowUser = "SELECT count(id) as counts FROM t_follow  WHERE user_id = ? ";

			PreparedStatement pStmt = conn.prepareStatement(FollowUser);


			// SQL文を完成させる　？に入る言葉をデータベースから取り出す
			// 1，2，3は何番目の'？'か
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する(変更なし)
			ResultSet rs = pStmt.executeQuery();

			// 結果表(rs)をコレクションにコピーする
			rs.next();
			count = rs.getInt("counts");
			}

		//e は例外exceptionの"e"
		catch (SQLException e) {
			e.printStackTrace();
			count = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			count = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					count = 0;
				}
			}
		}
		return count;
	}
	//フォロワーの人数を返すメソッドfollowercount
		public int Followercount(String user_id) {

			Connection conn = null;
			int count=0;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する(変更済み）
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(pStmtの意味は、コンパイルされた(実行可能な)SQL文)
				// SQLを使いたいときは必ずpStmtをつけると思っといていい!
				//フォロー一覧
				String FollowUser = "SELECT count(id) as counts FROM t_follow  WHERE follow_id = ? ";

				PreparedStatement pStmt = conn.prepareStatement(FollowUser);


				// SQL文を完成させる　？に入る言葉をデータベースから取り出す
				// 1，2，3は何番目の'？'か
				pStmt.setString(1, user_id);

				// SQL文を実行し、結果表を取得する(変更なし)
				ResultSet rs = pStmt.executeQuery();

				// 結果表(rs)をコレクションにコピーする
				rs.next();
				count = rs.getInt("counts");
				}

			//e は例外exceptionの"e"
			catch (SQLException e) {
				e.printStackTrace();
				count = 0;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				count = 0;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						count = 0;
					}
				}
			}
			return count;
		}

//フォロワー一覧を返すメソッドFollowerUser
	//user_idが引数
	public List<Follow> FollowerUser(String user_id) {
		if (user_id == null) { return null; }
		Connection conn = null;
		List<Follow> followList = new ArrayList<Follow>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する(変更済み）
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(pStmtの意味は、コンパイルされた(実行可能な)SQL文)
			// SQLを使いたいときは必ずpStmtをつけると思っといていい!
			// 【検索項目】アイコン画像・ユーザー名・プロフィール文

			//フォロワー一覧
			String FollowerUser = "SELECT A.user_id, A.user_name, A.user_pf, A.user_img, B.exchange "
					+ "FROM m_user AS A,"
					+ "("
					+ "  SELECT F.user_id, G.user_id AS exchange"
					+ "  FROM t_follow AS F"
					+ "  LEFT JOIN t_follow AS G"
					+ "  ON F.user_id = G.follow_id AND F.follow_id = G.user_id"
					+ "  WHERE F.follow_id = ?"
					+ ") AS B "
					+ "WHERE A.user_id = B.user_id"
					+ "";
			PreparedStatement pStmt2 = conn.prepareStatement(FollowerUser);

			// SQL文を完成させる　？に入る言葉(paramに入る言葉)をデータベースから取り出す
			// 1，2，3は何番目の'？'か

				pStmt2.setString(1,user_id);

			// SQL文を実行し、結果表を取得する(変更なし)
			ResultSet rs = pStmt2.executeQuery();

			// 結果表(rs)をコレクション(followerList)にコピーする
			while (rs.next()) {
				followList.add(
					new Follow(
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("user_pf"),
						rs.getString("user_img"),
						rs.getString("exchange") != null
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

//フォローボタンを押したユーザーをフォローする
	public boolean insert(String user_id, String follow_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO t_follow (user_id,follow_id) "
					+ "VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 空文字列ではなくnullを入れることになってる
			//user_id
			if (user_id != null && !user_id.equals("")) {
				pStmt.setString(1, user_id);
			} else {
				return result;
			}
			//follow_id
			if (follow_id != null && !follow_id.equals("")) {
				pStmt.setString(2, follow_id);
			} else {
				return result;
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

//フォロー解除ボタンを押したユーザーのフォローを解除する
	public boolean delete(String user_id,String follow_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pdojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM t_follow WHERE user_id=? AND follow_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);
			pStmt.setString(2, follow_id);

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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

}
