package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {

 
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = "<h1><font color='red'>geshiqi</font></h1>";
		response.getOutputStream().write(data.getBytes());
		ServletContext context = this.getServletContext();//
		RequestDispatcher rd = context.getRequestDispatcher("/servlet/ServletDemo5");
		rd.forward(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		 
	}

}
