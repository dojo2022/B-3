package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// マイページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
				dispatcher.forward(request, response);
	}

		//リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String icon = request.getParameter("icon");
			String userName = request.getParameter("userName");
			String profileString = request.getParameter("profileString");
			String  = request.getParameter("");
			String postalcode = request.getParameter("postalcode");
			String address = request.getParameter("address");
			String telephonenumber = request.getParameter("telephonenumber");
			String faxnumber = request.getParameter("faxnumber");
			String mailaddress = request.getParameter("mailaddress");


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
