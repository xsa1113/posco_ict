<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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
dao.count(seq);
BbsDto dto = dao.selectWriter(seq);

//조회수 증가
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>내용</h2>

<div align="center">
<table border = "1">
<col width="70"><col width="600">
<tr>
	<th> 작성자</th>
		<td><%= dto.getId() %></td>
</tr>
<tr>
	<th>조회수</th>
		<td><%= dto.getReadcount() %></td>
</tr>
<tr>
	<th> 작성일</th>
		<td><%= dto.getWdate() %></td>
</tr>
<tr>
	<th> 제목</th>
		<td><%= dto.getTitle() %></td>
</tr>
<tr>
	<th> 정보</th>
		<td><%= dto.getRef() %> - <%= dto.getStep() %> - <%= dto.getDepth() %></td>
</tr>
<tr>
	<th> 내용</th>
		<td><%= dto.getContent() %></td>
</tr>


</table>

</div>




</body>
</html>