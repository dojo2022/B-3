<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>レビュー一覧 | FLIFRE</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/review.css">
</head>
<body>
	<%@ include file="header.jsp" %>

	<!-- 投稿フォーム-->
	<main>
		<div class="review">
			<div class="video-image"></div>
			<h1>作品名</h1><!-- m_videoのvideo_nameを引用 -->
        	<h2>再生時間</h2><!-- m_videoのvideo_timeを引用 -->
        	<h2>作品ジャンル</h2><!-- m_videoのgenre_idを引用 -->

        	<a href="/FLIFRE/Servlet"><img src ="./images/pf_img.png"></a><!-- m_userのuser_img アイコンを引用予定 -->
			<span>ユーザー名</span><!-- m_userのuser_nameを引用予定 -->
			<div class="review-contents">
				<div class="feelcat">
	        	感想カテゴリ１<!-- m_feelcatのfeelcat_idを引用 -->
	        	感想カテゴリ１<!-- m_feelcatのfeelcat_idを引用 -->
	        	</div>
				<p class="date">投稿日時</p><!-- <!-- t_reviewのreview_dateを引用 -->
				本文<!-- t_reviewのreview_contentsを引用 -->
        	</div>
		</div>
	</main>
</body>
</html>