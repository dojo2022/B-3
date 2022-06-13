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
      <p class="log">
         <a href="/FLIFRE/LogoutServlet"><img src="images/logout.png"  width="120" height="29" alt="ログアウト"></a>
         <!--ログアウト状態のページではこっち→　<a href="/FLIFRE/LoginServlet"><img src="images/login.png"  width="97" height="29" alt="ログイン"></a>　-->
      </p>
      <div class="hamburger-menu">
         <input type="checkbox" id="menu-btn-check">
         <label for="menu-btn-check" class="menu-btn"><span></span></label>
      </div>
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
      <!--ここまでメニュー-->
</header>

<!-- <c:forEach var="" items="" > -->
<form id = profile_edit method="POST" action="/FLIFRE/ProfileServlet">
	<table>
		<tr>
			<td>アイコン
			</td>
			<td><input type="image" src=".png" name="icon" value="編集">
			</td>
		</tr>
		<tr>
			<td>ヘッダー
			</td>
			<td><input type="image" src=".png" name="header" value="編集">
			</td>
		</tr>
		<tr>
			<td>ユーザー名
			</td>
			<td><input type="image" name="userName" value="編集">
			</td>
		</tr>
		<tr>
			<td>プロフィール文
			</td>
			<td><input type="text" name="profile" value="編集">
			</td>
		</tr>
	</table>
</form>
<!-- </c:forEach> -->
</body>
</html>