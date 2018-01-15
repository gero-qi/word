<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>欢迎登陆</title>
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="scripts/login.js"></script>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->	
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<style type="text/css">
			.s1 {
					cursor:pointer
				}
		</style>
	</head>
	<body style="font-size:30px">
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>	
				<div id="content">
					<p id="whereami"></p>
			<dt>
				<div>
					用户名:&nbsp;<input type="text" name="" id="count"/>
					<span style="color:red;" id="count_msg"></span>
				</div>
			</dt>
			<p id="whereami"></p>
			<dt>
				<div>
					密&nbsp;&nbsp;码&nbsp;:&nbsp;<input type="password" name="" id="password"/>
					<span style="color: red;" id="password_msg"></span>
				</div>
			</dt>
			<p id="whereami"></p>
			<dt>
				<div>
					<input type="button" name="" id="login" value="登录" class="s1"/>
				</div>
			</dt>
			<p id="whereami"></p>

				</div>
		  </div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
