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
import model.LoginUser;
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

		LoginUser user = (LoginUser)session.getAttribute("id");

		// フォロー一覧を検索する
		FollowDao  fDao = new FollowDao();
		List<MasterUser> followList = fDao.FollowUser(user.getUser_id());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followList", followList);

		// フォロワー一覧を検索する
		FollowDao  fwDao = new FollowDao();
		List<MasterUser> followerList = fwDao.FollowerUser(user.getUser_id());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followerList", followerList);

		// フォロー/フォロワー一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/follow_list.jsp");
		dispatcher.forward(request, response);
	}
}

