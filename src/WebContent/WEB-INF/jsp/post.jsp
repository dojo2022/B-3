<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>レビュー投稿 | FLIFRE</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/post.css">
	<script src="js/post.js" defer></script>
</head>


<body>

   <%@ include file="header.jsp" %>


	<!-- 投稿フォーム-->
   	<main>
   		<div class="post-box">
   			<form id="post_form" method="POST" action="/FLIFRE/PostServlet" onsubmit="return post()">
				<table>
					<tr>
		    			<td><input class="circle" type="" name=""  value="${user_img}" readonly></td><!-- m_userのuser_img アイコンを引用予定 -->
		   				<td><strong>${user_name}</strong></td>
		   				<!-- 			<span>ユーザー名</span>m_userのuser_nameを引用予定 -->
		   			</tr>
		   		</table>
				<div id="btn" class="post-btn"></div>
	<!--         	<div class="post-contents"> -->

		        <h1>${video_name}</h1><!-- m_videoのvideo_nameを引用 -->

		        <h2>${video_time}</h2><!-- m_videoのvideo_timeを引用 -->
		        <h2>${genre_id}</h2><!-- m_videoのgenre_idを引用 -->
			    <table>
			        <tr>
						<td>
				        	感想カテゴリ１
				        </td>
				        <td>
					        <select name="select1" onchange="change(this)">
					        	<option>選択してください</option>
					            <option value="1番目">爆笑コメディ</option>
					            <option value="2番目">ポジティブ</option>
					            <option value="3番目">癒される</option>
					            <option value="4番目">スカッとする</option>
					            <option value="5番目">優雅</option>
					            <option value="6番目">非日常的</option>
					            <option value="7番目">わくわく</option>
					            <option value="8番目">ときめく</option>
					            <option value="9番目">勉強になる</option>
					            <option value="10番目">泣ける</option>
					            <option value="11番目">儚い</option>
					            <option value="12番目">衝撃的</option>
					            <option value="13番目">ミステリアス</option>
					            <option value="14番目">ダークな</option>
					            <option value="15番目">怖い</option>
					            <option value="16番目">グロテスク</option>
					        </select>
						</td>
						<td>
				         	感想カテゴリ２
				         </td>
				         <td>
				         	<select name="select2">
					            <option>選択してください</option>
					            <option label="爆笑コメディ"></option>
					            <option label="ポジティブ"></option>
					            <option label="癒される"></option>
					            <option label="スカッとする"></option>
					            <option label="優雅"></option>
					            <option label="非日常的"></option>
					            <option label="わくわく"></option>
					            <option label="ときめく"></option>
					            <option label="勉強になる"></option>
					            <option label="泣ける"></option>
					            <option label="儚い"></option>
					            <option label="衝撃的"></option>
					            <option label="ミステリアス"></option>
					            <option label="ダークな"></option>
					            <option label="怖い"></option>
					            <option label="グロテスク"></option>
							</select>
						</td>
						<td>
				        	5段階評価
				        </td>
				        <td>
				        </td>
				    </tr>
					<tr>
						<td>
					    	本文
					    </td>
					</tr>
					<tr>
					    <td colspan="5">
					         <div class="text">
					        	<textarea name="text" cols="100" rows="10"></textarea>
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
					</tr>
			    </table>
	        </form>
        </div>
	</main>

</body>
</html>