package com.staff.daoImp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.staff.dao.StaffDao;
import com.staff.domain.CrmStaff;

public class StaffDaoImp extends HibernateDaoSupport implements  StaffDao {

	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		List<CrmStaff> allStaff=this.getHibernateTemplate().find("from crm_staff where loginName=? and loginPwd=?",loginName,loginPwd);
		if(allStaff.size()==1){
			return allStaff.get(0);
		}
		return null;
	}



}
