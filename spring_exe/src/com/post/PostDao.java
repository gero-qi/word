package com.post;

import java.util.List;

import domain.CrmDepartment;
import domain.CrmPost;

public interface PostDao {
	public List<CrmPost> findAll();
	
	public List<CrmPost> findAllByDep(CrmDepartment departmeng );

	public CrmPost findPostById(String postId);

 
}
