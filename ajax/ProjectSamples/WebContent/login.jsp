<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>login</title>

<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border : 3px solid #0000ff;
	padding: 10px;
}

</style>


</head>
<body>
<h2>login page</h2>

<div class="center">
<form action="loginAf.jsp" method="post">
<table border="1">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" id="id" name="id" size="20"><br>
		<input type="checkbox" id="chk_save_id">아이디저장		
	</td>
</tr>

<tr>
	<th>패스워드</th>
	<td>
		<input type="password" name="pwd" size="20">
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="로그인">
		<a href="regi.jsp">회원가입</a>
	</td>
</tr>
</table>
</form>
</div>


</body>
</html>