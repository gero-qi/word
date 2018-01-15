<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.uname==null}">
	<c:redirect url="http://localhost:8080/jc-emp-m/login.jsp"></c:redirect>
</c:if>
<html>
	<head>
		<title>员工管理</title>
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
					<h1>员工列表</h1>
					<form action="search.do" method="post">
						<input name="name" />
						<button>搜索</button>
					</form>
				
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
								年龄
							</td>
							<td>
								薪水
							</td>
							<td>
								性别
							</td>
							<td>
								生日
							</td>
							<td>
								民族
							</td>
							<td>
								籍贯
							</td>
							<td>
								出生地
							</td>
							<td>
								职位
							</td>
							<td>
								毕业院校
							</td>
							<td>
								学历
							</td>
							<td>
								毕业时间
							</td>
							<td>
								电话
							</td>
							<td>
								传真
							</td>
							<td>
								邮箱
							</td>
							<td>
								操作
							</td>
						</tr>
						<tr class="row${s.index % 2 + 1}">
							<td>
								${emp.id}
							</td>
							<td>
								${emp.name}
							</td>
							<td>
								${emp.password}
							</td>
							<td>
								${emp.age}
							</td>
							<td>
								${emp.salary}
							</td>
							<td>
								${emp.sex}
							</td>
							<td>
								${emp.birth}
							</td>
							<td>
								${emp.nation}
							</td>
							<td>
								${emp.nativePlace}
							</td>
							<td>
								${emp.birthPlace}
							</td>
							<td>
								${emp.job}
							</td>
							<td>
								${emp.college}
							</td>
							<td>
								${emp.academic}
							</td>
							<td>
								${emp.graduationDate}
							</td>
							<td>
								${emp.tel}
							</td>
							<td>
								${emp.fax}
							</td>
							<td>
								${emp.mail}
							</td>
							<td>
								<a href="delete.do?name=${emp.name}" 
								onclick="return confirm('确定删除${emp.name}吗?');">删除</a>&nbsp;
								<a href="load.do?name=${emp.name}"
								onclick="return confirm('确定修改${emp.name}吗?');">修改</a>
							</td>
						</tr>
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
                    <a>第${page}页</a>
                    <a href="list1.do?num=${num+20}">下一页</a>
                </div>
					<p>
						<input type="button" class="button" value="添加员工"
							onclick="location='addEmp.jsp'" />
							
					<input type="button"  class="button" value="返回"
						onclick="location='listEmp.do'" 
							align="right" style="position:absolute;
							right:60px; top:395px; height:25px; width:40px;"/>
					</p>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
