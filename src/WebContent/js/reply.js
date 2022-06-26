/**
 *
 */

let status_index = document.getElementById("status_index");
let reply_submit=new Array();
let reply=new Array();
for (let i=0;i<100;i++){
	reply_submit[i]= document.getElementById("reply_submit"+i);
	reply[i]= document.getElementById("reply"+i);
	reply_submit[i].style.display="none";
	reply[i].addEventListener('click',function(){
	reply_submit[i].style.display="block";
	});

}
