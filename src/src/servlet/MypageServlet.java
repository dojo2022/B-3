package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MasterUserDao;
import model.MasterUser;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションからユーザーIDを取得
		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
		//session.getAttribute("xxx")
		//idをとる

		//if (session = "id", user) {
		// セッションスコープにIDを格納する
		//HttpSession session = request.getSession();
		//session.setAttribute(user_id);
		// }

		String user_id = "";

		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user = dao.selectOne(user_id);
		request.setAttribute("m_user", user);


		//ReviweDao dao = new ReviewDao();
		//Review user = dao.selectOne(review_id);
		//request.setAttribute("t_review", user);

		// マイページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
				dispatcher.forward(request, response);
				return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//
//				//リクエストパラメータを取得する
//				//マイレビュー投稿一覧関連
//				String review_id = request.getParameter("review_id");
//				String user_id = request.getParameter("user_id");
//				String video_id = request.getParameter("video_id");
//				String review_contents = request.getParameter("review_contents");
//				String genre_id = request.getParameter("genre_id");
//				String feelcat_name1 = request.getParameter("feelcat_name1");
//				String feelcat_name2 = request.getParameter("feelcat_name2");
//				String star = request.getParameter("star");
//				String review_date = request.getParameter("review_date");
//
//				//リプライ一覧関連
//				String reply_id = request.getParameter("reply_id");
//				String review_id = request.getParameter("review_id");
//				String user_id = request.getParameter("user_id");
//				String reply_contents = request.getParameter("reply_contents");
//				String reply_date = request.getParameter("reply_date");
//
//				//スタンプを送ったレビュー一覧関連
//				String reaction_id = request.getParameter("reaction_id");
//				String review_id = request.getParameter("review_id");
//				String user_id = request.getParameter("user_id");
//				String stamp_id = request.getParameter("stamp_id");
//
//
//			// レビュー編集処理を行う
//			ReviewDao rDao = new ReviewDao();
//			if (rDao.insert(new Review(,))) {	// 登録成功
//				request.setAttribute("result",
//				//new Result("登録成功！", "投稿しました。", "/FLIFRE/PostServlet"));
//				"success");
//			}
//			else {	// 登録失敗
//				request.setAttribute("result",
//				//new Result("登録失敗！", "投稿できませんでした。", "/FLIFRE/PostServlet"));
//				"fail");
//			}
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
//			dispatcher.forward(request, response);
//
//
//			// リプライ編集処理を行う
//			ReplyDao rDao = new ReplyDao();
//			if (rDao.insert(new Reply(,))) {	// 登録成功
//			request.setAttribute("result",
//			//new Result("登録成功！", "投稿しました。", "/FLIFRE/PostServlet"));
//			"success");
//			}
//			else {	// 登録失敗
//			request.setAttribute("result",
//			//new Result("登録失敗！", "投稿できませんでした。", "/FLIFRE/PostServlet"));
//			"fail");
//			}
//			// 結果ページにフォワードする
//		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
//			dispatcher.forward(request, response);
//
//
//			// リアクション編集処理を行う
//			ReactionDao rDao = new ReactionDao();
//			if (rDao.insert(new Reaction(,))) {	// 登録成功
//			request.setAttribute("result",
//			//new Result("登録成功！", "投稿しました。", "/FLIFRE/PostServlet"));
//			"success");
//			}
//			else {	// 登録失敗
//			request.setAttribute("result",
//			//new Result("登録失敗！", "投稿できませんでした。", "/FLIFRE/PostServlet"));
//			"fail");
//			}
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
//			dispatcher.forward(request, response);
	}

}
