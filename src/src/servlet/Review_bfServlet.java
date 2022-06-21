package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import model.Review;

/**
 * Servlet implementation class Review_bfServlet
 */
@WebServlet("/Review_bfServlet")
public class Review_bfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review_bfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 検索処理を行う
			ReviewDao rDao = new rDAO();
			List<Review> cardList = rDao.select(new Review("", "", "", "", "", "", "", "", ""));

		// 検索結果をリクエストスコープに格納する
			request.setAttribute("reviewList", cardList);

		// レビュー一覧ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review_bf.jsp");
			dispatcher.forward(request, response);
	}
}
