<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<p id="demo"></p>
<br>
<button type="button">클릭</button>

<script type="text/javascript">
$(document).ready(function(){
	
	$("button").click(function(){
		
		$.ajax({
			url:"./hello",
			type:"get",
		//	data:"id=abc&pw=123",
			data:{id:"abc", pw: "123"},
			success:function(data){
				//alert('success');
				//alert(data);
				//alert(JSON.stringify(data)); // 어떤 데이터가 들었는지 확인 json.stringify로
				//$("#demo").text(data.str);

				alert(JSON.stringify(data));
				
					//다수의 데이터를 넘겼을 때 map으로 받아올때
				//$("#demo").text(data.mydatas.title + "  " + data.mydatas.content);
				
				$("#demo").text(data.list[0].number + " " + data.list[0].name);				
				
			},
			error:function(){
				
			}
			
			
		})
	});
});

</script>

</body>
</html>