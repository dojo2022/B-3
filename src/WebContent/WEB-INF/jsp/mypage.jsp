<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@ include file="header.jsp" %>

<!-- メインここから -->
<main>

<!-- マイプロフィールボックスここから -->
<div class="myprofile">
	<img id="pf_icon" src ="./images/pf_img.png">
	<!-- <input class="circle" type="" name="" value="" readonly> -->
	<!-- m_userのuser_img アイコンを引用予定 -->

	<span id="username">炙りえんがわ　　</span>
	<!-- <input class="user"type="" name="" value="" readonly> -->
	<!-- m_userのuser_nameを引用予定 -->

	<a id="pf_edit" href="/FLIFRE/ProfileServlet">
	<img id="pf_edit" src ="./images/pf_edit.png"></a>
	<br>
	<br>

	<span id="pf">アニメと洋画が好きです。</span>
	<!-- <input class="profile"type="" name="" value="" readonly> -->
	<!-- m_userのuser_pfを引用予定 -->
	<br>
	<br>
	<span id="follow">フォロー</span> <!-- m_userのfollow_idを引用予定 -->
	<span id="follower">フォロワー</span> <!-- m_userのfollow_idを引用予定 -->
	<!-- <c:forEach var="e" items="${cardList}" >
		<tr>
			<td>${e.follow_id}</td>
			<td>${e.user_id}</td>
		</tr>
	</c:forEach> フォローフォロワー一覧ページの形式に合わせる -->
</div>
<!-- マイプロフィールボックスここまで -->
<hr>
<br>

<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここから -->
<!-- <c:forEach var="" items="" > -->
<form id = "mylist_edit" method="POST" action="/FLIFRE/MypageServlet">
	<table>
		<tr>
			<td>
			<span  id="review_tag" >　　レビュー投稿　　</span>
			<span  id= "reply_tag" >　　リプライ　　</span>
			<span  id= "stamp_tag" >　　スタンプを送ったレビュー　　</span>
			</td>
		</tr>
		<tr>
			<td>
			<div id= "review_list" >
				<p>レビュー投稿一覧</p>
			<hr>
				<span id="username">炙りえんがわ　　</span>
				<!-- <input class="user"type="" name="" value="" readonly> -->
				<!-- t_reviewのuser_idを引用 -->

				<span id="review_video">アイアンマン　　</span>
				<!-- <input class="video"type="" name="" value="" readonly> -->
				<!-- t_reviewのvideo_idを引用 -->

				<span id="review_star">★★★★★　　</span>
				<!-- <input class="star"type="" name="" value="" readonly> -->
				<!-- t_reviewのstarを引用、形式は画像なのか数値なのか未定 -->

				<span id="review_time">2022年6月14日 20時30分　　</span>
				<!-- <input class="time"type="" name="" value="" readonly> -->
				<!-- t_reviewのreview_dateを引用、細かい時間まで必要か要検討 -->
			<br>

				<span id="review_genre">ジャンル：アクション　　</span>
				<!-- <input class="genre"type="" name="" value="" readonly> -->
				<!-- t_reviewのgenre_idを引用 -->

				<span id="review_feelcat1">感想カテゴリ1：スカッとする　　</span>
				<!-- <input class="feelcat1"type="" name="" value="" readonly> -->
				<!-- t_reviewのfeelcat_name1を引用 -->

				<span id="review_feelcat2">感想カテゴリ2：わくわく　　</span>
				<!-- <input class="feelcat2"type="" name="" value="" readonly> -->
				<!-- t_reviewのfeelcat_name2を引用 -->

				<p id="review">面白すぎる。他のアベンジャーズ作品も見てみようと思った。</p>
				<!-- <input class="review"type="" name="" value="" readonly> -->
				<!-- t_reviewのreview_contentsを引用 -->
					<input type="submit" name="REVIEWDELETET" value="削除">
					<input type="submit" name="REVIEWEDIT" value="編集">
			<br>
			</div>

			<div id= "reply_list" >
				<p>リプライ一覧</p>
			<hr>
				<span id="reply_username">To うに軍艦</span>
				<br>

				<span id="username">炙りえんがわ　　</span>
				<!-- <input class="user"type="" name="" value="" readonly> -->
				<!-- t_reviewのuser_idを引用 -->
				<br>
				<span id="reply">リプライありがとうございます！同じ作品が好きな方に出会えて嬉しいです。</span>
					<input type="submit" name="REPLYDELETET" value="削除">
					<input type="submit" name="REPLYWEDIT" value="編集">
			<br>
			</div>

			<div id= "stamp_list" >
				<p>スタンプを送ったレビュー一覧</p>
			<hr>
				<span id="username">うに軍艦　　</span>
				<!-- <input class="user"type="" name="" value="" readonly> -->
				<!-- t_reviewのuser_idを引用 -->

				<span id="review_video">アイアンマン　　</span>
				<!-- <input class="video"type="" name="" value="" readonly> -->
				<!-- t_reviewのvideo_idを引用 -->

				<span id="review_star">★★★★★　　</span>
				<!-- <input class="star"type="" name="" value="" readonly> -->
				<!-- t_reviewのstarを引用、形式は画像なのか数値なのか未定 -->

				<span id="review_time">2022年6月12日 16時00分</span>
				<!-- <input class="time"type="" name="" value="" readonly> -->
				<!-- t_reviewのreview_dateを引用、細かい時間まで必要か要検討 -->
			<br>

				<span id="review_genre">ジャンル：アクション　　</span>
				<!-- <input class="genre"type="" name="" value="" readonly> -->
				<!-- t_reviewのgenre_idを引用 -->

				<span id="review_feelcat1">感想カテゴリ１：スカッとする　　</span>
				<!-- <input class="feelcat1"type="" name="" value="" readonly> -->
				<!-- t_reviewのfeelcat_name1を引用 -->

				<span id="review_feelcat2">感想カテゴリ２：非日常的　　</span>
				<!-- <input class="feelcat2"type="" name="" value="" readonly> -->
				<!-- t_reviewのfeelcat_name2を引用 -->

				<p id="review">始まりにして頂点。全てが最高。</p>
				<!-- <input class="review"type="" name="" value="" readonly> -->
				<!-- t_reviewのreview_contentsを引用 -->

					<input type="button" name="STAMP" value="スタンプ">
					  <!-- スタンプの画像をクリックするとスタンプ一覧のダイアログボックスが開く。
					  一覧からスタンプを1つ選択するとスタンプ画像が切り替わる予定 -->
					<input type="button" name="REPLY" value="リプライ">
					  <!-- リプライボタンをクリックするとリプライ入力フォームが開く。
					  入力後、送信ボタンを押す。 -->
			<br>
			</div>
			<br>
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

 -->