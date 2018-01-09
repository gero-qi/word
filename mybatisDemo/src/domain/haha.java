package domain;

import org.apache.ibatis.annotations.Select;

public interface haha {
	@Select("select * from user where id=#{id}")
	public User getUser(int id);
}
