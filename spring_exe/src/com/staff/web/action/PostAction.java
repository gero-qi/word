package com.staff.web.action;



import java.util.List;

import com.department.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.post.PostService;

import domain.CrmDepartment;
import domain.CrmPost;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {
	/**
	 * 
	 */
	 
	private CrmPost post= new CrmPost();
	public void setPost(CrmPost post) {
		this.post = post;
	}

	@Override
	public CrmPost getModel() {
		// TODO Auto-generated method stub
		return post;
	}
	private PostService postService;
	public void setPostService(PostService postService){
		 this.postService =postService;
	}
	
	private DepartmentService depservice;
	public void setDepartmentService(DepartmentService depservice){
		this.depservice=depservice;
	}

	public String findAllPost(){
		List<CrmPost> allpost = postService.findAllPost();
		ActionContext.getContext().put("allpost", allpost);
		return "listPost";
	}
	
	public String posteditUI(){
 		CrmPost crmpost = postService.findPostById(post.getPostId());
		ActionContext.getContext().put("crmpost", crmpost); 
 		List<CrmDepartment> alldep = depservice.findAllDep();
		ActionContext.getContext().put("alldep", alldep); 
		return "addOrEditPost";
	}
	
	public String edit(){
	 
		postService.updateModel(post);
		return "update";
	}
	
	
	
}
