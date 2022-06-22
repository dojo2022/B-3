package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MasterVideoDao;
import model.MasterVideo;

/**
 * Servlet implementation class Result_afServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String time = request.getParameter("time") != null ? request.getParameter("time") : "-1";
		String year = request.getParameter("year") != null ? request.getParameter("year") : "-1";
		String feelcat1 = request.getParameter("feelcat1");
		String feelcat2 = request.getParameter("feelcat2");
		String title = request.getParameter("title");
		String genre_id = request.getParameter("genre_id");

		// 検索処理を行う
		MasterVideoDao mvDao = new MasterVideoDao();
		List<MasterVideo> MasterVideoList = null;
		MasterVideo params = new MasterVideo(null, title, Integer.parseInt(year), Integer.parseInt(time), genre_id);
		if ( (feelcat1 == null || feelcat1.isEmpty()) && (feelcat2 == null || feelcat2.isEmpty()) ) {
			MasterVideoList = mvDao.select(params);
		} else {
			MasterVideoList = mvDao.selectFromReview(params, feelcat1, feelcat2);
		}

		request.setAttribute("videoList", MasterVideoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
