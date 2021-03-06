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
import model.Top;

/**
 * Servlet implementation class Top_afServlet
 */
@WebServlet("/Top_bfServlet")
public class Top_bfServlet extends HttpServlet {
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
		/*		if (session.getAttribute("id") == null) {
					response.sendRedirect("/FLIFRE/Top_bfServlet");
					return;
				}*/


		// レビュー一覧を検索する☆
		ReviewDao rDao = new ReviewDao();
		List<Top> Reviewlist = rDao.select1();


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Review", Reviewlist);

	// ログイン後トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_bf.jsp");
		dispatcher.forward(request, response);
	}

}