package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reply;
import model.Replydata;
import model.TopReply;

public class ReplyDao {

	// 引数review_idで検索項目を指定し、検索結果のリストを返す
		public List<Reply> select(String review_id) {
			Connection conn = null;
			List<Reply> Reply = new ArrayList<Reply>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT reply_id, review_id, user_id, reply_contents, reply_date FROM t_reply where review_id = ? ";
				//Date型はどうすればいい？
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, review_id);
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Reply card = new Reply(
					rs.getString("reply_id"),
					rs.getString("review_id"),
					rs.getString("user_id"),
					rs.getString("reply_contents"),
					rs.getString("reply_date")
					);
					Reply.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				Reply = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Reply = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Reply = null;
					}
				}
			}

			// 結果を返す
			return Reply;
		}
		// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<Reply> select(Reply param) {
				Connection conn = null;
				List<Reply> Reply = new ArrayList<Reply>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する(件数をカウントし降順で3つ表示)
					String sql = "SELECT reply_id, review_id, user_id, reply_contents, reply_date FROM t_reply ";
					//Date型はどうすればいい？
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Reply card = new Reply(
						rs.getString("reply_id"),
						rs.getString("review_id"),
						rs.getString("user_id"),
						rs.getString("reply_contents"),
						rs.getString("reply_date")
						);
						Reply.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					Reply = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Reply = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Reply = null;
						}
					}
				}

				// 結果を返す
				return Reply;
			}

			// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
			public boolean insert(Reply card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "INSERT INTO T_Reply (review_id, user_id, reply_contents) values (?, ?, ?)";
					//Date型はどうすればいい？
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getReview_id() != null && !card.getReview_id().equals("")) {
						pStmt.setString(1, card.getReview_id());
					}
					else {
						pStmt.setString(1, "");
					}
					if (card.getUser_id() != null && !card.getUser_id().equals("")) {
						pStmt.setString(2, card.getUser_id());
					}
					else {
						pStmt.setString(2, "");
					}
					if (card.getReply_contents() != null && !card.getReply_contents().equals("")) {
						pStmt.setString(3, card.getReply_contents());
					}
					else {
						pStmt.setString(3, "");
					}

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}

					String sql2 = "UPDATE T_Reply SET  reply_id =(SELECT concat('rp',right(concat('00000000',CAST( (SELECT id FROM T_Reply where reply_id is null) AS VARCHAR)),8) )from T_Reply where reply_id is null ) where reply_id is null";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);
					// SQL文を実行する
					if (pStmt2.executeUpdate() == 1) {
						result = true;
					}

				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();//スタックトレースを出力
				}
				finally {
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

			// 引数replyで指定されたリプライを更新し、成功したらtrueを返す
			public boolean update(Reply reply) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "UPDATE T_REPLY SET (reply_contents, reply_date) where review_id=?";

					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (reply.getReply_contents() != null && !reply.getReply_contents().equals("")) {
						pStmt.setString(1, reply.getReply_contents());
					}
					else {
						pStmt.setString(1, null);
					}

					if (reply.getReply_date() != null && !reply.getReply_date().equals("")) {
						pStmt.setString(2, reply.getReply_date());
					}
					else {
						pStmt.setString(2, null);
					}

					pStmt.setString(7, reply.getReview_id());

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				finally {
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


			// 引数replyで指定されたリプライを削除し、成功したらtrueを返す
			public boolean delete(String reply_id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "DELETE FROM T_REPLY where reply_id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, reply_id);

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				finally {
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


			//マイページリプライ一覧表示
			public List<Replydata> select2(String user_id) {
				Connection conn = null;
				List<Replydata> Replydata = new ArrayList<Replydata>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "SELECT m_user.user_name,m_user.user_img,t_reply.reply_date,t_reply.reply_contents FROM t_reply  LEFT JOIN m_user ON t_reply.user_id = m_user.user_id  WHERE \r\n"
							+ "m_user.user_id = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,user_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Replydata card = new Replydata(
						rs.getString("user_name"),
						rs.getString("user_img"),
						rs.getString("reply_date"),
						rs.getString("reply_contents")
						);
						Replydata.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					Replydata = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Replydata = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Replydata = null;
						}
					}
				}

				// 結果を返す
				return Replydata;
			}
			//Topリプライ一覧表示
			public List<TopReply> select7(String review_id) {
				Connection conn = null;
				List<TopReply> TopReply = new ArrayList<TopReply>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "SELECT m_user.user_name, t_reply.reply_contents, FROM t_reply  INNER JOIN m_user ON m_user.user_id = t_reply.user_id INNER JOIN t_review ON t_reply.review_id = t_review.review_id WHERE t_review.review_id = ? ";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,review_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						TopReply card = new TopReply(
						rs.getString("user_name"),
						rs.getString("reply_contents")
						);
						TopReply.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					TopReply = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					TopReply = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							TopReply = null;
						}
					}
				}

				// 結果を返す
				return TopReply;
			}
			public List<String> select_review_user_id(String user_id) {
				Connection conn = null;
				List<String> reviews =new ArrayList<String>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/Dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

//					String sql = "SELECT distinct review_id FROM t_reply  WHERE user_id = ?";

					String sql = "SELECT review_id FROM t_review  WHERE user_id = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,user_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while(rs.next()) {
						reviews.add(rs.getString("review_id"));
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					reviews = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					reviews = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							reviews = null;
						}
					}
				}

				// 結果を返す
				return reviews;
			}
			public List<Reply> select_name_contents_date(String review_id) {
				Connection conn = null;
				List<Reply> reviews =new ArrayList<Reply>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/Dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
//					String sql = "SELECT m_user.user_name,m_user.user_img,m_video.video_name,t_review.star, t_review.review_id ,t_review.review_date,m_genre.genre_name,t_review.feelcat_name1,t_review.feelcat_name2,t_review.review_contents FROM t_review  LEFT JOIN m_user ON t_review.user_id = m_user.user_id LEFT JOIN m_video ON t_review.video_id = m_video.video_id LEFT JOIN m_genre ON t_review.genre_id = m_genre.genre_id WHERE \r\n"
//							+ "m_user.user_id = ?";
					String sql = "SELECT reply_id,review_id,T_Reply.user_id,reply_contents ,reply_date, M_USER.user_name FROM T_REPLY LEFT JOIN M_USER ON T_REPLY.user_id = M_USER.USER_ID where review_id = ?";
					//String sql = "SELECT m_user.user_name as review_user_name,m_user.user_img,m_video.video_name,t_review.star, t_review.review_id ,t_review.review_date,m_genre.genre_name,t_review.feelcat_name1,t_review.feelcat_name2,t_review.review_contents ,reply_name FROM t_review  LEFT JOIN m_user ON t_review.user_id = m_user.user_id LEFT JOIN m_video ON t_review.video_id = m_video.video_id LEFT JOIN m_genre ON t_review.genre_id = m_genre.genre_id left join (SELECT reply_id,review_id,T_Reply.user_id,reply_contents ,reply_date, M_USER.user_name as reply_name FROM T_REPLY LEFT JOIN M_USER ON T_REPLY.user_id = M_USER.USER_ID) as reply_data  on t_review .review_id = reply_data.review_id WHERE m_user.user_id = ? ";


					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,review_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while(rs.next()) {
						Reply replydata= new Reply(
								rs.getString("reply_id"),
								rs.getString("review_id"),
								rs.getString("user_id"),
								rs.getString("reply_contents"),
								rs.getString("reply_date"),
								rs.getString("user_name")
								);
						reviews.add(replydata);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					reviews = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					reviews = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							reviews = null;
						}
					}
				}

				// 結果を返す
				return reviews;
			}

	}

