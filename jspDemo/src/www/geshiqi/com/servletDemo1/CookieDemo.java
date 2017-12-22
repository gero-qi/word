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

public class CookieDemo extends HttpServlet {

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
				out.write("您上次访问的是建是：");
				for(int i=0; i<cookies.length;i++){
					Cookie cookie = cookies[i];
					if(cookie.getName().equals("lastAccessTime")){
						Long lastAccessTime = Long.parseLong(cookie.getValue());
						Date date= new Date(lastAccessTime);
						DateFormat df = DateFormat.getDateTimeInstance();
						out.write(df.format(date));
					}
				}
			}else{
				out.write("这是您第一次访问本站");
			}
			Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
