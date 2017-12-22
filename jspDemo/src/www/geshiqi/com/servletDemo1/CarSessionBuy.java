package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.config.Book;

public class CarSessionBuy extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Set<Book> list =   (Set<Book>) session.getAttribute("books");
		if(list==null || list.size()==0){
			out.write("您暂时没有买入任何商品");
			return;
		}
		out.write("您购买的额书籍如下</br><hr>");
		
		for(Book book : list){
			out.write(book.getName()+"</br>");
			System.out.println(book);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
