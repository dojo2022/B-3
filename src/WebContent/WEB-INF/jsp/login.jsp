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
<body>
	<h1>FLIFRE</h1>
	<h2>ログイン</h2>
	<form>
		<table id="login_table">
			<tr>
				<td>
				<label>ID(メールアドレス)</label>
				<input type="text" name="ID">
				</td>
			</tr>
			<tr>
				<td>
				<label>パスワード</label>
				<input type="password" name="PW">
				</td>
			</tr>
			<tr>
		        <td>
		        <input type="submit" name="LOGIN" value="ログイン">
		        <a href="register.jsp">新規会員登録</a>
		        <span id="error_message"></span>
		        <td>
		    </tr>
		</table>
	</form>
</body>
</html>