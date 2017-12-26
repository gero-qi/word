<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 

<jsp:useBean id="UserBean1" class="db.config.UserBean1" scope="page"/>
<%
UserBean1.setName("葛士祺");
UserBean1.setSex("man");
UserBean1.setAge(24);
UserBean1.setMarried(false);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <h2>姓名：<%=UserBean1.getName() %></h2>
    <h2>年龄:<%=UserBean1.getAge() %></h2>
  </body>
</html>
