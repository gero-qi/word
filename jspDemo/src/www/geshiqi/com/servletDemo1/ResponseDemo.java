package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//outputChineseByOutputStream(response);
			printWriter(response);
	}

 
	private void outputChineseByOutputStream(HttpServletResponse response) throws IOException {
		String data = "全世界都说中国话";
		OutputStream op = response.getOutputStream();
		response.setHeader("content-type", "text/html;charset=utf-8");
		byte[] dataByteArr = data.getBytes("utf-8");
		op.write(dataByteArr);
	}
	private void printWriter(HttpServletResponse response) throws IOException{
		String data = "我说中国话";
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//out.write("<meta http-equiv='content-type' content='text/html;charset=utf-8'");
		out.write(data);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
 
}
