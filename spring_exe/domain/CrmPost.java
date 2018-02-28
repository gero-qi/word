package domain;

import java.util.Set;

/**
 * CrmPost entity. @author MyEclipse Persistence Tools
 */
public class CrmPost extends AbstractCrmPost implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CrmPost() {
	}

	/** full constructor */
	public CrmPost(CrmDepartment crmDepartment, String postName, Set crmStaffs) {
		super(crmDepartment, postName, crmStaffs);
	}

}
