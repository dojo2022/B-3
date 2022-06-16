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
	    	<div class="ranklist">
			<c:forEach var="g" items="${ genre }">
				<p class="ranking">${g}</p>
				<ul class="list">
				<c:forEach begin="0" end="2" var="i">
					<li><img class="rank" src="images/${ rank[i] }.png"><a href="/FLIFRE/Result_afServlet?video_id= ${Genre[g][i].video_id}">${ Genre[g][i].video_name}</a></li>
				</c:forEach>
				</ul>
			</c:forEach>
			</div>
        </div>
    </main>
    <footer>

    </footer>
</body>

</html>