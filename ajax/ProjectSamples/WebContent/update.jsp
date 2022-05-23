<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
request.setCharacterEncoding("utf-8");
// detail에서 내용과 제목을 받아온다

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


<%
BbsDao dao = BbsDao.getInstance();
int seq = Integer.parseInt(request.getParameter("seq"));
BbsDto dto = dao.selectWriter(seq);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h2>수정페이지</h2>



<div align="center">
<form action="updateAf.jsp" method="post">
		<input type="hidden" name="seq" value="<%=seq %>">
		<input type="hidden" name="id" value="<%=mem.getId() %>"> 
		
	<table border = "1">
	
		<col width="200"><col width="400">
		
		
		<tr>
			<th>아이디</th>
			<td><%=mem.getId()%></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="60" value="<%=dto.getTitle()%>"></td>
		</tr>
		
		<tr>
			<th>내용</th><td><textarea rows="20" cols="50" name="content"><%=dto.getContent()%></textarea></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성완료">
			</td>
		
		</tr>
		
	</table>

</form>

</div>


</body>
</html>