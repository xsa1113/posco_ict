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

%>

<%
BbsDao dao  = BbsDao.getInstance();
// delete 문 실행

boolean isS = dao.writeDelete(seq);
if(isS){
%>
	<script type="text/javascript">
	alert("정삭적으로 글이 삭제되었습니다");
	location.href = "bbslist.jsp";
	</script>
<%
} else{
%>
	<script type="text/javascript">
	alert("글삭제 오류");
	location.href = "bbslist.jsp";
	</script>
<%
}
%>

</body>
</html>