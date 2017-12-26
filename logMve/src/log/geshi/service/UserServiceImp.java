package log.geshi.service;

import log.geshi.dao.UserDaoIF;
import log.geshi.dao.UserDaoImpl;
import log.geshi.domain.Users;

public class UserServiceImp implements UserServiceIF {
	private UserDaoIF userDao = new UserDaoImpl();
	
	public void registerUser(Users user) {
		System.out.println(user);
		try{
		if(userDao.find(user.getName())){
			throw new Exception("注册的用户名已经存在");
		}else{
			
		userDao.add(user);
		}}catch(Exception e){
			e.printStackTrace();
		}
		

	}

	public boolean loginUser(String name, String password) {
		System.out.println(name+""+password);
		try{
			if(userDao.find(name, password)){
				
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}

}
