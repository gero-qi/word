package com.staff.serviceImp;

import com.staff.dao.StaffDao;
import com.staff.domain.CrmStaff;
import com.staff.service.StaffService;

public class StaffServiceImp implements StaffService {
	private StaffDao staffDao;
	
	@Override
	public CrmStaff login(CrmStaff staff) {
		return staffDao.find(staff.getLoginName(),staff.getLoginPwd());
	}
	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
 


}
