<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!--国际标准  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %> 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <!-- 加载页面插件jstl中的一种方法c:each -->
<%-- <c:if test="${sessionScope.name==null}"> --%>
<!--  -->
<%-- 	<c:redirect url="http://localhost:8080/jc-emp/login.jsp"></c:redirect> --%>
<%-- </c:if>	 --%>

 <script>
 checkAllOpen = function(){
		if($("#checkAll").is(":checked")){
			$("input[type='checkbox']").each(function(){
//	 			console.log("1")
				 this.checked=true;
			});
		}else{
			$("input[type='checkbox']").each(function(){
//	 			console.log("1")
				 this.checked=false;
			});
		}
	};
	checkOne = function(){
		 var ids = "";
		$("input[type='checkbox']:checked").each(function(){
// 			console.log("1")
// 			 this.checked=true;
			 ids = this.id +","+ ids;
			 $("#countSize").val(ids)
		});
	}
 </script>
</style>
<html>
	<head>
		<title>我国成品油管网数据库</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			<!-- 网页头的标准 -->
			<script type="text/javascript" src="js/jquery-1.11.1.js"></script> 
			<!-- 引入jquery框架 -->
	</head>
	<body>
	<p>
			<c1:date pattern="yyyy-MM-dd"/><br/>

		</p>
	</div>
	<div id="topheader" font-size="1.5em">
		<h1 id="title" font-size="1.5em">
			<a href="#">HR人员信息管理
			</a>
		</h1>
		<div id="content">
						<table class="table">
						<tr class="table_header">
							<td>
								编号
							</td>
							<td>
								姓名
							</td>
							<td>
								密码
							</td>
							<td>
								email
							</td>
							<td>
								账号等级
							</td>
							<td>
								部门
							</td>
							<td>
								职务
							</td>
							<td>
								操作
							</td>
						</tr >
						<c:forEach items="${resultMapList}" var="e" varStatus="s">
						<tr class="row${s.index % 2 + 1}">
							<td>
								${e.id}
							</td>
							<td>
								${e.name}
							</td>
							<td>
								${e.password}
							</td>
							<td>
								${e.email}
							</td>
							<td>
								${e.level}
							</td>
							<td>
								${e.departName}
							</td>
							<td>
								${e.ResName}
							</td>
							<td>
								<a href="delete.do?id=${e.id}" 
								onclick="return confirm('确定删除管线名称'${e.oilname}'吗?');">删除</a>&nbsp;
								<a href="load.do?id=${e.id}"
								onclick="return confirm('确定修改管线名称'${e.oilname}'吗?');">修改</a>
							</td>
						</tr>
						</c:forEach>
					</table>
	</div>
	
	
	
	</body>
	
	
</html>

