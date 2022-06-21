package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MasterVideo;

public class MasterVideoDao {

	public List<MasterVideo> select(MasterVideo param) {
		Connection conn = null;
		List<MasterVideo> cardList = new ArrayList<MasterVideo>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT video_id, video_name, video_year, video_time, genre_id from m_video WHERE video_name LIKE ? AND video_year LIKE ? AND video_time LIKE ? AND genre_id LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getVideo_name() != null) {
				pStmt.setString(1, "%" + param.getVideo_name() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getVideo_year() != null) {
				pStmt.setString(2, "%" + param.getVideo_year() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getVideo_time() != null) {
				pStmt.setString(3, "%" + param.getVideo_time() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getGenre_id() != null) {
				pStmt.setString(4, "%" + param.getGenre_id() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				MasterVideo card = new MasterVideo(
				rs.getString("video_id"),
				rs.getString("video_name"),
				rs.getString("video_year"),
				rs.getString("video_time"),
				rs.getString("genre_id")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	public MasterVideo selectOne(String param) {
		Connection conn = null;
		MasterVideo cardList = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT video_id, video_name, video_year, video_time, genre_id from m_video WHERE video_id = ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param != null) {
				pStmt.setString(1, param);
			}
			else {
				pStmt.setString(1, null);
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				cardList = new MasterVideo(
				rs.getString("video_id"),
				rs.getString("video_name"),
				rs.getString("video_year"),
				rs.getString("video_time"),
				rs.getString("genre_id")
				);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	public List<MasterVideo> selectFromReview(MasterVideo params, String feelcat1, String feelcat2) {
		return select(params);
		// Connection conn = null;
		// List<MasterVideo> videoList = new ArrayList<MasterVideo>();

		// try {
		// 	// JDBCドライバを読み込む
		// 	Class.forName("org.h2.Driver");

		// 	// データベースに接続する
		// 	conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

		// 	// SQL文を準備する
		// 	String sql = " SELECT *"
		// 			   + " FROM t_review"
		// 			   ;
		// 	PreparedStatement pStmt = conn.prepareStatement(sql);

		// }
		// catch (SQLException e) {
		// 	e.printStackTrace();
		// 	videoList = null;
		// }
		// catch (ClassNotFoundException e) {
		// 	e.printStackTrace();
		// 	videoList = null;
		// }
		// finally {
		// 	// データベースを切断
		// 	if (conn != null) {
		// 		try {
		// 			conn.close();
		// 		}
		// 		catch (SQLException e) {
		// 			e.printStackTrace();
		// 			videoList = null;
		// 		}
		// 	}
		// }
		// return null;
	}
}
