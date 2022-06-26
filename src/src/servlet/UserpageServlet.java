package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import model.Follow;
import model.LoginUser;
import model.MasterUser;
import model.Reply;
import model.Reviewdata;

/**
 * Servlet implementation class UserpageServlet
 */
@WebServlet("/UserpageServlet")
public class UserpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserpageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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

		//パラメーターからユーザーIDを取得
		request.setCharacterEncoding("UTF-8");
		//このユーザーIDはフォローしている人のID
		String user_id = request.getParameter("user_id");

		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user = dao.selectOne(user_id);
		request.setAttribute("m_user", user);

		// フォロー・フォロワーを数える
		FollowDao ffDao = new FollowDao();
		int follow_count = ffDao.Followcount(user_id);
		int follower_count = ffDao.Followercount(user_id);
		// 計算結果をリクエストスコープに格納する
		request.setAttribute("followCount", follow_count);
		request.setAttribute("followerCount", follower_count);

		// フォロー一覧を検索する いるのか？
		FollowDao fDao = new FollowDao();
		List<MasterUser> followList = fDao.FollowUser(user.getUser_id());
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followList", followList);

		// フォロワー一覧を検索する いるのか？
		FollowDao fwDao = new FollowDao();
		List<Follow> followerList = fwDao.FollowerUser(user.getUser_id());
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followerList", followerList);

		// レビュー一覧を検索する☆
		ReviewDao rDao = new ReviewDao();
		List<Reviewdata> Reviewdata = rDao.select2(user_id);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Reviewdata", Reviewdata);

		FollowDao flwDao = new FollowDao();
		LoginUser loginUser = (LoginUser) session.getAttribute("id");
		String loginId = loginUser.getUser_id();
		boolean check = flwDao.check(loginId, user_id);
		request.setAttribute("check", check);

		// ユーザーページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//リクエストパラメータを取得する☆
		request.setCharacterEncoding("UTF-8");
		//		String reply_id = request.getParameter("reply_id");
		//		String reply_contents = request.getParameter("reply_contents");
		////		//JAVAで現在時刻を取得する
		////		LocalDateTime now_datetime2 = LocalDateTime.now();
		////		//取得したデータを文字列型「"yyyy/MM/dd hh:mm:ss"」に変換する
		////		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		////		String reply_date = sdf2.format(now_datetime);
		//
		//		String reaction_id = request.getParameter("reaction_id");
		//		String stamp_id = request.getParameter("stamp_id");

		// リクエストパラメータを取得する
		String user_id = request.getParameter("user_id");
		String follow_id = request.getParameter("follow_id");
		String bottun = request.getParameter("submit");

		// フォロー・フォロー解除処理を行う
		FollowDao flwDao = new FollowDao();
		if (bottun.equals("フォロー")) {
			flwDao.insert(user_id, follow_id);
		} else if (bottun.equals("フォロー解除")) {
			flwDao.delete(user_id, follow_id);
			//リプライの送信処理
		} else if (bottun.equals("リプライを送信する")) {

			String reply_contents = request.getParameter("textarea");
			String review_id = request.getParameter("review_id");

			// 新規リプライ送信を行う☆
			ReplyDao pDao = new ReplyDao();
			if (pDao.insert(new Reply("", review_id, user_id, reply_contents, ""))) { // 登録成功

				request.setAttribute("result", "success");
				//			new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
			} else { // 登録失敗
				request.setAttribute("result", "fail");
				//			new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
			}
			//ueda
			//reviewデータ（replyのデータ）のデータを取得する
			//取得したデータをセッションスコープに格納する
			//user_idからreview_idを取得する（だれがどのレビューを書いたか一覧）
			//

			ReplyDao rDao = new ReplyDao();
			List<String> Reviews = rDao.select_review_user_id(user_id);
			//リプライがあったレビューの一覧を取得
			List<List<Reply>>replyLists = new ArrayList<List<Reply>>();
			for(String Review_id: Reviews) {
				List<Reply> replyList = rDao.select_name_contents_date(Review_id);
				replyLists.add(replyList);
			}
			HttpSession session = request.getSession();
			session.setAttribute("replyLists", replyLists);



		}
		// 結果ページにフォワードする
		//				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
		response.sendRedirect("/FLIFRE/MypageServlet");

	}

}

//フォロー/フォロワー一覧ページにリダイレクトする
/*	response.sendRedirect("/FLIFRE/MypageServlet?user_id=${id.user_id}");*/

//				// リアクション編集または削除を行う→スタンプはクリックで切り替わるけどどう表現すればいい？☆
//				ReactionDao aDao = new ReactionDao();
//				if (request.getParameter("STAMP").equals("")) {
//					if (aDao.update(new Reaction(reaction_id, stamp_id, user_id, stamp_id))) {	// 登録成功
//						request.setAttribute("result","success");
//		//				new Result("更新成功", "新しいスタンプに変更しました。", "/FLIFRE/MypageServlet"));
//					}
//					else {
//						request.setAttribute("result","fail");
//		//				new Result("更新失敗", "新しいスタンプに変更できませんでした。", "/FLIFRE/PostServlet"));
//					}
//				}
//				else {
//					if (aDao.delete(reaction_id)) {	// 削除成功
//						request.setAttribute("result","success");
//		//				new Result("削除成功！", "リアクションを削除しました。", "/FLIFRE/MypageServlet"));
//					}
//					else {						// 削除失敗
//						request.setAttribute("result","fail");
//		//				new Result("削除失敗！", "リアクションを削除できませんでした。", "/FLIFRE/MypageServlet"));
//					}
//				}
//				// 結果ページにフォワードする
//				RequestDispatcher dispatcher1 = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
//				dispatcher1.forward(request, response);
