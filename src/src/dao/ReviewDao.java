package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;
import model.Reviewdata;
import model.Top;

public class ReviewDao {
	//public List<Reviewdata> selectReview(String user_id) {
		//Connection conn = null;
		//List<Reviewdata> Review = new ArrayList<Reviewdata>();

		//try {
			// JDBCドライバを読み込む
			//Class.forName("org.h2.Driver");

			// データベースに接続する
			//conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(件数をカウントし降順で3つ表示)
			//String sql = "SELECT  m_user.user_name ,m_user.user_img FROM t_review left join m_user on t_review.user_id = m_user.user_id  where m_user.user_id = ? ";
			//Date型はどうすればいい？
			//PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setString(1, user_id);
			// SQL文を実行し、結果表を取得する
			//ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//while (rs.next()) {
				//Reviewdata card = new Reviewdata(
				//rs.getString("user_name"),
				//rs.getString("user_img")
				//);
				//Review.add(card);
			//}
		//}
		//catch (SQLException e) {
			//e.printStackTrace();
			//Review = null;
		//}
		//catch (ClassNotFoundException e) {
			//e.printStackTrace();
			//Review = null;
		//}
		//finally {
			// データベースを切断
			//if (conn != null) {
				//try {
					//conn.close();
				//}
				//catch (SQLException e) {
					//e.printStackTrace();
					//Review = null;
				//}
			//}
		//}

		//// 結果を返す
		//return Review;
	//}

