package log.geshi.dao;

import log.geshi.domain.Users;

public interface UserDaoIF {
	//根据名字和密码来查找用户是存在，并返回查到的用户 
	boolean find(String name, String password );
	//添加一个用户
	void add(Users user);
	//根据用户名
	boolean find(String name);
	
}
