<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="common.css">
    <link rel="stylesheet" href="ranking.css">
    <title>ランキング | FLIFRE</title>
</head>

<body>
    <!---->
    <header>
        <a href="Top_bfServlet.java"><img id="logo" src="logo.png"></a>
        <!--検索とログイン（ほぼ全画面）-->
        <input type="text" name="text" placeholder="タイトル入力">
        <input type="submit" name="submit" value="検索">
        <input type="button" onclick="/LFIFRE/LoginServlet.java" value="ログイン">
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
                <option label=""></option>
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
                <option label="1960年代"></option>
                <option label="1970年代"></option>
                <option label="1980年代"></option>
                <option label="1990年代"></option>
                <option label="2000年代"></option>
                <option label="2010年代"></option>
                <option label="2020年代"></option>
            </select>
        </form>
        <!--検索とログイン（ほぼ全画面)終了-->
        <!--ハンバーガーメニュー-->
        <input type="checkbox" class="menu-btn" id="menu-btn">
		<label for="menu-btn" class="menu-icon"><span class="navicon"></span></label>
  		<ul class="menu">
		    <li><a href="/FLIFRE/Result_bfServlet">アニメ</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">国内</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">欧米</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">韓国</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">華流</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">アクション</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">コメディ</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">キッズ・ファミリー</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">ヒューマンドラマ</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">サスペンス</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">ラブロマンス</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">ホラー</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">ファンタジー</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">SF</a></li>
		    <li><a href="/FLIFRE/Result_bfServlet">バラエティ</a></li>
		    <li><a href="/FLIFRE/Ranking_bfServlet">レビューランキング</a></li>
  		</ul>
        <!--ハンバーガーメニュー終了-->
    </header>
    <main>
        <div class="ranking-box">
        <h1 class="ranking">項目別ランキング</h1>
        <div class="ranklist">
            <p class="ranking">通算</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">月間</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">アニメ</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">国内</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">欧米</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">韓国</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">華流</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">アクション</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">コメディ</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">キッズ・ファミリー</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">ヒューマンドラマ</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">サスペンス</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">ラブロマンス</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">ホラー</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">ファンタジー</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">SF</p>
            <ul class="list">
                <li><img class="rank" src="Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="Silver.png">あぶりとろ</li>
                <li><img class="rank" src="Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        <div class="ranklist">
            <p class="ranking">バラエティー</p>
            <ul class="list">
                <li><img class="rank" src="images/Gold.png">あぶりえんがわ</li>
                <li><img class="rank" src="images/Silver.png">あぶりとろ</li>
                <li><img class="rank" src="images/Bronze.png">あぶりカルビ</li>
            </ul>
        </div>
        </div>
    </main>
    <footer>

    </footer>
</body>

</html>