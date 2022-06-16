<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ | FLIFRE</title>
<link rel="stylesheet" href="/FLIFRE/css/common.css">
<link rel="stylesheet" href="/FLIFRE/css/profile.css">
<script src="/FLIFRE/js/profile.js " defer></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<!-- メインここから -->
	<main>

		<!-- マイプロフィールボックスここから -->
		<div class="myprofile">
			<!-- <img id="pf_icon" src="./images/pf_img.png"> -->
			<img id="pf_icon">
			<input class="circle" type="image" name="icon" value="" readonly>
			<!-- m_userのuser_img アイコンを引用予定 -->

			<!-- <span id="username">炙りえんがわ </span> -->
			<span id="username">
			<input class="user"type="text" name="userName" value="" readonly>
			</span>
			<!-- m_userのuser_nameを引用予定 -->

			<a id="pf_edit" href="/FLIFRE/ProfileServlet">
			<img id="pf_edit"src="./images/pf_edit.png"></a>
			<br>
			<br>

			<!-- <span id="pf">アニメと洋画が好きです。</span> -->
			<span id="pf">
			<input class="profile" type="text" name="profileString" value="" readonly>
			</span>
			<!-- m_userのuser_pfを引用予定 -->
			<br>
			<br>

			<!-- <span id="follow">フォロー</span> -->
			<!-- m_userのfollow_idを引用予定 -->
			<span id="follower">フォロワー</span>
			<!-- m_userのfollow_idを引用予定 -->
			<!-- <c:forEach var="e" items="${cardList}" >
		<tr>
			<td>${e.follow_id}</td>
			<td>${e.user_id}</td>
		</tr>
	</c:forEach> フォローフォロワー一覧ページの形式に合わせる -->
		</div>
		<!-- マイプロフィールボックスここまで -->
		<br>
		<hr>
		<br>

		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここから -->
		<!-- <c:forEach var="" items="" > -->
		<form id="mylist_edit" method="POST" action="/FLIFRE/MypageServlet">
			<table>
				<tr>
					<td><span id="review_tag"> レビュー投稿 </span>
					<span id="reply_tag"> リプライ </span>
					<span id="stamp_tag">スタンプを送ったレビュー </span></td>
				</tr>
				<tr>
					<td>
						<div id="review_list">
							<hr>
							<img id="pf_icon" src="./images/pf_img.png">
							<!-- <input class="circle" type="" name="" value="" readonly> -->
							<!-- m_userのuser_img アイコンを引用予定 -->

							<span id="username">炙りえんがわ </span>
							<!-- <input class="user"type="" name="" value="" readonly> -->
							<!-- t_reviewのuser_idを引用 -->
							<br> <br> <span id="review_video">アイアンマン</span>
							<!-- <input class="video"type="" name="" value="" readonly> -->
							<!-- t_reviewのvideo_idを引用 -->

							<span id="review_star"> ★★★★★ </span>
							<!-- <input class="star"type="" name="" value="" readonly> -->
							<!-- t_reviewのstarを引用、形式は画像なのか数値なのか未定 -->

							<span id="review_time">2022年6月14日 20時30分</span>
							<!-- <input class="time"type="" name="" value="" readonly> -->
							<!-- t_reviewのreview_dateを引用、細かい時間まで必要か要検討 -->
							<br> <span id="review_genre"> ジャンル：アクション </span>
							<!-- <input class="genre"type="" name="" value="" readonly> -->
							<!-- t_reviewのgenre_idを引用 -->

							<span id="review_feelcat1"> 感想カテゴリ1：スカッとする </span>
							<!-- <input class="feelcat1"type="" name="" value="" readonly> -->
							<!-- t_reviewのfeelcat_name1を引用 -->

							<span id="review_feelcat2"> 感想カテゴリ2：わくわく </span>
							<!-- <input class="feelcat2"type="" name="" value="" readonly> -->
							<!-- t_reviewのfeelcat_name2を引用 -->

							<p id="review">面白すぎる。他のアベンジャーズ作品も見てみようと思った。</p>
							<!-- <input class="review"type="" name="" value="" readonly> -->
							<!-- t_reviewのreview_contentsを引用 -->
							<input type="submit" name="REVIEWDELETET" value="削除">
							 <input type="submit" name="REVIEWEDIT" value="編集"> <br> <br>
						</div>

						<div id="reply_list">
							<hr>
							<img id="pf_icon" src="./images/pf_img.png">
							<!-- <input class="circle" type="" name="" value="" readonly> -->
							<!-- m_userのuser_img アイコンを引用予定 -->

							<span id="reply_username">To うに軍艦</span>
							<!-- <input class="user"type="" name="" value="" readonly> -->
							<!-- t_replyのreview_id, user_idを引用 -->
							<br> <br> <span id="reply_time">2022年6月14日21時30分</span>
							<!-- <input class="time"type="" name="" value="" readonly> -->
							<!-- t_replyのreply_dateを引用、細かい時間まで必要か要検討 -->
							<br>

							<p id="reply_sentence">リプライありがとうございます！同じ作品が好きな方に出会えて嬉しいです。</p>
							<!-- <input class="reply"type="" name="" value="" readonly> -->
							<!-- t_replyのreply_contentsを引用 -->
							<input type="submit" name="REPLYDELETET" value="削除"> <input
								type="submit" name="REPLYWEDIT" value="編集"> <br> <br>
						</div>

						<div id="stamp_list">
							<hr>
							<img id="pf_icon" src="./images/pf_img.png">
							<!-- <input class="circle" type="" name="" value="" readonly> -->
							<!-- m_userのuser_img アイコンを引用予定 -->

							<span id="username">うに軍艦 </span>
							<!-- <input class="user"type="" name="" value="" readonly> -->
							<!-- t_reviewのuser_idを引用 -->
							<br> <br> <span id="review_video">アイアンマン</span>
							<!-- <input class="video"type="" name="" value="" readonly> -->
							<!-- t_reviewのvideo_idを引用 -->

							<span id="review_star"> ★★★★★ </span>
							<!-- <input class="star"type="" name="" value="" readonly> -->
							<!-- t_reviewのstarを引用、形式は画像なのか数値なのか未定 -->

							<span id="review_time">2022年6月12日 16時00分</span>
							<!-- <input class="time"type="" name="" value="" readonly> -->
							<!-- t_reviewのreview_dateを引用、細かい時間まで必要か要検討 -->
							<br> <span id="review_genre"> ジャンル：アクション </span>
							<!-- <input class="genre"type="" name="" value="" readonly> -->
							<!-- t_reviewのgenre_idを引用 -->

							<span id="review_feelcat1"> 感想カテゴリ１：スカッとする </span>
							<!-- <input class="feelcat1"type="" name="" value="" readonly> -->
							<!-- t_reviewのfeelcat_name1を引用 -->

							<span id="review_feelcat2"> 感想カテゴリ２：非日常的 </span>
							<!-- <input class="feelcat2"type="" name="" value="" readonly> -->
							<!-- t_reviewのfeelcat_name2を引用 -->

							<p id="review">始まりにして頂点。全てが最高。
							うわあああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ</p>
							<!-- <input class="review"type="" name="" value="" readonly> -->
							<!-- t_reviewのreview_contentsを引用 -->
							<img id="image_file" src="images/nikochan5.png" onclick="henkou()" width="50"
								height="50">
							<!-- スタンプの画像をクリックすると画像が変化 -->
							<br>
								<!-- <input class="review" readonly> -->
								<!-- リプライフォームここから -->
									<label class="open"	for="popup"><img id="reply" src="images/reply.png"
									onclick="replyfrom()" width="50" height="50">
									</label>
								<input type="checkbox" id="popup">
								<div class="overlay">
									<div class="window" id=>
										<label class="close" for="popup">× </label>
										<div class="example">
											<label for="namelabel">ユーザー名</label>
											<br>
											<input type="text"
												name="name" id="namelabel" placeholder="">
												<br>
										</div>
										<div class="example">
											<label for="ikenlabel">リプライ内容</label>
											<br>
											<textarea id="iken"></textarea>
											<br>
										</div>
										<div class="example">
											<input type="submit" value="送信する">
											<!-- リプライボタンをクリックするとリプライ入力フォームが開く。
						  					入力後、送信ボタンを押す。 -->
										</div>
									</div>
								</div>
								<!-- リプライフォームここまで -->
							</div>
						</td>
				</tr>
			</table>
		</form>
		<!-- </c:forEach> -->
		<!-- マイレビュー投稿・リプライ・スタンプを送ったレビュー一覧ここまで -->
