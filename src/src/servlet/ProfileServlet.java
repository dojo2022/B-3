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
import model.LoginUser;
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


		//★セッションからユーザーIDを取得
		//sessionスコープにいるのならそれを取ってきて変数user_idに代入する
		LoginUser user = (LoginUser)session.getAttribute("id");
		String user_id = user.getUser_id();

		//データベースから名前を取得
		MasterUserDao dao = new MasterUserDao();
		MasterUser user2 = dao.selectOne(user_id);
		request.setAttribute("m_user", user2);

		// プロフィール変更ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profileEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_img = request.getParameter("user_img");
		String user_name = request.getParameter("user_name");
		String user_pf = request.getParameter("user_pf");

		//レビューの内容を変更する
		MasterUser prof_af = new MasterUser(user_id,"","",user_name,user_pf,user_img,"");
		MasterUserDao mDao = new MasterUserDao();

		//現在のプロフィールの内容
		MasterUser prof_bf = mDao.selectOne(user_id);

		mDao.update(prof_bf,prof_af);

		// マイページにリダイレクトする
		response.sendRedirect("/FLIFRE/MypageServlet");
	}
}
