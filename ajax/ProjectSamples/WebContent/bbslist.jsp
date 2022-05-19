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

List<BbsDto> list = dao.getBbsList();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>게시판</h2>

<div align="center">

<table border = "1">
<col width="70"><col width="600"><col width="150">


<tr>
	<th>번호</th><th>제목</th><th>작성자</th>

</tr>

<%
if(list == null || list.size() == 0){
	%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
	<%
}else{
	for(int i=0; i<list.size(); i++){
		BbsDto bbs = list.get(i);
	%>
		<tr>
			<th><%= i+1 %></th>

			<td>
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
				<%= bbs.getTitle() %>
				</a>
			</td>
			
			<td>
				<%= bbs.getId() %>
			</td>
		</tr>
	
	<%
	}
}
%>
</table>

<a href="bbswrite.jsp">글쓰기</a>

</div>
</body>
</html>