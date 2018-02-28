package com.department;

import java.util.List;

import domain.CrmDepartment;

public interface DepartmentDao {
	public List<CrmDepartment> findAllDep();
	
}
