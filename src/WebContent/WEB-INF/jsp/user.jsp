<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js"></script>
</head>
<body>
<a href="/FLIFRE/Top_afServlet"><img src="images/logo.png" width="649" height="119" alt="FLIFRE"></a>
<input type="text" name="text" placeholder="タイトル入力">
<input type="submit" name="submit" value="検索">
<input type="button" onclick="/FLIFRE/LoginServlet" value="ログアウト">
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
	<form name="sample">
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
<!-- ルーレット -->

<div>
	<form id = follow_Lift method="POST" action="/FLIFRE/MypageServlet">
		<input type="button" name="FOLLOW" value="フォロー">
		<input type="button" name="FOLLOW" value="フォロー中">
	</form>
	<table>
		<tr>
			<td>
			<img src ="/FLIFRE/WecContent/images/pf_hd.png">
			</td><!-- m_userのuser_hd ヘッダーを引用、backgroundにしたい -->
		</tr>
		<tr>
			<td>
			<img src ="/FLIFRE/WecContent/images/pf_img.png">
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

	<a href="/FLIFRE/Servlet">レビュー投稿</a>
			<!-- t_reviewのvideo_id, user_id, review_contents, genre_id,
			feelcat_name1, feelcat_name2, star, reply_id, stamp_id, review_dateを引用 -->
	<!-- スタンプ -->
	<!-- リプライ -->
</body>
</html>