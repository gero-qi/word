<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.uname==null}">
	<c:redirect url="http://localhost:8080/jc-emp-m/login.jsp"></c:redirect>
</c:if>	
<html>
	<head>
		<title>员工管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			<script type="text/javascript">	
	     	//从cookie获取empId
     	//	var empId = getCookie("eid");
     	//	if(empId==null){
        // 	window.location.href="login.jsp";
     //	}
			</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1 style="color:red;">${search_error}</h1>
					<h1>
						员工列表
					</h1>
					
				<form action="search.do" method="post">
						<input name="name" />
						<button>搜索</button>
						<input type="button" onclick="location='listEmp.do'" value="返回" >
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
						<c:forEach items="${emp}" var="e" varStatus="s">
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
								${e.age}
							</td>
							<td>
								${e.salary}
							</td>
							<td>
								${e.sex}
							</td>
							<td>
								${e.birth}
							</td>
							<td>
								${e.nation}
							</td>
							<td>
								${e.nativePlace}
							</td>
							<td>
								${e.birthPlace}
							</td>
							<td>
								${e.job}
							</td>
							<td>
								${e.college}
							</td>
							<td>
								${e.academic}
							</td>
							<td>
								${e.graduationDate}
							</td>
							<td>
								${e.tel}
							</td>
							<td>
								${e.fax}
							</td>
							<td>
								${e.mail}
							</td>
							<td>
								<a href="delete.do?name=${e.name}" 
								onclick="return confirm('确定删除${e.name}吗?');">删除</a>&nbsp;
								<a href="load.do?name=${e.name}"
								onclick="return confirm('确定修改${e.name}吗?');">修改</a>
							</td>
						</tr>
						</c:forEach>
					</table>
				<!--分页-->
               <div align="center">
        	   		<c:choose>
                		<c:when test="${num>1}">
                  			<a href="list1.do?num=${num-5}">上一页</a>
                		</c:when>
                		<c:otherwise>
                  			<a>上一页</a>
                		</c:otherwise>
               		</c:choose>
               		
               		<%-- <c:forEach items="${page}" var="m" varStatus="s">
               		
               		</c:forEach> --%>
               		
					<c:forEach begin="1" end="${pages }" var="m" varStatus="s">
               			<c:choose>
               				<c:when test="${page==m}" >
               					<a href="list1.do?num=${(m-1)*5}" style="font-size: 20px">${m }</a>
               				</c:when>
               				<c:otherwise>
               					<a href="list1.do?num=${(m-1)*5}">${m }</a>
               				</c:otherwise>
               			</c:choose>
               		</c:forEach>
               		  
                    
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
