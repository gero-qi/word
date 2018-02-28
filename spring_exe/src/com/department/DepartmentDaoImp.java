package com.department;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.CrmDepartment;

public class DepartmentDaoImp extends HibernateDaoSupport implements DepartmentDao {

	public List<CrmDepartment> findAllDep() {
		
		return this.getHibernateTemplate().find("from CrmDepartment");
	}
	
}
