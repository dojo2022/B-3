<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


	<!-- 投稿一覧 -->
	<main>
		<h2>${video.video_name}</h2>
		<h3>${video.genre_name}</h3>
		<div class="review-box">
			<form id="review_form" method="GET" action="/FLIFRE/ReviewServlet" onsubmit="return post()">
<!-- 				<table class="table"> -->
					<c:forEach var="e" items="${reviewList}" >
						<!-- アイコン -->
						<img src="images/${e.user_img}" width="75" height="75"> <span>
							<!-- ユーザー名  --> <strong>${e.user_name}</strong>
						</span>
						<br> <span> <!--  5段階評価  --> ${e.star}
						</span>
						<!-- t_reviewのstarを引用 -->

						<span> <!-- 投稿日時 --> ${e.review_date}
						</span>
						<!-- t_reviewのreview_dateを引用 -->

						<br>感想カテゴリ： <span> <!--  感想カテゴリ1  --> ${e.feelcat_name1}
						</span>
						<!-- t_reviewのfeelcat_name1を引用 -->

						<span> <!--  感想カテゴリ2  --> ${e.feelcat_name2}
						</span>
						<!-- t_reviewのfeelcat_name2を引用 -->

						<br><br> <span> <!-- レビュー本文 --> ${e.review_contents}
						</span>
						<!-- t_reviewのreview_contentsを引用 -->
						<!-- ueda -->
						<!-- リプライの本文追加。書いた人の名前　日時　リプライした本文 -->
						<%-- <c:forEach var="reply" items="${}" >
</c:forEach> --%>
						<%-- <cforEach >
				<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50">
				<!-- マイページではちゃんと動作するのにユーザーページでは動かない！！確認が必要 -->
				<!-- スタンプの画像をクリックすると画像が変化 -->
				${e.stamp_name}
				<!-- m_stampのstamp_id, stamp_name --> --%>

						<br>

						<!-- リプライフォームここから ここのデータ格納方法が分からない-->
						<hr>
						<c:if test="${ not empty id }">
						<c:set var="e_review_id" value="${e.review_id}" />
						<c:forEach var="i" begin="0" end="${replyLists.size()}" step="1">
							<c:forEach var="reply" items="${replyLists[i] }">

								<c:set var="reply_review_id" value="${reply.review_id}" />


								<c:if test="${reply_review_id == e_review_id}">
									<p><a href="/FLIFRE/UserpageServlet?user_id=${reply.user_id}">
									${reply.user_name}</a></p>
									<p>${reply.reply_contents}</p>
									<p>${reply.reply_date}</p>
								</c:if>

							</c:forEach>
						</c:forEach>

						<input type="hidden" id="status_index" value="${status.index}">
						<img id="reply${status.index}" src="./images/reply.png"  width="50" height="50">
							<div id="reply_submit${status.index}">
								<input type="hidden" name="review_id" value="${e.review_id}">
								<input type="hidden" name="user_id" value="${id.user_id}">
								<input type="hidden" name="follow_id" value="${m_user.user_id}">
								<textarea id="iken" placeholder="内容を入力してください" name="textarea"></textarea>
								<br>
								<input type="submit" name="submit" value="リプライを送信する">

								<!-- リプライフォームここまで -->
							</div>
						</c:if>
						<hr>
					</c:forEach>
<!-- 						<table class="table"> -->
<!-- 							<tr class="review"> -->
<%-- 				    			<td id="icon"><img src="images/${e.user_img}" width="75" height="75"></td> --%>
<%-- 								<td id="name"><a href="/FLIFRE/UserpageServlet?user_id=${e.user_name}">${e.user_name}</a></td> --%>
<%-- 							    <td>${e.star}</td> --%>
<!-- 							    <td>感想カテゴリー：</td> -->
<%-- 							    <td>${e.feelcat_name1}</td> --%>
<%-- 							    <td>${e.feelcat_name2}</td> --%>
<%-- 							    <td>${e.review_date}</td> --%>
<!-- <!-- 							    <td><img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" height="50"></td> -->
<!-- 				   			</tr> -->

<!-- 				   			<tr> -->
<%-- 							    <td colspan="7">${e.review_contents}</td> --%>
<!-- 							    <td><label class="open" for="popup"><img id="reply" src="images/reply.png" onclick="replyfrom()"width="50" height="50"></label></td> -->
<!-- 							</tr> -->
<!-- 						</table> -->
<!-- 						<br> -->
<!-- 						<hr> -->
<!-- 						<br> -->


<!-- 	   				<input type="checkbox" id="popup"> -->
<!-- 				    <div class="overlay"> -->
<!-- 					   	<div class="window"> -->
<!-- 					       	<label class="close" for="popup">×</label> -->
<!-- 					       	<form> -->
<!-- 					           	<div class="example"> -->
<!-- 					   				<label for="namelabel">ユーザー名</label> -->
<!-- 					   				<input type="text" name="name" id="namelabel" placeholder="匿名"> -->
<!-- 					 			</div> -->
<!-- 					  			<div class="example"> -->
<!-- 								    <label for="ikenlabel" >リプライ内容</label> -->
<!-- 								    <textarea id="iken" placeholder="内容を入力してください"></textarea> -->
<!-- 					 			</div> -->
<!-- 					 			<div class="example"> -->
<!-- 					   				<input type="submit" value="送信する"> -->
<!-- 					 			</div> -->
<!-- 					       	</form> -->
<!-- 					   	</div> -->
<!-- 					</div> -->
		  		<div class="border-bottom"></div>
		  	</form>
		</div>
	</main>
  <!--label class="label" for="name">名前</label>
  <input id="name" type="text" name="name">
  <label class="label" for="message">コメント</label>
  <textarea rows="4" id="message" placeholder="ご意見をお寄せ下さい。" name="comment"></textarea>
  <input type="submit">
</form-->


<style>
label, input[type=text]{
 display:block;
}
</style>
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
//リプライクリックで入力フォーム表示
/*function replyfrom(){
    var reply = document.getElementById('reply');
    var source = reply.src;

}*/
</script>
</body>
</html>