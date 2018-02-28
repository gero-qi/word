package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * CrmCourseType entity. @author MyEclipse Persistence Tools
 */

public class CrmCourseType implements java.io.Serializable {

	// Fields

	private String courseTypeId;
	private Double courseCost;
	private Integer total;
	private String courseName;
	private String remark;
	private Set crmClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CrmCourseType() {
	}

	/** full constructor */
	public CrmCourseType(Double courseCost, Integer total, String courseName,
			String remark, Set crmClasses) {
		this.courseCost = courseCost;
		this.total = total;
		this.courseName = courseName;
		this.remark = remark;
		this.crmClasses = crmClasses;
	}

	// Property accessors

	public String getCourseTypeId() {
		return this.courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public Double getCourseCost() {
		return this.courseCost;
	}

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getCrmClasses() {
		return this.crmClasses;
	}

	public void setCrmClasses(Set crmClasses) {
		this.crmClasses = crmClasses;
	}

}