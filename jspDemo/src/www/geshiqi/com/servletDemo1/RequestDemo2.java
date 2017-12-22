package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//利用线程休眠防止表单提交		
		try{
			Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("提交一次");
		
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");
		String hiddenField = request.getParameter("hiddenField");
		String instStr="";
		//获取数组数据的机巧，可以避免insts数组weinull时引发的空指针异常错误：
		for(int i=0; insts!=null && i< insts.length; i++){
			if(i == insts.length-1){
				instStr+=insts[i];
			}else{
				instStr+=insts[i]+",";
				
			}
		}
		String htmlStr = "<table><tr><td>填写的编号：</td><td>{0}</td></tr>" +
				                             "<tr><td>填写的用户名：</td><td>{1}</td></tr>" +
				                             "<tr><td>填写的密码：</td><td>{2}</td></tr>" +
				                             "<tr><td>选中的性别：</td><td>{3}</td></tr>" +
				                             "<tr><td>选中的部门：</td><td>{4}</td></tr>" +
				                             "<tr><td>选中的兴趣：</td><td>{5}</td></tr>" +
				                             "<tr><td>填写的说明：</td><td>{6}</td></tr>" +
				                             "<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" +
				                         "</table>";
		htmlStr = MessageFormat.format(htmlStr, userid,username,userpass,sex,dept,instStr,note,hiddenField);
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		out.write(htmlStr.getBytes("UTF-8"));
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String parameName = paramNames.nextElement();
			String parameVale = request.getParameter(parameName);
			System.out.println(MessageFormat.format("{0}={1}", parameName,parameVale));
		}
		
		//request对象封装的参数是以map的形式存储的
//		Map<String ,String[]> parameMap = request.getParameterMap();
//		for(Map.Entry<String, String[]> entry:parameMap.entrySet()){
//			String paramName = entry.getKey();
//			String paramValue = "";
//			String[] paramValueArr = entry.getValue();
//			for (int i=0;paramValueArr!=null && i<paramValueArr.length;i++){
//				if(i==paramValueArr.length-1){
//					paramValue+=paramValueArr[i];
//				}else{
//					paramValue+=paramValueArr[i]+",";
//				}
//			}
//			System.out.println(MessageFormat.format("{0}={1}", paramName,paramValue));
//		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
