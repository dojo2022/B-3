package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
import dao.ReviewDao;
import model.Follow;
import model.MasterUser;
import model.Reaction;
import model.Reply;
import model.Review;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/FLIFRE/LoginServlet");
		return;
		}


		//パラメーターからユーザーIDを取得
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");


		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user1 = dao.selectOne(user_id);
		request.setAttribute("m_user", user1);

		// フォロー・フォロワーを数える
		FollowDao  ffDao = new FollowDao();
		int follow_count = ffDao.Followcount(user_id);
		int follower_count = ffDao.Followercount(user_id);
		// 計算結果をリクエストスコープに格納する
		request.setAttribute("followCount", follow_count);
		request.setAttribute("followerCount", follower_count);

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


		// レビュー一覧を検索する
		ReviewDao  rDao = new ReviewDao();
		List<Review> Review = rDao.select(user_id);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Review", Review);


		// ユーザーページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String reply_id = request.getParameter("reply_id");
		String reply_contents = request.getParameter("reply_contents");
		//JAVAで現在時刻を取得する
		LocalDateTime now_datetime2 = LocalDateTime.now();
		//取得したデータを文字列型「"yyyy/MM/dd hh:mm:ss"」に変換する
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String reply_date = sdf2.format(now_datetime);

		String reaction_id = request.getParameter("reaction_id");
		String stamp_id = request.getParameter("stamp_id");

		String user_id = request.getParameter("user_id");

		//フォロー・解除処理を行う→どのように表現すればいい？
		if (request.getParameter("FOLLOW").equals("")) {
			if (fDao.update(new Reaction(user_id))) {	// フォロー成功
				request.setAttribute("result","success");
//				new Result("更新成功", "新しくフォローしました。", "/FLIFRE/MypageServlet"));
			}
			else {
				request.setAttribute("result","fail");
//				new Result("更新失敗", "新しくフォローできませんでした。", "/FLIFRE/MypageServlet"));
			}
		}
		else {
			if (fDao.delete(user_id)) {	// 削除成功
				request.setAttribute("result","success");
//				new Result("削除成功！", "フォローを解除しました。", "/FLIFRE/MypageServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result","fail");
//				new Result("削除失敗！", "フォローを解除できませんでした。", "/FLIFRE/MypageServlet"));
			}
		}
		// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
				dispatcher.forward(request, response);


		if (request.getParameter("STAMP").equals("")) {
			if (aDao.update(new Reaction(reaction_id, stamp_id))) {	// 登録成功
				request.setAttribute("result","success");
//				new Result("更新成功", "新しいスタンプに変更しました。", "/FLIFRE/MypageServlet"));
			}
			else {
				request.setAttribute("result","fail");
//				new Result("更新失敗", "新しいスタンプに変更できませんでした。", "/FLIFRE/PostServlet"));
			}
		}
		else {
			if (aDao.delete(reaction_id)) {	// 削除成功
				request.setAttribute("result","success");
//				new Result("削除成功！", "リアクションを削除しました。", "/FLIFRE/MypageServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result","fail");
//				new Result("削除失敗！", "リアクションを削除できませんでした。", "/FLIFRE/MypageServlet"));
			}
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
		dispatcher1.forward(request, response);


		// 新規リプライ送信を行う
		ReplyDAO pDao = new pDAO();
		if (pDao.insert(new Reply(reply_id, reply_contents, reply_date))) {	// 登録成功
			request.setAttribute("result","success");
//			new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
		}
		else {	// 登録失敗
			request.setAttribute("result","fail");
//			new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
		dispatcher2.forward(request, response);



	}

}
