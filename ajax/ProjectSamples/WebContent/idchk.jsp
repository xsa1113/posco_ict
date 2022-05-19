<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
System.out.println(id);
MemberDao dao = MemberDao.getInstance();

boolean isS = dao.idCheck(id);

if(isS){
	out.println("NO");
}else{
	out.println("OK");
}
%>
