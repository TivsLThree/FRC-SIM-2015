var code = 0;
var mechparts = 0;
var elecparts = 0;
var grants = 0;
var control = 0;
var dayCount = 0;
var members ={
		programmers:parseInt(localStorage.getItem("proCount")),
		electricians:parseInt(localStorage.getItem("elecCount")),
		mechanics:parseInt(localStorage.getItem("mechCount")),
		pr:parseInt(localStorage.getItem("prCount")),
		mentors:parseInt(localStorage.getItem("mentorCount"))
}
var days=["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"];
var weekCount = 1;
window.setInterval(function(){
	if(dayCount < 5){	
	dayCount++;
	updateCount();
	updateDisplay();
	}else{
		dayCount = 6;
		updateDisplay();

	}
},5000);

function updateCount(){
	code = code + members.programmers;
	mechparts = mechparts + members.mechanics;
	elecparts = elecparts + members.electricians;
	grants = grants + members.pr;
	control = control + members.mentors;
}
function updateDisplay(){
	document.getElementById("code").innerHTML = code;
	document.getElementById("mechparts").innerHTML = mechparts;
	document.getElementById("elecparts").innerHTML = elecparts;
	document.getElementById("grants").innerHTML = grants;
	document.getElementById("control").innerHTML = control;
	document.getElementById("day").innerHTML = days[dayCount];
	var count = weekCount+1;
	if(dayCount == 6){
		document.getElementById("next").innerHTML = "Go to Week " +count;
	}else {
		document.getElementById("next").innerHTML = "Week: " +weekCount;
	}
}
function nextWeek(){
	if(dayCount == 6){
	dayCount = 0;
	weekCount++;
	updateDisplay();
	}
}