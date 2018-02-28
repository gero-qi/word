/** 
 * 通过部门select，级联显示职务
 * @param departmentObj  部门对象，this
 * @param postId 职务的select id,字符串数据，需要提供成员变量，是否回调函数中无法获得
 * @deprecated 处理比较麻烦，
 * 	1.回调函数获得postId
 * 	2.js文件中不能使用el函数
 */
function showPost(obj){
	var depId = obj.value;
	var depName = obj.name;
	alert(depName+"111111");
	var xmlhttp=null;
	if(window.XMLHttpRequest){
		xmlhttp= new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xmlhttp = new ActiveObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status ==200 ){
			var textData = xmlhttp.responseText;
			alert(textData);
			var jsonData = eval("("+textData+")");
			console.log(jsonData);
			alert(typeof jsonData);

			var postSelect = document.getElementById("postSelectId");
			postSelect.innerHTML = "<option value=''>----请选择------</oprion>";
			for(var i =0; i<jsonData.length;i++){
				var postObj = jsonData[i];
				var postId = postObj.postId;
				var postName = postObj.postName;
				postSelect.innerHTML +="<option value='"+post+"'>"+postName+"</option>"; 
			}
		}
	};
	var url="${pageContext.request.contextPath}/AjaxAction?crmDepartment.depId="+depId+"&crmDepartment.depName="+depName;
	xmlhttp.open("GET", url);
	xmlhttp.send(null);
}