package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Top_bfServlet
 */
@WebServlet("/Top_bfServlet")
public class Top_bfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン前トップページに遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_af.jsp");
		dispatcher.forward(request, response);
	}

}