<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  
  <body>
  
  你的ip地址是（使用java代码获取输出）<%String ip = request.getRemoteAddr();out.write(ip); %>;
  <hr/>
  
  <demo1:test1>ceshi<br/></demo1:test1>
 	 
 	<li><c:out value="&lt未使用字符转义&gt" escapeXml="false"></c:out>
 	
 	
 	
 	</ul>
 
  </body>
</html>
