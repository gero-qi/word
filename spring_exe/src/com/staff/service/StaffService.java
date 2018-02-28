package com.staff.service;

import java.util.List;

import domain.CrmStaff;

 

public interface StaffService {


	public CrmStaff logins(CrmStaff staff);
	
	public List<CrmStaff> showStaff();
	
	public CrmStaff  findByStaffId(String StaffId);

	public void add(CrmStaff staff);

	public void updateStaff(CrmStaff staff);

	public void deleteStaff(CrmStaff staff);
}
