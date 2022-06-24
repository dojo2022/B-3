const btn=document.getElementById("btn");

// btn.addEventListener("click",window.location.href="./header.jsp");
function btn_click(){
  window.location.href="/FLIFRE/PostServlet";
}
btn.addEventListener("click",btn_click);

function regist() {
    const select1 = document.getElementById('register_form').select1.value;
    const text = document.getElementById('register_form').text.value;


	if (select1 === '' || text === '') {
		document.getElementById('error_message').textContent = '※必須項目を入力してください！';
        return false;
	}

	document.getElementById('error_message').textContent = '';
};



