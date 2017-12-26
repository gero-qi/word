package www.geshiqi.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogServelt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submitFlag = request.getParameter("submitFlag");
		if("toLogin".equals(submitFlag))	{
			toLogin(request,response);
		}else if("login".equals(submitFlag)){
			login(request,response);
			return;
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		UserBean user= new UserBean();
		user.setName(name);
		user.setPassword(password);
		user.validate();
		if(user.login()){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		}else{
			request.setAttribute("user", user);
			toLogin(request,response);
		}
		
	}

	private void toLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/log.jsp").forward(request, response);
		
	}
	

}
