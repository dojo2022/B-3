<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/FLIFRE/css/common.css">
    <link rel="stylesheet" href="/FLIFRE/css/ranking.css">
    <title>ランキング | FLIFRE</title>
</head>

<body>
    <!---->
    <%@ include file="header.jsp" %>
    <main>
        <div class="ranking-box">
            <h1 class="ranking">項目別ランキング</h1>
			<%
	    pageContext.setAttribute(
	        "genre",
	        new String[] {
	            "通算","アニメ", "国内", "欧米",
	            "韓国", "華流", "アクション", "コメディ", "キッズ・ファミリー", "ヒューマンドラマ",
	            "サスペンス", "ラブロマンス", "ホラー", "ファンタジー", "SF","バラエティ"
	        }
	    );
		pageContext.setAttribute(
			"rank",
			new String[] {
					"Gold","Silver","Bronze"
			}
				);
	    %>
	    <!-- 高山さん作ジャンル名と作品の多重拡張for文 -->
	    	<!--ここから

	    	<div class="ranklist">
			<c:forEach var="g" items="${ genre }">
				<p class="ranking">${g}</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${ReviewRanking[g][i].video_id}">${ ReviewRanking[g][i].video_name}</a></li>
				</c:forEach>
				</ul>
			</c:forEach>
			</div>
			ここまで-->

		<!-- ジャンルごとに分けてランキングの繰り返し（上位3つ） -->

			<div class="ranklist">
				<p class="ranking">通算</p>
				<ul class="list">
				<c:forEach var="t" items="${ totalRank }">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${totalRank[t].video_id}">${ totalRank[t].video_name}</a></li>
				</c:forEach>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">アニメ</p>
				<ul class="list">
				<c:forEach var="a" items="${ animeRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">国内</p>
				<ul class="list">
				<c:forEach var="l" items="${ localRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">韓国</p>
				<ul class="list">
				<c:forEach var="k" items="${ koreaRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">華流</p>
				<ul class="list">
				<c:forEach var="c" items="${ chinaRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">アクション</p>
				<ul class="list">
				<c:forEach var="a" items="${ actionRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">コメディ</p>
				<ul class="list">
				<c:forEach var="c" items="${ comedyRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">キッズ・ファミリー</p>
				<ul class="list">
				<c:forEach var="f" items="${ familyRank}">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ヒューマンドラマ</p>
				<ul class="list">
				<c:forEach var="h" items="${ humanRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">サスペンス</p>
				<ul class="list">
				<c:forEach var="s" items="${ suspenseRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ラブロマンス</p>
				<ul class="list">
				<c:forEach var="r" items="${ romanceRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ホラー</p>
				<ul class="list">
				<c:forEach var="h" items="${ horrorRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ファンタジー</p>
				<ul class="list">
				<c:forEach var="f" items="${ fantasyRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">SF</p>
				<ul class="list">
				<c:forEach var="s" items="${ sfRank }">

				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">バラエティ</p>
				<ul class="list">
				<c:forEach var="b" items="${ barietyRank }">

				</c:forEach>
				</ul>
			</div>
        </div>
    </main>
    <footer>

    </footer>
</body>

</html>