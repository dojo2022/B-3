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

<!-- フォロー一覧を表示する -->
	<div class="flex">
	<div id="table">
	<table border="1" class="follow_table">
  		<tbody id="follow_body">
		    <!-- <tr>
		      <th id="icon">アイコン</th><th id="userName">ユーザー名</th><th id="prof">プロフィール文</th>
		    </tr> -->
		    <c:forEach var="i" items="${followList}" >
			    <tr id="deleteBottomBorder">
				    <!-- <td>${i.user_img}</td> -->
				    <td><img src="images/${i.user_img}" width="50" height="50"></td>
				    <td>${i.user_name}</td>
				    <td>${i.user_pf}</td>
			    </tr>
			    <tr id="deleteTopBorder">
			    	<td id="bottun" colspan="3">
			    	<input type="submit" name="UnfollowBottun" value="フォロー解除" id="followListBottun">
			    	</td>
			    </tr>
		    </c:forEach>
  		</tbody>
	</table>
	</div>

<!-- フォロワー一覧を表示する -->
	<div id="table">
	<table border="1" id="follower_table">
  		<tbody id="follower_body">
		    <!-- <tr>
		      <th>アイコン</th><th>ユーザー名</th><th>プロフィール文</th>
		    </tr> -->
		    <c:forEach var="i" items="${followerList}" >
		    <tr>
			    <td><img src="images/${i.user_img}" width="50" height="50"></td>
			    <td>${i.user_name}</td>
			    <td>${i.user_pf}</td>
		    </tr>
		    <tr>
		    	<td id="bottun" colspan="3">
		    	<c:choose>
		    	<c:when test = "${i.follow_exchange}">
		    		<input type="submit" name="UnfollowBottun" value="フォロー解除" id="followListBottun">
		    	</c:when>
		    	<c:otherwise>
					<input type="submit" name="FollowBottun" value="フォロー" id="followListBottun">
				</c:otherwise>
				</c:choose>
				</td>
		    </tr>
		    </c:forEach>
  		</tbody>
	</table>
	</div>
	</div>
</body>
</html>