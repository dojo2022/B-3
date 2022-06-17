package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import model.Review;

/**
 * Servlet implementation class Top_afServlet
 */
@WebServlet("/Top_afServlet")
public class Top_afServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/FLIFRE/LoginServlet");
			return;
		}


       //リクエストパラメーター取得
		request.setCharacterEncoding("UTF-8");


		//検索処理を行う
		ReviewDao rDao = new ReviewDao();
		List<Review> ReviewRanking = rDao.select(new Review());//<改造>検索無関係はからにする

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ReviewRanking", ReviewRanking);

	// ログイン後トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_af.jsp");
		dispatcher.forward(request, response);
	}
}