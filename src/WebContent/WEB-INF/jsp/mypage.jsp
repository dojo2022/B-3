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
<<<<<<< HEAD

			<input class="header" type="image" name="user_hd" value="${m_user.user_hd}" readonly>
			<!-- m_userのuser_hd ヘッダーを引用、myprofileクラスの背景に配置したい -->

			<span><!-- <img id="pf_icon" src="./images/pf_img.png"> -->
			<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
=======

			<span>${m_user.user_hd}
			<!-- m_userのuser_hd ヘッダーを引用、myprofileクラスの背景に配置したい -->
			</span>

			<span><!-- <img id="pf_icon" src="./images/pf_img.png"> -->
			${m_user.user_img}
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14
			</span>
			<!-- m_userのuser_img アイコンを引用、丸い形にするかは未定 -->

			<span><!-- 炙りえんがわ  -->
<<<<<<< HEAD
			<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
=======
			${m_user.user_name}
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14
			</span><!-- m_userのuser_nameを引用 -->


			<span class ="pf_edit">
			<a  href="/FLIFRE/ProfileServlet"><img src="./images/pf_edit.png"></a>
			</span><!-- プロフィール編集ボタン -->
<<<<<<< HEAD
			<br>
			<br>

			<span><!-- アニメと洋画が好きです。 -->
			<input class="profile" type="text" name="user_pf" value="${m_user.user_pf}" readonly>
			</span><!-- m_userのuser_pfを引用 -->
			<br>
			<br>

			<a id="follow" href="/FLIFRE/FollowlistServlet">フォロー・フォロワー</a>
			<br>
			<input class="follow" type="text" name="user_id" value="${t_follow.user_id}" readonly>
			<input class="follow" type="text" name="follow_id" value="${t_follow.follow_id}" readonly>
			<!-- t_followのuser_id,follow_idを引用 -->
=======
			<br>

			<span><!-- アニメと洋画が好きです。 -->
			${m_user.user_pf}
			</span><!-- m_userのuser_pfを引用 -->
			<br>
			<br>

			<a id="follow" href="/FLIFRE/FollowlistServlet">
			<span>フォロー　${followCount}</span>
			<span>フォロワー　${followerCount}</span>
			</a>
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14
		</div>
		<!-- マイプロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここから -->
<<<<<<< HEAD
		<!-- <c:forEach var="p" items="${postList}" > -->
=======
		<c:forEach var="e" items="${Review}" >
			<p>${e.review_id}</p>
		</c:forEach>

		<c:forEach var="e" items="${Reply}" >
			<p>${e.reply_id}</p>
		</c:forEach>

		<c:forEach var="e" items="${Reaction}" >
			<p>${e.reaction_id}</p>
		</c:forEach>
