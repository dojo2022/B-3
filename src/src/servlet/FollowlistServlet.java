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
import model.Follow;
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
		List<Follow> followerList = fwDao.FollowerUser(user.getUser_id());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followerList", followerList);

		// フォロー/フォロワー一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/follow_list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String follow_id = request.getParameter("follow_id");
		String bottun = request.getParameter("followBottun");

// フォロー・フォロー解除処理を行う
		FollowDao flwDao = new FollowDao();
		if (bottun.equals("フォロー")) {
			flwDao.insert(user_id,follow_id);
		} else {
			flwDao.delete(user_id, follow_id);
		}


		//フォロー/フォロワー一覧ページにリダイレクトする
		response.sendRedirect("/FLIFRE/FollowlistServlet");
		}

}

