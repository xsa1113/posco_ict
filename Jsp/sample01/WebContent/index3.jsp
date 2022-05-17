<%@page import="sample01.YouClass"%>
<%@page import="sample01.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//response(=응답)

	//response.sendRedirect("http://www.naver.com");

	//response.sendRedirect("./index.jsp");
	//response.sendRedirect("./index2.jsp?name=성춘향&age=16&hobby=그림그리기");
	
	String hobby[] = {"음악감상", "그림그리기"};	
	Human human = new Human("성춘향", 16, hobby);

	//짐싸!
	//request.setAttribute("human", human);
	//session.setAttribute("human",human );
	request.getSession().setAttribute("human",human);
	
	//잘가
	pageContext.forward("index4.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



</body>
</html>