<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
  <%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
<head>
</head>

  
  <body>
  <h1>haha</h1>
  <jsp:forward page="/demo2.jsp">
 	<jsp:param value="ref1" name="ref1"/>
 	<jsp:param value="ref2" name="ref2"/>
</jsp:forward>
  </body>
</html>
