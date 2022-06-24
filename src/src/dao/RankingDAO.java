package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ranking;

public class RankingDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す(通算)
	public List<Ranking> selectAll() {
		Connection conn = null;
		List<Ranking> ReviewRanking = new ArrayList<Ranking>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(件数をカウントし降順で表示)
			String sql = "SELECT t_review.video_id,M_VIDEO.video_name,count(t_review.video_id) FROM t_review LEFT JOIN M_VIDEO ON t_review.video_id=M_VIDEO.video_id GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Ranking card = new Ranking(
				rs.getString("video_id"),
				rs.getString("video_name"),
			    rs.getInt("count(t_review.video_id)")
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
	// 引数paramで検索項目を指定し、検索結果のリストを返す(アニメ)
		public List<Ranking> selectAnime() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000001'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(国内)
		public List<Ranking> selectLocal() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000002'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
				    rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(欧米)
		public List<Ranking> selectUs() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000003'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
		            rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(韓国)
		public List<Ranking> selectKorea() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000004'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
				    rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(華流)
		public List<Ranking> selectChina() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000005'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(アクション)
		public List<Ranking> selectAction() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000006'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(コメディ)
		public List<Ranking> selectComedy() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000007'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(キッズ・ファミリー)
		public List<Ranking> selectFamily() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000008'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3 ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(ヒューマンドラマ)
		public List<Ranking> selectHuman() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000009'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(サスペンス)
		public List<Ranking> selectSuspense() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000010'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(ラブロマンス)
		public List<Ranking> selectRomance() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000011'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(ホラー)
		public List<Ranking> selectHorror() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000012'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(ファンタジー)
		public List<Ranking> selectFantasy() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000013'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(SF)
		public List<Ranking> selectSf() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000014'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す(バラエティ)
		public List<Ranking> selectBariety() {
			Connection conn = null;
			List<Ranking> ReviewRanking = new ArrayList<Ranking>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する(件数をカウントし降順で3つ表示)
				String sql = "SELECT t_review.video_id,m_video.video_name,count(t_review.video_id) FROM t_review LEFT JOIN m_video ON t_review.video_id=m_video.video_id WHERE t_review.genre_id = 'g000000015'  GROUP BY t_review.video_id ORDER BY count(t_review.video_id) DESC LIMIT 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Ranking card = new Ranking(
					rs.getString("video_id"),
					rs.getString("video_name"),
				    rs.getInt("count(t_review.video_id)")
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
