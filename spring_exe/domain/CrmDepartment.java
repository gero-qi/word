package domain;

import java.util.Set;

/**
 * CrmDepartment entity. @author MyEclipse Persistence Tools
 */
public class CrmDepartment extends AbstractCrmDepartment implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CrmDepartment() {
	}

	/** full constructor */
	public CrmDepartment(String depName, Set crmPosts) {
		super(depName, crmPosts);
	}

}
