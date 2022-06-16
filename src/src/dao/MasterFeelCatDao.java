package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MasterFeelCat;
import model.MasterVideo;
import model.Review;

public class MasterFeelCatDao {

	public List<MasterFeelCat> select(MasterFeelCat param) {
		Connection conn = null;
		List<MasterFeelCat> cardList = new ArrayList<MasterFeelCat>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT feelcat_id, feelcat_name from m_feelcat";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				MasterVideo card = new MasterVideo(
				rs.getString("feelcat_id"),
				rs.getString("feelcat_name")
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
				String sql = "INSERT INTO Review (feelcat1, feelcat2) values (?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getFeelcat1() != null && !card.getFeelcat1().equals("")) {
					pStmt.setString(1, card.getFeelcat1());
				}
				else {
					pStmt.setString(1, "");
				}
				if (card.getFeelcat2() != null && !card.getFeelcat2().equals("")) {
					pStmt.setString(2, card.getFeelcat2());
				}
				else {
					pStmt.setString(2, "");
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
		}
}
