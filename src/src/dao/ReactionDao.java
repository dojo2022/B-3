package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reaction;
import model.Reactiondata;

public class ReactionDao {

	// 引数review_idで検索項目を指定し、検索結果のリストを返す
	public List<Reaction> select(String review_id) {
		Connection conn = null;
		List<Reaction> Reaction = new ArrayList<Reaction>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(件数をカウントし降順で3つ表示)
			String sql = "SELECT reaction_id, review_id, user_id, stamp_id FROM t_reaction where review_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, review_id);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Reaction card = new Reaction(
				rs.getString("reaction_id"),
				rs.getString("review_id"),
				rs.getString("user_id"),
				rs.getString("stamp_id")
				);
				Reaction.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Reaction = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Reaction = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Reaction = null;
				}
			}
		}

		// 結果を返す
		return Reaction;
	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Reaction> select(Reaction param) {
			Connection conn = null;
			List<Reaction> Reaction = new ArrayList<Reaction>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT reaction_id, review_id, user_id, stamp_id FROM t_reaction ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Reaction card = new Reaction(
					rs.getString("reaction_id"),
					rs.getString("review_id"),
					rs.getString("user_id"),
					rs.getString("stamp_id")
					);
					Reaction.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				Reaction = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Reaction = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Reaction = null;
					}
				}
			}

			// 結果を返す
			return Reaction;
		}

		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		//→スタンプも登録処理が必要か？
		public boolean insert(Reaction card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "INSERT INTO Reaction (reaction_id, review_id, user_id, stamp_id) values (?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getReaction_id() != null && !card.getReaction_id().equals("")) {
					pStmt.setString(1, card.getReaction_id());
				}
				else {
					pStmt.setString(1, "");
				}
				if (card.getReview_id() != null && !card.getReview_id().equals("")) {
					pStmt.setString(2, card.getReview_id());
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
				if (card.getStamp_id() != null && !card.getStamp_id().equals("")) {
					pStmt.setString(4, card.getStamp_id());
				}
				else {
					pStmt.setString(4, "");
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

		//マイページリアクション一覧表示
		public List<Reactiondata> select2(String user_id) {
			Connection conn = null;
			List<Reactiondata> Reactiondata = new ArrayList<Reactiondata>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する

				String sql = "SELECT m_user.user_name,m_user.user_img,m_video.video_name,t_review.star,t_review.review_date,m_genre.genre_name,t_review.feelcat_name1,t_review.feelcat_name2,t_review.review_contents, m_stamp.stamp_name FROM t_review  LEFT JOIN m_user ON t_review.user_id = m_user.user_id LEFT JOIN m_video ON t_review.video_id = m_video.video_id "
						+ "LEFT JOIN m_genre ON t_review.genre_id = m_genre.genre_id LEFT JOIN m_stamp ON t_reaction.stamp_id = m_stamp.stamp_id WHERE \r\n "
						+ "m_user.user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Reactiondata card = new Reactiondata(
					rs.getString("user_name"),
					rs.getString("user_img"),
					rs.getString("video_name"),
					rs.getString("star"),
					rs.getString("review_date"),
					rs.getString("genre_name"),
					rs.getString("feelcat_name1"),
					rs.getString("feelcat_name2"),
					rs.getString("review_contents"),
					rs.getString("stamp_name")
					);
					Reactiondata.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				Reactiondata = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Reactiondata = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Reactiondata = null;
					}
				}
			}

			// 結果を返す
			return Reactiondata;
		}

}


