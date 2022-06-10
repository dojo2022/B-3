<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/contact.css">
<body>
	<h1>FlIFRE</h1>
<!-- ログアウトボタン -->
	<input type="button" onclick="/FLIFRE/LogoutServlet" value="ログアウト">
<!-- ハンバーガーメニュー -->
	<header>
		<input type="checkbox" class="menu-btn" id="menu-btn">
		<label for="menu-btn" class="menu-icon"><span class="navicon"></span></label>
  		<ul class="menu">
		    <li><a href="/FLIFRE/Result_afServlet">アニメ</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">国内</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">欧米</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">韓国</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">華流</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">アクション</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">コメディ</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">キッズ・ファミリー</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">ヒューマンドラマ</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">サスペンス</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">ラブロマンス</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">ホラー</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">ファンタジー</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">SF</a></li>
		    <li><a href="/FLIFRE/Result_afServlet">バラエティ</a></li>
		    <li><a href="/FLIFRE/Ranking_afServlet">レビューランキング</a></li>
		    <li><a href="/FLIFRE/MypageServlet">マイページ</a></li>
  		</ul>
  	</header>
<!-- お問い合わせ -->
	<table id="contact_table">
		<tr>
			<td>お問い合わせ</td>
		</tr>
		<tr>
			<td>各種お問い合わせに関しましては、
			aburiengawa@gmail.comに送信いただきますようお願い申し上げます。</td>
		</tr>
		<tr>
			<td>お問い合わせに含めていただきたい項目は以下の通りです。</td>
		</tr>
		<tr>
			<td>
			<ol>
				<li>ユーザー名
				<li>お問い合わせの種類
				<ol>
					<li>サービスについて
					<li>作品情報について
					<li>ユーザーについて
					<li>その他
				</ol>
				<li>お問い合わせの内容（200文字まで）
			</ol>
			</td>
		</tr>
		<tr>
			<td>以上の項目をすべて記入されませんと、
			返信いたしかねますので何卒よろしくお願い申し上げます。</td>
		</tr>
	</table>
</body>
</head>
</html>