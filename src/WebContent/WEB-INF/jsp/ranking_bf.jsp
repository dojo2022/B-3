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
<div class="wrapper">
    <!---->
    <%@ include file="header.jsp" %>
    <main>
        <div class="ranking-box">
            <h1 class="ranking">項目別ランキング</h1>
            <div class="ranklist">
                <p class="ranking">通算</p>
                <ul class="list">
                <c:forEach begin="1" end="3" var="e" items="${ReviewRanking}" >
                    <li><img class="rank" src="Gold.png"><c:out value="${ReviewRanking[1]}"></c:out></li>
                    <li><img class="rank" src="Silver.png"><c:out value="${ReviewRanking[2]}"></c:out></li>
                    <li><img class="rank" src="Bronze.png"><c:out value="${ReviewRanking[3]}"></c:out></li>
                </c:forEach>
                </ul>
            </div>

           <div class="ranklist">
                <p class="ranking">月間</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">アニメ</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">国内</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">欧米</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">韓国</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">華流</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">アクション</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">コメディ</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">キッズ・ファミリー</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">ヒューマンドラマ</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">サスペンス</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">ラブロマンス</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">ホラー</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">ファンタジー</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">SF</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
            <div class="ranklist">
                <p class="ranking">バラエティー</p>
                <ul class="list">
                    <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                    <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                    <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
                </ul>
            </div>
        </div>
    </main>
    <footer>

    </footer>
</div>
</body>

</html>