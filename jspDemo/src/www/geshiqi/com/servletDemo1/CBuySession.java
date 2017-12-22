package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.config.Book;
import db.config.DBbook;

public class CBuySession extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Book book = DBbook.getAll().get(id);
		HttpSession session = request.getSession();
		
		Set<Book> list =  (Set<Book>) session.getAttribute("books");
		if(list==null){
			list = new HashSet<Book>();
			session.setAttribute("books", list);
		}
		list.add(book);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
