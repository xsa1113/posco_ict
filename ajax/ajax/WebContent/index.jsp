<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >


<p id="demo"></p>

<button type="button">button</button>

<script type="text/javascript">
$(document).ready(function(){
	$("button").click(function(){
		//load를 많이 사용하면 프로그램 자체가 무거워지고 많이 사용하지 않고 있다.
		//$("#demo").load("default.html");
		
		//default.html 폴더안에 ptag를 가져온다.
		//$("#demo").load("default.html #ptag");
		
		// 데이터를 파라미터로 보내서 가져올거다		
		//$("#demo").load("data.jsp","name=John&age=24");
		
		//$("#demo").load("data.jsp", {name: "Tom", age:26});
		
		$("#demo").load(
			"data.jsp", // 불러올 파일 
			{ "name":"춘향이", "age":16}, //불러올 부분에 셋팅값
			// 갔다가 온다음 
			function(data, status, xhr){ //작업의 결과
				//alert("success");
				//alert(data);
				//alert(status);
				alert(JSON.stringify(xhr));
			}
		);
		
	});
});

</script>

</body>
</html>