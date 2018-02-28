package com.post;

import java.util.List;

import domain.CrmDepartment;
import domain.CrmPost;

public interface PostService {
	public List<CrmPost> findAllPost();
	
	public List<CrmPost> findPostBydep(CrmDepartment department	);

	public CrmPost findPostById(String postId);

	public void updateModel(CrmPost post);
}
