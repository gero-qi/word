<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ page isELIgnored="false" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <% pageContext.setAttribute("name", "gehsiqi");
	pageContext.setAttribute("pass","12345d");
 %>
 <% String refName = (String)pageContext.getAttribute("name");
 	String pass = (String)pageContext.getAttribute("pass"); %>

  </head>
  <h1>姓名：<%=refName %></h1>
  <h2>密码：<%=pass	  %></h2>
  <body>
  
  </body>
</html>
