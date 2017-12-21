package www.geshiqi.com.servletDemo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseAndCheckImage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkcode=request.getParameter("validateCode");
		String checkcodeSession = (String) request.getSession().getAttribute("checkcode");
		if (checkcodeSession.equals(checkcode)){
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else {
			response.sendError(404);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