>>>>>>> 700fdc5e999afcc3f450f3d286ac406391c3af14

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
							<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
							<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
							<!-- m_userのuser_imgを引用 --><!-- t_reviewのuser_idを引用? -->

							<span><!-- 炙りえんがわ  -->
							<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
							</span><!-- m_userのuser_nameを引用 --><!-- t_reviewのuser_idを引用? -->
						<br>
						<br>

							<span><!-- アイアンマン -->
							<input class="video" type="text" name="video_id" value="${t_review.video_id}" readonly>
							</span><!-- t_reviewのvideo_idを引用 -->

							<span><!-- ★★★★★  -->
							<input class="star" type="text" name="star" value="${t_review.star}" readonly>
							</span><!-- t_reviewのstarを引用 -->

							<span id="review_time"><!-- 2022年6月14日 20時30分 -->
							<input class="time" type="date" name="review_date" value="${t_review.review_date}" readonly>
							</span><!-- t_reviewのreview_dateを引用 -->
						<br>

							<span><!--  ジャンル：アクション  -->
							<input class="genre" type="text" name="genre_id" value="${t_review.genre_id}" readonly>
							</span><!-- t_reviewのgenre_idを引用 -->

							<span><!-- 感想カテゴリ1：スカッとする -->
							<input class="feelcat1" type="text" name="feelcat_name1" value="${t_review.feelcat_name1}" readonly>
							</span><!-- t_reviewのfeelcat_name1を引用 -->

							<span><!--  感想カテゴリ2：わくわく  -->
							<input class="feelcat2" type="text" name="feelcat_name2" value="${t_review.feelcat_name2}" readonly>
							</span><!-- t_reviewのfeelcat_name2を引用 -->

							<span><!-- 面白すぎる。他のアベンジャーズ作品も見てみようと思った。 -->
							<input class="review" type="text" name="review_contents" value="${t_review.review_contents}" readonly>
							</span><!-- t_reviewのreview_contentsを引用 -->
							<br>
							<br>

							<input class="delete" type="submit" name="REVIEWDELETET" value="削除">
							<input class="edit" type="submit" name="REVIEWEDIT" value="編集">
						<br>
						<br>
						</div>

						<div id="reply_list">
						<!-- t_replyを呼び出したい -->
							<hr>
							<!-- <span> To うに軍艦
							<input class="user" type="text" name="user_id" value="${t_review.user_id}" readonly>
							</span> -->

							<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
							<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
							<!-- m_userのuser_imgを引用 --><!-- t_replyのuser_idを引用? -->

							<span><!-- From 炙りえんがわ -->
							<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
							</span><!-- m_userのuser_nameを引用 --><!-- t_replyのuser_idを引用? -->
						<br>
						<br>

							<span><!-- 2022年6月14日21時30分 -->
							<input class="time" type="date" name="reply_date" value="${t_reply.reply_date}" readonly>
							</span><!-- t_replyのreply_dateを引用 -->
							<br>

							<span><!-- リプライありがとうございます！同じ作品が好きな方に出会えて嬉しいです。 -->
							<input class="reply" type="text" name="reply_contents" value="${t_reply.reply_contents}" readonly>
							</span><!-- t_replyのreply_contentsを引用 -->
							<br>
							<br>

							<input class="delete" type="submit" name="REPLYDELETET" value="削除">
							<input class="edit" type="submit" name="REPLYWEDIT" value="編集">
						<br>
						<br>
						</div>

						<div id="stamp_list">
						<!--t_reactionを呼び出したい-->
						<hr>
							<a  href="/FLIFRE/UserpageServlet">
							<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
							<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
							</a>
							<!-- m_userのuser_imgを引用 --> <!-- t_reactionのreview_idを引用？ -->

							<a  href="/FLIFRE/UserpageServlet">
							<span><!-- うに軍艦  -->
							<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
							</span>
							</a>
							<!-- t_reviewのuser_nameを引用 --><!-- t_reactionのreview_idを引用？ -->
						<br>
						<br>

							<span><!-- アイアンマン -->
							<input class="video" type="text" name="video_id" value="${t_review.video_id}" readonly>
							</span><!-- t_reviewのvideo_idを引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!--  ★★★★★  -->
							<input class="star" type="text" name="star" value="${t_review.star}" readonly>
							</span><!-- t_reviewのstarを引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!-- 2022年6月12日 16時00分 -->
							<input class= "time" type="date" name="review_date" value="${t_review.review_date}" readonly>
							</span><!-- t_reviewのreview_dateを引用 --><!-- t_reactionのreview_idを引用？ -->
						<br>

							<span><!--  ジャンル：アクション  -->
							<input class="genre" type="text" name="genre_id" value="${t_review.genre_id}" readonly>
							</span><!-- t_reviewのgenre_idを引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!--  感想カテゴリ1：スカッとする  -->
							<input class="feelcat1" type="text" name="feelcat_name1" value="${t_review.feelcat_name1}" readonly>
							</span><!-- t_reviewのfeelcat_name1を引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!--  感想カテゴリ2：非日常的  -->
							<input class="feelcat2" type="text" name="feelcat_name2" value="${t_review.feelcat_name2}" readonly>
							</span><!-- t_reviewのfeelcat_name2を引用 --><!-- t_reactionのreview_idを引用？ -->

							<span><!-- 始まりにして頂点。全てが最高。 -->
							<input class="review" type="text" name="review_contents" value="${t_review.review_contents}" readonly>
							</span><!-- t_reviewのreview_contentsを引用 --><!-- t_reactionのreview_idを引用？ -->
							<br>

							<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
							<input class="stamp" type="image" name="STAMP" value="${t_reaction.stamp_id}" readonly>
							<!-- スタンプの画像をクリックすると画像が変化 -->
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
							</div>
						</td>
				</tr>
			</table>
		</form>
		<!-- </c:forEach> -->
		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここまで -->
</main>
<!-- メインここまで -->
<br>
<br>
</body>
</html>

<!--マイページ class, id, label 一覧

div class="myprofile" ：マイプロフィールボックス
input class="header" ：プロフィールのヘッダー画像
input class="circle" ：プロフィールのアイコン画像、丸い形にするかは未定
input class="user" ：ユーザー名全般
span class ="pf_edit" ：マイプロフィール編集ボタン
input class="profile" ：プロフィール文
a id="follow" ：フォロー・フォロワー一覧へのリンク
input class="follow" ：フォロー数(t_followのuser_id)とフォロワー数(t_followのfollow_id)


form id = "mylist_edit" ：マイレビュー投稿・リプライ・スタンプ履歴一覧フォーム(テーブル)
span id="review_tag" ：レビュー投稿見出し
span id= "reply_tag" ：リプライ見出し
span id= "stamp_tag" ：スタンプを送ったレビュー見出し

div id= "review_list" ：レビュー投稿一覧
input class="video" ：レビュー作品名
input class="star" ：レビュー五段階評価
input class="time" ：レビュー・リプライ時間(日付)
input class="genre" ：レビュージャンル
input class="feelcat1" ：レビュー感想カテゴリ1
input class="feelcat2" ：レビュー感想カテゴリ2
input class="review" ：レビュー本文

div id= "reply_list" ：リプライ一覧
input class="reply" ：リプライ本文

input class="delete" ：削除ボタン
input class="edit" ：編集ボタン

div id= "stamp_list" ：スタンプを送ったレビュー一覧
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