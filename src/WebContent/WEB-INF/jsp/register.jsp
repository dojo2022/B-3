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
	<div id="logo">
		<a href="/FLIFRE/Top_afServlet">
			<img src="images/logo.png" width="240" height="140" alt="FLIFRE">
		</a>
	</div>
	</header>
<!-- 新規会員登録 -->
	<main>
	<h2 id="explain">新規会員登録</h2>
	<form method="POST" action="/FLIFRE/RegisterServlet">
		<table id="register_table">
			<tr>
				<td>
				<label>メールアドレス<br>
				<input type="text" name="user_mail">
				</label>
				</td>
			</tr>
			<tr>
				<td>
				<label>パスワード<br>
				<input type="password" name="user_pw" id="password"><br>
				<input type="checkbox" id="password-check">
				パスワードを表示
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
		    <tr>
			    <td>
			    <strong><a href="/FLIFRE/LoginServlet">ログイン</a></strong>
			    </td>
			</tr>
			<tr>
			    <td>
			    <strong><a href="/FLIFRE/Top_bfServlet">トップページ</a></strong>
			    </td>
			</tr>
		</table>
	</form>
	</main>
	<script>
		    const pwd = document.getElementById('password');
		    const pwdCheck = document.getElementById('password-check');
		    pwdCheck.addEventListener('change', function() {
		        if(pwdCheck.checked) {
		            pwd.setAttribute('type', 'text');
		        } else {
		            pwd.setAttribute('type', 'password');
		        }
		    }, false);
	</script>
	</div>
</body>
</html>