<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<script src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
	$(document).ready(function (){
	$.ajax({
	dataType:'jsonp',
	url:'http://record.btime.com/getNews?tab=all&lastTime=&pageRow=10&uid=1465366&refresh=1',
	type:'GET',
	success:function(result){
	 var txt=result.data;
  	 var content="";
	for(var  i=0; i<txt.length;i++){
	$name=txt[i].open_url;
	content=content+"<h1><a href="+$name+">"+txt[i].data.title+"</h1>"+"<div>"+txt[i].data.summary+"<div>"+"<br/>"+"<hr/>";}
	console.log(content);
	document.getElementById("wenzhang").innerHTML=content; 
	}
	});
	
	
	}
	);
	
	</script>
  </head>
  
  <body>
  <div id="wenzhang"></div>
    <input type="button" value="ajax跨域" onclick="ajaxk()">
  </body>
</html>
