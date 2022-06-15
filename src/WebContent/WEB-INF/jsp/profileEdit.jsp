<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール変更 | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js"></script>
</head>
<body>
<header>
<h1 id="logo">
<a href="/FLIFRE/Top_afServlet"><img src="images/logo.png" width="240" height="140" alt="FLIFRE"></a>
</h1>

<p class="log">
	<a href="/FLIFRE/${ empty id ? 'Login' : 'Logout' }Servlet">
	<img src="images/${ empty id ? 'login' : 'logout' }.png"
	width="97" height="29" alt="${ empty id ? 'ログイン' : 'ログアウト' }">
	</a>
</p>

<!--ここからメニュー-->
 <div class="hamburger-menu">
	        <input type="checkbox" id="menu-btn-check">
	        <label for="menu-btn-check" class="menu-btn"><span></span></label>
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
	                <core:if test="${ not empty id }">
	                	<li><a href="/FLIFRE/MypageServlet">マイページ</a></li>
	                </core:if>
	                <li><a href="/FLIFRE/ContactServlet">お問い合わせ</a></li>
	            </ul>
	        </div>
	    </div>
<!--ここまでメニュー-->
</header>

<!-- メインここから -->
<main>
<!-- <c:forEach var="" items="" > -->
<form id = profile_edit method="POST" action="/FLIFRE/ProfileServlet">
	<table>
		<tr>
			<td>
			アイコン
			</td>
		</tr>
		<tr>
			<td>
			<img src="./images/pf_img.png">
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" name="ICONWEDIT" value="編集">
			<hr>
			</td>
		</tr>
		<tr>
			<td>
			ヘッダー
			</td>
		</tr>
		<tr>
			<td><img src="./images/pfEdit_hd.png">
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" name="ICONWEDIT" value="編集">
			<hr>
			</td>
		</tr>
		<tr>
			<td>
			ユーザー名
			</td>
		</tr>
		<tr>
			<td>
			炙りえんがわ
			</td>
		</tr>
		<tr>
			<td><input type="text" name="userName" value="編集">
			<hr>
			</td>
		</tr>
		<tr>
			<td>
			プロフィール文
			</td>
		</tr>
		<tr>
			<td>
			アニメと洋画が好きです。
			</td>
		</tr>
		<tr>
			<td><input type="text" name="profile" value="編集">
			</td>
		</tr>
	</table>
</form>
<!-- </c:forEach> -->
<!-- メインここまで -->
</main>
</body>
</html>