package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.config.Book;
import db.config.DBbook;

public class CSessionDemo3 extends HttpServlet {

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.getSession();
		out.write("本网站有书如下：</b><hr>");
		Set<Map.Entry<String, Book>> set = DBbook.getAll().entrySet();
		for(Map.Entry<String, Book> me:set){
			Book book = me.getValue();
			String url = request.getContextPath()+"/servlet/CBuySession?id="+book.getId();
			url = response.encodeUrl(url);
			out.println(book.getName()+"<a href='"+url+"'>购买</a><br/>");
		}
		String urlcar = request.getContextPath()+"/servlet/CarSessionBuy";
		out.println("<a href='"+urlcar+"'>购物车</a><br/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
