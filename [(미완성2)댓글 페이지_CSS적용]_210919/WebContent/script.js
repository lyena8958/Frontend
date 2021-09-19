$.ajax({
	type : "GET",
	url : "ad.json",
	dataType : "json",
	success : function(data){
		var str = "";
		$.each(data, function(index, obj){
			str += "<li>";
			str += "<a href='" + obj.link + "'>";
			str += "<img alt='"+ obj.alt +"' ";
			str += "src='img/" + obj.img + "'>";
			str += "</a></li>";
			
			
		});
		$("#adAdd").append(str);
	},
	error : function(){
		alert('에러발생');
	}
});

function del(){
	result = confirm("삭제 하시겠습니까?");
	if(result == true){
		
	}
	
}

function signUpMove(){
	
	window.open('signUp.jsp','회원가입', 'width=500, height=700');
}

function edit(){
	document.querySelector(".Edit").innerHTML = "<input type='hidden' name='mnum' value='${msg.mnum}'>"
	document.querySelector(".Edit").innerHTML =	"<input type='hidden' name='userID' value='${userData.userID}'>"
	document.querySelector(".Edit").innerHTML =	"<input type='hidden' name='mcnt' value='${mcnt}'>"
	document.querySelector(".Edit").innerHTML =	"<input type='text' name='msg' value='${msg.msg}'>"
	document.querySelector(".Edit").innerHTML =	"<input type='submit' value='수정하기'>"
}