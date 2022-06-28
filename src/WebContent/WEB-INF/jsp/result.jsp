<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html lang="ja-jp">

<head>
    <meta charset="UTF-8">
    <title> 検索結果 | FLIFRE </title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/result.css">
</head>

<body>
    <!-- header start -->
    <%@ include file="header.jsp" %>
    <!-- header end -->

    <div class="wrapper">
        <!-- 検索結果　一覧 start-->
        <main>
            <div id="search-result-container">
                <core:forEach var="video" items="${ videoList }">
                <div class="search-result-item">
                    <div class="video-image">
                      <img src="images/sampleImage.png"
                           width="250px"
                           onError="this.onerror=null;this.src='images/sampleImage.png';">
                    </div>
                    <table class="video-info">
                        <tr>
                            <th>作品名：</th>
                            <td>${ video.video_name }</td>
                        </tr>
                        <tr>
                            <th>年代：</th>
                            <td>${ video.video_year }年</td>
                        </tr>
                        <tr>
                            <th>時間：</th>
                            <td>${ video.video_time }分</td>
                        </tr>
                    </table>
                    <div class="buttons">
                        <button type="button" title="write-review"
                                onclick="location.href='/FLIFRE/PostServlet?video_id=${ video.video_id }'"
                                ${empty id? 'hidden' : ''}>
                            レビューを<br>
                            書く
                        </button>
                        <button type="button" title="read-review"
                                onclick="location.href='/FLIFRE/ReviewServlet?video_id=${ video.video_id }'" >
                            レビューを<br>
                            見る
                        </button>
                    </div>
                </div>
                </core:forEach>
            </div>
        </main>
        <!-- 検索結果　一覧 end-->

        <!-- footer start -->
        <footer>

        </footer>
        <!-- footer end -->
    </div>
</body>

</html>