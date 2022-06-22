package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import model.MasterUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新規会員登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_mail = request.getParameter("user_mail");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");

		// 登録処理を行う
		RegisterDao rgDao = new RegisterDao();
		if (rgDao.insert(new MasterUser("",user_mail,user_pw,user_name,"","",""))) {
			// 登録成功
			request.setAttribute("error_message", "登録に成功しました。ログイン画面からログインしてください。");
		} else {
			// 登録失敗
			request.setAttribute("error_message", "登録に失敗しました");
		}

		//ログインページにリダイレクトする
		response.sendRedirect("/FLIFRE/LoginServlet");
		}

}