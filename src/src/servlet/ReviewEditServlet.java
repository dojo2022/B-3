package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import model.Review;
import model.Reviewdata;

/**
 * Servlet implementation class PostEditServlet
 */
@WebServlet("/ReviewEditServlet")
public class ReviewEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//レビュー投稿編集の時
				request.setCharacterEncoding("UTF-8");
				String subm=request.getParameter("submit");
				if(("レビュー編集完了").equals(subm)) {

					//★リクエストパラメータを取得する
							/*String review_id = request.getParameter("review_id");
							String user_id = request.getParameter("user_id");
							String video_id = request.getParameter("video_id");
					String genre_id = request.getParameter("genre_id");*/
					String review_contents = request.getParameter("review_contents");
					String feelcat_name1 = request.getParameter("feelcat_name1");
					if(feelcat_name1.equals("選択してください")){
						feelcat_name1 = "";
					}
					String feelcat_name2 = request.getParameter("feelcat_name2");
					if(feelcat_name2.equals("選択してください")){
						feelcat_name2 = "";
					}
					String star = request.getParameter("star");
					if(star.equals("選択してください")){
						star = "";
					}String review_id = request.getParameter("review_id");

					//レビューの内容を変更する
					Review review_data = new Review(review_id,"","",review_contents,"",feelcat_name1,feelcat_name2,star,"");
					ReviewDao rDao = new ReviewDao();
					
					//現在のレビューの内容
					Reviewdata now_review = rDao.select4(review_id);

					if (rDao.update(review_data,now_review)) {	// 更新成功
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
						dispatcher.forward(request, response);
					}
					else {												// 更新失敗
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
						dispatcher.forward(request, response);
					}
					// 結果ページにフォワードする

				}
	}

}
