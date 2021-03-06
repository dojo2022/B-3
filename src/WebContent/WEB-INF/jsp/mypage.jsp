<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js " defer></script>
<script src="/FLIFRE/js/reply.js" defer></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<!-- メインここから -->
	<main>

		<!-- マイプロフィールボックスここから -->
		<div class="myprofile">
			<!-- ヘッダー -->
			<!--${m_user.user_hd} -->
			<!-- m_userのuser_hdを引用、myprofileクラスの背景に配置したい -->

			<span>
				<!-- アイコン --> <img src="images/${m_user.user_img}" width="75"
				height="75">
			</span>
			<!-- m_userのuser_imgを引用 -->
			<span>
				<!-- ユーザー名  --> <strong>${m_user.user_name}</strong>
			</span>
			<!-- m_userのuser_nameを引用 -->


			<span class="pf_edit">
				<!-- プロフィール編集ボタン --> <a href="/FLIFRE/ProfileServlet"><img
					src="./images/pf_edit.png"></a>
			</span> <br> <br> <span>
				<!-- プロフィール文 --> ${m_user.user_pf}
			</span>
			<!-- m_userのuser_pfを引用 -->
			<br> <br> <a id="follow" href="/FLIFRE/FollowlistServlet">
				<span>フォロー ${followCount}</span> <span>フォロワー ${followerCount}</span>
			</a>
		</div>
		<!-- マイプロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- マイレビュー投稿・リプライ・※スタンプを送ったレビュー一覧ここから -->

		<table>
			<tr>
				<td><span id="review_tag">　　レビュー投稿　　</span>
				<span id="reply_tag">　　リプライ　　</span> </td>
						<!-- <span id="stamp_tag">スタンプを送ったレビュー </span> -->
			</tr>
			<tr>
				<td>
					<div id="review_list">
						<!--t_reviewを呼び出したい -->
						<hr>
						<br>

						<c:forEach var="e" items="${Reviewdata}">

							<span>
								<!-- アイコン --> <img src="images/${e.user_img}" width="75"
								height="75">
							</span>

							<span>
								<!-- ユーザー名  --> <strong>${e.user_name}</strong>
							</span>
							<br>
							<br>

							<span>
								<!-- 作品名 -->【 ${e.video_name} 】
							</span>
							<span>
								<!--  ジャンル  --> ${e.genre_name}
							</span>
								<!-- t_reviewのgenre_idを引用 -->
							<!-- t_reviewのvideo_idを引用 -->
							<form id="mylist_edit" method="POST" action="/FLIFRE/MypageServlet">
								<span>
									<!-- 5段階評価  --> ${e.star} <input type="hidden" name="star"
									value="${e.star}">
								</span>
								<!-- t_reviewのstarを引用 -->
								<br>
								感想カテゴリ：
								<span>
									<!-- 感想カテゴリ1 --> ${e.feelcat_name1} <input type="hidden"
									name="feelcat_name1" value="${e.feelcat_name1}">
								</span>
								<!-- t_reviewのfeelcat_name1を引用 -->

								<span>
									<!--  感想カテゴリ2  --> ${e.feelcat_name2} <input type="hidden"
									name="feelcat_name2" value="${e.feelcat_name2}">
								</span>
								<!-- t_reviewのfeelcat_name2を引用 -->

								<br>
								<br>
								<span>
									<!-- レビュー本文 --> ${e.review_contents} <input type="hidden"
									name="review_contents" value="${e.review_contents}">
								</span>
								<!-- t_reviewのreview_contentsを引用 -->
								<br>
								<br><span>
									<!-- 投稿日時 --> ${e.review_date}
								</span>

								<br>
								<br>
								<input type="hidden" name="review_id" value="${e.review_id}">
								<input type="hidden" name="review_id" value="${e.review_date}">
									<button class="delete" type="submit" name="submit" value="レビュー削除">レビュー削除</button>
									<button class="edit" type="submit" name="submit" value="レビュー編集">レビュー編集</button>
								<br>
								<br>
								<hr>
								<div id="user_reply">
								<c:set var="e_review_id" value="${e.review_id}" />
								<c:forEach var="i" begin="0" end="${replyLists.size()}" step="1">
									<c:forEach var="reply" items="${replyLists[i] }">

										<c:set var="reply_review_id" value="${reply.review_id}" />


										<c:if test="${reply_review_id == e_review_id}">
											<p><a href="/FLIFRE/UserpageServlet?user_id=${reply.user_id}">
											${reply.user_name}</a></p>
											<p>${reply.reply_contents}</p>
											<p>${reply.reply_date}</p>
										</c:if>

									</c:forEach>
								</c:forEach>
								</div>
								<hr>
								<%-- <input type="hidden" id="status_index" value="${status.index}">
								<img id="reply${status.index}" src="./images/reply.png"  width="50" height="50">
								<div id="reply_submit${status.index}">
								<input type="hidden" name="review_id" value="${e.review_id}">
								<input type="hidden" name="user_id" value="${id.user_id}">
								<input type="hidden" name="follow_id" value="${m_user.user_id}">
								<textarea id="iken" placeholder="内容を入力してください" name="textarea"></textarea>
								<input type="submit" name="submit" value="リプライを送信する">
								</div> --%>

								<br>
							</form>
						</c:forEach>

					</div>

					<div id="reply_list">
						<!-- t_replyを呼び出したい -->
						<hr>
						<br>
						<c:forEach var="e" items="${Replydata}">
						<!-- リプライ先のレビューリンクか何かがあればいい -->

							<!-- 自分のアイコン -->
							 <img src="images/${e.user_img}" width="75"
								height="75">
							<!-- m_userのuser_imgを引用 -->
							<!-- t_replyのuser_idを引用? -->
							<br>

							<span>
								<!-- 自分のユーザー名 --> ${e.user_name}
							</span>
							<!-- m_userのuser_nameを引用 -->
							<!-- t_replyのuser_idを引用? -->
							<br>
							<br>

							<span>
								<!-- 投稿日時 --> ${e.reply_date}
							</span>
							<!-- t_replyのreply_dateを引用 -->
							<br>

							<span>
								<!-- リプライ本文 --> ${e.reply_contents} <input type="hidden"
								name="reply_contents" value="${e.reply_contents}">
							</span>
							<!-- t_replyのreply_contentsを引用 -->
							<br>
							<br>
							<input type="hidden" name="reply_date" value="${e.reply_date}">

							<hr>
							<br>
						</c:forEach>

					</div>
				</td>
			</tr>
		</table>
					<%-- <div id="stamp_list">
						<!--t_reactionを呼び出したい-->
						<hr>
						<br>
						 <cforEach>
							<a href="/FLIFRE/UserpageServlet"> <!-- アイコン -->
								${e.user_img}
							</a>
							<!-- m_userのuser_imgを引用 -->
							<!-- t_reactionのreview_idを引用？ -->

							<a href="/FLIFRE/UserpageServlet"> <span>
									<!-- ユーザー名 --> ${e.user_name}
							</span>
							</a>
							<!-- t_reviewのuser_nameを引用 -->
							<!-- t_reactionのreview_idを引用？ -->
							<br>
							<br>

							<span>
								<!-- 作品名 --> ${e.video_name}
							</span>
							<!-- t_reviewのvideo_idを引用 -->
							<!-- t_reactionのreview_idを引用？ -->

							<span>
								<!--  5段階評価  --> ${e.star}
							</span>
							<!-- t_reviewのstarを引用 -->
							<!-- t_reactionのreview_idを引用？ -->

							<span>
								<!-- 投稿日時 --> ${e.review_date}
							</span>
							<!-- t_reviewのreview_dateを引用 -->
							<!-- t_reactionのreview_idを引用？ -->
							<br>

							<span>
								<!--  ジャンル  --> ${e.genre_name}
							</span>
							<!-- t_reviewのgenre_idを引用 -->
							<!-- t_reactionのreview_idを引用？ -->

							<span>
								<!--  感想カテゴリ1 --> ${e.feelcat_name1}
							</span>
							<!-- t_reviewのfeelcat_name1を引用 -->
							<!-- t_reactionのreview_idを引用？ -->

							<span>
								<!--  感想カテゴリ2 --> ${e.feelcat_name2}
							</span>
							<!-- t_reviewのfeelcat_name2を引用 -->
							<!-- t_reactionのreview_idを引用？ -->

							<span>
								<!-- レビュー本文 --> ${e.review_contents}
							</span>
							<!-- t_reviewのreview_contentsを引用 -->
							<!-- t_reactionのreview_idを引用？ -->
							<br>

							<img id="image_file" src="images/nikochan5.png"
								onclick="henkou()" width="50" height="50">
							<!-- スタンプの画像をクリックすると画像が変化 -->
							${e.stamp_name}
							<!-- m_stampのstamp_id, stamp_name -->
							<br>

							<!-- リプライフォームここから ここのデータ格納方法が分からない-->
							<label class="open" for="popup"><img id="reply"
								src="images/reply.png" onclick="replyfrom()" width="50"
								height="50"> </label>
							<input type="checkbox" id="popup">
							<div class="overlay">
								<div class="window">
									<label class="close" for="popup">× </label>
									<div class="example">
										<label for="namelabel">ユーザー名</label> <br> <input
											type="text" name="name" id="namelabel" placeholder="">
										<br>
									</div>
									<div class="example">
										<label for="ikenlabel">リプライ内容</label> <br>
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

						<hr>
					</div> --%>


		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここまで -->
	</main>
	<!-- メインここまで -->
	<br>
	<br>
</body>
</html>