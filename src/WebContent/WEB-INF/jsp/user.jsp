<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<br>
<!-- メインここから -->
<main>

<!-- ユーザープロフィールボックスここから -->
<div class="userprofile">
	<form id = follow_Lift method="POST" action="/FLIFRE/MypageServlet">
		<input type="button" name="FOLLOW" value="フォロー">
		<!-- 既にフォローしている場合は「フォロー中」と表示する、jsの処理？ -->
	</form>
	<br>

	<img id="pf_icon" src ="./images/pf_img.png">
	<!-- <input class="circle" type="" name="" value="" readonly> -->
	<!-- m_userのuser_img アイコンを引用予定 -->

	<span id="username">うに軍艦　　</span>
	<!-- <input class="user"type="" name="" value="" readonly> -->
	<!-- m_userのuser_nameを引用予定 -->
	<br>
	<br>

	<span id="pf">ジャンル問わず色々見てます。</span>
	<!-- <input class="profile"type="" name="" value="" readonly> -->
	<!-- m_userのuser_pfを引用予定 -->
	<br>
	<br>

	<span id="follow">フォロー　　</span><!-- m_userのfollow_idを引用予定 -->
	<span id="follower">フォロワー　　</span><!-- m_userのfollow_idを引用予定 -->
	<!-- <c:forEach var="e" items="${cardList}" >
		<tr>
			<td>${e.follow_id}</td>
			<td>${e.user_id}</td>
		</tr>
	</c:forEach> フォローフォロワー一覧ページの形式に合わせる -->

</div>
<!-- ユーザープロフィールボックスここまで -->
<hr>
<br>

<!-- ユーザーレビュー投稿一覧ここから -->
<!-- <c:forEach var="" items="" > -->
<form id = userreview method="POST" action="/FLIFRE/MypageServlet">
	<table>
		<tr>
			<td>
			<span id="userreview_tag">　　レビュー投稿　　</span>
			</td>
		</tr>
		<tr>
			<td>
			<div id= "userreview_list" >
				<p>　　レビュー投稿一覧　　</p>
			<hr>
				<span id="username">うに軍艦　　</span>
				<!-- <input class="user"type="" name="" value="" readonly> -->
				<!-- t_reviewのuser_idを引用 -->

				<span>アイアンマン　　</span>
				<!-- <input class="video"type="" name="" value="" readonly> -->
				<!-- t_reviewのvideo_idを引用 -->

				<span>★★★★★　　</span>
				<!-- <input class="star"type="" name="" value="" readonly> -->
				<!-- t_reviewのstarを引用、形式は画像なのか数値なのか未定 -->

				<span>2022年6月12日16時00分　　</span>
				<!-- t_reviewのreview_dateを引用 -->

			<br>
				<span>ジャンル：アクション　　</span><!-- t_reviewのgenre_idを引用 -->

				<span>感想カテゴリ1：スカッとする　　</span><!-- t_reviewのfeelcat_name1を引用 -->

				<span>感想カテゴリ2：非日常的　　</span><!-- t_reviewのfeelcat_name2を引用 -->

				<p>始まりにして頂点。全てが最高。</p>
				<!-- t_reviewのreview_contentsを引用 -->

					<input type="button" name="STAMP" value="スタンプ">
					<input type="text" name="REPLY" value="リプライ">
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

<!-- class, id一覧

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
span id="reply" ：リプライ本文

div id= "stamp_list" ：スタンプを送ったレビュー一覧
 -->