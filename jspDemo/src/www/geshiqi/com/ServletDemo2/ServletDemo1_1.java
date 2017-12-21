package www.geshiqi.com.ServletDemo2;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1_1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data ="¸ðÊ¿ì÷";
		ServletContext context = this.getServletContext();
		context.setAttribute("data", data);
		
		response.setHeader("content-type","text/html;charset=utf-8");
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("utf-8"));
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
