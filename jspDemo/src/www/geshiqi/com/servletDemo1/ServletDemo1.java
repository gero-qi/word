package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {
	public void  doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		request.getRequestDispatcher("/WEB-INF/lib/UserBean1.jsp").forward(request, response);
		 
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
