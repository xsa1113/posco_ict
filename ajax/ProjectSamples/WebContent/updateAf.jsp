<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
int seq = Integer.parseInt(request.getParameter("seq"));
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");
%>

<%
BbsDao dao  = BbsDao.getInstance();

// update문을 활용해서 진행

boolean isS = dao.writeUpdate(seq, content, title);

if(isS){
%>
	<script type="text/javascript">
	alert("정삭적으로 글이 수정되었습니다.");
	location.href = "bbslist.jsp";
	</script>
<%
} else{
%>
	<script type="text/javascript">
	alert("정삭적으로 글이 수정되었습니다.");
	location.href = "bbslist.jsp";
	</script>
<%
}
%>

</body>
</html>