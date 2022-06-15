<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録 ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/register.css">
</head>
<body id="register_body">
	<div class="wrapper">
<!-- ロゴ -->
	<header>
		<a href="/FLIFRE/Top_afServlet">
			<img src="images/logo.png" width="480" height="281" alt="FLIFRE">
		</a>
	</header>
<!-- 新規会員登録 -->
	<main>
	<h2 id="explain">新規会員登録</h2>
	<form method="POST" action="/FLIFRE/RegisterServlet">
		<table id="register_table">
			<tr>
				<td>
				<label>メールアドレス(ID)<br>
				<input type="text" name="ID">
				</label>
				</td>
			</tr>
			<tr>
				<td>
				<label>パスワード<br>
				<input type="password" name="PW">
				</label>
				</td>
			</tr>
			<tr>
				<td>
				<label>パスワード（再入力）<br>
				<input type="password" name="PW">
				</label>
				</td>
			</tr>
			<tr>
				<td>
				<label>ユーザー名<br>
				<input type="text" name="user_name">
				</label><br>
				</td>
			</tr>
			<tr>
		        <td>
		        <input type="submit" name="REGISTER" value="登録">
		        <input type="reset" name="reset" value="リセット"><br>
          		<span id="error_message"></span>
		        <td>
		    </tr>
		</table>
	</form>
	</main>
	</div>
</body>
</html>