	// 引数user_idで検索項目を指定し、検索結果のリストを返す
//	public List<Review> select(String user_id) {
//		Connection conn = null;
//		List<Review> Review = new ArrayList<Review>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
//
//			// SQL文を準備する(件数をカウントし降順で3つ表示)
//			String sql = "SELECT review_id,  video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star, review_date FROM t_review where user_id = ? ";
//			//Date型はどうすればいい？
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, user_id);
//			// SQL文を実行し、結果表を取得する
//			ResultSet rs = pStmt.executeQuery();
//
//			// 結果表をコレクションにコピーする
//			while (rs.next()) {
//				Review card = new Review(
//				rs.getString("review_id"),
//				rs.getString("video_id"),
//				rs.getString("user_id"),
//				rs.getString("review_contents"),
//				rs.getString("genre_id"),
//				rs.getString("feelcat_name1"),
//				rs.getString("feelcat_name2"),
//				rs.getString("star"),
//				rs.getString("review_date")
//				);
//				Review.add(card);
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			Review = null;
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			Review = null;
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//					Review = null;
//				}
//			}
//		}
//
//		// 結果を返す
//		return Review;
//	}
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Reviewdata> select(String video_id) {
			Connection conn = null;
			List<Reviewdata> Review = new ArrayList<Reviewdata>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = " SELECT m_user.user_name,m_user.user_img,m_video.video_name,t_review.star,t_review.review_date,m_genre.genre_name,t_review.feelcat_name1,t_review.feelcat_name2,t_review.review_contents"
						   + " FROM t_review "
						   + " LEFT JOIN m_user ON t_review.user_id = m_user.user_id"
						   + " LEFT JOIN m_video ON t_review.video_id = m_video.video_id"
						   + " LEFT JOIN m_genre ON t_review.genre_id = m_genre.genre_id"
						   + " WHERE t_review.video_id = ?"
						   ;
				//Date型はどうすればいい？
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, video_id);
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Reviewdata card = new Reviewdata(
					rs.getString("user_name"),
					rs.getString("user_img"),
					rs.getString("video_name"),
					rs.getString("star"),
					rs.getString("review_date"),
					rs.getString("genre_name"),
					rs.getString("feelcat_name1"),
					rs.getString("feelcat_name2"),
					rs.getString("review_contents")
					);
					Review.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				Review = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Review = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Review = null;
					}
				}
			}

			// 結果を返す
			return Review;
		}

		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Review card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "INSERT INTO T_REVIEW (review_id,  video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star) values (?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる


				pStmt.setString(1, null);

				if (card.getVideo_id() != null && !card.getVideo_id().equals("")) {
					pStmt.setString(2, card.getVideo_id());
				}
				else {
					pStmt.setString(2, "");
				}
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(3, card.getUser_id());
				}
				else {
					pStmt.setString(3, "");
				}
				if (card.getReview_contents() != null && !card.getReview_contents().equals("")) {
					pStmt.setString(4, card.getReview_contents());
				}
				else {
					pStmt.setString(4, "");
				}
				if (card.getGenre_id() != null && !card.getGenre_id().equals("")) {
					pStmt.setString(5, card.getGenre_id());
				}
				else {
					pStmt.setString(5, "");
				}
				if (card.getFeelcat_name1() != null && !card.getFeelcat_name1().equals("")) {
					pStmt.setString(6, card.getFeelcat_name1());
				}
				else {
					pStmt.setString(6, "");
				}
				if (card.getFeelcat_name2() != null && !card.getFeelcat_name2().equals("")) {
					pStmt.setString(7, card.getFeelcat_name2());
				}
				else {
					pStmt.setString(7, "");
				}
				if (card.getStar() != null && !card.getStar().equals("")) {
					pStmt.setString(8, card.getStar());
				}
				else {
					pStmt.setString(8, "");
				}
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}

				String sql2 = "UPDATE T_REVIEW SET  review_id =(SELECT concat('rv',right(concat('00000000',CAST( (SELECT id FROM T_REVIEW where review_id is null) AS VARCHAR)),8) )from T_REVIEW where review_id is null ) where review_id is null";
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


			// 引数reviewで指定されたレビューを更新し、成功したらtrueを返す
			public boolean update(Review review,Review now_review) {
				Connection conn = null;
				boolean result = false;

				try {
					//現在のデータを取得


					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "UPDATE T_REVIEW SET review_contents=?, feelcat_name1=?, feelcat_name2=?, star=?  where review_id=? ";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (review.getReview_contents() != null && !review.getReview_contents().equals("")) {
						pStmt.setString(1, review.getReview_contents());
					}
					else {
						pStmt.setString(1, null);
					}


					if (review.getFeelcat_name1() != null && !review.getFeelcat_name1().equals("")) {
						pStmt.setString(2, review.getFeelcat_name1());
					}
					else {
						pStmt.setString(2, now_review.getFeelcat_name1());
					}

					if (review.getFeelcat_name2() != null && !review.getFeelcat_name2().equals("")) {
						pStmt.setString(3, review.getFeelcat_name2());
					}
					else {
						pStmt.setString(3, now_review.getFeelcat_name2());
					}

					if (review.getStar() != null && !review.getStar().equals("")) {
						pStmt.setString(4, review.getStar());
					}
					else {
						pStmt.setString(4, now_review.getStar());
					}
					pStmt.setString(5, review.getReview_id());

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


			// 引数review_idで指定されたレビューを削除し、成功したらtrueを返す
			public boolean delete(String review_id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "DELETE FROM T_REVIEW where review_id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, review_id);

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

			//topレビュー一覧表示
			public List<Top> select1() {
				Connection conn = null;
				List<Top> Reviewlist = new ArrayList<Top>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/Dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "SELECT m_user.user_name,m_user.user_img,m_video.video_name,t_review.review_contents,t_review.review_date FROM (t_review  LEFT JOIN m_user ON t_review.user_id = m_user.user_id ) LEFT JOIN m_video ON t_review.video_id = m_video.video_id;";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Top card = new Top(
						rs.getString("user_name"),
						rs.getString("user_img"),
						rs.getString("video_name"),
						rs.getString("review_contents"),
						rs.getString("review_date")
						);
						Reviewlist.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					Reviewlist = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Reviewlist = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Reviewlist = null;
						}
					}
				}

				// 結果を返す
				return Reviewlist;
			}

			//マイページレビュー一覧表示
			public List<Reviewdata> select2(String user_id) {
				Connection conn = null;
				List<Reviewdata> Reviewdata = new ArrayList<Reviewdata>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "SELECT m_user.user_name,m_user.user_img,m_video.video_name,t_review.star, t_review.review_id ,t_review.review_date,m_genre.genre_name,t_review.feelcat_name1,t_review.feelcat_name2,t_review.review_contents FROM t_review  LEFT JOIN m_user ON t_review.user_id = m_user.user_id LEFT JOIN m_video ON t_review.video_id = m_video.video_id LEFT JOIN m_genre ON t_review.genre_id = m_genre.genre_id WHERE \r\n"
							+ "m_user.user_id = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,user_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Reviewdata card = new Reviewdata(
						rs.getString("user_name"),
						rs.getString("user_img"),
						rs.getString("video_name"),
						rs.getString("star"),
						rs.getString("review_date"),
						rs.getString("genre_name"),
						rs.getString("feelcat_name1"),
						rs.getString("feelcat_name2"),
						rs.getString("review_contents"),
						rs.getString("review_id")
						);
						Reviewdata.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					Reviewdata = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Reviewdata = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Reviewdata = null;
						}
					}
				}

				// 結果を返す
				return Reviewdata;
			}
			//ログイン後topレビュー一覧表示
			public List<Top> select3(String user_id) {
				Connection conn = null;
				List<Top> Reviewlist2 = new ArrayList<Top>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/Dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "select m_user.user_name, m_user.user_img, t_review.review_date, t_review.review_contents, m_video.video_name from t_review inner join t_follow on T_review.user_id = t_follow.follow_id inner join m_user ON t_review.user_id = m_user.user_id  inner join m_video ON t_review.video_id = m_video.video_id where t_follow.user_id = ?"  ;
					PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,user_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Top card = new Top(
						rs.getString("user_name"),
						rs.getString("user_img"),
						rs.getString("video_name"),
						rs.getString("review_contents"),
						rs.getString("review_date")
						);
						Reviewlist2.add(card);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					Reviewlist2 = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					Reviewlist2 = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							Reviewlist2 = null;
						}
					}
				}

				// 結果を返す
				return Reviewlist2;
			}
			public Review select4(String review_id) {
				Connection conn = null;
				Review card =null;
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/Dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "SELECT * FROM t_review  WHERE review_id = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,review_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					rs.next();
					 card = new Review(
							rs.getString("review_id"),
							rs.getString("video_id"),
							rs.getString("user_id"),
							rs.getString("review_contents"),
							rs.getString("genre_id"),
							rs.getString("feelcat_name1"),
							rs.getString("feelcat_name2"),
							rs.getString("star"),
							rs.getString("review_date")
						);

				}
				catch (SQLException e) {
					e.printStackTrace();
					card = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					card = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							card = null;
						}
					}
				}

				// 結果を返す
				return card;
			}

		}
