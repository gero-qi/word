package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> HeadInfos = request.getHeaderNames();
		out.write("获得呵护短所有请求头信息如下</br>");
		while(HeadInfos.hasMoreElements()){
			String HeadName = (String) HeadInfos.nextElement();
			String Headvalue = (String) request.getHeader(HeadName);
			out.write(HeadName + "  :   " + Headvalue+"</br>");	
		}
		out.write("获取客户端Accpt-Encoding请求头的值：</br>");
		Enumeration<String> e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String string = (String) e.nextElement();
			out.write(string);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
