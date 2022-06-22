<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js"  defer></script>
</head>
<body>
<%@ include file="header.jsp" %>

	<!-- メインここから -->
	<main>

		<!-- ユーザープロフィールボックスここから -->
		<div class="userprofile">

		<!-- ${m_user.user_hd} -->
		<!-- m_userのuser_hdを引用、userprofileクラスの背景に配置したい -->


		<form id = follow_Lift method="POST" action="/FLIFRE/UserpageServlet">
			<input type="button" name="FOLLOW" value="フォロー">
			<!-- 既にフォローしている場合は「フォロー中」と表示する。jsで動きを付ける
			FollowlistServletとFollowDaoの処理も必要 -->
		</form>
	<br>

		<span><!-- アイコン -->
		<img src="images/${m_user.user_img}" width="75" height="75">
		</span>
		<!-- m_userのuser_imgを引用 -->

		<span><!-- ユーザー名  -->
		${m_user.user_name}
		</span><!-- m_userのuser_nameを引用 -->
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
	<!-- ユーザープロフィールボックスここまで -->
	<br>
	<hr>
	<br>

	<!-- ユーザーレビュー投稿一覧ここから -->
	<form id = "userreview" method="POST" action="/FLIFRE/UserpageServlet">
		<table>
			<tr>
				<td>
				<span id="userreview_tag">　　レビュー投稿　　</span>
				</td>
			</tr>
			<tr>
				<td>
					<div id= "userreview_list" >
					<!--t_reviewを呼び出したい -->
					<hr>
					<br>
					<c:forEach var="e" items="${Reviewdata}" >
					<br>
						<!-- アイコン -->
						<img src="images/${e.user_img}" width="75" height="75">


						<span><!-- ユーザー名  -->
						${e.user_name}
						</span>
					<br>

						<span><!-- 作品名 -->
						${e.video_name}
						</span><!-- t_reviewのvideo_idを引用 -->

						<span><!--  5段階評価  -->
						${e.star}
						</span><!-- t_reviewのstarを引用 -->

						<span><!-- 投稿日時 -->
						${e.review_date}
						</span><!-- t_reviewのreview_dateを引用 -->
					<br>

						<span><!--  ジャンル  -->
						${e.genre_name}
						</span><!-- t_reviewのgenre_idを引用 -->

						<span><!--  感想カテゴリ1  -->
						${e.feelcat_name1}
						</span><!-- t_reviewのfeelcat_name1を引用 -->

						<span><!--  感想カテゴリ2  -->
						${e.feelcat_name2}
						</span><!-- t_reviewのfeelcat_name2を引用 -->

						<span><!-- レビュー本文 -->
						${e.review_contents}
						</span><!-- t_reviewのreview_contentsを引用 -->
					</c:forEach>

					<c:forEach var="e" items="${Reactiondata}" >
						<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
						<!-- マイページではちゃんと動作するのにユーザーページでは動かない！！確認が必要 -->
						<!-- スタンプの画像をクリックすると画像が変化 -->
						${e.stamp_name}
						<!-- m_stampのstamp_id, stamp_name -->
					</c:forEach>
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
					</div>
				</td>
			</tr>
		</table>
	</form>
	<!-- ユーザーレビュー投稿一覧ここまで -->
</main>
<!-- メインここまで -->
<br>
<br>
</body>
</html>