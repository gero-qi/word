package domain;

import java.util.Set;

/**
 * CrmCourseType entity. @author MyEclipse Persistence Tools
 */
public class CrmCourseType extends AbstractCrmCourseType implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CrmCourseType() {
	}

	/** full constructor */
	public CrmCourseType(Double courseCost, Integer total, String courseName,
			String remark, Set crmClasses) {
		super(courseCost, total, courseName, remark, crmClasses);
	}

}
