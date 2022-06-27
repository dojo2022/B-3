<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>レビュー投稿 | FLIFRE</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/post.css">
    <link rel="stylesheet" href="css/top.css">
</head>


<body>
<%@ include file="header.jsp" %>
<h2>レビュー投稿を表示します</h2>
<!--  script type="text/javascript" src="/FLIFRE/jsp.js"></script>
    <form method="POST" action="/FLIFRE/Top_afServlet"-->
<div class="border1">


 <c:forEach var="e" items="${Review}">
 	<img src="images/${e.user_img}" width="75" height="75">
 	<span>
		<!-- ユーザー名  --> <strong>${e.user_name}</strong>
	</span>
	<br>
	<br>

<!-- 	<span> -->
<%-- 		<!-- 作品名 -->【 ${e.video_name} 】 --%>
		<span class="video">【 ${e.video_name} 】</span>

<!-- 	</span> -->
<!-- 	<span> -->
<%-- 		<!--  ジャンル  --> ${e.genre_name} --%>
<!-- 	</span> -->
<!-- 	<span> -->
<%-- 		<!-- 5段階評価  --> ${e.star} <input type="hidden" name="star" --%>
<%-- 		value="${e.star}"> --%>
<!-- 	</span> -->
<!-- 	<br> -->
<!-- 	感想カテゴリ： -->
<!-- 	<span> -->
<%-- 		<!-- 感想カテゴリ1 --> ${e.feelcat_name1} <input type="hidden" --%>
<%-- 		name="feelcat_name1" value="${e.feelcat_name1}"> --%>
<!-- 	</span> -->
 	<!-- t_reviewのfeelcat_name1を引用 -->

<!-- 	<span> -->
<%-- 		<!--  感想カテゴリ2  --> ${e.feelcat_name2} <input type="hidden" --%>
<%-- 		name="feelcat_name2" value="${e.feelcat_name2}"> --%>
<!-- 	</span> -->
	<!-- t_reviewのfeelcat_name2を引用 -->
	<br>
	<br>
	<span>
		<!-- レビュー本文 --> ${e.review_contents} <input type="hidden"
		name="review_contents" value="${e.review_contents}">
	</span>
	<br>
	<br><span>
		<!-- 投稿日時 --> ${e.review_date}
	</span>

  <table class="table">
   <tr>
    <td><span class="circle" >${e.user_img}</span></td>
   </tr>
   <tr>
    <td><span class="user">${e.user_name}</span></td>
    <td><span class="video">${e.video_name}</span></td>
    <td><span class="time">${e.review_date}</span></td>
   </tr>
   <tr>
    <td><textarea class="review" readonly>${e.review_contents}</textarea></td>
    </tr>
    </table>
    <br>
    <hr>
    <br>
    </c:forEach>


    	</div>
	</div>

  <div class="border-bottom"></div>
</div>
<!-- レビュー星表示 -->
    <script>
//スタンプクリックで変化ループ
      var img_src = new Array("images/nikochan5.png","images/nikochan6.png");
      var i = 0;

      function henkou() {

        if (i == 1) {
          i = 0;
        } else {
          i ++;
        }
        document.getElementById("image_file").src = img_src[i];
      }
      //resultという名前のスコープの中身を取り出す
      //中身がsuccessだったら成功しましたのアラート表示

</script>


</body>
</html>