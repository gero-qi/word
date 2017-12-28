<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ page isELIgnored="false" %>
 
  <%@taglib uri="/geshiqi" prefix="demo1" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  
  <body>
  
  你的ip地址是（使用java代码获取输出）<%String ip = request.getRemoteAddr();out.write(ip); %>;
  <hr/>
  
  <demo1:test1>ceshi<br/></demo1:test1>
 	<ul>
 	<li><c:out value="1">out 标签的使用方法</c:out></li>
 	
 	
 	
 	
 	</ul>
 
  </body>
</html>
