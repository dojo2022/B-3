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
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Ranking> select(Ranking param) {
		Connection conn = null;
		List<Ranking> ReviewRanking = new ArrayList<Ranking>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する(件数をカウントし降順で3つ表示)
			String sql = "SELECT video_id count(video_id) FROM t_review GROUP BY video_id ORDER BY count(video_id) DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getName() != null) {
				pStmt.setString(1, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getCompany() != null) {
				pStmt.setString(2, "%" + param.getCompany() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getMail() != null) {
				pStmt.setString(3, "%" + param.getMail() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Ranking card = new Ranking(
				rs.getString("number"),
				rs.getString("name"),
				rs.getString("company"),
				rs.getString("address"),
				rs.getString("mail")
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
