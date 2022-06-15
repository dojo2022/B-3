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
	<div class="wrapper">
<!-- ロゴ -->
	<div id="logo">
		<a href="/FLIFRE/Top_afServlet">
			<img src="images/logo.png" width="480" height="281" alt="FLIFRE">
		</a>
	</div>
<!-- ハンバーガーメニュー -->
   <header>
      <p class="log">
         <a href="/FLIFRE/LogoutServlet"><img src="images/logout.png"  width="120" height="29" alt="ログアウト"></a>
         <!--ログアウト状態のページではこっち→　<a href="/FLIFRE/LoginServlet"><img src="images/login.png"  width="97" height="29" alt="ログイン"></a>　-->
      </p>
      <div class="hamburger-menu">
         <input type="checkbox" id="menu-btn-check">
         <label for="menu-btn-check" class="menu-btn"><span></span></label>
<!--ここからメニュー-->
      <div class="menu-content">
         <ul>
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
            <li><a href="/FLIFRE/MypageServlet">マイページ</a></li> <!--ログアウト状態のページではカット-->
         </ul>
      </div>
      </div>
   </header>
<!--ここまでメニュー-->
<!-- お問い合わせ -->
	<main>
	<h2 id="explain">お問い合わせ</h2>
	<table id="contact_table">
		<tr>
			<td>各種お問い合わせに関しましては、
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
			返信いたしかねますので何卒よろしくお願い申し上げます。</td>
			<br>
		</tr>
	</table>
	</main>
	</div>
</body>
</html>