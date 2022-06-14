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
<br>
<br>

<!-- メインここから -->
<main>
<div class ="myprofile">
	<img src ="./images/pf_img.png"><!-- m_userのuser_img アイコンを引用予定 -->
	<span>炙りえんがわ　　</span><!-- m_userのuser_nameを引用予定 -->
	<a id="pf_edit" href="/FLIFRE/ProfileServlet"><img src ="./images/pf_edit.png"></a>
	<br>
	<span>アニメと洋画が好きです。</span><!-- m_userのuser_pfを引用予定 -->
	<br>
	<br>
	<span>フォロー</span><!-- m_userのfollow_idを引用予定 -->
	<span>フォロワー</span><!-- m_userのfollow_idを引用予定 -->
</div>
<hr>
<br>

<!-- <c:forEach var="" items="" > -->
<form id = myreview_edit method="POST" action="/FLIFRE/MypageServlet">
	<table>
		<tr>
			<td>
			<span  id="review_tag" >　　レビュー投稿　　</span>
			<span  id= "reply_tag" >　　リプライ　　</span>
			<span  id= "stamp_tag" >　　スタンプを送ったレビュー　　</span>
			</td>
		</tr>
		<tr>
		<td >
		<div id= "review_list" >
		<p>レビュー投稿一覧</p>
		<hr>
			<span>炙りえんがわ　　</span><span>アイアンマン　　</span><span>★★★★★　　</span>
			<!-- t_reviewのuser_id,video_id,starを引用 -->
			<span>2022年6月14日</span><!-- t_reviewのreview_dateを引用 -->
			<br>
			<span>ジャンル：アクション　　</span><!-- t_reviewのgenre_idを引用 -->
			<span>感想カテゴリ１：スカッとする　　</span><!-- t_reviewのfeelcat_name1を引用 -->
			<span>感想カテゴリ２：わくわく</span><!-- t_reviewのfeelcat_name2を引用 -->
			<p>面白すぎる。他のアベンジャーズ作品も見てみようと思った。</p><!-- t_reviewのreview_contentsを引用 -->


				<input type="submit" name="REVIEWDELETET" value="削除">
				<input type="submit" name="REVIEWEDIT" value="編集">
				<br>
		</div>
		<div id= "reply_list" >
			<p>リプライ一覧</p>
			<hr>
				<span>To うに軍艦</span>
				<br>
				<span>リプライありがとうございます！同じ作品が好きな方に出会えて嬉しいです。</span>
				<input type="submit" name="REPLYDELETET" value="削除">
				<input type="submit" name="REPLYWEDIT" value="編集">
				<br>
		</div>
		<div id= "stamp_list" >
		<p>スタンプを送ったレビュー一覧</p>
		<hr>
			<span>うに軍艦　　</span><span>アイアンマン　　</span><span>★★★★★　　</span>
			<!-- t_reviewのuser_id,video_id,starを引用 -->
			<span>2022年6月12日</span><!-- t_reviewのreview_dateを引用 -->
			<br>
			<span>ジャンル：アクション　　</span><!-- t_reviewのgenre_idを引用 -->
			<span>感想カテゴリ１：スカッとする</span><!-- t_reviewのfeelcat_name1を引用 -->
			<span>感想カテゴリ２：非日常的</span><!-- t_reviewのfeelcat_name2を引用 -->
			<p>始まりにして頂点。全てが最高。</p><!-- t_reviewのreview_contentsを引用 -->
				<input type="button" name="STAMP" value="スタンプ">
				<!-- <dialog>を使って、jsで動きを作る -->
				<input type="text" name="REPLY" value="リプライ">
				<input type="submit" name="REPLYSEND" value="送信">
				<br>
		</div>
		<br>
		</td>
		</tr>
	</table>
</form>
<!-- </c:forEach> -->
</main>
<br>
<br>

</body>
</html>