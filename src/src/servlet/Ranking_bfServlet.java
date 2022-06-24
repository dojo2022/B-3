package servlet;

import java.io.IOException;
import java.util.List;

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
				/*
				Map< String, List<String> > map = new HashMap< String, List<String> >();
				request.setAttribute("ReviewRanking", map);
				*/
				//通算別ランキングを取得する
				RankingDAO rankDao = new RankingDAO();
				List<Ranking> totalRank=rankDao.selectAll();
				//結果をリクエストスコープに入れる
				request.setAttribute("totalRank", totalRank);

				//アニメ別ランキングを取得する
				List<Ranking> animeRank=rankDao.selectAnime();
				//結果をリクエストスコープに入れる
				request.setAttribute("animeRank",animeRank);

				//国内別ランキングを取得する
				List<Ranking> localRank=rankDao.selectLocal();
				//結果をリクエストスコープに入れる
				request.setAttribute("localRank",localRank);

				//欧米別ランキングを取得する
				List<Ranking> usRank=rankDao.selectUs();
				//結果をリクエストスコープに入れる
				request.setAttribute("usRank",usRank);

				//韓国別ランキングを取得する
				List<Ranking> koreaRank=rankDao.selectKorea();
				//結果をリクエストスコープに入れる
				request.setAttribute("koreaRank",koreaRank);

				//華流別ランキングを取得する
				List<Ranking> chinaRank=rankDao.selectChina();
				//結果をリクエストスコープに入れる
				request.setAttribute("chinaRank",chinaRank);

				//アクション別ランキングを取得する
				List<Ranking> actionRank=rankDao.selectAction();
				//結果をリクエストスコープに入れる
				request.setAttribute("actionRank",actionRank);

				//コメディ別ランキングを取得する
				List<Ranking> comedyRank=rankDao.selectComedy();
				//結果をリクエストスコープに入れる
				request.setAttribute("comedyRank",comedyRank);

				//キッズ・ファミリー別ランキングを取得する
				List<Ranking> familyRank=rankDao.selectFamily();
				//結果をリクエストスコープに入れる
				request.setAttribute("familyRank",familyRank);

				//ヒューマンドラマ別ランキングを取得する
				List<Ranking> humanRank=rankDao.selectHuman();
				//結果をリクエストスコープに入れる
				request.setAttribute("humanRank",humanRank);

				//サスペンス別ランキングを取得する
				List<Ranking> suspenseRank=rankDao.selectSuspense();
				//結果をリクエストスコープに入れる
				request.setAttribute("suspenseRank",suspenseRank);

				//ラブロマンス別ランキングを取得する
				List<Ranking> romanceRank=rankDao.selectRomance();
				//結果をリクエストスコープに入れる
				request.setAttribute("romanceRank",romanceRank);

				//ホラー別ランキングを取得する
				List<Ranking> horrorRank=rankDao.selectHorror();
				//結果をリクエストスコープに入れる
				request.setAttribute("horrorRank",horrorRank);

				//ファンタジー別ランキングを取得する
				List<Ranking> fantasyRank=rankDao.selectFantasy();
				//結果をリクエストスコープに入れる
				request.setAttribute("fantasyRank",fantasyRank);

				//SF別ランキングを取得する
				List<Ranking> sfRank=rankDao.selectSf();
				//結果をリクエストスコープに入れる
				request.setAttribute("sfRank",sfRank);

				//バラエティ別ランキングを取得する
				List<Ranking> barietyRank=rankDao.selectBariety();
				//結果をリクエストスコープに入れる
				request.setAttribute("barietyRank",barietyRank);

				//ランキングページへ遷移
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking_bf.jsp");
				dispatcher.forward(request, response);

	}
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// リクエストパラメータを取得する
//				request.setCharacterEncoding("UTF-8");
//				String video_id = request.getParameter("video_id");
//				String video_name = request.getParameter("video_name");
//
//				// 検索処理を行う
//				RankingDAO rDao = new RankingDAO();
//				List<Ranking> ReviewRanking = rDao.select(new Ranking(video_id,video_name));
//
//				// 検索結果をリクエストスコープに格納する
//				request.setAttribute("ReviewRanking", ReviewRanking);
//
//				//ランキングページへ遷移
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking_bf.jsp");
//				dispatcher.forward(request, response);
				doGet(request,response);

	}
}
