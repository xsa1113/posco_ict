<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  html 주석문 -->
<%-- JSP주석문 --%>

<h3>hello jsp</h3>


<%
 //java 영역
 // scriptlet = script + applet 
 System.out.println("hello JSP");

%>

<%
String str = "hello jsp";

%>

<p>str:<%=str %></p>

<input type="text" size="20" value="<%= str %>">

<br>

<%
	// java -> form()
	out.println("<h3>str : " + str + "</h3>");
%>

<%
for(int i=0; i<5; i++){
%>
<p>p tag<%=i %></p>

<%
	}
%>

<script type="text/javascript">
//java코드에서 넘겨받은 값
let s = "<%=str %>";

console.log(s);

</script>

</body>




</html>