<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
System.out.println(id);
MemberDao dao = MemberDao.getInstance();

boolean isS = dao.idCheck(id);
out.print(isS);
%>
<%-- <%
if(isS){

%>
	<script type="text/javascript">
	alert("동일한 아이디가 있습니다");
	</script>
	
<%
} else{
%>
	<script type="text/javascript">
	alert("동일한 아이디가 없습니다. 사용해도 좋습니다");
	</script>
	
	<%
	
}
%> --%>