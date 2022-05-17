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

<table align="center" border="1">
	<tr bgcolor="lightgrey">
		<td></td>
		<% 
			for(int i=0; i<10; i++){
		%>
		<td align="center" width="80"><%=i %></td>
		<%
			}
		%>
		<%
			for(int i=0; i<10; i++){
		%>
		<tr>
			<td align="center" bgcolor="lightgrey" widht="50"><%=i %></td>
			<%
				for(int j=0; j<10; j++){
			%>
			<td align="center"><%=j %> X <%=i %> = <%=j *i %> </td>
			<%
				}
			%>		
		</tr>
	<%
			}
	%>
	</tr>

</table>

</body>
</html>