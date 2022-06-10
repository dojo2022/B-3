<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォロー/フォロワー一覧 ｜ FLIFRE</title>
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/common.css">
<link rel="stylesheet" type="text/css" href="/FLIFRE/css/follow_list.css">
</head>
<body>
	<h1>FLIFRE</h1>
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
<!-- 検索 -->
	<input type="text" name="text" placeholder="タイトル入力">
        <input type="submit" name="submit" value="検索">
        <input type="button" onclick="/FLIFRE/LoginServlet" value="ログイン">
        <form name="sample">
            感想カテゴリ１
            <select name="select1" onchange="change(this)">
               <option>選択してください</option>
               <option value="1 番目">爆笑コメディ</option>
               <option value="2 番目">ポジティブ</option>
               <option value="3 番目">癒される</option>
               <option value="4 番目">スカッとする</option>
               <option value="5 番目">優雅</option>
               <option value="6 番目">非日常的</option>
               <option value="7 番目">わくわく</option>
               <option value="8 番目">ときめく</option>
               <option value="9 番目">勉強になる</option>
               <option value="10 番目">泣ける</option>
               <option value="11 番目">儚い</option>
               <option value="12 番目">衝撃的</option>
               <option value="13 番目">ミステリアス</option>
               <option value="14 番目">ダークな</option>
               <option value="15 番目">怖い</option>
               <option value="16 番目">グロテスク</option>
            </select>
            感想カテゴリ２
            <select name="select2">
               <option>選択してください</option>
               <option label="爆笑コメディ"></option>
               <option label="ポジティブ"></option>
               <option label="癒される"></option>
               <option label="スカッとする"></option>
               <option label="優雅"></option>
               <option label="非日常的"></option>
               <option label="わくわく"></option>
               <option label="ときめく"></option>
               <option label="勉強になる"></option>
               <option label="泣ける"></option>
               <option label="儚い"></option>
               <option label="衝撃的"></option>
               <option label="ミステリアス"></option>
               <option label="ダークな"></option>
               <option label="怖い"></option>
               <option label="グロテスク"></option>
            </select>
            <br>
            再生時間
             <select name="select3">
               <option label="～30分"></option>
               <option label="31～60分"></option>
               <option label="61～90分"></option>
               <option label="91～120分"></option>
               <option label="121～150分"></option>
               <option label="151～180分"></option>
               <option label="181分～"></option>
            </select>
            年代
            <select name="select4">
                <option label=""></option>
                <option label="～1960年代"></option>
                <option label="1970年代"></option>
                <option label="1980年代"></option>
                <option label="1990年代"></option>
                <option label="2000年代"></option>
                <option label="2010年代"></option>
                <option label="2020年代"></option>
             </select>
		</form>
<!-- フォロー一覧を表示する -->
	<h2>フォロー</h2>
	<div>
	<table id="follow_table">
  		<tbody>
		    <tr>
		      <th>アイコン</th><th>ユーザー名</th><th>プロフィール文</th>
		    </tr>
		    <c:forEach var="i" items="${cardList}" >
		    <tr>
			    <td>${i.number}</td>
			    <td>${i.name}</td>
			    <td>${i.company}</td>
		    </tr>
		    </c:forEach>
  		</tbody>
	</table>
	</div>
	フォロー解除
<!-- フォロワー一覧を表示する -->
	<h2>フォロワー</h2>
	<div>
	<table id="follower_table">
  		<tbody>
		    <tr>
		      <th>アイコン</th><th>ユーザー名</th><th>プロフィール文</th>
		    </tr>
		    <c:forEach var="i" items="${cardList}" >
		    <tr>
			    <td>${i.number}</td>
			    <td>${i.name}</td>
			    <td>${i.company}</td>
		    </tr>
		    </c:forEach>
  		</tbody>
	</table>
	</div>
	フォロー・フォロー解除
</body>
</html>