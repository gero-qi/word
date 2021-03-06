package com.staff.serviceImp;

import java.util.List;

import Utils.GetUtills;

import com.staff.dao.StaffDao;
 
import com.staff.service.StaffService;

import domain.CrmStaff;

public class StaffServiceImp implements StaffService {
	private StaffDao staffDao;
	
	@Override
	public CrmStaff logins(CrmStaff staff) {
		System.out.println(staff.getLoginName()+"beforgetMd5");
		String loginPwdMd5=GetUtills.getMD5Value(staff.getLoginPwd());
		 System.out.println(loginPwdMd5);
		return staffDao.find(staff.getLoginName(),loginPwdMd5);
	}
	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	@Override
	public List<CrmStaff> showStaff(){
	 
		return  this.staffDao.findAll();
	}
	@Override
	public CrmStaff findByStaffId(String StaffId) {
		 
		return this.staffDao.findById(StaffId);
	}
	@Override
	public void add(CrmStaff staff) {
		this.staffDao.addStaff(staff);
		
	}
	@Override
	public void updateStaff(CrmStaff staff) {
		this.staffDao.updateStaff(staff);
		
	}
	@Override
	public void deleteStaff(CrmStaff staff) {
		this.staffDao.delete(staff);
		
	}
 


}
