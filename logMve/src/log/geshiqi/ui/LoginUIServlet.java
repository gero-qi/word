package log.geshiqi.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import log.geshi.domain.Users;
import log.geshi.service.UserServiceIF;
import log.geshi.service.UserServiceImp;

public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 UserServiceIF userService = new UserServiceImp();
			 request.setAttribute("name", name);
			 request.getRequestDispatcher("/index.jsp").forward(request, response);
		 
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
