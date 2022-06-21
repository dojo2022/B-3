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
import dao.ReviewDao;
import model.LoginUser;
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

		//★セッションからユーザーIDを取得
		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
		LoginUser user = (LoginUser)session.getAttribute("id");
		String user_id = user.getUser_id();

		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user1 = dao.selectOne(user_id);
		request.setAttribute("m_user", user1);

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


		//フォロー・解除処理を行う→どのように表現すればいい？


		// リアクション編集または削除を行う→スタンプはクリックで切り替わるけどどう表現すればいい？
		if (request.getParameter("STAMP").equals("")) {
			if (aDao.update(new Reaction(reaction_id, review_id, user_id, stamp_id))) {	// 登録成功
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
		dispatcher.forward(request, response);


		// 新規リプライ送信を行う
		ReplyDAO pDao = new pDAO();
		if (pDao.insert(new Reply(reply_id, review_id, user_id,
			reply_contents, reply_date))) {	// 登録成功
			request.setAttribute("result","success");
//			new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
		}
		else {	// 登録失敗
			request.setAttribute("result","fail");
//			new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
		dispatcher.forward(request, response);



	}

}
