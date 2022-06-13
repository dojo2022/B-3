<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js"></script>
</head>
<body>
<header>
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
            <li><a href="/FLIFRE/MypageServlet">マイページ</a></li>　　　　　　<!--ログアウト状態のページではカット-->
          </ul>
          <!--ここまでメニュー-->
      </div>
  </header>
  <form method="POST" action="/FLIFRE/SearchServlet">
		<a href="/FLIFRE/Top_afServlet"><img src="images/logo.png" width="480" height="281" alt="FLIFRE"></a>
	<input type="text" name="text" placeholder="タイトル入力">
        <input type="submit" name="submit" value="検索">
        <a href="/FLIFRE/LogoutServlet"><img src="images/logout.png"  width="120" height="29" alt="ログアウト"></a>
  　  <!--ログアウト状態のページではこっち　<a href="/FLIFRE/LoginServlet"><img src="images/login.png"  width="120" height="29" alt="ログイン"></a>　-->
            感想カテゴリ１
            <select name="select1" onchange="change(this)">
               <option>選択してください</option>
               <option value="1番目">爆笑コメディ</option>
               <option value="2番目">ポジティブ</option>
               <option value="3番目">癒される</option>
               <option value="4番目">スカッとする</option>
               <option value="5番目">優雅</option>
               <option value="6番目">非日常的</option>
               <option value="7番目">わくわく</option>
               <option value="8番目">ときめく</option>
               <option value="9番目">勉強になる</option>
               <option value="10番目">泣ける</option>
               <option value="11番目">儚い</option>
               <option value="12番目">衝撃的</option>
               <option value="13番目">ミステリアス</option>
               <option value="14番目">ダークな</option>
               <option value="15番目">怖い</option>
               <option value="16番目">グロテスク</option>
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
          <input type="image" src="./images/roulette" name="ROULETTE" value="ルーレット">

<div>
<a href="/FLIFRE/ProfileServlet"><img src ="./images/pf_edit.png"></a>
	<table>
		<tr>
			<td>
			<img src ="./images/pf_hd.png">
			</td><!-- m_userのuser_hd ヘッダーを引用、backgroundにしたい -->
		</tr>
		<tr>
			<td>
			<img src ="./images/pf_img.png">
			</td><!-- m_userのuser_img アイコンを引用 -->
		</tr>
		<tr>
			<td>
			ユーザー名
			</td><!-- m_userのuser_nameを引用予定 -->
		</tr>
		<tr>
			<td>
			プロフィール文
			</td><!-- m_userのuser_pfを引用予定 -->
		</tr>
	</table>
		<p>フォロー数</p><!-- m_userのfollow_idを引用予定 -->
		<p>フォロワー数</p><!-- m_userのfollow_idを引用予定 -->
</div>


<!-- <c:forEach var="" items="" > -->
<form id = myreview_edit method="POST" action="/FLIFRE/MypageServlet">
	<table>
		<tr>
			<td>
			<span>レビュー投稿</span>
			</td>
			<td>
			<span>リプライ</span>
			</td>
			<td>
			<span>スタンプを送ったレビュー</span>
			</td>
		</tr>
		<tr>
		<td id= "review_list"><table><p>レビュー投稿一覧</p>
				<input type="submit" name="REVIEWDELETET" value="削除">
				<input type="submit" name="REVIEWEDIT" value="編集">
		</table></td>
		<td id= "reply_list"><table><p>リプライ一覧</p>
				<input type="submit" name="REPLYDELETET" value="削除">
				<input type="submit" name="REPLYWEDIT" value="編集">
		</table></td>
		<td id= "stamp_list"><table><p>スタンプを送ったレビュー一覧</p>
				<input type="submit" name="STAMPDELETET" value="削除">
				<input type="submit" name="STAMPEDIT" value="編集">
		</table></td>
		</tr>
	</table>
</form>
<!-- </c:forEach> -->


</body>
</html>