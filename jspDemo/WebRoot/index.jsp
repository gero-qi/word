<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ page isELIgnored="false" %>
 <%@taglib uri="/geshiqi" prefix="xdp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
  你的ip地址是（使用java代码获取输出）<%String ip = request.getRemoteAddr();out.write(ip); %>;
  <hr/>
  <xdp:viewIP/>
  
    恭喜你验证成功g. <br>
    <%=(String)request.getAttribute("data") %>
    ${data}
  </body>
</html>
