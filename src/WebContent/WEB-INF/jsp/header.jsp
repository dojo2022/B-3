<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<header>
<script src="js/roulette.js" defer></script>
<form method="POST" action="/FLIFRE/ResultServlet">
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
						"衝撃的", "ミステリアス", "ダーク", "怖い", "グロテスク",
					}
				);
			%>
	    <div class="search1">
	    	<table>
		    	<tr>
		    		<th>
			    		再生時間
			    	</th>
			    	<td>
				        <select name="time">
				            <option label="選択してください" value="-1"></option>
				            <option label="～30分" value="30"></option>
				            <core:forEach var="i" begin="30" end="150" step="30">
				            	<option label="${ i + 1 }～${ i + 30 }分" value="${ i + 30 }"></option>
				            </core:forEach>
				            <option label="181分～" value="1440"></option>
				        </select>
			        </td>
              </tr>
              <tr>
			        <th>
			        	年代
			        </th>
			        <td>
				        <select name="year">
				            <option label="選択してください" value="-1"></option>
				            <option label="～1960年代" value="1970"></option>
				            <core:forEach var="year" begin="1970" end="2020" step="10">
				            	<option label="${ year }年代" value="${ year + 10 }"></option>
				            </core:forEach>
				        </select>
			        </td>
				</tr>
				<tr>
					<th>
				        感想カテゴリ
				    </th>
				    <td>
				        <select name="feelcat">
				        	<option value="">選択してください</option>
				            <core:forEach items="${ categories }" varStatus="status">
				      			<option value="${ status.current }">${ status.current }</option>
				            </core:forEach>
				        </select>
			        </td>
		    	</tr>
		    	<tr>
		    		<th>
				         作品名
				    </th>
				    <td colspan="2">
				    	<input type="text" name="title" placeholder="タイトル入力">
				    	<input type="submit" name="submit" value="検索">
				    </td>
				    <td>
				    </td>
				</tr>
		    </table>
		</div>

		<div class="search2">
			<p class="roulette">
				<button type="button" onclick="roulette()">
					<img src="images/roulette.png" name="ROULETTE" alt="ルーレット">
				</button>
			</p>
		</div>


	    <div id="log" class="${ empty id ? 'login' : 'logout' }">
	        <a href="/FLIFRE/${ empty id ? 'Login' : 'Logout' }Servlet">
	            <img src="images/${ empty id ? 'login' : 'logout' }.png"
	                 width="97" height="29"
	                 alt="${ empty id ? 'ログイン' : 'ログアウト' }">
	        </a>
	    </div>

	    <!--ここからメニュー-->
	    <div class="hamburger-menu">
	        <input type="checkbox" id="menu-btn-check">
	        <label for="menu-btn-check" class="menu-btn"><span></span></label>
	        <div class="menu-content">
	            <ul>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000001">アニメ</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000002">国内</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000003">欧米</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000004">韓国</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000005">華流</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000006">アクション</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000007">コメディ</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000008">キッズ・ファミリー</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000009">ヒューマンドラマ</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000010">サスペンス</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000011">ラブロマンス</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000012">ホラー</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000013">ファンタジー</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000014">SF</a></li>
	                <li><a href="/FLIFRE/ResultServlet?genre_id=g000000015">バラエティ</a></li>
	                <li><a href="/FLIFRE/Ranking_bfServlet">レビューランキング</a></li>
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
<script>
	let logout = document.getElementById('log');
	if (logout.classList.contains('logout')) {
		logout.addEventListener('click', (e) => {
			if (!window.confirm('ログアウトしますか？')) {
				e.preventDefault();
			}
		});
	}
</script>
</header>
