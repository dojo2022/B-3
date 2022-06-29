<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/contact.css">
</head>
<body id="contact_body">
	 <%@ include file="header.jsp" %>
<!--ここまでメニュー-->
<!-- お問い合わせ -->
	<main>
	<h2 id="explain">お問い合わせ</h2>
	<div class="contact-box">
	<table id="contact_table">
		<tr>
			<td><br>各種お問い合わせに関しましては、
			<strong>aburiengawa@gmail.com</strong>に送信いただきますようお願い申し上げます。</td>
		</tr>
		<tr>
			<td>お問い合わせに含めていただきたい項目は以下の通りです。</td>
			<br>
		</tr>
		<tr>
			<td>
			<table id="ct_items">
				<tr>
				<td>
					<label>①ユーザー名</label><br>
				</td>
				</tr>
				<tr>
				<td>
					<label>②お問い合わせの種類</label><br>
					<ol>
						<li>サービスについて
						<li>作品情報について
						<li>ユーザーについて
						<li>その他
					</ol>
				</td>
				</tr>
				<tr>
				<td>
					<label>③お問い合わせの内容（200文字まで）</label><br>
				</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>以上の項目をすべて記入されませんと、
			返信いたしかねますので何卒よろしくお願い申し上げます。<br><br></td>
		</tr>
	</table>
	</div>
	</main>
	</div>
</body>
</html>