
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  	用户：${user }已登录
    <form action="${pageContext.request.contextPath}/servlet/LogServelt " method="post">
    <input type="hidden" name="submitFlag" value="login"/>
    name:<input type="text" name="name"  /><br/>
    password:<input type="text"	name="password"/><br/>
    <input type="submit" value="login"/>
    
    
    
    </form>
  </body>
</html>
