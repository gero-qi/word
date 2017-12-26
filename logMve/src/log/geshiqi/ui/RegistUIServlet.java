package log.geshiqi.ui;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import log.geshi.domain.Users;
import log.geshi.service.UserServiceIF;
import log.geshi.service.UserServiceImp;

public class RegistUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("0.0");
		Users user =new Users();
		String[] a = new String[3];
		Enumeration enu = request.getParameterNames();
		int i =0;
		while(enu.hasMoreElements()){
			 a[i]= (String) enu.nextElement();
					 i++;
					 System.out.println(i);
		}
		user.setName(a[0]);
		user.setPassword(a[1]);
		user.setEmail(a[2]);
		UserServiceIF usi = new  UserServiceImp();
		usi.registerUser(user);
		request.getRequestDispatcher(request.getContextPath()+"/log.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
