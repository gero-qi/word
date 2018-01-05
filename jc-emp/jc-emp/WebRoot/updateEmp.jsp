<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<%@ page isELIgnored="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <c:if test="${sessionScope.name==null}"> --%>
<%-- 	<c:redirect url="http://localhost:8080/jc-emp/login.jsp"></c:redirect> --%>
<%-- </c:if> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
			<script type="text/javascript" src="js/jquery-1.11.1.js"></script> 
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						修改员工
					</h1>
					<form action="modify.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									管线名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="oilname" id="oilname" value="${emp.oilname }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									总公司:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="company" id="company" value="${emp.company }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									分公司:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="firm" id="firm" value="${emp.firm }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									建设时间:
								</td>
								<td valign="middle" align="left">
									<input type="date" class="inputgri" name="opentime" id="opentime" value="${emp.strDate }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									起点:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="fromcity" id="fromcity" value="${emp.fromcity }"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
										终点:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="tocity" id="tocity" value="${emp.tocity }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										途径省市:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="provinces" id="provinces" value="${emp.provinces }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									管线长度:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="oillength" id="oillength" value="${emp.oillength }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										运力:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="capacity" id="capacity" value="${emp.capacity }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									压力:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="pressue" id="pressue" value="${emp.pressue }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										温度:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="temperature" id="temperature" value="${emp.temperature }"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									管径:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="diameter" id="diameter" value="${emp.diameter }"/>
								</td>
							</tr>

						</table>
						<input type="hidden" name="id" value="${emp.id}"/>
						<input type="hidden" name="oilname" value="${emp.oilname}"/>
						<p>
							<input type="submit" class="button" 
							value="确定" />
								<input type="button"  class="button" value="返回"
						onclick="location='list.do'" 
							align="right"/>
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
