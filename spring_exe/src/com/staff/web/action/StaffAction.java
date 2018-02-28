package com.staff.web.action;


import java.util.List;

import Utils.GetUtills;

import com.department.DepartmentService;
import com.department.DepartmentServiceImp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.post.PostService;
import com.staff.dao.StaffDao;
import com.staff.daoImp.StaffDaoImp;
import com.staff.service.StaffService;

import domain.CrmDepartment;
import domain.CrmStaff;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
	//封装数据
	private CrmStaff staff = new CrmStaff();
	@Override
	public CrmStaff getModel() {
		return staff ;
	}
	
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	private StaffService staffService;
	private DepartmentService departmentService;


	public void setDepartmentService(DepartmentServiceImp departmentService) {
		this.departmentService = departmentService;
	}


	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
 
	
	/**
	 * 员工登录
	 * @return
	 */
	public String login(){
		 
		//1 查询员工
		CrmStaff findStaff = staffService.logins(staff);
		//2 是否成功
		System.out.println(findStaff+"test");
		if(findStaff != null){
			//成功
			// 3.1 session作用域保存数据
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			// 3.2 重定向首页 -- xml配置
			return "success";
		} 
	 
		//4 不成功
		this.addFieldError("", "用户名与密码不匹配");
		// * 请求转发显示
		return "login";
	}
	
 
	public String home(){
		System.out.println("home");
		return "home";
	}
	
	public String remove(){
		ActionContext.getContext().getSession().remove("loginStaff");
		return "login";
	}
	
	public String findAllStaff(){
		
		List<CrmDepartment> editDepartment =  this.departmentService.findAllDep();
		ActionContext.getContext().put("editDepartment", editDepartment);
		
		
		List<CrmStaff> allstaff= this.staffService.showStaff();
		ActionContext.getContext().put("allstaff", allstaff);
		 
		return "showStaff";
	}
	
	public String editUI(){
		String StaffId = staff.getStaffId();
		CrmStaff editStaff=   this.staffService.findByStaffId(StaffId);
		ActionContext.getContext().getValueStack().set("editStaff", editStaff);
		List<CrmDepartment> editDepartment =  this.departmentService.findAllDep();
		ActionContext.getContext().put("editDepartment", editDepartment);
		return "editjsp";
	}
	public String  add(){
		System.out.println(staff+"before add" );
		this.staffService.add(staff);
		return "afterAdd";
	}
	 
	public String edit(){
		this.staff.setLoginPwd(GetUtills.getMD5Value(staff.getLoginPwd()));
		this.staffService.updateStaff(staff);
		return "findAllStaff";
	}
 
	public String addUI(){
		System.out.println("method++++++addUI");
		List<CrmDepartment> editDepartment =  this.departmentService.findAllDep();
		ActionContext.getContext().put("editDepartment", editDepartment);
		return "addjsp";
	}
	public String deleteStaff(){
		this.staffService.deleteStaff(this.staff);
		return "afterAdd";
	}
	
	public String findLimit(){
		List<CrmDepartment> editDepartment =  this.departmentService.findAllDep();
		ActionContext.getContext().put("editDepartment", editDepartment);
		
		
		return "showStaff";
		
	}
}
