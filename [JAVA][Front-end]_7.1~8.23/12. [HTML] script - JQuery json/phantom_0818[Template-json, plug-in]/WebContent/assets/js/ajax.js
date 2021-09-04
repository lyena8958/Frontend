$.ajax({
	type:"GET",
	url:"data.json",
	dataType:"json",
	success:function(data){
		var str="";
		$.each(data,function(index,obj){
			str+="<div class='swiper-slide'><a href='#'><img src='images/";
			str+=obj.name;
			str+="_0.jpg' alt='";
			str+=obj.details;
			str+="'></a></div>";
		});
		$(".swiper-wrapper").append(str);
	},
	error:function(){
		alert("에러발생!");
	}
});