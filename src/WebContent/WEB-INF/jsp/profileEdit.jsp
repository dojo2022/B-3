<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール変更 | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile_edit.css">
<script src="/FLIFRE/js/profile.js"  defer></script>
</head>
<body>

 <%@ include file="header.jsp" %>


<h2 id="explain">プロフィール変更</h2>

<br>
<br>

<main>
	<form method="POST" action="/FLIFRE/ProfileServlet">
	<input type="hidden" name="user_id" value="${id.user_id}">
		<table class="pE_table">
		<tbody>
			<tr>
				<th>変更項目</th><th>変更前</th><th>変更後</th>
			</tr>
 			<tr id="icon_tr">
				<td id="icon_tr">
					アイコン画像
				</td>
 			<td id="icon_tr">
					<img src="images/${m_user.user_img}" width="80" height="80">
				</td>
				<td id="icon_tr">
					<select name="iconSelect">
						<optgroup label="icon">
							<option value="icon1">icon1.png</option>
							<option value="icon2">icon2.png</option>
							<option value="icon3">icon3.png</option>
							<option value="icon4">icon4.png</option>
							<option value="icon5">icon5.png</option>
						</optgroup>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					ユーザー名
				</td>
				<td>
					${m_user.user_name}
				</td>
				<td>
					<input type="text" name="user_name" value="">
				</td>
			</tr>
			<tr>
				<td>
					プロフィール文
				</td>
				<td>
					${m_user.user_pf}
				</td>
				<td>
					<input type="text" name="user_pf" value="">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="reset" name="reset" value="リセット">
					<input type="submit" name="profEditBottun" value="変更">
				</td>
			</tr>
		</tbody>
		</table>
	</form>
</main>

<br>
<br>

<%-- 	<!-- メインここから -->
	<main>
	<!-- 画像をフォルダから選んでアップロードできるようにしたいので、Nyampleを参考にする必要あり -->

		<!-- プロフィール変更ボックスここから -->
		<div class="myprofileEdit">
			<p id="ic_edit_tag">　　アイコン変更　　</p>
			<span>
			${m_user.user_img}
			</span>
			<!-- m_userのuser_img 現在使用中のアイコンを引用 -->

			<!-- 画像選択(仮)-->
			<form action="hoge.html" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
  				<div class="portlate" id="imageframe">
    			<input type="file" name="imgfile" value="" accept="image/png,image/jpeg,image/gif" multiple>
  				</div>
			</form>
		<br>
		<hr>

			<p id="user_edit_tag">　　ユーザー名変更　　</p>
			<span id="bf_edit">
			${m_user.user_name}
			</span>
			<!-- m_userのuser_name 現在使用中のユーザー名を引用 -->

			<p id="edittext"><input type="text" name="userNameEdit" value="編集"></p>
		<hr>

			<p id="pf_edit_tag">　　プロフィール文変更　　</p>
			<span id="bf_edit">
			${m_user.user_pf}
			</span>
			<!-- m_userのuser_pf 現在使用中のプロフィール文を引用 -->

			<p id="edittext"><input type="text" name="profileEdit" value="編集"></p>
		<br>
		<br>

		<p id="confilmButton"><input type="button" name="editConfilm" value="変更内容を確定">
		<!-- 変更内容を確定して反映させるボタン -->
		<br>
		</div>
		<!-- プロフィール変更ボックスここまで -->
<br>
<!-- メインここまで -->
</main>
<br>
<br> --%>

</body>
</html>