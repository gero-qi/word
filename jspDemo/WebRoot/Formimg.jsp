<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>在form表单中使用验证码</title>
  <script type="text/javascript">
  function changeImg(obj,createTypeFlag){
  	document.getElementById(obj.id).src="${pageContext.request.contextPath}/servlet/ResponseDemo3?createTypeFlag="+createTypeFlag+"&"+Math.random();}
  </script>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/ResponseAndCheckImage" method="post">
    验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清换一张" src="${pageContext.request.contextPath}/servlet/ResponseDemo3" id="validateCodeImg" onclick="changeImg(this,'nl')">
    <br/>
    <input type="submit" value="提交">
   <%--  中文验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清换一张吧" src="${pageContext.request.contextPath }/servlet/ResponseDemo3?createTypeFlag=ch" id="validateCodeImg1" onclick="changeImg(this,'ch')"> --%>
    
    </form>
  </body>
</html>
