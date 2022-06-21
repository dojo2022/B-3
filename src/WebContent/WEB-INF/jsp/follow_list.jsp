<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォロー/フォロワー一覧 ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/follow_list.css">
</head>
<body class="fbody">
	<%@ include file="header.jsp" %>

<!-- タブでフォロー/フォロワーを切り替えられるように -->
	<div class="area">

<!-- フォロー一覧タブ -->
	<input type="radio" name="tab_name" id="follow_tab" checked>
	<label class="tab_class" for=follow_tab>フォロー</label>
	<div class="content_class">

		<br>
		<br>
		<br>

		<div id="table">
		<table class="follow_table">
	  		<tbody id="follow_body">
			    <c:forEach var="i" items="${followList}" >
				    <tr>
					    <td id="icon"><img src="images/${i.user_img}" width="75" height="75"></td>
					    <td id="name"><a href="/FLIFRE/UserpageServlet?user_id=${i.user_id}">${i.user_name}</a></td>
					    <td id="pf">${i.user_pf}</td>
				    	<td id="bottun">
				    	<input type="submit" name="UnfollowBottun" value="フォロー解除">
				    	</td>
				    </tr>
			    </c:forEach>
	  		</tbody>
		</table>
		</div>

		<br>
		<br>
		<br>

	</div>

<!-- フォロワー一覧タブ -->
	<input type="radio" name="tab_name" id="follower_tab" checked>
	<label class="tab_class" for=follower_tab>フォロワー</label>
	<div class="content_class">

		<br>
		<br>
		<br>

		<div id="table">
		<table class="follow_table">
	  		<tbody id="follow_body">
			    <c:forEach var="i" items="${followerList}" >
			    <tr>
				    <td id="icon"><img src="images/${i.user_img}" width="75" height="75"></td>
				    <td id="name"><a href="/FLIFRE/UserpageServlet?user_id=${i.user_id}">${i.user_name}</a></td>
				    <td id="pf">${i.user_pf}</td>
			    	<td id="bottun">
			    	<c:choose>
			    	<c:when test = "${i.follow_exchange}">
			    		<input type="submit" name="UnfollowBottun" value="フォロー解除">
			    	</c:when>
			    	<c:otherwise>
						<input type="submit" name="FollowBottun" value="フォロー">
					</c:otherwise>
					</c:choose>
					</td>
			    </tr>
			    </c:forEach>
	  		</tbody>
		</table>
		</div>

		<br>
		<br>
		<br>

	</div>
	</div>
</body>
</html>