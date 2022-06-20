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
<<<<<<< HEAD
=======
import model.LoginUser;
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14
import model.MasterUser;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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

<<<<<<< HEAD
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
=======
		//★セッションからユーザーIDを取得
		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
		LoginUser user = (LoginUser)session.getAttribute("id");
		String user_id = user.getUser_id();

		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user2 = dao.selectOne(user_id);
		request.setAttribute("m_user", user2);
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14

		// プロフィール変更ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profileEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
<<<<<<< HEAD

		//プロフィール変更処理
=======
		//リクエストパラメータを取得する

		//プロフィール更新(変更)処理
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14

	}

}
