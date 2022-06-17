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
<body>
	<%@ include file="header.jsp" %>

<!-- フォロー一覧を表示する -->
	<div class="flex">
	<table border="1" id="follow_table">
		<p>フォロー</p>
  		<tbody>
		    <tr>
		      <th>アイコン</th><th>ユーザー名</th><th>プロフィール文</th>
		    </tr>
		    <c:forEach var="i" items="${followList}" >
		    <tr>
			    <td>${i.user_img}</td>
			    <td>${i.user_name}</td>
			    <td>${i.user_pf}</td>
		    </tr>
		    <tr>
		    	<td colspan="3" >
		    	<input type="submit" name="UnfollowBottun" value="フォロー解除" id="followListBottun">
		    	</td>
		    </tr>
		    </c:forEach>
  		</tbody>
	</table>

<!-- フォロワー一覧を表示する -->
	<table border="1" id="follower_table">
  		<tbody>
  		<p>フォロワー</p>
		    <tr>
		      <th>アイコン</th><th>ユーザー名</th><th>プロフィール文</th>
		    </tr>
		    <c:forEach var="i" items="${followList}" >
		    <tr>
			    <td>${i.user_img}</td>
			    <td>${i.user_name}</td>
			    <td>${i.user_pf}</td>
		    </tr>
		    <tr>
		    	<td colspan="3">
		    	<input type="submit" name="FollowBottun" value="フォロー" id="followListBottun">
				<input type="submit" name="UnfollowBottun" value="フォロー解除" id="followListBottun">
				</td>
		    </tr>
		    </c:forEach>
  		</tbody>
	</table>
	</div>
</body>
</html>