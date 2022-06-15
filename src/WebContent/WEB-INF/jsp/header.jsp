<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<header>
<form method="POST" action="/FLIFRE/SearchServlet">
	<div class="search">

			<h1 id="logo">
		    	<a href="/FLIFRE/Top_afServlet"><img src="images/logo.png" width="240" height="140" alt="FLIFRE"></a>
		    </h1>

		     <%
	    pageContext.setAttribute(
	        "categories",
	        new String[] {
	            "爆笑コメディ", "ポジティブ", "癒される", "スカッとする", "優雅",
	            "非日常的", "わくわく", "ときめく", "勉強になる", "泣ける", "儚い",
	            "衝撃的", "ミステリアス", "ダークな", "怖い", "グロテスク",
	        }
	    );
	    %>
	    <div class="search1">
	    		 再生時間
		        <select name="select3">
		            <option label=""></option>
		            <option label="～30分"></option>
		            <core:forEach var="i" begin="30" end="150" step="30">
		            	<option label="${ i + 1 }～${ i + 30 }分"></option>
		            </core:forEach>
		            <option label="181分～"></option>
		        </select>
		        年代
		        <select name="select4">
		            <option label=""></option>
		            <option label="～1960年代"></option>
		            <core:forEach var="year" begin="1970" end="2020" step="10">
		            	<option label="${ year }年代"></option>
		            </core:forEach>
		        </select>
		        <br>
		        感想カテゴリ１
		        <select name="select1" onchange="change(this)">
		        	<option>選択してください</option>
		            <core:forEach items="${ categories }" varStatus="status">
		            	<option value="${ status.count }番目">${ status.current }</option>
		            </core:forEach>
		        </select>
		        感想カテゴリ２
		        <select name="select2">
		            <option>選択してください</option>
		            <core:forEach var="cat" items="${ categories }">
		            	<option label="${ cat }"></option>
		            </core:forEach>
		        </select>
		        <br>
		         作品名
		    	<input type="text" name="title" placeholder="タイトル入力">
		    	<input type="submit" name="submit" value="検索">
		</div>

		<div class="search2">
			<p class="roulette">
				<input type="image" src="images/roulette.png" name="ROULETTE" value="ルーレット">
			</p>
		</div>


	    <p class="log">
	        <a href="/FLIFRE/${ empty id ? 'Login' : 'Logout' }Servlet">
	            <img src="images/${ empty id ? 'login' : 'logout' }.png"
	                 width="97" height="29"
	                 alt="${ empty id ? 'ログイン' : 'ログアウト' }">
	        </a>
	    </p>

    <%
    pageContext.setAttribute(
        "categories",
        new String[] {
            "爆笑コメディ", "ポジティブ", "癒される", "スカッとする", "優雅",
            "非日常的", "わくわく", "ときめく", "勉強になる", "泣ける", "儚い",
            "衝撃的", "ミステリアス", "ダークな", "怖い", "グロテスク",
        }
    );
    %>

    <form method="POST" action="/FLIFRE/SearchServlet">
        <h1 id="logo">
            <a href="/FLIFRE/Top_afServlet"><img src="images/logo.png" width="240" height="140" alt="FLIFRE"></a>
        </h1>
        <div class="search">
            作品名
            <input type="text" name="title" placeholder="タイトル入力">
            <br>
            感想カテゴリ１
            <select name="select1" onchange="change(this)">
                <option>選択してください</option>
                <core:forEach items="${ categories }" varStatus="status">
                    <option value="${ status.count }番目">${ status.current }</option>
                </core:forEach>
            </select>
            感想カテゴリ２
            <select name="select2">
                <option>選択してください</option>
                <core:forEach var="cat" items="${ categories }">
                    <option label="${ cat }"></option>
                </core:forEach>
            </select>
            <br>
            再生時間
            <select name="select3">
                <option label=""></option>
                <option label="～30分"></option>
                <core:forEach var="i" begin="30" end="150" step="30">
                    <option label="${ i + 1 }～${ i + 30 }分"></option>
                </core:forEach>
                <option label="181分～"></option>
            </select>
            年代
            <select name="select4">
                <option label=""></option>
                <option label="～1960年代"></option>
                <core:forEach var="year" begin="1970" end="2020" step="10">
                    <option label="${ year }年代"></option>
                </core:forEach>
            </select>
            <br>
            <input type="submit" name="submit" value="検索">
        </div>
    </form>
    <p class="roulette">
    	<input type="image" src="images/roulette.png" name="ROULETTE" value="ルーレット">
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
</form>

</header>
