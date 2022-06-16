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

import dao.FollowDao;
import model.MasterUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/FollowlistServlet")
public class FollowlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/FLIFRE/LoginServlet");
			return;
		}

		// フォロー一覧
		FollowDao  fDao = new FollowDao();
		List<MasterUser> followList = fDao.FollowUser();

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followList", followList);

		// フォロー/フォロワー一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/follow_list.jsp");
		dispatcher.forward(request, response);
	}
}

