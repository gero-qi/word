package com.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.department.domain.CrmDepartment;
import com.staff.domain.CrmStaff;

public class CrmPost {
	/*create table crm_post(
			postId varchar(255) not null primary key,
			postName varchar(255) not null,
			depId varchar(255) default null,
			constraint foreign key (depId) reference crm_department (depId)
			);*/
	
	private String postId;
	private String postName;
	private String depId;
	//多个职务对应一个部门     
	private CrmDepartment department;
	//一个职务可以有多个员工
	private Set<CrmStaff> staffSet = new HashSet<CrmStaff> ();
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public CrmDepartment getDepartment() {
		return department;
	}
	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}
	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}
	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}
	
}
