package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RankingDAO;
import model.Ranking;

/**
 * Servlet implementation class Ranking_bfServlet
 */
@WebServlet("/Ranking_bfServlet")
public class Ranking_bfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Map< String, List<String> > map = new HashMap< String, List<String> >();
				request.setAttribute("ReviewRanking", map);
				//通算別ランキングを取得する
				RankingDAO rankDao = new RankingDAO();
				List<Ranking> totalRank=rankDao.selectAll();
				//結果をリクエストスコープに入れる
				request.setAttribute("totalRank", totalRank);

				//国内別ランキングを取得する
				List<Ranking> localRank=rankDao.selectLocal();
				//結果をリクエストスコープに入れる
				request.setAttribute("localRank",localRank);


				//アニメ別ランキングを取得する
				List<Ranking> animeRank=rankDao.selectAnime();
				//結果をリクエストスコープに入れる
				request.setAttribute("animeRank",animeRank);


				//ランキングページへ遷移
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking_bf.jsp");
				dispatcher.forward(request, response);

	}
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String video_id = request.getParameter("video_id");
				String video_name = request.getParameter("video_name");

				// 検索処理を行う
				RankingDAO rDao = new RankingDAO();
				List<Ranking> ReviewRanking = rDao.select(new Ranking(video_id, video_name));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("ReviewRanking", ReviewRanking);

				//ランキングページへ遷移
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking_bf.jsp");
				dispatcher.forward(request, response);


	}
}
