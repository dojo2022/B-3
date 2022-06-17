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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		//リクエストパラメータを取得する 画面に表示 GET?
		//マイプロフィール関連
			request.setCharacterEncoding("UTF-8");
			String user_id = request.getParameter("user_id");
			String user_img = request.getParameter("user_img");
			String user_name = request.getParameter("user_name");
			String user_pf = request.getParameter("user_pf");
			String user_hd = request.getParameter("user_hd");
			String follow_id = request.getParameter("follow_id");

		//マイレビュー投稿一覧関連
			String review_id = request.getParameter("review_id");
			String user_id = request.getParameter("user_id");
			String video_id = request.getParameter("video_id");
			String review_contents = request.getParameter("review_contents");
			String genre_id = request.getParameter("genre_id");
			String feelcat_name1 = request.getParameter("feelcat_name1");
			String feelcat_name2 = request.getParameter("feelcat_name2");
			String star = request.getParameter("star");
			String review_date = request.getParameter("review_date");

		//リプライ一覧関連
			String reply_id = request.getParameter("reply_id");
			String review_id = request.getParameter("review_id");
			String user_id = request.getParameter("user_id");
			String reply_contents = request.getParameter("reply_contents");
			String reply_date = request.getParameter("reply_date");

		//スタンプを送ったレビュー一覧関連
			String reaction_id = request.getParameter("reaction_id");
			String review_id = request.getParameter("review_id");
			String user_id = request.getParameter("user_id");
			String stamp_id = request.getParameter("stamp_id");

	}

		//リクエストパラメータを取得する 内容の編集 こっちがPOST？

}
