<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript">function showPost(obj){
	var depId = obj.value;

	var depName = obj.name;

	var xmlhttp=null;
	if(window.XMLHttpRequest){
		xmlhttp= new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xmlhttp = new ActiveObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status ==200 ){
			var textData = xmlhttp.responseText;
			var jsonData = eval("("+textData+")");
			var postSelect = document.getElementById("postSelectId");
			postSelect.innerHTML = "<option value=''>----请选择------</oprion>";
			 
			for(var i =0; i<jsonData.length;i++){
				var postObj = jsonData[i];
				var postId = postObj.postId;
				var postName = postObj.postName;
				postSelect.innerHTML +="<option value='"+postId+"'>"+postName+"</option>"; 
			}
		}
	};
	var url="${pageContext.request.contextPath}/AjaxAction?crmDepartment.depId="+depId+"&crmDepartment.depName="+depName;
	xmlhttp.open("GET", url);
	xmlhttp.send(null);
}</script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="${pageContext.request.contextPath}/staffAction_add" method="get">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/> </td>
	    <td>性别：</td>
	    <td><input type="radio" name="gender"  value="男"/>男
	    	<input type="radio" name="gender"  value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<s:select list="editDepartment"
	    	listKey="depId" listValue="depName" 
	    	headerKey="" headerValue="----请--选--择----" onchange="showPost(this)">
	    </s:select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	 <s:select list="crmPost!=null?crmPost.crmDepartment.crmPosts:{}" name="crmPost.postId"
	    	listKey="crmPost.postId" listValue="crmPost.postName"  
	    	headerKey="" headerValue="----请--选--择----"  id="postSelectId" />
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>
</body>
</html>
