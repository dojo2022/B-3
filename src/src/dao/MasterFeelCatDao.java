//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.MasterFeelCat;
//
//public class MasterFeelCatDao {
//
//	public List<MasterFeelCat> select(MasterFeelCat param) {
//		Connection conn = null;
//		List<MasterFeelCat> cardList = new ArrayList<MasterFeelCat>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
//
//			// SQL文を準備する
//			String sql = "SELECT feelcat_id, feelcat_name from m_feelcat";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を実行し、結果表を取得する
//			ResultSet rs = pStmt.executeQuery();
//
//			// 結果表をコレクションにコピーする
//			while (rs.next()) {
//				MasterFeelCat card = new MasterFeelCat(
//				rs.getString("feelcat_id"),
//				rs.getString("feelcat_name")
//				);
//				cardList.add(card);
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			cardList = null;
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			cardList = null;
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//					cardList = null;
//				}
//			}
//		}
//
//		// 結果を返す
//		return cardList;
//	}
//}
