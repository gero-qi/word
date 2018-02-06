package com.staff.domain;

import java.util.Date;

import com.post.domain.CrmPost;

public class CrmStaff {
/*create table crm_staff(
		staffId varchar(255) not null primary key,
		loginName varchar(255) default null,
		loginPwd varchar(100) default null,
		staffName varchar（100） default null,
		gender varchar(20) default null,
		onDutyDate datetime default null,
		postId varchar(255) default null,
		constraint foreign key(postId) references crm_post (postId)
		);	*/
	private String staffId;
	private String loginName;
	private String loginPwd;
	private String staffName;
	private String gender;
	private String onDutyDate;
	private Date postId;
	//多名员工对应一个职务
	private CrmPost post;
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOnDutyDate() {
		return onDutyDate;
	}
	public void setOnDutyDate(String onDutyDate) {
		this.onDutyDate = onDutyDate;
	}
	public Date getPostId() {
		return postId;
	}
	public void setPostId(Date postId) {
		this.postId = postId;
	}
	public CrmPost getPost() {
		return post;
	}
	public void setPost(CrmPost post) {
		this.post = post;
	}
	
	
}
