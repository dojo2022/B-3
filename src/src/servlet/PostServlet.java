package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MasterUserDao;
import dao.MasterVideoDao;
import dao.ReviewDao;
import model.MasterUser;
import model.MasterVideo;
import model.Review;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//作品のidなどをもらう
		String video_id=
		request.getParameter("video_id");

		//daoを使って抽出したデータをリストに格納する
		MasterVideoDao vDao = new MasterVideoDao();
		MasterVideo video = vDao.selectOne(video_id);

		//作品の情報をリクエストスコープに入れる
		request.setAttribute("video", video);

		//今だけ本番はセッションスコープの「id」を使う
		request.setAttribute("id", "test");

		MasterUserDao uDao = new MasterUserDao();
		MasterUser user = uDao.selectOne("test");

		request.setAttribute("user",user);

		// 投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
		dispatcher.forward(request, response);
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String video_id = request.getParameter("video_id");
		String user_id = request.getParameter("user_id");
		String review_contents = request.getParameter("review_contents");
		String genre_id = request.getParameter("genre_id");
		String feelcat_name1 = request.getParameter("feelcat_name1");
		String feelcat_name2 = request.getParameter("feelcat_name2");
		String star = request.getParameter("star");


		// 投稿処理を行う
		ReviewDao rDao = new ReviewDao();


		if (rDao.insert(new Review(video_id, user_id, review_contents, genre_id, feelcat_name1, feelcat_name2, star))) {	// 登録成功
			request.setAttribute("result","投稿しました。");
//			new Result("登録成功！", "投稿しました。", "/simpleBC/PostServlet"));
		}
		else {	// 登録失敗
			request.setAttribute("result","投稿できませんでした。");
//			new Result("登録失敗！", "投稿できませんでした。", "/simpleBC/PostServlet"));
		}

		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_af.jsp");
		dispatcher.forward(request, response);
	}
}
