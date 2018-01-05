<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:if test="${sessionScope.name==null}"> --%>
<%-- 	<c:redirect url="http://localhost:8080/jc-emp/login.jsp"></c:redirect> --%>
<%-- </c:if>	              --%>
<html>
	<head>
		<title>员工管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
		<script type="text/javascript">
			//检验年龄合法性
			$(function(){
				$("#age_a").blur(function(){
					//获取输入的年龄
					var age=$("#age_a").val();
					if(age>0 && age<=100){
						$("#age_t").text("");
					}else{
						$("#age_t").text("年龄不符合逻辑");
						$("#age_a").val("");
					}
				});
				//检验密码合法性
				$("#pas").blur(function(){
					var password=$("#pas").val();
					if(isNaN(password) || password.length!=6){
						$("#pas_t").text("请输入6位数字");
						$("#pas").val("");
					}else{
						$("#pas_t").text("");
					}
				});
				//检验电话合法性
				$("#phone").blur(function(){
					var tel=$("#phone").val();
					if(isNaN(tel) || tel.length!=11){
						$("#phone_t").text("请输入11位数字");
						$("#phone").val("");
					}else{
						$("#phone_t").text("");
					}
				});
				//检验传真合法性
				$("#fax_").blur(function(){
					var fax=$("#fax_").val();
					if(isNaN(fax) || fax.length!=8){
						$("#fax_t").text("请输入8位数字");
						$("#fax_").val("");
					}else{
						$("#fax_t").text("");
					}
				});
				//检验邮箱合法性
				$("#em").blur(function(){
					var mail=$("#em").val();
					//1.表示a~z、A～Z、0～9、下划线、点以及减号可以出现至少1次也可以多次，然后出现@符号。
					//2.这段中的“（）”表示分组，这段正则表示这一组至少出现一次，也可以出现多次。
					//	括号中的内容表示，a~z、A～Z、0～9及减号可以至少出现1次也可以出现多次，然后出现“.”字符。
					//3.表示a~z、A～Z、0～9可以出现大于等于2次，小于等于4次。
					var reg=/^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
					if(!reg.test(mail)){
						$("#em_t").text("请输入正确的邮箱");
						$("#em").val("");
					}else{
						$("#em_t").text("");
					}
				});
			});
			
		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>	
				<div id="content">
					<p id="whereami">
					</p>
					<span ><h1 style="color:red;">${msg}</h1></span>
					<span><h1 style="color:red;">${as_error}</h1></span>
					<h1>
						添加管线
					</h1>
					<form action="add.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									管线名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="oilname" id="oilname"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									总公司:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="company" id="company"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									分公司:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="firm" id="firm"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									建设时间:
								</td>
								<td valign="middle" align="left">
									<input type="date"  value="2015-12-8" class="inputgri" name="opentime" id="opentime"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									起点:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="fromcity" id="fromcity"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
										终点:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="tocity" id="tocity"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										途径省市:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="provinces" id="provinces"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									管线长度:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="oillength" id="oillength"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										运力:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="capacity" id="capacity"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									压力:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="pressue" id="pressue"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										温度:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="temperature" id="temperature"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									管径:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="diameter" id="diameter"/>
								</td>
							</tr>
						</table>
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
