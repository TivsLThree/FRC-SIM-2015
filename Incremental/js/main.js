	var members = {
		programmers:0,
		electricians:0,
		mechanics:0,
		pr:0,
		mentors:0,
		total:15
};
	function add(){
		members.total = members.total +1;	
}
	function sub(){		
		members.total = members.total - 1;
}
	function addPro(){
		if(canAdd()){
			sub();
			members.programmers = members.programmers +1;
	}
}
	function subPro(){
		if(canSub(members.programmers)){
			add();
			members.programmers = members.programmers -1;
	}
}


	function addMech(){
		if(canAdd()){
			sub();
			members.mechanics = members.mechanics +1;
	}
}
	function subMech(){
		if(canSub(members.mechanics)){
			add();
			members.mechanics = members.mechanics -1;
	}
}
	function addPR(){
		if(canAdd()){
			sub();
			members.pr = members.pr +1;
	}
}
	function subPR(){
		if(canSub(members.pr)){
			add();
			members.pr = members.pr -1;
	}
}
	function addElec(){
		if(canAdd()){
			sub();
			members.electricians = members.electricians +1;
	}
}
	function subElec(){
		if(canSub(members.electricians)){
			add();
			members.electricians = members.electricians -1;
	}
}
function addMentor(){
		if(canAdd()){
			sub();
			members.mentors = members.mentors +1;
	}
}
	function subMentor(){
		if(canSub(members.mentors)){
			add();
			members.mentors = members.mentors -1;
	}
}







function send(){
	if(members.total == 0){	
		localStorage.setItem("proCount",members.programmers);
		localStorage.setItem("elecCount",members.electricians);
		localStorage.setItem("mechCount",members.mechanics);
		localStorage.setItem("prCount",members.pr);
		localStorage.setItem("mentorCount",members.mentors);
		window.location = "week1.html";
		}
	}



















function canSub( a){
	return members.total <15 && a!=0;
}
function canAdd(){
	return members.total >0;
}
function clearPro(){
	members.total = members.total + members.programmers;
	members.programmers = 0;
}
function clearMech(){
	members.total = members.total + members.mechanics;
	members.mechanics = 0;
}
function clearPR(){
	members.total = members.total + members.pr;
	members.pr = 0;
}
function clearElec(){
	members.total = members.total + members.electricians;
	members.electricians = 0;
}
function clearMentor(){
	members.total = members.total + members.mentors;
	members.mentors = 0;
}














window.setInterval(function(){

	document.getElementById("promembers").innerHTML = members.programmers;
	document.getElementById("mechmembers").innerHTML = members.mechanics;
	document.getElementById("prmembers").innerHTML = members.pr;
	document.getElementById("elecmembers").innerHTML = members.electricians;
	document.getElementById("mentormembers").innerHTML = members.mentors;
	if(members.total != 0){
			document.getElementById("send").innerHTML = members.total;
	}else{
		document.getElementById("send").innerHTML = "Ready";

	}	
},10);
