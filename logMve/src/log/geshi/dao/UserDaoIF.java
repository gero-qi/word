package log.geshi.dao;

import log.geshi.domain.Users;

public interface UserDaoIF {
	//�������ֺ������������û��Ǵ��ڣ������ز鵽���û� 
	boolean find(String name, String password );
	//���һ���û�
	void add(Users user);
	//�����û���
	boolean find(String name);
	
}
