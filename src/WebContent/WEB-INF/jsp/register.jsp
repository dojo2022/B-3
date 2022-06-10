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
<body>
	<h1>FLIFRE</h1>
	<h2>新規会員登録</h2>
	<form>
		<table id="register_table">
			<tr>
				<td>
				<label>メールアドレス(IDになります)</label>
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
				<label>パスワード（再入力）</label>
				<input type="password" name="PW">
				</td>
			</tr>
			<tr>
				<td>
				<label>ユーザー名</label>
				<input type="text" name="user_name">
				</td>
			</tr>
			<tr>
		        <td>
		        <input type="submit" name="REGISTER" value="登録">
		        <input type="reset" name="reset" value="リセット">
          		<span id="error_message"></span>
		        <td>
		    </tr>
		</table>
	</form>
</body>
</html>