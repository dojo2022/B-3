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
import dao.ReactionDao;
import dao.ReplyDao;
import dao.ReviewDao;
import model.LoginUser;
import model.MasterUser;
import model.Reaction;
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

		//★セッションからユーザーIDを取得
		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
		LoginUser user = (LoginUser)session.getAttribute("id");
		String user_id = user.getUser_id();


		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser userdata = dao.selectOne(user_id);
		request.setAttribute("m_user", userdata);

		// フォロー・フォロワーを数える
		FollowDao  fDao = new FollowDao();
		int follow_count = fDao.Followcount(user_id);
		int follower_count = fDao.Followercount(user_id);
		// 計算結果をリクエストスコープに格納する
		request.setAttribute("followCount", follow_count);
		request.setAttribute("followerCount", follower_count);

		// レビュー一覧を検索する
		ReviewDao  rDao = new ReviewDao();
		List<Review> Review = rDao.select(user_id);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Review", Review);

		// リプライ一覧を検索する
		ReplyDao  pDao = new ReplyDao();
 		List<Reply> Reply = pDao.select(user_id);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Reply", Reply);

		// リアクション一覧を検索する
		ReactionDao  aDao = new ReactionDao();
		List<Reaction> Reaction = aDao.select(user_id);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Reaction", Reaction);


//		// フォロー一覧を検索する
//				FollowDao  fDao = new FollowDao();
//				List<MasterUser> followList = fDao.FollowUser(user.getUser_id());
//
//				// 検索結果をリクエストスコープに格納する
//				request.setAttribute("followList", followList);
//



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
			String review_id1 = request.getParameter("review_id");
			String user_id1 = request.getParameter("user_id");
			String reply_contents = request.getParameter("reply_contents");
			String reply_date = request.getParameter("reply_date");


			//スタンプを送ったレビュー一覧関連
			String reaction_id = request.getParameter("reaction_id");
			//String review_id = request.getParameter("review_id");
			//String user_id = request.getParameter("user_id");
			String stamp_id = request.getParameter("stamp_id");


			// レビュー編集または削除を行う
			ReviewDao rDao = new ReviewDao();
  		if (request.getParameter("REVIEWEDIT").equals("編集")) {
				if (rDao.update(new Review(review_id1, user_id1, video_id, review_contents,
					genre_id, feelcat_name1, feelcat_name2, star, review_date))) {	// 登録成功
					request.setAttribute("result","success");
//					new Result("更新成功", "新しいレビューを投稿しました。", "/FLIFRE/MypageServlet"));
				}
				else {
					request.setAttribute("result","fail");
//					new Result("更新失敗", "新しいレビューを投稿できませんでした。", "/FLIFRE/PostServlet"));
				}
			}
			else {
				if (rDao.delete(review_id1)) {	// 削除成功
					request.setAttribute("result","success");
//					new Result("削除成功！", "レビューを削除しました。", "/FLIFRE/MypageServlet"));
				}
				else {						// 削除失敗
					request.setAttribute("result","fail");
//					new Result("削除失敗！", "レビューを削除できませんでした。", "/FLIFRE/MypageServlet"));
				}
			}
  			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);


			// リプライ編集または削除を行う
			ReplyDao pDao = new ReplyDao();
			if (request.getParameter("REPLYWEDIT").equals("編集")) {
				if (pDao.update(new Reply(reply_id, review_id1, user_id1,
		  			reply_contents, reply_date))) {	// 登録成功
					request.setAttribute("result","success");
//					new Result("更新成功", "新しいリプライを送信しました。", "/FLIFRE/MypageServlet"));
				}
				else {
					request.setAttribute("result","fail");
//					new Result("更新失敗", "新しいリプライを送信できませんでした。", "/FLIFRE/PostServlet"));
				}
			}
			else {
				if (rDao.delete(reply_id)) {	// 削除成功
					request.setAttribute("result","success");
//					new Result("削除成功！", "リプライを削除しました。", "/FLIFRE/MypageServlet"));
				}
				else {						// 削除失敗
					request.setAttribute("result","fail");
//					new Result("削除失敗！", "リプライを削除できませんでした。", "/FLIFRE/MypageServlet"));
				}
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);


			// リアクション編集または削除を行う→スタンプはクリックで切り替わるけどどう表現すればいい？
			if (request.getParameter("STAMP").equals("")) {
				if (aDao.update(new Reaction(reaction_id, review_id1, user_id1, stamp_id))) {	// 登録成功
					request.setAttribute("result","success");
//					new Result("更新成功", "新しいスタンプに変更しました。", "/FLIFRE/MypageServlet"));
				}
				else {
					request.setAttribute("result","fail");
//					new Result("更新失敗", "新しいスタンプに変更できませんでした。", "/FLIFRE/PostServlet"));
				}
			}
			else {
				if (aDao.delete(reaction_id)) {	// 削除成功
					request.setAttribute("result","success");
//					new Result("削除成功！", "リアクションを削除しました。", "/FLIFRE/MypageServlet"));
				}
				else {						// 削除失敗
					request.setAttribute("result","fail");
//					new Result("削除失敗！", "リアクションを削除できませんでした。", "/FLIFRE/MypageServlet"));
				}
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);


			// 新規リプライ送信を行う
			ReplyDAO pDao = new pDAO();
			if (pDao.insert(new Reply(reply_id, review_id1, user_id1,
				reply_contents, reply_date))) {	// 登録成功
				request.setAttribute("result","success");
//				new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
			}
			else {	// 登録失敗
				request.setAttribute("result","fail");
//				new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
			dispatcher.forward(request, response);
	}
}