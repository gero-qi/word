$(function(){//页面加载完毕后执行
	$("#login").click(function(){
		//清除原有的提示信息
		$("#count_msg").html("");
		$("#password_msg").html("");
		//获取请求数据
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		//检查数据格式
		var ok=true;
		/*if(name==""){
			$("#count_msg").html("用户名不能为空");
			ok=false;
		}*/
		if(password==""){
			$("#password_msg").html("密码不能为空");
			ok=false;
		}
		if(ok){//发送Ajax请求
			$.ajax({
				url:"http://localhost:8080/jc-emp-m/login.do",
				type:"post",
				dataType:"json",
				data:{"name":name,"pwd":password},
				success:function(result){//result是服务器返回的json结果
					if(result.status==0){
						 //获取用户ID，写入Cookie
		                 //var empId = result.data;
		                 alert(result.name);
		                 //addCookie("eid",empId,2);//存储2小时
						 window.location.href="listEmp.do";
					}else if(result.status==1){
						$("#count_msg").html(result.msg);
					}else if(result.status==2){
						$("#password_msg").html(result.msg);
				}
			}
		});
	}
	});
});