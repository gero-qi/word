<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:if test="${sessionScope.name==null}"> --%>
<%-- 	<c:redirect url="http://localhost:8080/jc-emp/login.jsp"></c:redirect> --%>
<%-- </c:if>	 --%>
<html>
	<head>
		<title>我国成品油管网数据库</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			<style type="text/css">
				.button{
					cursor:pointer
				}
			</style>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami"></p>
					<h1 style="color:red;">${search_error}</h1>
					<h1>我国成品油管网数据库</h1>
					<!-- <form action="search.do" method="post">
						<input name="name" />
						<button>搜索</button>
					</form> -->
				
					<table class="table">
						<tr class="table_header">
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
						</tr>
						<c:forEach items="${emp}" var="e" varStatus="s">
						<tr class="row${s.index % 2 + 1}">
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
						</tr>
						</c:forEach>
					</table>
				<!--分页-->
               <div align="center">
        	   		<c:choose>
                		<c:when test="${num>1}">
                  			<a href="list1.do?num=${num-20}">上一页</a>
                		</c:when>
                		<c:otherwise>
                  			<a>上一页</a>
                		</c:otherwise>
               		</c:choose>  
<!--                     <a>第${page}页</a> -->
                    <a href="list1.do?num=${num+20}">下一页</a>
                </div>
					<p>
						<input type="button" class="button" value="添加员工"
							onclick="location='addEmp.jsp'" />
							
					<input type="button"  class="button" value="返回"
						onclick="location='list.do'" 
							align="right" style="position:absolute;
							right:60px; top:395px; height:25px; width:40px;"/>
					</p>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
