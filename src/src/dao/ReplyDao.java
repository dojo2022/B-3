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
import model.Top;
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
					String sql = "INSERT INTO Reply (reply_id, review_id, user_id, reply_contents, reply_date) values (?, ?, ?, ?, ?)";
					//Date型はどうすればいい？
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getReply_id() != null && !card.getReply_id().equals("")) {
						pStmt.setString(1, card.getReply_id());
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
					if (card.getReply_contents() != null && !card.getReply_contents().equals("")) {
						pStmt.setString(4, card.getReply_contents());
					}
					else {
						pStmt.setString(4, "");
					}

					if (card.getReply_date() != null && !card.getReply_date().equals("")) {
						pStmt.setString(5, card.getReply_date());
					}
					else {
						pStmt.setString(5, "");
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

				//topページreply取得
			public List<Replydata> select3() {
				Connection conn = null;
				List<Replydata> TopReply = new ArrayList<Replydata>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する

					String sql = "SELECT m_user.user_name,t_reply.reply_date,t_reply.reply_contents FROM m_user LEFT JOIN t_reply ON m_user.user_id = t_reply.user_id";
					PreparedStatement pStmt = conn.prepareStatement(sql);

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
			//name
		public List<Top> select4(String user_id) {
			Connection conn = null;
			List<Top> Replyname = new ArrayList<Top>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する

				String sql = "SELECT m_user.user_name from m_user WHERE m_user.user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Top card = new Top(
					rs.getString("user_name"),
					"",
					"",
					"",
					""
					);
					Replyname.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				Replyname = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				Replyname = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						Replyname = null;
					}
				}
			}

			// 結果を返す
			return Replyname;
		}
		//reply送信
		public boolean insert(TopReply card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する 改造
				String sql = "insert into TopReply (user_name, reply_contents) values (?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);//そのまま

				// SQL文を完成させる 改造　データがなかったら
				if (card.getUser_name() != null && !card.getUser_name().equals("")) {
					pStmt.setString(1, card.getUser_name());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getReply_contents() != null && !card.getReply_contents().equals("")) {
					pStmt.setString(2, card.getReply_contents());
				}
				else {
					pStmt.setString(2, null);
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
	}

