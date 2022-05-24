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
<%-- 
<%
BbsDao dao = BbsDao.getInstance();
int seq = Integer.parseInt(request.getParameter("seq"));
dao.count(seq);
BbsDto dto = dao.selectWriter(seq);

//조회수 증가
%>
 --%>
<%
BbsDto dto = (BbsDto)request.getAttribute("dto");

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

<br>
<button type="button" onclick="answerBbs(<%=dto.getSeq() %>)">답글</button>
<button type="button" onclick="location.href= 'bbs?param=bbslist'">글목록</button>

<%

if(dto.getId().equals(mem.getId())){
%>

<button type="button" onclick="updateBbs(<%=dto.getSeq() %>)">수정</button>
<button type="button" onclick="deleteBbs(<%=dto.getSeq() %>)">삭제</button>

<%
}
%>
</div>


<script type="text/javascript">
function answerBbs(seq){
	location.href = "answer.jsp?seq=" + seq;
}
function updateBbs(seq){
	// 수정 기존 내용 제목과 내용 수정
	location.href = "./bbs?param=update&seq=" + seq;
	console.log(seq);
}
function deleteBbs(seq){
	/* 업데이트 명령어 활용 del를 바꿔준다 0냐 1냐에 따라서 달라진다 bblist 이글은 삭제되었습니다. */
	location.href = "./bbs?param=delete&seq=" + seq;
}


</script>



</body>
</html>