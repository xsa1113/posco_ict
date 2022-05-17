<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">JSP실습</h2>

<%! int size = 0; %>
<% size ++; %>


<table border = "1">
	<% for(int i=0; i<size; i++){ %>
	<tr>
		<%for(int j=0; j<size; j++) {%>
			<td><%=i %>x<%=j %> = <%=i*j %></td>
		<%} %>
	</tr>
	<% } %>

</table>
</body>
</html>