<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/login.css">
</head>
<body id="login_body">
	<div class="wrapper">
<!-- ロゴ -->
		<a href="/FLIFRE/Top_afServlet">
			<img src="images/logo.png" width="480" height="281" alt="FLIFRE">
		</a>
<!-- ログイン -->
	<main>
		<h2 id="explain">ログイン</h2>
		<form method="POST" action="/FLIFRE/LoginServlet">
			<table id="login_table">
				<tr>
					<td>
					<label>ID(メールアドレス)<br>
					<input type="text" name="ID">
					</label>
					</td>
				</tr>
				<tr>
					<td>
					<label>パスワード<br>
					<input type="password" name="PW">
					</label><br>
					</td>
				</tr>
				<tr>
			        <td>
			        <input type="submit" name="LOGIN" value="ログイン">
			        <input type="reset" name="reset" value="リセット"><br>
			        <span id="error_message"><%= request.getAttribute("error_message") %></span>
			        <td>
			    </tr>
			    <tr>
			    	<td>
			    	<a href="register.jsp">新規会員登録</a>
			    	</td>
			    </tr>
			</table>
		</form>
		<br>
	</main>
	</div>
</body>
</html>