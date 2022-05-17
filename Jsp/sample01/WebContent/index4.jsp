<%@page import="sample01.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 짐찾기
	//Human human = (Human)request.getAttribute("human");

	//session으로 보냈을때 session으로 받아야즤
	Human human = (Human)session.getAttribute("human");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

name:<%= human.getName() %>
<br>
age:<%=human.getAge() %>
<br>

<% 
	for(String x : human.getHobby()){
%>

	hobby: <%=x %>

<%
	}
%>

</body>
</html>