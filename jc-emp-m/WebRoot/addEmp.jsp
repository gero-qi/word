<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.uname==null}">
	<c:redirect url="http://localhost:8080/jc-emp-m/login.jsp"></c:redirect>
</c:if>
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
						添加员工
					</h1>
					<form action="add.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" 
									class="inputgri" name="password" id="pas"/>
									<span style="color :red" id="pas_t"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="age" id="age_a"/>
									<span style="color :red" id="age_t"></span><br>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
						<!-- 	<td valign="middle" align="left">
									<select id="gender" name="sex" class="inputgri">
										<option>男</option>
										<option>女</option>
									</select>
								</td>
						-->
								<td valign="middle" align="left">
									<input type="checkbox" name="sex" value="男" class="inputgri"/>
									<span>男</span>
									<input type="checkbox" name="sex" value="女" class="inputgri">
									<span>女</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									生日:
								</td>
								<td valign="middle" align="left">
									<input type="date"  value="2015-12-8"
									class="inputgri" name="birth" />
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
										民族:
								</td>
								<td valign="middle" align="left">
									<lable for="course">
									</lable>
									<select id="course" class="inputgri" name="nation">
										<option>汉</option>
										<option>满</option>
										<option>蒙</option>
										<option>苗</option>
									</select>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										籍贯:
								</td>
								<td valign="middle" align="left">
									<lable for="native">
									</lable>
									<select id="native" class="inputgri" name="nativePlace">
										<option>吉林</option>
										<option>山东</option>
										<option>河北</option>
										<option>北京</option>
									</select>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									出生地:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="birthPlace" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										职位:
								</td>
								<td valign="middle" align="left">
									<lable for="jb">
									</lable>
									<select id="jb" class="inputgri" name="job">
										<option>IT</option>
										<option>doctor</option>
										<option>teacher</option>
										<option>Clerk</option>
										<option>banker</option>
									</select>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									毕业院校:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="college" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
										学历:
								</td>
								<td valign="middle" align="left">
									<lable for="aca">
									</lable>
									<select id="aca" class="inputgri" name="academic">
										<option>本科</option>
										<option>研究生</option>
										<option>博士</option>
										<option>硕士</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									毕业时间:
								</td>
								<td valign="middle" align="left">
									<input type="date" 
									class="inputgri" name="graduationDate" value="2015-12-8"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									电话:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="tel" id="phone"/>
									<span style="color:red" id="phone_t"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									传真:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="fax" id="fax_"/>
									<span style="color:red" id="fax_t"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									邮箱:
								</td>
								<td valign="middle" align="left">
									<input type="text" 
									class="inputgri" name="mail" id="em"/>
									<span style="color:red" id="em_t"></span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" 
							value="确定" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
