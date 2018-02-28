package com.staff.dao;

import java.util.List;

import domain.CrmStaff;

public interface StaffDao {
	public CrmStaff find(String loginName,String loginPwd);
	
	public List<CrmStaff> findAll();
	
	
	public CrmStaff findById(String staffId);

	public void addStaff(CrmStaff staff);

	public void updateStaff(CrmStaff staff);

	public void delete(CrmStaff staff);
}
