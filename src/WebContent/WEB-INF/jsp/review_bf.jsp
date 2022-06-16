<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<h2>レビュー投稿を表示します</h2>
	<div class="border1">
		<table class="table">
			<tr>
    			<td><input class="circle" type="" name="" value="" readonly></td>
   			</tr>
   			<tr>
    			<td><input class="user" type="" name="" value="" readonly></td>
			    <td><input class="video" type="" name="" value="" readonly></td>
			    <td><input class="time" type="" name="" value="" readonly></td>
			    <td><img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50" hight="50"></td>
   			</tr>
   			<tr>
			    <td><input class="review" type="" name="" value="" readonly></td>
			    <td><label class="open" for="popup"><img id="reply" src="images/reply.png" onclick="replyfrom()"width="50" hight="50"></label></td>
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
			</tr>
 		</table>
  		<div class="border-bottom"></div>
	</div>
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