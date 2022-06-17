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
		<!--user_id -->
			<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
			<img id="pf_icon">
			<input class="circle" type="image" name="user_img" value="" readonly>
			<!-- m_userのuser_img アイコンを引用予定 -->

			<!-- <span id="username">炙りえんがわ </span> -->
			<span id="username">
			<input class="user" type="text" name="user_name" value="${user_name}" readonly>
			</span>
			<!-- m_userのuser_nameを引用予定 -->

			<a id="pf_edit" href="/FLIFRE/ProfileServlet">
			<img id="pf_edit"src="./images/pf_edit.png"></a>
			<br>
			<br>

			<!-- <span id="pf">アニメと洋画が好きです。</span> -->
			<span id="pf">
			<input class="profile" type="text" name="user_pf" value="" readonly>
			</span>
			<!-- m_userのuser_pfを引用予定 -->
			<br>
			<br>

			<span id="follow">フォロー</span>
			<span id="follower">フォロワー</span>
			<br>
			<input class="follow" type="text" name="follow_id" value="" readonly>
			<!-- <input class="follow" type="text" name="follow_id" value="" readonly> -->
			<!-- m_userのfollow_idを引用 -->
		</div>
		<!-- マイプロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここから -->
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