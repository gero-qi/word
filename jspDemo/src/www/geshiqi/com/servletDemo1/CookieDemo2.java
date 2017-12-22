package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Cookie[] cookie =request.getCookies();
			for(int i =0; i<cookie.length;i++){
				 if("LastAccessTime".equals(cookie[i].getName())){
					 String lastaccesstime = cookie[i].getValue();
					 Date date = new Date(Long.parseLong(lastaccesstime));
					 DateFormat df = DateFormat.getDateTimeInstance();
					 String dateq = df.format(date);
					 out.write(dateq);
				 }
			}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
