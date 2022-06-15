const btn=document.getElementById("btn");

// btn.addEventListener("click",window.location.href="./header.jsp");
function btn_click(){
  window.location.href="/FLIFRE/PostServlet";
}
btn.addEventListener("click",btn_click);