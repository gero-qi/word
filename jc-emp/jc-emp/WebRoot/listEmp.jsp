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
<html>
	<head>
		<title>我国成品油管网数据库</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			<!-- 网页头的标准 -->
			<script type="text/javascript" src="js/jquery-1.11.1.js"></script> 
			<!-- 引入jquery框架 -->
	</head>
	<script>
		
	</script>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					<!-- 定位作用 -->
					</p>
			 	<h1 style="color:red;">${search_error}</h1>
					<h1>
						员工列表
					</h1>
					<form action="search.do" method="post" style="float:left;">
						<input name="name" placeholder="这里输入管线名称……"/>
						<button>搜索</button>
					</form>
					<form action="search.do" method="post" style="float:left;">
						<input name="company" placeholder="这里输入总公司……"/>
						<button>搜索</button>
					</form>
					<form action="search.do" method="post" style="float:left;">
						<input name="provinces" placeholder="这里输入途径省市……"/>
						<button>搜索</button>
					</form>
					
					<form action="count.do" method="post" style="margin-right:1000px;">
						<input type="hidden" id="countSize" name="countSize" value="">
						<input name="count1" placeholder="选择需要计算运力的管线……" value="${sizeCount }"/>
						<button>计算运力</button>
					</form>
				
					<table class="table">
						<tr class="table_header">
							<td>
								<input type="checkbox" id="checkAll" onclick="checkAllOpen()">
							</td>
							<td>
								编号
							</td>
							<td>
								管线名称
							</td>
							<td>
								总公司
							</td>
							<td>
								分公司
							</td>
							<td>
								建设时间
							</td>
							<td>
								起点
							</td>
							<td>
								终点
							</td>
							<td>
								途径省市
							</td>
							<td>
								管线长度
							</td>
							<td>
								运力
							</td>
							<td>
								压力
							</td>
							<td>
								温度
							</td>
							<td>
								管径
							</td>
							<td>
								操作
							</td>
						</tr >
						<c:forEach items="${emp}" var="e" varStatus="s">
						<tr class="row${s.index % 2 + 1}">
						<!-- jstl便利查询结果集 -->
							<td>
								<input type="checkbox" id="${e.id}" onclick="checkOne()">
							</td>
							<td>
								${e.id}
							</td>
							<td>
								${e.oilname}
							</td>
							<td>
								${e.company}
							</td>
							<td>
								${e.firm}
							</td>
<!-- 							<td> -->
<!-- 								${e.opentime} -->
<!-- 							</td> -->
							<td><fmt:formatDate value="${e.opentime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
							<!-- 将后端的data日期转为前台的标准化 -->
							<td>
								${e.fromcity}
							</td>
							<td>
								${e.tocity}
							</td>
							<td>
								${e.provinces}
							</td>
							<td>
								${e.oillength}
							</td>
							<td>
								${e.capacity}
							</td>
							<td>
								${e.pressue}
							</td>
							<td>
								${e.temperature}
							</td>
							<td>
								${e.diameter}
							</td>
							<td>
								<a href="delete.do?id=${e.id}" 
								onclick="return confirm('确定删除管线名称'${e.oilname}'吗?');">删除</a>&nbsp;
								<a href="load.do?id=${e.id}"
								onclick="return confirm('确定修改管线名称'${e.oilname}'吗?');">修改</a>
								<!-- 动态加载删除和修改按钮相后端发送请求 -->
							</td>
						</tr>
						</c:forEach>
					</table>
				<!--分页-->
               <div align="center" >
        	   		<c:choose>
                		<c:when test="${num>1}">
                  			<a href="list1.do?num=${num-5}">上一页</a>
                		</c:when>
                		<c:otherwise>
                  			<a>上一页</a>
                		</c:otherwise>
               		</c:choose> 
               		 
               		  
     				<c:forEach items="${sessionScope.pagess }" var="m" varStatus="s" >
     				 <td ><a style="background: black" href="list1.do?num=${m.value}">${m.key }</a></td> 
               		 <>
               		</c:forEach> 
               		
               		 
               		
<!--                     <a style="font-size:15px">第${page}页</a> -->
                    <a href="list1.do?num=${num+5}">下一页</a>
                </div>
                
					<p>
						<input type="button" class="button" value="添加员工"
							onclick="location='addEmp.jsp'" />
					</p>
				</div>
			</div>
						<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
