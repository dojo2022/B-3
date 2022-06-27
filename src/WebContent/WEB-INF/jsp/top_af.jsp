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
 <c:forEach var="e" items="${Reviewdata}">
  <table class="table">
   <tr>
    <td><span class="circle" >${e.user_img}</span></td>
   </tr>
   <tr>
    <td><span class="user">${e.user_name}</span></td>
    <td><span class="video">${e.video_name}</span></td>
        <td><label class="open" for="popup"><img id="reply" src="images/reply.png" onclick="replyfrom()"width="30" hight="30"></label></td>
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
     <input type="checkbox" id="popup">
     <div class="overlay">
    <div class="window">
        <label class="close" for="popup">×</label>
        <from>
            <div class="example">
    <label for="namelabel">ユーザー名</label>
    <input type="text" name="name" id="namelabel" placeholder="匿名">
  </div>
   <div class="example">
    <label for="ikenlabel" >リプライ内容</label>
    <textarea id="iken" placeholder="内容を入力してください"></textarea>
  </div>
  <div class="example">
    <input type="submit" value="送信する">
  </div>
        </from>
    </div>
</div>


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
      if(document.getAttribute("result") != null){
		window.alert(document.getAttribute("result"));
      }
</script>

</body>
</html>