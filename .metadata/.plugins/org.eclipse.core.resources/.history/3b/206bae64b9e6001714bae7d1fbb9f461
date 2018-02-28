package www.geshiqi.com.ServletDemo2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4_4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data="<h1>this is ServeltDemo4_4 request</h1>";
		response.getWriter().print(data);
		request.setAttribute("from", "i come from ServletDemo4_4");
		ServletContext context= this.getServletContext();
		RequestDispatcher fd = context.getRequestDispatcher("/servlet/ServeltDemo5_5");
		fd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
