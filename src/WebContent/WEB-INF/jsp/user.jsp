<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js" defer></script>
<script src="/FLIFRE/js/reply.js" defer></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<!-- メインここから -->
	<main>

		<!-- ユーザープロフィールボックスここから -->
		<div class="userprofile">

			<!-- ${m_user.user_hd} -->
			<!-- m_userのuser_hdを引用、userprofileクラスの背景に配置したい -->
			<form method="POST" action="/FLIFRE/UserpageServlet">
				<input type="hidden" name="user_id" value="${id.user_id}"> <input
					type="hidden" name="follow_id" value="${m_user.user_id}">
				<c:choose>
					<c:when test="${check}">
						<button type="submit" class="follow" name="submit" value="フォロー解除">フォロー解除</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="follow" name="submit" value="フォロー">フォロー</button>
					</c:otherwise>
				</c:choose>
			</form>
			<br> <span> <!-- アイコン --> <img
				src="images/${m_user.user_img}" width="75" height="75">
			</span>
			<!-- m_userのuser_imgを引用 -->

			<span> <strong><!-- ユーザー名  --> ${m_user.user_name}
			</strong></span>
			<!-- m_userのuser_nameを引用 -->
			<br> <br> <span> <!-- プロフィール文 --> ${m_user.user_pf}
			</span>
			<!-- m_userのuser_pfを引用 -->
			<br> <br> <a id="follow" href="/FLIFRE/FollowlistServlet">
				<span>フォロー ${followCount}</span> <span>フォロワー ${followerCount}</span>
			</a>
		</div>
		<!-- ユーザープロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- ユーザーレビュー投稿一覧ここから -->

		<table>
			<tr>
				<td><span id="userreview_tag"> レビュー投稿 </span></td>
			</tr>
			<tr>
				<td>
					<div id="userreview_list">
						<!--t_reviewを呼び出したい -->
						<hr>
						<br>
						<c:forEach var="e" items="${Reviewdata}" varStatus="status">
							<form id="userreview${status.index}" method="POST"
								action="/FLIFRE/UserpageServlet">
								<!-- アイコン -->
								<img src="images/${e.user_img}" width="75" height="75"> <span>
									<!-- ユーザー名  --><strong>${e.user_name}</strong>
								</span> <br> <br>

								<span> <!-- 作品名 -->
								【${e.video_name} 】
								</span>
								<!-- t_reviewのvideo_idを引用 -->
								<!-- t_reviewのreview_dateを引用 -->
								<span> <!--  ジャンル  --> ${e.genre_name}
								</span>

								<br>
								<span> <!--  5段階評価  --> ${e.star}
								</span>
								<!-- t_reviewのstarを引用 -->
								<br>

								感想カテゴリ：
								<span> <!--  感想カテゴリ1  --> ${e.feelcat_name1}
								</span>
								<!-- t_reviewのfeelcat_name1を引用 -->

								<span> <!--  感想カテゴリ2  --> ${e.feelcat_name2}
								</span>
								<!-- t_reviewのfeelcat_name2を引用 -->
								<br>

								<br> <span> <!-- レビュー本文 --> ${e.review_contents}
								</span>

								<br>
								<br>
								<span> <!-- 投稿日時 --> ${e.review_date}
								</span>
								<!-- t_reviewのreview_contentsを引用 -->
								<!-- ueda -->
								<!-- リプライの本文追加。書いた人の名前　日時　リプライした本文 -->
								<%-- <c:forEach var="reply" items="${}" >
</c:forEach> --%>
								<%-- <cforEach >
						<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
						<!-- マイページではちゃんと動作するのにユーザーページでは動かない！！確認が必要 -->
						<!-- スタンプの画像をクリックすると画像が変化 -->
						${e.stamp_name}
						<!-- m_stampのstamp_id, stamp_name --> --%>

								<br>

								<!-- リプライフォームここから ここのデータ格納方法が分からない-->
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

								<div id="user_reply">
									<input type="hidden" id="status_index" value="${status.index}">
									<img id="reply${status.index}" src="./images/reply.png"  width="50" height="50">
									<div id="reply_submit${status.index}">
									<input type="hidden" name="review_id" value="${e.review_id}">
									<input type="hidden" name="user_id" value="${id.user_id}">
									<input type="hidden" name="follow_id" value="${m_user.user_id}">
									<textarea id="iken" placeholder="内容を入力してください" name="textarea"></textarea>
									<br><input type="submit" name="submit" value="リプライを送信する">
									<!-- リプライフォームここまで -->
									</div>
								</div>
								<hr>

							</form>

						</c:forEach>

					</div>
				</td>
			</tr>
		</table>
<p id="reviewdata_size" style="display:none;">${Reviewdata.size()}</p>
		<!-- ユーザーレビュー投稿一覧ここまで -->
	</main>
	<!-- メインここまで -->
	<br>
	<br>
</body>
</html>