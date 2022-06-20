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

		<input class="header" type="image" name="user_hd" value="${m_user.user_hd}" readonly>
		<!-- m_userのuser_hd ヘッダーを引用、myprofileクラスの背景に配置したい -->

		<form id = follow_Lift method="POST" action="/FLIFRE/UserpageServlet">
			<input type="button" name="FOLLOW" value="フォロー">
			<!-- 既にフォローしている場合は「フォロー中」と表示する。jsで動きを付ける
			FollowlistServletとFollowDaoの処理も必要 -->
		</form>
	<br>

		<span><!-- <img id="pf_icon" src="./images/pf_img.png"> -->
		<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
		</span>
		<!-- m_userのuser_img アイコンを引用、丸い形にするかは未定 -->

		<span><!-- うに軍艦  -->
		<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
		</span><!-- m_userのuser_nameを引用 -->
	<br>
	<br>

		<span><!-- ジャンル問わず色々見てます。 -->
		<input class="profile" type="text" name="user_pf" value="${m_user.user_pf}" readonly>
		</span><!-- m_userのuser_pfを引用 -->
	<br>
	<br>

		<a id="follow" href="/FLIFRE/FollowlistServlet">フォロー・フォロワー</a>
		<br>
		<input class="follow" type="text" name="user_id" value="${t_follow.user_id}" readonly>
		<input class="follow" type="text" name="follow_id" value="${t_follow.follow_id}" readonly>
		<!-- t_followのuser_id,follow_id -->
	</div>
	<!-- ユーザープロフィールボックスここまで -->
	<hr>
	<br>

	<!-- ユーザーレビュー投稿一覧ここから -->
	<!-- <c:forEach var="p" items="${postList}" > -->
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
						<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
						<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
						<!-- m_userのuser_imgを引用 --><!-- t_reviewのuser_idを引用? -->

						<span><!-- うに軍艦  -->
						<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
						</span><!-- m_userのuser_nameを引用 --><!-- t_reviewのuser_idを引用? -->
					<br>
					<br>

						<span><!-- アイアンマン -->
						<input class="video" type="text" name="video_id" value="${t_review.video_id}" readonly>
						</span><!-- t_reviewのvideo_idを引用 -->

						<span><!--  ★★★★★  -->
						<input class="star" type="text" name="star" value="${t_review.star}" readonly>
						</span><!-- t_reviewのstarを引用 -->

						<span><!-- 2022年6月12日 16時00分 -->
						<input class= "time" type="date" name="review_date" value="${t_review.review_date}" readonly>
						</span><!-- t_reviewのreview_dateを引用 -->
					<br>

						<span><!--  ジャンル：アクション  -->
						<input class="genre" type="text" name="genre_id" value="${t_review.genre_id}" readonly>
						</span><!-- t_reviewのgenre_idを引用 -->

						<span><!--  感想カテゴリ1：スカッとする  -->
						<input class="feelcat1" type="text" name="feelcat_name1" value="${t_review.feelcat_name1}" readonly>
						</span><!-- t_reviewのfeelcat_name1を引用 -->

						<span><!--  感想カテゴリ2：非日常的  -->
						<input class="feelcat2" type="text" name="feelcat_name2" value="${t_review.feelcat_name2}" readonly>
						</span><!-- t_reviewのfeelcat_name2を引用 -->

						<span><!-- 始まりにして頂点。全てが最高。 -->
						<input class="review" type="text" name="review_contents" value="${t_review.review_contents}" readonly>
						</span><!-- t_reviewのreview_contentsを引用 -->

						<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
						<input class="stamp" type="image" name="stamp_id" value="${t_reaction.stamp_id}" readonly>
						<!-- スタンプの画像をクリックすると画像が変化 -->
						<!-- m_stampのstamp_id, stamp_name -->
						<!-- マイページではちゃんと動作するのにユーザーページでは動かない！！確認が必要 -->
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
	<!-- </c:forEach> -->
	<!-- ユーザーレビュー投稿一覧ここまで -->
</main>
<!-- メインここまで -->
<br>
<br>
</body>
</html>

<!-- ユーザーページ class, id, label 一覧

div class="userprofile" ：ユーザープロフィールボックス
input class="header" ：プロフィールのヘッダー画像
form id = follow_Lift ：フォロー・解除ボタン(フォーム)
input class="circle" ：プロフィールのアイコン画像
input class="user" ：ユーザー名
input class="profile" ：プロフィール文
a id="follow" ：フォロー・フォロワー一覧へのリンク
input class="follow" ：フォロー数(t_followのuser_id)とフォロワー数(t_followのfollow_id)


form id = "userreview" ：ユーザーレビュー投稿フォーム(テーブル)
span id="userreview_tag" ：ユーザーレビュー投稿見出し

div id= "userreview_list" ：ユーザーレビュー投稿一覧
input class="video" ：レビュー作品名
input class="star" ：レビュー五段階評価
input class= "time" ：レビュー日付
input class="genre" ：レビュージャンル
input class="feelcat1" ：レビュー感想カテゴリ1
input class="feelcat2" ：レビュー感想カテゴリ2
input class="review"：レビュー本文

img id="image_file" ：変化前のスタンプ
input class="stamp" ：リアクションをしたスタンプ(t_reactionのstamp_id)
label class="open" ：リプライエリア
div class="overlay" ：リプライエリアのオーバーレイ
div class="window" ：リプライエリアのウィンドウ
label class="close" ：リプライエリアを閉じる
div class="example" ：リプライエリアの要素
label for="namelabel" ：リプライのユーザー名ラベル
label for="ikenlabel" ：リプライの入力欄ラベル
textarea id="iken" ：リプライ入力欄
 -->