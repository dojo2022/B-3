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
import model.LoginUser;
import model.Top;

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

		//ユーザーIDを取得
				LoginUser user = (LoginUser)session.getAttribute("id");
				String user_id = user.getUser_id();

		/*review_id取得
				Review use = (Review)session.getAttribute("id");
				String Review_id = use.getReview_id();*/

		// レビュー一覧を検索する
				ReviewDao  rDao = new ReviewDao();
				List<Top> Reviewlist2 = rDao.select3(user_id);
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("Reviewdata", Reviewlist2);

	/*	//それぞれのレビューに紐づけてリプライ表示
				ReplyDao  tDao = new ReplyDao();
				List<TopReply> TopReply = rDao.select7(review_id);
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("Review", TopReply);*/

	// ログイン後トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_af.jsp");
		dispatcher.forward(request, response);
	}

}