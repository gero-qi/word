package log.geshi.service;

import log.geshi.domain.Users;

public interface UserServiceIF {
	//ע�Ṧ��
	void registerUser(Users user);
	//��¼����
	boolean loginUser(String name,String password);
	
}
