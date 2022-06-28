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
    <script src="/FLIFRE/js/profile.js" defer></script>
<script src="/FLIFRE/js/reply.js" defer></script>
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
    <td><img class="circle" src="images/${e.user_img}" width="75" height="75"></td>
   </tr>
   <tr>
    <td><span class="user"><a href="/FLIFRE/UserpageServlet?user_id=${e.user_id}">${e.user_name}</a></span></td>
    <td><span class="video">${e.video_name}</span></td>
    <input type="hidden" id="status_index" value="${status.index}">
        <td><label class="open" for="popup"><img id="reply${status.index}" src="images/reply.png" onclick="replyfrom()"width="30" hight="30"></label></td>
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

<div id="user_reply">
                                    <input type="hidden" id="status_index" value="${status.index}">
                                    <div id="reply_submit${status.index}">
                                    <input type="hidden" name="review_id" value="${e.review_id}">
                                    <input type="hidden" name="user_id" value="${id.user_id}">
                                    <input type="hidden" name="follow_id" value="${m_user.user_id}">
                                    <textarea id="iken" placeholder="内容を入力してください" name="textarea"></textarea>
                                    <input type="submit" name="submit" value="リプライを送信する">
                                    <!-- リプライフォームここまで -->
                                    </div>
                                </div>
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