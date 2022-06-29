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
import dao.ReviewDao;
import model.MasterVideo;
import model.Reviewdata;

/**
 * Servlet implementation class Review_bfServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//作品のidなどをもらう
		String video_id=
		request.getParameter("video_id");

		//daoを使って抽出したデータをリストに格納する
		MasterVideoDao vDao = new MasterVideoDao();
		MasterVideo video = vDao.selectOne(video_id);

		//作品の情報をリクエストスコープに入れる
		request.setAttribute("video", video);

		// 検索処理を行う
			ReviewDao rDao = new ReviewDao();
			List<Reviewdata> cardList = rDao.select(video_id);

		// 検索結果をリクエストスコープに格納する
			request.setAttribute("reviewList", cardList);

		// レビュー一覧ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		//リクエストパラメータを取得する☆
//		request.setCharacterEncoding("UTF-8");
//
//		String bottun = request.getParameter("submit");
//
//		if (bottun.equals("リプライを送信する")) {
//
//			String reply_contents = request.getParameter("textarea");
//			String review_id = request.getParameter("review_id");
//
//			// 新規リプライ送信を行う☆
//			ReplyDao pDao = new ReplyDao();
//			if (pDao.insert(new Reply("", review_id, user_id, reply_contents, ""))) { // 登録成功
//
//				request.setAttribute("result", "success");
//				//			new Result("登録成功！", "リプライを送信しました。", "/FLIFRE/MypageServlet"));
//			} else { // 登録失敗
//				request.setAttribute("result", "fail");
//				//			new Result("登録失敗！", "リプライを送信できませんでした。", "/FLIFRE/MypageServlet"));
//			}
//		}
//		String userurl="/FLIFRE/UserpageServlet?user_id="+follow_id;
//		response.sendRedirect(userurl);
//		return;
	}
}
