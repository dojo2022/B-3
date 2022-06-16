<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォロー/フォロワー一覧 ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/follow_list.css">
</head>
<body>
	<div class="wrapper">
	<%@ include file="header.jsp" %>

<!-- フォロー一覧を表示する -->
	<h2 id="explain">フォロー</h2>
	<div>
	<table id="follow_table">
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
		    </c:forEach>
  		</tbody>
	</table>
	</div>
	フォロー解除
<!-- フォロワー一覧を表示する -->
	<h2 id="explain">フォロワー</h2>
	<div>
	<table id="follower_table">
  		<tbody>
		    <tr>
		      <th>アイコン</th><th>ユーザー名</th><th>プロフィール文</th>
		    </tr>
		    <c:forEach var="i" items="${followList}" >
		    <tr>
			    <td>${i.user_img}</td>
			    <td>${i.user_pf}</td>
			    <td>${i.user_pf}</td>
		    </tr>
		    </c:forEach>
  		</tbody>
	</table>
	</div>
	フォロー・フォロー解除
	</main>
	</div>
</body>
</html>