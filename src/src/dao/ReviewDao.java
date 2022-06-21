package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class ReviewDao {
	// 引数user_idで検索項目を指定し、検索結果のリストを返す
	public List<Review> select(String user_id) {
		Connection conn = null;
		List<Review> Review = new ArrayList<Review>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(件数をカウントし降順で3つ表示)
			String sql = "SELECT review_id,  video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star, review_date FROM t_review where user_id = ? ";
			//Date型はどうすればいい？
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(0, user_id);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Review card = new Review(
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
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Review> select(Review param) {
			Connection conn = null;
			List<Review> Review = new ArrayList<Review>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT review_id,  video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star, review_date FROM t_review ";
				//Date型はどうすればいい？
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Review card = new Review(
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
				String sql = "INSERT INTO Review (review_id,  video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star, review_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				//Date型はどうすればいい？

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getReview_id() != null && !card.getReview_id().equals("")) {
					pStmt.setString(1, card.getReview_id());
				}
				else {
					pStmt.setString(1, "");
				}
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
				if (card.getReview_date() != null && !card.getReview_date().equals("")) {
					pStmt.setString(9, card.getReview_date());
				}
				else {
					pStmt.setString(9, "");
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
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
}


