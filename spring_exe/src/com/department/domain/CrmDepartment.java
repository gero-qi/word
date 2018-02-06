package com.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.post.domain.CrmPost;

public class CrmDepartment {
/*	create table crm_department( 
 * 						depId varchar(255) not null primary key,
						depName varchar(50) default Null 
			);*/
	private String depId;
	private String depName;
	//部门对职务，一对多  用set集合
	private Set<CrmPost> postSet = new HashSet<CrmPost>();
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Set<CrmPost> getPostSet() {
		return postSet;
	}
	public void setPostSet(Set<CrmPost> postSet) {
		this.postSet = postSet;
	}
	
}
