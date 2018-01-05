package com.jc.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.jc.entity.tOil;
import com.jc.util.MyBatisUtil;

public class ActionServlet extends HttpServlet {

	 

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取请求资源
		String uri = request.getRequestURI();
		System.out.println(uri);
		// 分析请求路径，截取需要的部分
		String action = uri.substring(uri.lastIndexOf("/") + 1,
				uri.lastIndexOf("."));
		System.out.println(action);
		// 连接数据库
		SqlSession session1 = MyBatisUtil.getSqlSession();
		//页数
		
		List<Object> acount=session1.selectList("findRows");
			int rowss= (Integer) acount.get(0) ;
			int pages= rowss/5 +1;
			int j=0;
			Map<Integer, Integer> tmap = new LinkedHashMap<Integer, Integer>();
			for(int i=1 ;i<=pages ;i++){
				j = (i-1)*5;
				tmap.put(i, j);
			}
			request.getSession().setAttribute("pagess", tmap);
			
		
		System.out.println(action);
		int page=0;
		// 查看员工列表
		if ("list".equals(action)) {
			int num=0;
			page=num/20+1;
	 
			try {
				 
				List<tOil> emp = session1.selectList("findPage",num);
				//把值绑定到request上
				request.setAttribute("emp", emp);
				request.setAttribute("num", num);
				request.setAttribute("page",page);
				//获取数据库中总记录数
 
 				 
				request.getRequestDispatcher("listEmp.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				//使用声明式处理异常，将异常抛给容器
				throw new ServletException(e);
			}finally{
				session1.close();
			}	
		} 
		else if("list1".equals(action)){
			System.out.println(request.getSession().getAttribute("pages"));
				//获取listEmp中的num
				int num=Integer.parseInt(request.getParameter("num"));
				//页数
				page=num/5+1;
				//将页数绑定到request上
				request.setAttribute("page",page);
				
 				
			try{
				List<tOil> emp=session1.selectList("findPage",num);
				//判断数据库中的数据
				if(!emp.isEmpty()){//有数据
					request.setAttribute("num",num);
					request.setAttribute("emp",emp);
					request.getRequestDispatcher("listEmp.jsp").forward(request, response);
				}else{
					response.sendRedirect("list.do");
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}
		}
		// 增
		else if ("add".equals(action)) {
			// 获取用户输入的信息
			String oilname = request.getParameter("oilname");
			String company = request.getParameter("company");
			String firm = request.getParameter("firm");
			String opentime = request.getParameter("opentime");
			String fromcity=request.getParameter("fromcity");
			String tocity=request.getParameter("tocity");
			String provinces=request.getParameter("provinces");
			Double oillength=Double.valueOf(request.getParameter("oillength"));
			Double capacity=Double.valueOf(request.getParameter("capacity"));
			Double pressue=Double.valueOf(request.getParameter("pressue"));
			Double temperature=Double.valueOf(request.getParameter("temperature"));
			Double diameter=Double.valueOf(request.getParameter("diameter"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
					//添加数据
					tOil emp = new tOil();
					emp.setOilname(oilname);
					emp.setCompany(company);
					emp.setFirm(firm);
					emp.setOpentime(sdf.parse(opentime));
					emp.setFromcity(fromcity);
					emp.setTocity(tocity);
					emp.setProvinces(provinces);
					emp.setOillength(oillength);
					emp.setCapacity(capacity);
					emp.setPressue(pressue);
					emp.setTemperature(temperature);
					emp.setDiameter(diameter);
					//讲数据插入到数据库
					session1.insert("save", emp);
					//提交数据
					session1.commit();
					response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}
		}
		// 删
		else if ("delete".equals(action)) {
			try {
				String id = request.getParameter("id");
				session1.delete("delete",id);
				session1.commit();
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}
		} 
		else if ("load".equals(action)) {
			try {
				String id = request.getParameter("id");
				//默认为get请求，为了避免乱码问题
//				name=new String(name.getBytes("iso-8859-1"),"utf-8"); 
				tOil emp = session1.selectOne("findById", id);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				emp.setStrDate(sdf.format(emp.getOpentime()));
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("updateEmp.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}
		}
		//搜索
		else if("search".equals(action)){
			String oilname=request.getParameter("name");
			String company=request.getParameter("company");
			String provinces=request.getParameter("provinces");
			List<tOil> emp = null;
			if(oilname!=""&&oilname!=null){
				emp =session1.selectList("findByName",oilname);
			}
			if(company!=""&&company!=null){
				emp =session1.selectList("findByCompany",company);
			}
			if(provinces!=""&&provinces!=null){
				emp =session1.selectList("findByProvinces",provinces);
			}
			
			try{//搜索的人不在数据库中
				if(emp==null){
					request.setAttribute("search_error","非常抱歉，您要找的人不存在！");
					request.getRequestDispatcher("listEmp.jsp").forward(request, response);
				}else{
					request.setAttribute("emp",emp);
					request.getRequestDispatcher("listSearch.jsp").forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}
		}
		//计算运力
		else if("count".equals(action)){
			String countSize=request.getParameter("countSize");
			if(countSize!=null){
				String[] arrIds = countSize.split(",");
				String ids = "";
				tOil oil = null;
				Double sizeCount = 0.0;
				for(int i=0;i<arrIds.length;i++){
					oil = session1.selectOne("findById",arrIds[i]);
					sizeCount += oil.getCapacity();
				}
//				String oilname = "("+ids.substring(0,ids.length()-1)+")";
//				System.out.println(oilname);
//				List<tOil> list = session1.selectList("findIds",oilname);
//				Double capacity = 0.0;
//				for(int i=0;i<list.size();i++){
//					capacity += list.get(i).getCapacity();
//				}
				System.out.println(sizeCount);
				try{//搜索的人不在数据库中
						request.setAttribute("sizeCount",sizeCount);
						request.getRequestDispatcher("list.do").forward(request, response);
				}catch(Exception e){
					e.printStackTrace();
					throw new ServletException(e);
				}finally{
					session1.close();
				}
			}else{
				request.getRequestDispatcher("list.do").forward(request, response);
			}
			
		}
		//修改
		else if ("modify".equals(action)) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 获取修改文本框中的数据
			String id = request.getParameter("id");
			String oilname = request.getParameter("oilname");
			String company = request.getParameter("company");
			String firm = request.getParameter("firm");
			Date opentime = null;
			if(!"".equals(request.getParameter("opentime"))){
				try {
					opentime = sdf.parse(request.getParameter("opentime"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String fromcity=request.getParameter("fromcity");
			String tocity=request.getParameter("tocity");
			String provinces=request.getParameter("provinces");
			Double oillength=null;
			if(!"".equals(request.getParameter("oillength"))){
				oillength = Double.valueOf(request.getParameter("oillength"));
				
			}
			Double capacity=null;
			if(!"".equals(request.getParameter("capacity"))){
				capacity = Double.valueOf(request.getParameter("capacity"));
			}
			Double pressue=null;
			if(!"".equals(request.getParameter("pressue"))){
				pressue = Double.valueOf(request.getParameter("pressue"));
			}
			Double temperature=null;
			if(!"".equals(request.getParameter("temperature"))){
				temperature = Double.valueOf(request.getParameter("temperature"));
			}
			Double diameter=null;
			if(!"".equals(request.getParameter("diameter"))){
				diameter = Double.valueOf(request.getParameter("diameter"));
			}
			
			try {
				tOil emp = new tOil();
				emp.setId(Integer.valueOf(id));
				emp.setOilname(oilname);
				emp.setCompany(company);
				emp.setFirm(firm);
				emp.setOpentime(opentime);
				emp.setFromcity(fromcity);
				emp.setTocity(tocity);
				emp.setProvinces(provinces);
				emp.setOillength(oillength);
				emp.setCapacity(capacity);
				emp.setPressue(pressue);
				emp.setTemperature(temperature);
				emp.setDiameter(diameter);
				session1.update("update", emp);
				session1.commit();
				//重定向
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}
		}
		// 登录前进行验证
		else if ("login".equals(action)) {
			// 比较验证码是否正确
			// 先获得输入的验证码
			System.out.println("111");
			String number_input = request.getParameter("number");
			System.out.println("输入的验证码:"+number_input);
			// 再获得页面生成的验证码
			HttpSession session = request.getSession();
			String number_out = (String) session.getAttribute("number");
			System.out.println("页面生成的验证码:"+number_out);
/*			try{
				//验证验证码
				if (!number_input.equalsIgnoreCase(number_out)) {
					// 验证码错误
					request.setAttribute("number_error", "验证码错误！");
					request.getRequestDispatcher("login.do").forward(request, response);
					return;
				}*/
				// 获取输入的用户名和密码
//				String name=request.getParameter("name");
//				session.setAttribute("name", name);
				// System.out.println(name);
//				String pwd = request.getParameter("password");
				// System.out.println(pwd);
				// 依据用户名和密码，查询数据库中是够有对应记录
//				tOil emp=session1.selectOne("findByName",name);
//				if(emp!=null && emp.getPassword().equals(pwd)){
					// 重定向到员工表
					response.sendRedirect("list.do");
//				}else {
//					request.setAttribute("str_error", "用户名或密码错误！");
//					request.getRequestDispatcher("login.jsp").forward(request, response);	
//					}
/*			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}finally{
				session1.close();
			}*/

		}

	}

}
