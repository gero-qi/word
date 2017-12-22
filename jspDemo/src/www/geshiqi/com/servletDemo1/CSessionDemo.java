package www.geshiqi.com.servletDemo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CSessionDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("username", "geshiqi");
		String sessionId = session.getId();
		if(session.isNew()){
			response.getWriter().write("session创建成功，session的id是："+sessionId);
			response.getWriter().print("session has already exist");
		}else{
			response.getWriter().print("session has already exist");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
