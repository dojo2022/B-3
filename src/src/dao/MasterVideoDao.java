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
			String sql = " SELECT *"
					   + " FROM m_video"
					   + " WHERE video_name LIKE ?"
					   + " AND video_year BETWEEN ? AND ?"
					   + " AND video_time BETWEEN ? AND ?"
					   + " AND genre_id LIKE ?"
					   ;

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getVideo_name() != null && !param.getVideo_name().isEmpty()) {
				pStmt.setString(1, "%" + param.getVideo_name() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}

			int year = param.getVideo_year();
			if (year > 1970) {
				pStmt.setInt(2, year - 10);
				pStmt.setInt(3, year - 1);
			} else if (year == 1970) {
				pStmt.setInt(2, 0);
				pStmt.setInt(3, year - 1);
			} else {
				pStmt.setInt(2, 0);
				pStmt.setInt(3, 3000);
			}

			int time = param.getVideo_time();
			if (time > 180) {
				pStmt.setInt(4, 181);
				pStmt.setInt(5, 1440);
			} else if (time >= 30) {
				pStmt.setInt(4, time - 30 + 1);
				pStmt.setInt(5, time);
			} else {
				pStmt.setInt(4, 0);
				pStmt.setInt(5, 1440);
			}
			if (param.getGenre_id() != null) {
				pStmt.setString(6, param.getGenre_id());
			}
			else {
				pStmt.setString(6, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				MasterVideo card = new MasterVideo(
				rs.getString("video_id"),
				rs.getString("video_name"),
				rs.getInt("video_year"),
				rs.getInt("video_time"),
				rs.getString("genre_id"),
				null
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
			String sql = "SELECT video_id, video_name, video_year, video_time, m_genre.genre_id, genre_name from m_video INNER JOIN m_genre ON m_video.genre_id = m_genre.genre_id WHERE video_id = ?";
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
				rs.getInt("video_year"),
				rs.getInt("video_time"),
				rs.getString("genre_id"),
				rs.getString("genre_name")
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

	public List<MasterVideo> selectFromReview(MasterVideo params, String feelcat) {

		Connection conn = null;
		List<MasterVideo> videoList = new ArrayList<MasterVideo>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = " SELECT V.*"
					   + " FROM t_review as R, m_video as V"
					   + " WHERE R.video_id = V.video_id"
					   + " AND ( R.feelcat_name1 LIKE ? OR  R.feelcat_name2 LIKE ? )"
					   + " AND V.video_name LIKE ?"
					   + " AND V.video_year BETWEEN ? AND ?"
					   + " AND V.video_time BETWEEN ? AND ?"
					   + " AND V.genre_id LIKE ?"
					   + " GROUP BY R.video_id"
					   ;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (feelcat != null && !feelcat.isEmpty()) {
				pStmt.setString(1, "%" + feelcat + "%");
				pStmt.setString(2, "%" + feelcat + "%");
			} else {
				pStmt.setString(1, "%");
				pStmt.setString(2, "%");
			}

			if (params.getVideo_name() != null && !params.getVideo_name().isEmpty()) {
				pStmt.setString(3, "%" + params.getVideo_name() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			int year = params.getVideo_year();
			if (year > 1970) {
				pStmt.setInt(4, year - 10);
				pStmt.setInt(5, year - 1);
			} else if (year == 1970) {
				pStmt.setInt(4, 0);
				pStmt.setInt(5, year - 1);
			} else {
				pStmt.setInt(4, 0);
				pStmt.setInt(5, 3000);
			}

			int time = params.getVideo_time();
			if (time > 180) {
				pStmt.setInt(6, 181);
				pStmt.setInt(7, 1440);
			} else if (time >= 30) {
				pStmt.setInt(6, time - 30 + 1);
				pStmt.setInt(7, time);
			} else {
				pStmt.setInt(6, 0);
				pStmt.setInt(7, 1440);
			}
			if (params.getGenre_id() != null) {
				pStmt.setString(8, params.getGenre_id());
			}
			else {
				pStmt.setString(8, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				MasterVideo video = new MasterVideo(
				rs.getString("video_id"),
				rs.getString("video_name"),
				rs.getInt("video_year"),
				rs.getInt("video_time"),
				rs.getString("genre_id"),
				null
				);
				videoList.add(video);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			videoList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			videoList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					videoList = null;
				}
			}
		}
		return videoList;
	}
}
