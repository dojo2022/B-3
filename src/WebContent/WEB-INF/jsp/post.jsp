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
   			<form id="post_form" method="GET" action="/FLIFRE/PostServlet" onsubmit="return post()">
				<table>
					<tr>
		    			<td><input class="circle" type="" name=""  value="${user.user_img}" readonly></td><!-- m_userのuser_img アイコンを引用予定 -->
		   				<td><strong>${user.use_name}</strong></td>
		   				<!-- 			<span>ユーザー名</span>m_userのuser_nameを引用予定 -->
		   			</tr>
		   		</table>
				<div id="btn" class="post-btn"></div>
	<!--         	<div class="post-contents"> -->

		    <h1>${video.video_name}</h1><!-- m_videoのvideo_nameを引用 -->
		    <%
	    pageContext.setAttribute(
	        "categories",
	        new String[] {
	            "爆笑コメディ", "ポジティブ", "癒される", "スカッとする", "優雅",
	            "非日常的", "わくわく", "ときめく", "勉強になる", "泣ける", "儚い",
	            "衝撃的", "ミステリアス", "ダーク", "怖い", "グロテスク",
	        }
	    );
	    %>

		    <h2>${vidoe.video_time}</h2><!-- m_videoのvideo_timeを引用 -->
		    <h2>${video.genre_id}</h2><!-- m_videoのgenre_idを引用 -->
		    </form>

		    <form id="post_form" method="POST" action="/FLIFRE/PostServlet" onsubmit="return post()">
			    <input type="hidden" name="video_id" value="${video.video_id}">
			    <input type="hidden" name="user_id" value="'${video.user_id}">
			    <input type="hidden" name="genre_id" value="'${video.genre_id}">
			    <table>
			        <tr>
						<td>
				        	感想カテゴリ１
				        </td>
				        <td>
					       <select name="feelcat1" onchange="change(this)">
				        	<option>選択してください</option>
				            <core:forEach items="${ categories }" varStatus="status">
				      			<option value="${ status.current }">${ status.current }</option>
				            </core:forEach>
				        </select>
						</td>
						<td>
				         	感想カテゴリ２
				         </td>
				         <td>
				         	<select name="feelcat2">
				            <option>選択してください</option>
				            <core:forEach items="${ categories }" varStatus="status">
				            	<option value="${ status.current }">${ status.current }</option>
				            </core:forEach>
				        </select>
						</td>
						<td>
				        	5段階評価
				        </td>
				        <td>
				        	<select name="star">
				        		<option>選択してください</option>
				        		<option value="1">★</option>
				        		<option value="2">★★</option>
				        		<option value="3">★★★</option>
				        		<option value="4">★★★★</option>
				        		<option value="5">★★★★★</option>
				        	</select>
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
					    <td colspan="6">
					         <div class="text">
					        	<textarea name="review_contents" cols="100" rows="10"></textarea>
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

					    </td>
					</tr>
			    </table>
	        </form>
        </div>
	</main>

</body>
</html>