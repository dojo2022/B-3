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
				<c:forEach begin="0" end="2" var="i">
					<li ><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${totalRank[i].video_id}">${ totalRank[i].video_name}</a>
					<span class="count">${ totalRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">アニメ</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${animeRank[i].video_id}">${ animeRank[i].video_name}</a>
					<span class="count">${ animeRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">国内</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${localRank[i].video_id}">${ localRank[i].video_name}</a>
					<span class="count">${ localRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">欧米</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${usRank[i].video_id}">${ usRank[i].video_name}</a>
					<span class="count">${ usRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>
			<div class="ranklist">
				<p class="ranking">韓国</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${koreaRank[i].video_id}">${ koreaRank[i].video_name}</a>
					<span class="count">${ koreaRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">華流</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${chinaRank[i].video_id}">${ chinaRank[i].video_name}</a>
					<span class="count">${ chinaRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">アクション</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${actionRank[i].video_id}">${ actionRank[i].video_name}</a>
					<span class="count">${ actionRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">コメディ</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${comedyRank[i].video_id}">${ comedyRank[i].video_name}</a>
					<span class="count">${ comedyRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">キッズ・ファミリー</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${familyRank[i].video_id}">${ familyRank[i].video_name}</a>
					<span class="count">${ familyRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ヒューマンドラマ</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${humanRank[i].video_id}">${ humanRank[i].video_name}</a>
					<span class="count">${ humanRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">サスペンス</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${suspenseRank[i].video_id}">${ suspenseRank[i].video_name}</a>
					<span class="count">${ suspenseRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>


			<div class="ranklist">
				<p class="ranking">ラブロマンス</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${romanceRank[i].video_id}">${ romanceRank[i].video_name}</a>
					<span class="count">${ romanceRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ホラー</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${horrorRank[i].video_id}">${ horrorRank[i].video_name}</a>
					<span class="count">${ horrorRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">ファンタジー</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${fantasyRank[i].video_id}">${ fantasyRank[i].video_name}</a>
					<span class="count">${ fantasyRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">SF</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${sfRank[i].video_id}">${ sfRank[i].video_name}</a>
					<span class="count">${ sfRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>

			<div class="ranklist">
				<p class="ranking">バラエティ</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${barietyRank[i].video_id}">${ barietyRank[i].video_name}</a>
					<span class="count">${ barietyRank[i].count}</span></li>
				</c:forEach>
				</ul>
			</div>
        </div>
    </main>
    <footer>

    </footer>
</body>

</html>