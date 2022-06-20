package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MasterUserDao;
import model.MasterUser;

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

//		//★セッションからユーザーIDを取得 →書き方分からない
//		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
//		//session.getAttribute("xxx")
//		//idをとる
//		if (session = "id", user) {
//		// セッションスコープにIDを格納する
//		HttpSession session = request.getSession();
//		session.setAttribute(user_id);
//		session.getAttribute("user_id")
//		}


		String user_id = "";

		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user = dao.selectOne(user_id);
		request.setAttribute("m_user", user);

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

		//フォロー・解除処理


//		// リアクション編集または削除を行う→スタンプはクリックで切り替わるだけだからいらない？
//
//		// 新規リプライ送信を行う
//		ReplyDAO pDao = new pDAO();
//		if (pDao.insert(new Reply(reply_id, review_id, user_id,
//			reply_contents, reply_date))) {	// 登録成功
//			request.setAttribute("result",
//			new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
//		}
//		else {	// 登録失敗
//			request.setAttribute("result",
//			new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
//		}
//
//		// 結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/FLIFRE/jsp/mypage.jsp");
//		dispatcher.forward(request, response);
//
//

	}

}
