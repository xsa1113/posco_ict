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
	String name = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String[] hobby = request.getParameterValues("hobby");
	String age = request.getParameter("age");
	String talk = request.getParameter("talk");

%>

	<h3>전송된 정보</h3>

	<p>아이디 : <%=name %></p>
	<p>패스워드 : <%=pwd %></p>
	
	<% for (int i=0; i<hobby.length; i++){ %>
		<p> 취미 : <%= hobby[i] %> </p>
	<%} %>
	
	<p>나이 : <%=age %> </p>
	
	<p>하고싶은말 : <%=talk %></p>
	<p></p>
	

</body>
</html>