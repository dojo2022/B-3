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
			<span id="pf_hd">
			<input class="header" type="image" name="user_hd" value="${m_user.user_hd}" readonly>
			</span>
			<!-- m_userのuser_hd ヘッダーを引用、出来れば背景に設定したい -->

			<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
			<span id="pf_icon">
			<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
			</span>
			<!-- m_userのuser_img アイコンを引用 -->

			<!-- <span id="username">炙りえんがわ </span> -->
			<span id="username">
			<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
			</span>
			<!-- m_userのuser_nameを引用 -->

			<a id="pf_edit" href="/FLIFRE/ProfileServlet">
			<img id="pf_edit"src="./images/pf_edit.png"></a>
			<br>
			<br>

			<!-- <span id="pf">アニメと洋画が好きです。</span> -->
			<span id="pf">
			<input class="profile" type="text" name="user_pf" value="${m_user.user_pf}" readonly>
			</span>
			<!-- m_userのuser_pfを引用 -->
			<br>
			<br>

			<a id="follow" href="/FLIFRE/FollowlistServlet">フォロー・フォロワー</a>
			<br>
			<input class="follow" type="text" name="user_id" value="${t_follow.user_id}" readonly>
			<input class="follow" type="text" name="follow_id" value="${t_follow.follow_id}" readonly>
			<!-- m_userのfollow_idを引用 -->
		</div>
		<!-- マイプロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここから -->

		<form id="mylist_edit" method="POST" action="/FLIFRE/MypageServlet">
			<table>
				<tr>
					<td><span id="review_tag"> レビュー投稿 </span>
					<span id="reply_tag"> リプライ </span>
					<span id="stamp_tag">スタンプを送ったレビュー </span></td>
				</tr>
				<tr>
					<td>
						<div id="review_list">
						<!--t_reviewを呼び出したい -->
						<hr>
							<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
							<img id="pf_icon">
							<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
							<!-- m_userのuser_imgを引用 --><!-- t_reviewのuser_idを引用? -->

							<!-- <span id="username">炙りえんがわ </span> -->
							<span id="username">
							<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
							</span>
							<!-- m_userのuser_nameを引用 --><!-- t_reviewのuser_idを引用? -->

						<br>
						<br>
							<!-- <span id="review_video">アイアンマン</span> -->
							<span id="review_video">
							<input class="video" type="text" name="video_id" value="${t_review.video_id}" readonly>
							</span>
							<!-- t_reviewのvideo_idを引用 -->

							<!-- <span id="review_star"> ★★★★★ </span> -->
							<span id="review_star">
							<input class="star" type="text" name="star" value="${t_review.star}" readonly>
							</span>
							<!-- t_reviewのstarを引用 -->

							<!-- <span id="review_time">2022年6月14日 20時30分</span> -->
							<span id="review_time">
							<input class="time" type="date" name="review_date" value="${t_review.review_date}" readonly>
							</span>
							<!-- t_reviewのreview_dateを引用 -->

						<br>
							<!-- <span id="review_genre"> ジャンル：アクション </span> -->
							<span id="review_genre">
							<input class="genre" type="text" name="genre_id" value="${t_review.genre_id}" readonly>
							</span>
							<!-- t_reviewのgenre_idを引用 -->

							<!-- <span id="review_feelcat1"> 感想カテゴリ1：スカッとする </span> -->
							<span id="review_feelcat1">
							<input class="feelcat1" type="text" name="feelcat_name1" value="${t_review.feelcat_name1}" readonly>
							</span>
							<!-- t_reviewのfeelcat_name1を引用 -->

							<!-- <span id="review_feelcat2"> 感想カテゴリ2：わくわく </span> -->
							<span id="review_feelcat2">
							<input class="feelcat2" type="text" name="feelcat_name2" value="${t_review.feelcat_name2}" readonly>
							</span>
							<!-- t_reviewのfeelcat_name2を引用 -->

							<!-- <p id="review">面白すぎる。他のアベンジャーズ作品も見てみようと思った。</p> -->
							<p id="review">
							<input class="review" type="text" name="review_contents" value="${t_review.review_contents}" readonly>
							</p>
							<!-- t_reviewのreview_contentsを引用 -->

							<input type="submit" name="REVIEWDELETET" value="削除">
							<input type="submit" name="REVIEWEDIT" value="編集">
						<br>
						<br>
						</div>

						<div id="reply_list">
						<!-- t_replyを呼び出したい -->
							<hr>
							<!-- <span id="reply_username">To うに軍艦</span>
							<span id="reply_username">
							<input class="user" type="text" name="user_id" value="${t_review.user_id}" readonly>
							</span>
							-->

							<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
							<img id="pf_icon">
							<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
							<!-- m_userのuser_imgを引用 --><!-- t_replyのuser_idを引用? -->

							<!-- <span id="reply_username">From 炙りえんがわ</span>-->
							<span id="reply_username">
							<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
							</span>
							<!-- m_userのuser_nameを引用 --><!-- t_replyのuser_idを引用? -->

						<br>
						<br>
							<!-- <span id="reply_time">2022年6月14日21時30分</span> -->
							<span id="reply_time">
							<input class="time" type="date" name="reply_date" value="${t_reply.reply_date}" readonly>
							</span>
							<!-- t_replyのreply_dateを引用 -->
							<br>

							<!-- <p id="reply_sentence">リプライありがとうございます！同じ作品が好きな方に出会えて嬉しいです。</p> -->
							<p id="reply_sentence">
							<input class="reply" type="text" name="reply_contents" value="${t_reply.reply_contents}" readonly>
							</p>
							<!-- t_replyのreply_contentsを引用 -->
							<input type="submit" name="REPLYDELETET" value="削除">
							<input type="submit" name="REPLYWEDIT" value="編集">
						<br>
						<br>
						</div>

						<div id="stamp_list">
						<!--t_reactionを呼び出したい-->
							<hr>
							<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
							<img id="pf_icon">
							<input class="circle" type="image" name="user_img" value="${m_user.user_img}" readonly>
							<!-- m_userのuser_imgを引用 --> <!-- t_reactionのreview_idを引用？ -->

							<!-- <span id="username">うに軍艦 </span> -->
							<span id="username">
							<input class="user" type="text" name="user_name" value="${m_user.user_name}" readonly>
							</span>
							<!-- t_reviewのuser_nameを引用 --><!-- t_reactionのreview_idを引用？ -->

						<br>
						<br>
							<!-- <span id="review_video">アイアンマン</span> -->
							<span id="review_video">
							<input class="video" type="text" name="video_id" value="${t_review.video_id}" readonly>
							</span>
							<!-- t_reviewのvideo_idを引用 --><!-- t_reactionのreview_idを引用？ -->

							<!-- <span id="review_star"> ★★★★★ </span> -->
							<span id="review_star">
							<input class="star" type="text" name="star" value="${t_review.star}" readonly>
							</span>
							<!-- t_reviewのstarを引用 --><!-- t_reactionのreview_idを引用？ -->

							<!-- <span id="review_time">2022年6月12日 16時00分</span> -->
							<span id="review_time">
							<input class= "time" type="date" name="review_date" value="${t_review.review_date}" readonly>
							</span>
							<!-- t_reviewのreview_dateを引用 --><!-- t_reactionのreview_idを引用？ -->


							<br>
							<!-- <span id="review_genre"> ジャンル：アクション </span> -->
							<span id="review_genre">
							<input class="genre" type="text" name="genre_id" value="${t_review.genre_id}" readonly>
							</span>
							<!-- t_reviewのgenre_idを引用 --><!-- t_reactionのreview_idを引用？ -->

							<!-- <span id="review_feelcat1"> 感想カテゴリ1：スカッとする </span> -->
							<span id="review_feelcat1">
							<input class="feelcat1" type="text" name="feelcat_name1" value="${t_review.feelcat_name1}" readonly>
							</span>
							<!-- t_reviewのfeelcat_name1を引用 --><!-- t_reactionのreview_idを引用？ -->

							<!-- <span id="review_feelcat2"> 感想カテゴリ2：非日常的 </span> -->
							<span id="review_feelcat2">
							<input class="feelcat2" type="text" name="feelcat_name2" value="${t_review.feelcat_name2}" readonly>
							</span>
							<!-- t_reviewのfeelcat_name2を引用 --><!-- t_reactionのreview_idを引用？ -->

							<!-- <p id="review">始まりにして頂点。全てが最高。</p> -->
							<p id="review">
							<input class="review" type="text" name="review_contents" value="${t_review.review_contents}" readonly>
							</p>
							<!-- t_reviewのreview_contentsを引用 --><!-- t_reactionのreview_idを引用？ -->

							<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
							<input class="stamp" type="image" name="stamp_id" value="${t_reaction.stamp_id}" readonly>
							<!-- スタンプの画像をクリックすると画像が変化 -->
							<br>

								<!-- リプライフォームここから ここのデータ格納方法が分からない-->
									<label class="open"	for="popup"><img id="reply" src="images/reply.png"
									onclick="replyfrom()" width="50" height="50">
									</label>
								<input type="checkbox" id="popup">
								<div class="overlay">
									<div class="window" id=>
										<label class="close" for="popup">× </label>
										<div class="example">
											<label for="namelabel">ユーザー名</label>
											<br>
											<input type="text"
												name="name" id="namelabel" placeholder="">
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
		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここまで -->
