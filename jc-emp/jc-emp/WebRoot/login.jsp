<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>欢迎登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		
	</head>
	<body style="font-size:30px">
		<div id="wrap"style="width:1318px">
			<div id="top_content">
				<%@include file="header.jsp" %>	
				<div id="content">
					<p id="whereami"></p>
					<h1>欢迎</h1>
			<form action="login.do" method="get">
			  <fieldset>
				<legend>登录</legend>
					用户名:<input name="name"/>
					<span style="color: red";>${str_error}</span><br>
				          密&nbsp;&nbsp;&nbsp;码:<input name="password" type="password"/><br>
					验证码:<input name="numberCheck"/>
			 		<span style="color:red;">${number_error}</span>
					<img src="check" border="2px"
						 onclick="this.src='check?'+Math.random();" class="s1"/><br/>
				<p></p>
				<input type="submit" class="button" value="登录" style="font-size:20px"/>
			  </fieldset>
			</form>
				</div>
		  </div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
