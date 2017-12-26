<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>html得表单元素</title>
  <script type="text/javascript">
  var isCommitted  = false;
  function dosubmit(){
  	var btnSubmit = document.getElementById("submit");
  	btnSubmit.disabled= "disabled";
  	if(isCommitted ==false){
  		isCommitted =true;
  		return true;
  	}else{
  		return false;
  	}
  }</script>
  </head>
  
  <body>
  	<fieldset style="width:500px;margin-left: 750px">
  		<legend>Html的form表单元素</legend>
  		<form action="${pageContext.request.contextPath }/servlet/RequestDemo2"method="post" onsubmit="return dosubmit()">
  		 编    号:<input type="text" name="userid" value="NO." size="2" maxlength="2"></br>
  		 用户名（文本框）:<input type="text" name="username" value="请输入用户名"></br>
  		 密码:<input type="password" name="userpass" value="请输入密码"></br>
  		性别:<input type="radio" name="sex" value="男" checked> 男
  		<input type="radio" name="sex" value="女">女</br>
  		部门:
  		
  		<select name="dept">
  			<option value="技术部">技术部
  			<option value="销售部" SELECTED>销售部
  			<option value="财务部">财务部	
  		</select>
  		 兴趣：
  		 <input type="checkbox" name="inst" value="唱歌">唱歌
  		 <input type="checkbox" name="inst" value="游泳">游泳
  		 <input type="checkbox" name="inst" value="跳舞">跳舞
  		 说明：
  		 <textarea name="note" rows="5" cols="35"></textarea>
  		 
  		 <input type="hidden" name="token" vlaue="<%=session.getAttribute("token")%>">
  		 
  		 <input type="submit" value="提交" id="submit">
  		 <input type="reset" value="重置">
  		 
  		</form>
  	</fieldset>
  </body>
</html>