</main>
<!-- メインここまで -->
<br>
<br>
</body>
</html>

<!--マイページ class, id一覧

div class="myprofile" ：マイプロフィールボックス
img id="pf_icon" ：プロフィールのアイコン画像
span id="username" ：ユーザー名全般
a, img id="pf_edit" ：マイプロフィール編集ボタン
span id="pf" ：プロフィール文
span id="follow" ：フォロー数
span id="follower" ：フォロワー数

form id = "mylist_edit" ：マイレビュー投稿・リプライ・スタンプ履歴一覧フォーム(テーブル)

span  id="review_tag" ：レビュー投稿見出し
span  id= "reply_tag" ：リプライ見出し
id= "stamp_tag" ：スタンプを送ったレビュー見出し
div id= "review_list" ：レビュー投稿一覧
span id="review_video" ：レビュー作品名
span id="review_star" ：レビュー五段階評価
span id="review_time" ：レビュー日付
span id="review_genre" ：レビュージャンル
span id="review_feelcat1" ：レビュー感想カテゴリ1
span id="review_feelcat2" ：レビュー感想カテゴリ2
p id="review" ：レビュー本文

div id= "reply_list" ：リプライ一覧
span id="reply_username" ：リプライ先のユーザー名
span id="reply_time" ：リプライ日付
p id="reply_sentence" ：リプライ本文

div id= "stamp_list" ：スタンプを送ったレビュー一覧
 -->