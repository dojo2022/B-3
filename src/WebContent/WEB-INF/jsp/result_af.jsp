<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html lang="ja-jp">

<head>
    <meta charset="UTF-8">
    <title> 検索結果 | FLIFRE </title>
    <link rel="stylesheet" href="css/common.css">
    <!-- <script defer src="js/common.js"></script> -->
    <link rel="stylesheet" href="css/result.css">
    <script defer src="js/result.js"></script>
</head>

<!-- dummy -->
<core:set var="id">login_user</core:set>

<body>
    <div class="wrapper">
        <!-- header start -->
        <header>
            <p class="log">
                <core:choose>
                    <core:when test="${empty id}">
                        <a href="/FLIFRE/LoginServlet"><img src="images/login.png"  width="97" height="29" alt="ログイン"></a>
                    </core:when>
                    <core:otherwise>
                        <a href="/FLIFRE/LogoutServlet"><img src="images/logout.png" width="120" height="29" alt="ログアウト"></a>
                    </core:otherwise>
                </core:choose>
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
                        <core:if test="${not empty id}">
                            <li><a href=" /FLIFRE/MypageServlet">マイページ</a></li>
                            <!--ログアウト状態のページではカット-->
                        </core:if>
                    </ul>
                    <!--ここまでメニュー-->
                </div>
            </div>
        </header>
        <form method="POST" action="/FLIFRE/SearchServlet">
            <h1 id="logo">
                <a href="/FLIFRE/Top_af.Servlet"><img src="images/logo.png" width="480" height="281" alt="FLIFRE"></a>
            </h1>
            <div class="search">
                作品名
                <input type="text" name="text" placeholder="タイトル入力">
                <br>
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
                <br>
                <input type="submit" name="submit" value="検索">
            </div>
            <input type="image" src="images/roulette" name="ROULETTE" value="ルーレット">
        </form>

        <!-- 検索結果　一覧 start-->
        <main>
            <div id="search-result-container">
                <core:forEach var="i" begin="1" end="9" step="1">
                <div class="search-result-item">
                    <div class="video-image">
                    </div>
                    <table class="video-info">
                        <tr>
                            <th>作品名：</th>
                            <td>スターウォーズ - シーズン${i} -</td>
                        </tr>
                        <tr>
                            <th>年代：</th>
                            <td>2000</td>
                        </tr>
                    </table>
                    <div class="buttons">
                        <button type="button" title="write-review" onclick="navigateTo('write-review', 'video_id')" ${empty id? 'disabled' : ''}>
                            レビューを<br>
                            書く
                        </button>
                        <button type="button" title="read-review" onclick="navigateTo('read-review', 'video_id')">
                            レビューを<br>
                            見る
                        </button>
                    </div>
                </div>
                </core:forEach>
            </div>
        </main>
        <!-- 検索結果　一覧 end-->

        <!-- footer start -->
        <footer>

        </footer>
        <!-- footer end -->
    </div>
</body>

</html>