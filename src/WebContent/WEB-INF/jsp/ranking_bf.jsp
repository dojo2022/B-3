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
            <h2 class="ranking-page">項目別レビュー数ランキング</h2>
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
				<h3 class="ranking">通算</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li ><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${totalRank[i].video_id}"><strong>${ totalRank[i].video_name}</strong></a>
					<span class="count">${ totalRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">アニメ</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${animeRank[i].video_id}"><strong>${ animeRank[i].video_name}</strong></a>
					<span class="count">${ animeRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">国内</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${localRank[i].video_id}"><strong>${ localRank[i].video_name}</strong></a>
					<span class="count">${ localRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">欧米</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${usRank[i].video_id}"><strong>${ usRank[i].video_name}</strong></a>
					<span class="count">${ usRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>
			<div class="ranklist">
				<h3 class="ranking">韓国</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${koreaRank[i].video_id}"><strong>${ koreaRank[i].video_name}</strong></a>
					<span class="count">${ koreaRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">華流</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${chinaRank[i].video_id}"><strong>${ chinaRank[i].video_name}</strong></a>
					<span class="count">${ chinaRank[i].count}post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">アクション</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${actionRank[i].video_id}"><strong>${ actionRank[i].video_name}</strong></a>
					<span class="count">${ actionRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">コメディ</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${comedyRank[i].video_id}"><strong>${ comedyRank[i].video_name}</strong></a>
					<span class="count">${ comedyRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">キッズ・ファミリー</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${familyRank[i].video_id}"><strong>${ familyRank[i].video_name}</strong></a>
					<span class="count">${ familyRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">ヒューマンドラマ</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${humanRank[i].video_id}"><strong>${ humanRank[i].video_name}</strong></a>
					<span class="count">${ humanRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">サスペンス</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${suspenseRank[i].video_id}"><strong>${ suspenseRank[i].video_name}</strong></a>
					<span class="count">${ suspenseRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>


			<div class="ranklist">
				<h3 class="ranking">ラブロマンス</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${romanceRank[i].video_id}"><strong>${ romanceRank[i].video_name}</strong></a>
					<span class="count">${ romanceRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">ホラー</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${horrorRank[i].video_id}"><strong>${ horrorRank[i].video_name}</strong></a>
					<span class="count">${ horrorRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">ファンタジー</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${fantasyRank[i].video_id}"><strong>${ fantasyRank[i].video_name}</strong></a>
					<span class="count">${ fantasyRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">SF</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${sfRank[i].video_id}"><strong>${ sfRank[i].video_name}</strong></a>
					<span class="count">${ sfRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<h3 class="ranking">バラエティ</h3>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/ResultServlet?video_id= ${barietyRank[i].video_id}"><strong>${ barietyRank[i].video_name}</strong></a>
					<span class="count">${ barietyRank[i].count} post</span></li>
				</c:forEach>
				</ul>
			</div>
        </div>
    </main>
    <footer>

    </footer>
</body>

</html>