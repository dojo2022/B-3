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

/**
 * Servlet implementation class Ranking_bfServlet
 */
@WebServlet("/Ranking_bfServlet")
public class Ranking_bfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String review_id = request.getParameter("");
				String company = request.getParameter("company");
				String address = request.getParameter("address");
				String mail = request.getParameter("mail");

				// 検索処理を行う
				RankingDAO bDao = new RankingDAO();
				List<Ranking> cardList = bDao.select(new Ranking(number, name, company, address, mail));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking_bf.jsp");
				dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
