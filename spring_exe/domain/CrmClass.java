package domain;

import java.sql.Timestamp;

/**
 * CrmClass entity. @author MyEclipse Persistence Tools
 */
public class CrmClass extends AbstractCrmClass implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CrmClass() {
	}

	/** full constructor */
	public CrmClass(CrmCourseType crmCourseType, String name,
			Timestamp beginTime, Timestamp endTime, String status,
			Integer totalCount, Integer upgradeCount, Integer changeCount,
			Integer runoffCount, String remark, Timestamp uploadTime,
			String uploadPath, String uploadFilename) {
		super(crmCourseType, name, beginTime, endTime, status, totalCount,
				upgradeCount, changeCount, runoffCount, remark, uploadTime,
				uploadPath, uploadFilename);
	}

}
