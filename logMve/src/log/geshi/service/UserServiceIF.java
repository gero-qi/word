package log.geshi.service;

import log.geshi.domain.Users;

public interface UserServiceIF {
	//注册功能
	void registerUser(Users user);
	//登录功能
	boolean loginUser(String name,String password);
	
}
