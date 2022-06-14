/**
 *
 */
 /*タグのエレメントを代入*/
const review_tag = document.getElementById('review_tag');
const reply_tag = document.getElementById("reply_tag");
const stamp_tag = document.getElementById("stamp_tag");

/*リストのエレメントを代入*/
const review_list = document.getElementById("review_list");
const reply_list =document.getElementById("reply_list");
const stamp_list =document.getElementById("stamp_list");

/*初期化（全てのリストを表示しない）*/
review_list.style.display = 'none';
reply_list.style.display = 'none';
stamp_list.style.display = 'none';

/*各タグがクリックされた時の処理*/
review_tag.addEventListener('click', function() {
	review_list.style.display = 'block';
	reply_list.style.display = 'none';
	stamp_list.style.display = 'none';
});

reply_tag.addEventListener('click', function() {
	review_list.style.display = 'none';
	reply_list.style.display = 'block';
	stamp_list.style.display = 'none';
});
stamp_tag.addEventListener('click', function() {
	review_list.style.display = 'none';
	reply_list.style.display = 'none';
	stamp_list.style.display = 'block';
});