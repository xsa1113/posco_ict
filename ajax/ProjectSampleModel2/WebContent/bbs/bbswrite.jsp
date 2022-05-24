<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
%>
    
    
<%

Object obj = session.getAttribute("login");
if(obj == null){
	%>
	<script>
	alert("로그인해주십시오");
	location.href = "login.jsp";
	</script>

	<%
}

MemberDto mem = (MemberDto)obj;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h2>글작성</h2>
<div align="center">
<form action="../bbs" method="post">
		<input type="hidden" name="param" value="bbswriteAf">
		<input type="hidden" name="id" value="<%=mem.getId() %>"> 

	<table border = "1">
	
		<col width="200"><col width="400">
		
		<tr>
			<th>아이디</th>
			<td><%=mem.getId()%></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="60"></td>
		</tr>
		
		<tr>
			<th>내용</th><td><textarea rows="20" cols="50" name="content"></textarea></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성완료">
			</td>
		
		</tr>
		
	</table>

</form>

</div>


<!-- 

<div align="center">
<table border ="1">
<col width = "70"><col width="600">


<tr>
	<td>작성자</td><td id="writer">asd</td>
</tr>

<tr>
	<td>제목</td><td><input type="text" id="title" size="20"></td>
</tr>
<tr>
	<td>내용</td><td><textarea id="content"></textarea></td>
</tr>


</table>
<input type="button" id="writercom" value="글작성완료">
</div>

 -->
<!-- 
<script type="text/javascript">
$(document).ready(function(){
	$("#writercom").click(function(){
		$.ajax({
			url: "../bbs?param=bbswriteAf",
			type:"post",
			data:{"writer" : $("#writer").text(),
				 "title" : $("#title").val(), 
				 "content" : $("#content").val()},
				
				
				success:function(str){
					alert("글작성이 완료되었습니다");
				},
				error:function(){
					alert("error");
				}
			
		});
	});
	
	
});

</script> -->


</body>
</html>