<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="insertAf.jsp" id="hello">

아이디 <input type="text" name="id">
<br>
패스워드 <input type="password" name="pwd">
<br><br>

취미 <br>
<input type="checkbox" name = "hobby" value="잠자기">잠자기
<input type="checkbox" name = "hobby" value="노래하기">노래하기
<input type="checkbox" name = "hobby" value="게임하기">게임하기

<br><br>
연령대<br>
<input type="radio" name ="age" value="10대">10대
<input type="radio" name ="age" value="20대">20대
<input type="radio" name ="age" value="30대">30대
<input type="radio" name ="age" value="40대">40대
<input type="radio" name ="age" value="50대">50대
<input type="radio" name ="age" value="60대">60대

<br><br>
기타하고싶은말<br><br>
<textarea rows="10" cols="40" name="talk"  ></textarea>

<button onclick="func">전송</button>
</form>



<script type="text/javascript">
function func() {
	$("#hello").submit();
}


</script>


</body>
</html>