<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
   <meta http-equiv="Content_Type" content="text/html;charset=utf-8"/>
   <meta charset="UTF-8">
</head>
<body>
<h1>글 수정</h1>
<form method="post">
<input type="hidden" name="board_id" value="${board_id }"/>
<p>제목 : <input type="text" name="title"></input></p>   
<p>내용 : <input type="text" name="content"></input></p>   
<p>작성자 : <input type="text" name="user"></input></p>   
<input type="submit" value="저장">
</form>
</body>
</html>
