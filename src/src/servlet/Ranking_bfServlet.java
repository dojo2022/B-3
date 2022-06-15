package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ranking_bfServlet
 */
@WebServlet("/Ranking_bfServlet")
public class Ranking_bfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Map< String, List<String> > map = new HashMap< String, List<String> >();
				request.setAttribute("Genre", map);
				//ランキングページへ遷移
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking_bf.jsp");
				dispatcher.forward(request, response);
	}

}
