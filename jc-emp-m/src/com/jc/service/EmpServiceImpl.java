package com.jc.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.jc.dao.EmpDao;
import com.jc.entity.Emp;
import com.jc.entity.NoteResult;
@Service //扫描service组件
public class EmpServiceImpl implements EmpService{

	@Resource
	private EmpDao empDao;
	int page=0;
	int pages=0;
	 
	//登录
	public NoteResult checkLogin(String name, String pwd,HttpServletRequest request) {
		NoteResult result=new NoteResult();
		Emp emp =empDao.findByName(name);
		if(emp==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		else if(!pwd.equals(emp.getPassword())){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		else if(name.equals(emp.getName()) && pwd.equals(emp.getPassword())){
			HttpSession session=request.getSession();
			//使用session绑定姓名
			session.setAttribute("uname",name);
			result.setStatus(0);
			result.setMsg("登录成功");
		//	result.setData(emp.getId());//获取员工ID
			return result;
		}
		return result;
	}
	//删除
	public void toDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		empDao.delete(name);
		response.sendRedirect("listEmp.do");
	}
@Test
 	public int findRows(){
		int r=empDao.findRows();
		return r;
	} 
	//查询所有  员工表
	public void toFindAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num=0;
		//页数
		pages=(findRows()-1)/5+1;
		int page=num/5+1;
		try{
			List<Emp> emp=empDao.findPage(num);
			//绑定数据
			request.setAttribute("emp",emp);
			request.setAttribute("num",num);
			request.setAttribute("page",page);
			request.setAttribute("pages",pages);
			//转发
			request.getRequestDispatcher("listEmp.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	//分页
	public void toFindPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//从listEmp中获取num 
		pages=(findRows()-1)/5+1;
		int num=Integer.parseInt(request.getParameter("num"));
		int page=num/5+1;
		System.out.println(pages+""+page);
		request.setAttribute("page",page);
		request.setAttribute("pages",pages);
		try{
			List<Emp> emp=empDao.findPage(num);
			if(!emp.isEmpty()){//数据非空
				//绑定数据
				request.setAttribute("emp",emp);
				request.setAttribute("num",num);
				
				//转发
				request.getRequestDispatcher("listEmp.jsp").forward(request, response);
			}else{
				response.sendRedirect("listEmp.do");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	//增加
	public void toSave(HttpServletResponse response,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		String nation=request.getParameter("nation");
		String nativePlace=request.getParameter("nativePlace");
		String birthPlace=request.getParameter("birthPlace");
		String job=request.getParameter("job");
		String college=request.getParameter("college");
		String academic=request.getParameter("academic");
		String graduationDate=request.getParameter("graduationDate");
		String tel=request.getParameter("tel");
		String fax=request.getParameter("fax");
		String mail=request.getParameter("mail");
		Emp user=empDao.findByName(name);
		try{
			if (user!=null ) {
				request.setAttribute("msg", "用户名已经存在");
				request.getRequestDispatcher("addEmp.jsp").forward(request,response);
				return;
			}else{
				//判断是否完善信息
				if(name=="" || pwd=="" || age=="" || salary==""){
					request.setAttribute("as_error","请完善信息！");
					request.getRequestDispatcher("addEmp.jsp").forward(request, response);
					return;
				}
			}
			Emp emp=new Emp();
			emp.setName(name);
			emp.setPassword(pwd);
			emp.setAge((Integer.parseInt(age)));
			emp.setSalary(Double.parseDouble(salary));
			emp.setSex(sex);
			emp.setBirth(birth);
			emp.setNation(nation);
			emp.setNativePlace(nativePlace);
			emp.setBirthPlace(birthPlace);
			emp.setJob(job);
			emp.setCollege(college);
			emp.setAcademic(academic);
			emp.setGraduationDate(graduationDate);
			emp.setTel(tel);
			emp.setFax(fax);
			emp.setMail(mail);
			empDao.save(emp);
			response.sendRedirect("listEmp.do");
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	//修改
	public void toLoad(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso8859-1"),"utf-8");
		Emp emp = empDao.findByName(name);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
	}	
	public void toUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		String nation=request.getParameter("nation");
		String nativePlace=request.getParameter("nativePlace");
		String birthPlace=request.getParameter("birthPlace");
		String job=request.getParameter("job");
		String college=request.getParameter("college");
		String academic=request.getParameter("academic");
		String graduationDate=request.getParameter("graduationDate");
		String tel=request.getParameter("tel");
		String fax=request.getParameter("fax");
		String mail=request.getParameter("mail");
		try {
			Emp emp = new Emp();
			emp.setName(name);
			emp.setPassword(password);
			emp.setAge(Integer.parseInt(age));
			emp.setSalary(Double.parseDouble(salary));
			emp.setSex(sex);
			emp.setBirth(birth);
			emp.setNation(nation);
			emp.setNativePlace(nativePlace);
			emp.setBirthPlace(birthPlace);
			emp.setJob(job);
			emp.setCollege(college);
			emp.setAcademic(academic);
			emp.setGraduationDate(graduationDate);
			emp.setTel(tel);
			emp.setFax(fax);
			emp.setMail(mail);
			empDao.update(emp);
			response.sendRedirect("listEmp.do");
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	//搜索
	public void toSearch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		Emp emp=empDao.findByName(name);
		try{
			if(emp==null){//查不到数据
				request.setAttribute("search_error","非常抱歉，您要找的人不存在！");
				request.getRequestDispatcher("listEmp.jsp").forward(request, response);
			}else{
				request.setAttribute("emp",emp);
				request.getRequestDispatcher("listSearch.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
	
}
