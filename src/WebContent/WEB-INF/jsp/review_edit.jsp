<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビュー編集 | FLIFRE</title>
<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/post.css">
	<script src="js/post.js" defer></script>
</head>
<body>

   <%@ include file="header.jsp" %>


	<!-- 投稿フォーム-->
   	<main>
   		<div class="post-box">

		    <form id="post_form" method="POST" action="/FLIFRE/ReviewEditServlet" onsubmit="return post()">

			    <table>
			        <tr>
						<td>
				        	感想カテゴリ１
				        </td>
				        <td>
				         <p>${review_edit.feelcat_name1}</p>

					       <select name="feelcat_name1" onchange="change(this)">
				        	<option>選択してください</option>
				            <core:forEach items="${categories }" varStatus="status">
				      			<option value="${ status.current }">${ status.current }</option>
				            </core:forEach>
				        </select>
						</td>
						<td>
				         	感想カテゴリ２
				         </td>
				         <td>
				         <p>${review_edit.feelcat_name2}</p>
         				<select name="feelcat_name2">
				            <option>選択してください</option>
				            <core:forEach items="${categories }" varStatus="status">
				            	<option value="${ status.current }">${ status.current }</option>
				            </core:forEach>
				        </select>
						</td>
						<td>
				        	5段階評価
				        </td>
				        <td>
				        <p>${review_edit.star}</p>
 				        	<select name="star">
				        		<option>選択してください</option>
				        		<option value="★">★</option>
				        		<option value="★★">★★</option>
				        		<option value="★★★">★★★</option>
				        		<option value="★★★★">★★★★</option>
				        		<option value="★★★★★">★★★★★</option>
				        	</select>
				        <td>
				        </td>
				    </tr>
					<tr>
						<td>
					    	本文
					    </td>
					</tr>
					<tr>
					    <td colspan="6">
					         <div class="text">
					        	<textarea  name="review_contents" cols="100" rows="10">${review_edit.review_contents }</textarea>
				               	<input type="hidden" name="review_id" value="${review_edit.review_id}">
				        	</div>
				        </td>
					    <td>
					    </td>
					    <td>
					    </td>
					    <td>
					    </td>
					    <td>
					    </td>
					    <td>
					    <!-- submitボタンで/FLIFRE/PostServletのpostにデータを渡す -->
				<br> <br> <input type="hidden" name="review_date" value="${review_edit.review_date}">
				<button class="delete"type="submit" name="submit" value="レビュー編集中止">レビュー編集中止</button>
				<br>
				<br>
				<button class="edit" type="submit" name="submit" value="レビュー編集完了">レビュー編集完了</button>
								<br>
					    </td>
					</tr>
			    </table>
	        </form>
        </div>
</main>
<!-- メインここまで -->
</body>
</html>