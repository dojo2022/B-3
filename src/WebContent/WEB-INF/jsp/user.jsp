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
<div>
	<form id = follow_Lift method="POST" action="/FLIFRE/MypageServlet">
		<input type="button" name="FOLLOW" value="フォロー">
		<!-- 既にフォローしている場合は「フォロー中」と表示する -->

	</form>
	<div class ="userprofile">
	<img src ="./images/pf_img.png">
	<!-- m_userのuser_img アイコンを引用 -->
	<span id="username">うに軍艦</span><!-- m_userのuser_nameを引用予定 -->
	<br>
	<p>ジャンル問わず色々見てます。</p><!-- m_userのuser_pfを引用予定 -->
	<br>
	<br>
	<span>フォロー　　</span><!-- m_userのfollow_idを引用予定 -->
	<span>フォロワー　　</span><!-- m_userのfollow_idを引用予定 -->
	</div>
</div>
<hr>
<br>

<form id = myreview_edit method="POST" action="/FLIFRE/MypageServlet">
	<table>
		<tr>
			<td>
			<span>レビュー投稿</span>
			</td>
		</tr>
		<tr>
			<td><p>レビュー投稿一覧</p>
			<hr>
			<span id="username">うに軍艦　　</span><span>アイアンマン　　</span><span>★★★★★　　</span>
			<!-- t_reviewのuser_id,video_id,starを引用 -->
			<span>2022年6月12日</span><!-- t_reviewのreview_dateを引用 -->
			<br>
			<span>アクション</span><!-- t_reviewのgenre_idを引用 -->
			<span>スカッとする</span><!-- t_reviewのfeelcat_name1を引用 -->
			<span>非日常的</span><!-- t_reviewのfeelcat_name2を引用 -->
			<p>始まりにして頂点。全てが最高。</p><!-- t_reviewのreview_contentsを引用 -->
				<input type="button" name="STAMP" value="スタンプ">
				<input type="text" name="REPLY" value="リプライ">
			</td>
		</tr>
	</table>
</form>
</main>
</body>
</html>