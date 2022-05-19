<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

System.out.println(id + title + content);
%>


<%
BbsDao dao = BbsDao.getInstance();

boolean isS = dao.insertBbs(new BbsDto(id, title, content));

if(isS){
	%>
	<script type="text/javascript">
	alert("정상적으로 글이 추가 되었습니다");
	location.href = "bbslist.jsp";
	</script>
	
	<%
}else{
	%>
	<script type="text/javascript">
	alert("정상적으로 글이 작성 안됨");
	location.href ="bbswrite.jsp";
	</script>
	<%
}

%>

</body>
</html>