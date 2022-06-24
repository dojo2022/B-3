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

import dao.ReplyDao;
import dao.ReviewDao;
import model.LoginUser;
import model.Replydata;
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

		// レビュー一覧を検索する
				ReviewDao  rDao = new ReviewDao();
				List<Top> Reviewlist2 = rDao.select3(user_id);
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("Reviewlist2", Reviewlist2);

				// reply一覧取得
				ReplyDao  rpDao = new ReplyDao();
				List<Replydata> TopReply = rpDao.select3();
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("TopReply", TopReply);

				// name
				ReplyDao  rnDao = new ReplyDao();
				List<Top> Replyname = rnDao.select4(user_id);
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("Replyname", Replyname);

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_name = request.getParameter("user_name");
				String Reply_contents = request.getParameter("Reply_contents");


		/*		// 登録処理を行う
				ReplyDao bDao = new ReplyDao();
				if (bDao.insert(new TopReply(user_name, reply_contents))) {	// 登録成功
					request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
				}
				else {												// 登録失敗
					request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
				}
*/

	// ログイン後トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_af.jsp");
		dispatcher.forward(request, response);
	}

}