/**
 *
 */

function roulette() {
	let random = Math.floor(Math.random() * 15) + 1;
	let id = 'g' + String(random).padStart(9, '0');
	location.href = '/FLIFRE/ResultServlet?genre_id=' + id;
}
