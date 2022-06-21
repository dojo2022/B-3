<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js " defer></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<!-- メインここから -->
	<main>

		<!-- マイプロフィールボックスここから -->
		<div class="myprofile">
			<span><!-- ヘッダー -->
			${m_user.user_hd}
			<!-- m_userのuser_hdを引用、myprofileクラスの背景に配置したい -->
			</span>

			<span><!-- アイコン -->
			${m_user.user_img}
			</span>
			<!-- m_userのuser_imgを引用、丸い形にするかは未定 -->
			<br>

			<span><!-- ユーザー名  -->
			${m_user.user_name}
			</span><!-- m_userのuser_nameを引用 -->


			<span class ="pf_edit"><!-- プロフィール編集ボタン -->
			<a  href="/FLIFRE/ProfileServlet"><img src="./images/pf_edit.png"></a>
			</span>
			<br>
			<br>

			<span><!-- プロフィール文 -->
			${m_user.user_pf}
			</span><!-- m_userのuser_pfを引用 -->
			<br>
			<br>

			<a id="follow" href="/FLIFRE/FollowlistServlet">
			<span>フォロー　${followCount}</span>
			<span>フォロワー　${followerCount}</span>
			</a>
		</div>
		<!-- マイプロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここから -->
		<form id="mylist_edit" method="POST" action="/FLIFRE/MypageServlet">
			<table>
				<tr>
					<td>
					<span id="review_tag"> レビュー投稿 </span>
					<span id="reply_tag"> リプライ </span>
					<span id="stamp_tag">スタンプを送ったレビュー </span>
					</td>
				</tr>
				<tr>
					<td>
						<div id="review_list">
						<!--t_reviewを呼び出したい -->
						<hr>
						<br>
						<c:forEach var="e" items="${Review}" >
							<span><!-- アイコン -->
							${m_user.user_img}
							</span><!-- m_userのuser_imgを引用 --><!-- t_reviewのuser_idを引用? -->

							<span><!-- ユーザー名  -->
							${m_user.user_name}
							${t_review.user_id}
							</span><!-- m_userのuser_nameを引用 --><!-- t_reviewのuser_idを引用? -->
						<br>
						<br>

							<span><!-- 作品名 -->
							${t_review.review_id}
							${t_review.video_id}
							${m_video.video_name}
							</span><!-- t_reviewのvideo_idを引用 -->

							<span><!-- 5段階評価  -->
							${t_review.star}
							</span><!-- t_reviewのstarを引用 -->

							<span><!-- 投稿日時 -->
							${t_review.review_date}
							</span><!-- t_reviewのreview_dateを引用 -->
						<br>

							<span><!--  ジャンル  -->
							${t_review.genre_id}
							</span><!-- t_reviewのgenre_idを引用 -->

							<span><!-- 感想カテゴリ1 -->
							${t_review.feelcat_name1}
							</span><!-- t_reviewのfeelcat_name1を引用 -->

							<span><!--  感想カテゴリ2  -->
							${t_review.feelcat_name2}
							</span><!-- t_reviewのfeelcat_name2を引用 -->

							<span><!-- レビュー本文 -->
							${t_review.review_contents}
							</span><!-- t_reviewのreview_contentsを引用 -->
							<br>
							<br>

							<input class="delete" type="submit" name="REVIEWDELETET" value="削除">
							<input class="edit" type="submit" name="REVIEWEDIT" value="編集">
						<br>
						<hr>
						<br>
						</c:forEach>
						</div>

						<div id="reply_list">
						<!-- t_replyを呼び出したい -->
						<hr>
						<c:forEach var="e" items="${Reply}" >
							<!-- <span> 送り先のユーザー名
							${t_review.user_id}
							</span> -->
						<br>
						<br>

							<!-- 自分のアイコン -->
							${m_user.user_img}
							<!-- m_userのuser_imgを引用 --><!-- t_replyのuser_idを引用? -->
						<br>

							<span><!-- 自分のユーザー名 -->
							${m_user.user_name}
							</span><!-- m_userのuser_nameを引用 --><!-- t_replyのuser_idを引用? -->
						<br>
						<br>

							<span><!-- 投稿日時 -->
							${t_reply.reply_date}
							</span><!-- t_replyのreply_dateを引用 -->
							<br>

							<span><!-- リプライ本文 -->
							${t_reply.reply_contents}
							</span><!-- t_replyのreply_contentsを引用 -->
							<br>
							<br>

							<input class="delete" type="submit" name="REPLYDELETET" value="削除">
							<input class="edit" type="submit" name="REPLYWEDIT" value="編集">
						<br>
						<br>
						</c:forEach>
						<hr>
						</div>

						<div id="stamp_list">
						<!--t_reactionを呼び出したい-->
						<hr>
						<c:forEach var="e" items="${Reaction}" >
							<a  href="/FLIFRE/UserpageServlet">
							<!-- アイコン -->
							${m_user.user_img}
							</a>
							<!-- m_userのuser_imgを引用 --> <!-- t_reactionのreview_idを引用？ -->

							<a  href="/FLIFRE/UserpageServlet">
							<span><!-- ユーザー名 -->
							${m_user.user_name}
							</span>
							</a>
							<!-- t_reviewのuser_nameを引用 --><!-- t_reactionのreview_idを引用？ -->
						<br>
						<br>

							<span><!-- 作品名 -->
							${t_review.video_id}
							</span><!-- t_reviewのvideo_idを引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!--  5段階評価  -->
							${t_review.star}
							</span><!-- t_reviewのstarを引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!-- 2022年6月12日 16時00分 -->
							${t_review.review_date}
							</span><!-- t_reviewのreview_dateを引用 --><!-- t_reactionのreview_idを引用？ -->
						<br>

							<span><!--  ジャンル  -->
							${t_review.genre_id}
							</span><!-- t_reviewのgenre_idを引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!--  感想カテゴリ1 -->
							${t_review.feelcat_name1}
							</span><!-- t_reviewのfeelcat_name1を引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!--  感想カテゴリ2 -->
							${t_review.feelcat_name2}
							</span><!-- t_reviewのfeelcat_name2を引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!-- レビュー本文 -->
							${t_review.review_contents}
							</span><!-- t_reviewのreview_contentsを引用 --><!-- t_reactionのreview_idを引用？ -->
							<br>

							<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
							<!-- スタンプの画像をクリックすると画像が変化 -->
							${t_reaction.stamp_id}
							<!-- m_stampのstamp_id, stamp_name -->
							<br>

								<!-- リプライフォームここから ここのデータ格納方法が分からない-->
								<label class="open"	for="popup"><img id="reply" src="images/reply.png"
								onclick="replyfrom()" width="50" height="50">
								</label>
								<input type="checkbox" id="popup">
								<div class="overlay">
									<div class="window">
										<label class="close" for="popup">× </label>
										<div class="example">
											<label for="namelabel">ユーザー名</label>
											<br>
											<input type="text" name="name" id="namelabel" placeholder="">
											<br>
										</div>
										<div class="example">
											<label for="ikenlabel">リプライ内容</label>
											<br>
											<textarea id="iken"></textarea>
											<br>
										</div>
										<div class="example">
											<input type="submit" value="送信する">
											<!-- リプライボタンをクリックするとリプライ入力フォームが開く。
						  					入力後、送信ボタンを押す。 -->
										</div>
									</div>
								</div>
								<!-- リプライフォームここまで -->
							</c:forEach>
							<hr>
							</div>
						</td>
				</tr>
			</table>
		</form>
		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここまで -->
</main>
<!-- メインここまで -->
<br>
<br>
</body>
</html>