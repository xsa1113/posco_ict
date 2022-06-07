<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
   <title>Home</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
   <meta charset="UTF-8"/>
</head>
<body>
   <h1> 글상세</h1>
   <p> 제목 : ${data.title}</p>
   <p> 내용 : ${data.content}</p>
   <p> 작성자 : ${data.user}</p>
   <p> 입력일 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH.mm.ss"/></p>
   <a href="/update?board_id=${board_id}">수정</a>
   <form method="POST" action="/delete">
      <input type="hidden" name="board_id" value= "${board_id}">
      <input type="submit" value="삭제">
   </form>
   <a href="/">목록</a>
</body>
</html>