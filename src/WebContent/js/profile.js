/**
 *
 */
 /**/
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




/*にこちゃんスタンプクリックで変化ループ*/
      var img_src = new Array("images/nikochan5.png","images/nikochan6.png");
      var i = 0;

      function henkou() {

        if (i == 1) {
          i = 0;
        } else {
          i ++;
        }
        document.getElementById("image_file").src = img_src[i];
      }

/*画像変更フォーム*/
(function(){
    'use strict';

    var imageflame = document.getElementById('imageframe');
    var imageinput = document.querySelector('#imageframe input[name="imgfile"]');
    imageinput.style.display = "none";

    // 画像をドラッグしたとき、それを読み込みつつ表示

        // ファイルがドロップされたとき、そのファイルのアップロード処理を実行しつつ、クラス削除
        imageflame.addEventListener('drop', function(event){
            event.preventDefault();

            // クラス削除
            imageflame.classList.remove('dropover');

            // ドロップファイルを変数に格納
            var files = event.dataTransfer.files;
            // ファイルそのものをinputに格納
            imageinput.files = files;

            // 読み込んだ画像を表示
            for(var i = 0; i<files.length; i++){
                var file = files[i];

                var reader = new FileReader();
                reader.onload = function(elem) {
                    // 引数のelemはドラッグ中のファイルではなく、読み込みされた時点でのファイル。
                    imageflame.style.cssText = "background-image: url(" + elem.target.result + ");";
                };
                reader.readAsDataURL(file);

            }

        });

        // ドラッグ中のファイルがimageflameの上に来ていたらクラス追加しつつ、ドロップの許可を出す
        imageflame.addEventListener('dragover', function(event){
            event.preventDefault();
            imageflame.classList.add('dropover');

            // ドラッグ中のファイルの属性を変更し、ドロップ可能にする
            event.dataTransfer.dropEffect = 'copy';
        });

        // ドラッグ中のファイルがimageflameの上から離れたらクラス削除
        imageflame.addEventListener('dragleave', function(){
            imageflame.classList.remove('dropover');
        });

    // クリックしたときに「ファイルを選択」を起動
    imageflame.addEventListener('click', function(){
        imageinput.click();
    });

    // 画像が挿入されたとき、その画像を表示する
    imageinput.addEventListener('change', function(event){

        var reader = new FileReader();
        reader.onload = function(event){
            imageflame.style.cssText = "background-image: url(" + event.target.result + ");";
            console.log(event.target.result);
        }
        reader.readAsDataURL(event.target.files[0]);
    });


})();