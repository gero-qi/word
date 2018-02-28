package com.department;

import java.util.List;

import domain.CrmDepartment;

public class DepartmentServiceImp implements DepartmentService {
	private DepartmentDao departdao;
	public void setDepartdao(DepartmentDao departdao) {
		this.departdao = departdao;
	}
	public List<CrmDepartment> findAllDep() {
		
		return departdao.findAllDep();
	}

}