</main>
<!-- メインここまで -->
<br>
<br>
</body>
</html>

<!--マイページ class, id一覧

div class="myprofile" ：マイプロフィールボックス
img id="pf_icon" ：プロフィールのアイコン画像
span id="username" ：ユーザー名全般
a, img id="pf_edit" ：マイプロフィール編集ボタン
span id="pf" ：プロフィール文
span id="follow" ：フォロー数
span id="follower" ：フォロワー数

form id = "mylist_edit" ：マイレビュー投稿・リプライ・スタンプ履歴一覧フォーム(テーブル)

span  id="review_tag" ：レビュー投稿見出し
span  id= "reply_tag" ：リプライ見出し
id= "stamp_tag" ：スタンプを送ったレビュー見出し
div id= "review_list" ：レビュー投稿一覧
span id="review_video" ：レビュー作品名
span id="review_star" ：レビュー五段階評価
span id="review_time" ：レビュー日付
span id="review_genre" ：レビュージャンル
span id="review_feelcat1" ：レビュー感想カテゴリ1
span id="review_feelcat2" ：レビュー感想カテゴリ2
p id="review" ：レビュー本文

div id= "reply_list" ：リプライ一覧
span id="reply_username" ：リプライ先のユーザー名
span id="reply_time" ：リプライ日付
p id="reply_sentence" ：リプライ本文

div id= "stamp_list" ：スタンプを送ったレビュー一覧
 -->