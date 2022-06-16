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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/header.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String video_id = request.getParameter("video_id");
		String video_name = request.getParameter("video_name");
		String video_year = request.getParameter("video_year");
		String video_time = request.getParameter("video_time");
		String genre_id = request.getParameter("genre_id");

		// 検索処理を行う
		MasterVideoDao mvDao = new MasterVideoDao();
		List<MasterVideo> MasterVideoList = mvDao.select(new MasterVideo("", video_name, video_year, video_time, genre_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("MasterVideoList", MasterVideoList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result_bf.jsp");
		dispatcher.forward(request, response);
	}

}
