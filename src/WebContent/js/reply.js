/**
 *
 */

let reviewdata_size = document.getElementById("reviewdata_size").textContent;
console.log(reviewdata_size);
let reply_submit=new Array();
let reply=new Array();
for (let i=0;i<reviewdata_size;i++){
	reply_submit[i]= document.getElementById("reply_submit"+i);
	reply[i]= document.getElementById("reply"+i);
	reply_submit[i].style.display="none";
	reply[i].addEventListener('click',function(){
	reply_submit[i].style.display="block";
	});

}
