<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String proc = request.getParameter("proc");

if(proc.equals("regi")){
	String msg = request.getParameter("msg");
	
	if(msg.equals("OK")){
	%>
		<script type="text/javascript">
		alert("성공적으로 가입되었습니다");
		location.href = "member?param=login";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		alert("다시 기입해 주십시오");
		location.href = "member?param=createAf";
		</script>
		<%
	}
}else if(proc.equals("login")){
	String msg = request.getParameter("msg");
	if(msg.equals("OK")){
		%>
			<script type="text/javascript">
			alert("환영합니다");
			location.href = "bbs?param=bbslist";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
			alert("아이디나 비밀번호가 틀렸습니다. 다시 기입해 주십시오");
			location.href = "member?param=login";
			</script>
			<%
		}
}

%>



</body>
</html>