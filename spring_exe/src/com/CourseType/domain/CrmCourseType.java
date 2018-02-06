package com.CourseType.domain;

import java.util.HashSet;
import java.util.Set;

import com.classes.domain.CrmClass;

public class CrmCourseType {
/*	CREATE TABLE `crm_course_type` (
			  `courseTypeId` varchar(255) NOT NULL PRIMARY KEY,
			  `courseCost` double DEFAULT NULL,
			  `total` int(11) DEFAULT NULL,
			  `courseName` varchar(500) DEFAULT NULL,
			  `remark` varchar(5000) DEFAULT NULL
			);*/
	private String courseTypeId;
	private double courseCost;
	private int  total;
	private String courseName;
	private String remark;
	
	private Set<CrmClass> classSet = new HashSet<CrmClass>();

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public double getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(double courseCost) {
		this.courseCost = courseCost;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<CrmClass> getClassSet() {
		return classSet;
	}

	public void setClassSet(Set<CrmClass> classSet) {
		this.classSet = classSet;
	}
	
}
