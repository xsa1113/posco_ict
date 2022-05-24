<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
String id = request.getParameter("id");
%>
<body>


    <div class="container" style="margin-top:40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> My page </strong>
					</div>
					<div class="panel-body">
						<form role="form" action="../member" method="POST">
						<input type="hidden" name="id" id="id" value=<%=id %> > 
						<input type="hidden" name="param" value="delete">
							<fieldset>
								<div class="row">
									<div class="center-block" >
										<img class="profile-img" src="../images/사진5.png" width="100%" height="auto" alt="">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<p class ="form-control"><b><%=id %></b>님 환영합니다</p>
												<%-- <input class="form-control" placeholder="<%=id %>님 환영합니다" name="loginname" type="text" autofocus> --%>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
												
											</div>
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="회원탈퇴">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
						You have an account! <a href="#" onClick=""> <b>logout</b> </a>
					</div>
                </div>
			</div>
		</div>
	</div>

</body>
</html>