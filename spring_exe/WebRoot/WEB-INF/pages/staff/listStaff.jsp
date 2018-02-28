<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="${pageContext.request.contextPath}/staffAction_addUI">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<s:form id="conditionFormId" >
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	   	<s:textfield name="crmDepartment" ></s:textfield>
	    </td> 
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    <s:textfield name="crmPosts"></s:textfield>
	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><s:textfield name="staffName" size="12" /></td>
	  </tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>

    <s:iterator value="#allstaff" status="vs">
     
	  <tr class="<s:property value="'vs.even?' 'tabtd2':'tabtd1'"/>" >
	    <td align="center"><s:property value="staffName"/></td>
 	    <td align="center"><s:property value="gender"/></td>
	    <td align="center"><s:date name="onDutyDate" format="yyyy-MM-dd"/></td>
	    <td align="center"><s:property value="crmPost.crmDepartment.depName"/></td>
	    <td align="center"><s:property value="crmPost.postName"/></td>
	  	<td width="7%" align="center">
	  		<s:a namespace="/" action="staffAction_editUI">
	  		<s:param name="staffId" value="staffId" ></s:param>
	  		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
	  		</s:a>
	  		<s:a namespace="/" action="staffAction_deleteStaff">
	  		<s:param name="staffId" value="staffId" ></s:param>
	  		删除
	  		</s:a>
	  		
	  	</td>
	  	  
	  </tr>
	 </s:iterator>
</table>


 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
 
</body>
</html>
