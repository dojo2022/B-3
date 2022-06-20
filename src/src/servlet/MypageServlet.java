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
import dao.MasterUserDao;
import dao.ReplyDao;
import dao.ReviewDao;
import model.LoginUser;
import model.MasterUser;
import model.Reply;
import model.Review;

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

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/FLIFRE/LoginServlet");
		return;
		}

//		//★セッションからユーザーIDを取得 →書き方分からない
//		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
		LoginUser user = (LoginUser)session.getAttribute("id");
		String user_id = user.getUser_id();



		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser userdata = dao.selectOne(user_id);
		request.setAttribute("m_user", userdata);

//		// フォロー一覧を検索する
		FollowDao  fDao = new FollowDao();
		int follow_count = fDao.Followcount(user_id);
		int followed_count = fDao.Followedcount(user_id);
//		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followCount", follow_count);
		request.setAttribute("followedCount", followed_count);
//		// 投稿一覧を検索する
		ReviewDao  rDao = new ReviewDao();
		List<Review> Review = rDao.select(user_id);
//
//		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Review", Review);


		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

//		//レビュー投稿編集・リプライ編集・スタンプ反応・リプライ送信処理
//		// Resultページがいるのか？
//
			//★リクエストパラメータを取得する
			//マイレビュー投稿一覧関連
			request.setCharacterEncoding("UTF-8");
			String review_id = request.getParameter("review_id");
			String user_id = request.getParameter("user_id");
			String video_id = request.getParameter("video_id");
			String review_contents = request.getParameter("review_contents");
			String genre_id = request.getParameter("genre_id");
			String feelcat_name1 = request.getParameter("feelcat_name1");
			String feelcat_name2 = request.getParameter("feelcat_name2");
			String star = request.getParameter("star");
			String review_date = request.getParameter("review_date");

			//リプライ一覧関連
			String reply_id = request.getParameter("reply_id");
			String review_id = request.getParameter("review_id");
			String user_id = request.getParameter("user_id");
			String reply_contents = request.getParameter("reply_contents");
			String reply_date = request.getParameter("reply_date");

//			//スタンプを送ったレビュー一覧関連
//			String reaction_id = request.getParameter("reaction_id");
//			String review_id = request.getParameter("review_id");
//			String user_id = request.getParameter("user_id");
//			String stamp_id = request.getParameter("stamp_id");
//
//
			// レビュー編集または削除を行う
			ReviewDao rDao = new ReviewDao();
  		if (request.getParameter("REVIEWEDIT").equals("編集")) {
				if (rDao.update(new Review(review_id, user_id, video_id, review_contents,
					genre_id, feelcat_name1, feelcat_name2, star, review_date))) {	// 登録成功
					request.setAttribute("result",
					new Result("更新成功", "新しいレビューを投稿しました。", "/FLIFRE/MypageServlet"));
				}
				else {
					request.setAttribute("result",
					new Result("更新失敗", "新しいレビューを投稿できませんでした。", "/FLIFRE/PostServlet"));
				}
			}
			else {
				if (rDao.delete(review_id)) {	// 削除成功
					request.setAttribute("result",
					new Result("削除成功！", "レビューを削除しました。", "/FLIFRE/MypageServlet"));
				}
				else {						// 削除失敗
					request.setAttribute("result",
					new Result("削除失敗！", "レビューを削除できませんでした。", "/FLIFRE/MypageServlet"));
				}
			}
  			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);


			// リプライ編集または削除を行う
			ReplyDao pDao = new ReplyDao();
			if (request.getParameter("REPLYWEDIT").equals("編集")) {
				if (pDao.update(new Reply(reply_id, review_id, user_id,
		  			reply_contents, reply_date))) {	// 登録成功
					request.setAttribute("result",
					new Result("更新成功", "新しいリプライを送信しました。", "/FLIFRE/MypageServlet"));
				}
				else {
					request.setAttribute("result",
					new Result("更新失敗", "新しいリプライを送信できませんでした。", "/FLIFRE/PostServlet"));
				}
			}
			else {
				if (rDao.delete(reply_id)) {	// 削除成功
					request.setAttribute("result",
					new Result("削除成功！", "リプライを削除しました。", "/FLIFRE/MypageServlet"));
				}
				else {						// 削除失敗
					request.setAttribute("result",
					new Result("削除失敗！", "リプライを削除できませんでした。", "/FLIFRE/MypageServlet"));
				}
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);


			// リアクション編集または削除を行う→スタンプはクリックで切り替わるだけだからいらない？

			// 新規リプライ送信を行う
			ReplyDAO pDao = new pDAO();
			if (pDao.insert(new Reply(reply_id, review_id, user_id,
				reply_contents, reply_date))) {	// 登録成功
				request.setAttribute("result",
				new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
			}
			else {	// 登録失敗
				request.setAttribute("result",
				new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);
	}
}