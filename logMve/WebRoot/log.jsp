
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  <form action="${pageContext.request.contextPath }/servlet/LoginUIServlet" method="get">
   <table>
 <tr><td>姓名<input type="text" name="name"></td></tr>
  <tr> <td>密码<input type="password" name="password"></td></tr>
  <tr><td><input type="reset" value="清空"></td></tr>
  <tr> <td><input type="submit" value="提交"></td></tr>
  
  </table>
  </form>
  <body>
    
  </body>
</html>
