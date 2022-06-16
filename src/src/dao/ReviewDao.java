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
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Review> select(Review param) {
			Connection conn = null;
			List<Review> ReviewRanking = new ArrayList<Review>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT review_id,  video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star, review_date FROM t_review ";
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
					ReviewRanking.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ReviewRanking = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ReviewRanking = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ReviewRanking = null;
					}
				}
			}

			// 結果を返す
			return ReviewRanking;
		}
}
