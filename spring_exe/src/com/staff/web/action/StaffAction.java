package com.staff.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.staff.domain.CrmStaff;
import com.staff.service.StaffService;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
	private CrmStaff staff = new CrmStaff();
	@Override
	public CrmStaff getModel() {
		
		// TODO Auto-generated method stub
		return staff ;
	}
	private StaffService staffservice;
	public void setStaffservice(StaffService staffservice) {
		this.staffservice = staffservice;
	}
	
	public String login(){
		CrmStaff findedStaff= staffservice.login(staff); 
		
		
	}
}
