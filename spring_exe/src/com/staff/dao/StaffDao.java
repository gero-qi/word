package com.staff.dao;

import com.staff.domain.CrmStaff;

public interface StaffDao {
	public CrmStaff find(String loginName,String loginPwd);
}
