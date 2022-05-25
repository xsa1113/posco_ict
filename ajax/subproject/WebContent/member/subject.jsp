<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
<head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
#LoginForm{  background-repeat:no-repeat; background-position:center; background-size:cover; padding:10px;}

.form-heading { color:#fff; font-size:23px;}
.panel h2{ color:#444444; font-size:26px; margin:0 0 8px 0;}
.panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
.login-form .form-control {
  background: #f7f7f7 none repeat scroll 0 0;
  border: 1px solid #d4d4d4;
  border-radius: 4px;
  font-size: 14px;
  height: 50px;
  line-height: 50px;
}
.main-div {
  background: #ffffff none repeat scroll 0 0;
  border-radius: 2px;
  margin: 10px auto 30px;
  max-width: 38%;
  padding: 50px 70px 70px 71px;
}

.login-form .form-group {
  margin-bottom:10px;
}
.login-form{ text-align:center;}
.forgot a {
  color: #777777;
  font-size: 14px;
  text-decoration: underline;
}
.login-form  .btn.btn-primary {
  background: #f0ad4e none repeat scroll 0 0;
  border-color: #f0ad4e;
  color: #ffffff;
  font-size: 14px;
  width: 100%;
  height: 50px;
  line-height: 50px;
  padding: 0;
}
.forgot {
  text-align: left; margin-bottom:30px;
}
.botto-text {
  color: #ffffff;
  font-size: 14px;
  margin: auto;
}
.login-form .btn.btn-primary.reset {
  background: #ff9900 none repeat scroll 0 0;
}
.back { text-align: left; margin-top:10px;}
.back a {color: #444444; font-size: 13px;text-decoration: none;}
#idsave{
	align-content: center;
}


</style>

<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body id="LoginForm">
	<div class="container">
	<h1 class="form-heading">login Form</h1>
		<div class="login-form">
				<div class="main-div">
					    <div class="panel">
					   <h1>로그인</h1>
					   <p>Please enter your email and password</p>
					   </div>
				    <form action ="../member" method="post">
				    <input type="hidden" name ="param" value="loginAf">				
				        <div class="form-group">
				            <input type="text" class="form-control" id="id" name="id" placeholder="ID">
				            
				        </div>
				
				        <div class="form-group">
				
				            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
				
				        </div>
				        <div class="forgot">
				        <a href="../member?param=regi">회원가입 </a>
				        <span style = "float: right;" ><input type="checkbox" id="chk_save_id" >아이디저장</span>
				 
						</div>
						
				        <input type="submit" class="btn btn-primary" value= "Login">
				
				    </form>
			    </div>
		
		</div>
	</div>



</body>


<script type="text/javascript">

let user_id = $.cookie("user_id");
if(user_id != null){
	$("#id").val(user_id);
	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function() {
	
	if( $("#chk_save_id").is(":checked") ){ // 체크되었을 때
		
		if($("#id").val().trim() == ""){
			alert("id를 입력해 주십시오");
			$("#chk_save_id").prop("checked", false);
		}else{
			// cookie에 저장	
			$.cookie("user_id", $("#id").val().trim(), { expires:7, path:"/" });
		}
	}
	else{ // cookie를 삭제
		$.removeCookie("user_id", { path:"/" });
	}	
	
});

</script>
</html>