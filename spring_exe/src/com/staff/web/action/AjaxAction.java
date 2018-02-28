package com.staff.web.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.post.PostService;

import domain.CrmDepartment;
import domain.CrmPost;

public class AjaxAction extends ActionSupport implements ModelDriven<CrmPost> {
	private CrmPost crmpost = new CrmPost();
	@Override
	public CrmPost getModel() {
 
		return crmpost;
	}

	private PostService postService;
 
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	 
	public String changePost() throws IOException{
		System.out.println(crmpost.getCrmDepartment());
		List<CrmPost> posts= this.postService.findPostBydep(crmpost.getCrmDepartment());
		System.out.println(posts);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"crmDepartment","crmStaffs"});
		String jsonData = JSONArray.fromObject(posts,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonData);
		return "none";
		}


	}
	

 
