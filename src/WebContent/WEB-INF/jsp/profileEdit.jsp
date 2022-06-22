<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール変更 | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js"  defer></script>
</head>
<body>
<header>
<!-- <form method="POST" action="/FLIFRE/ResultServlet"> -->
	<div class="search">

			<h1 id="logo">
		    	<a href="/FLIFRE/Top_afServlet"><img src="images/logo.png" width="240" height="140" alt="FLIFRE"></a>
		    </h1>

		    <p class="log">
		        <a href="/FLIFRE/${ empty id ? 'Login' : 'Logout' }Servlet">
		            <img src="images/${ empty id ? 'login' : 'logout' }.png"
		                 width="97" height="29"
		                 alt="${ empty id ? 'ログイン' : 'ログアウト' }">
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
	</div>
</header>

	<!-- メインここから -->
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

			<p id="hd_edit_tag">　　ヘッダー変更　　</p>
			<span>
			${m_user.user_hd}
			</span>
			<!-- m_userのuser_hd 現在使用中のヘッダーを引用 -->

			<!-- 画像選択(仮) -->
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
<br>
</body>
</html>