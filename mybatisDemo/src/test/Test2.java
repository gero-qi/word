package test;

 
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import school.Classes;
import school.Teacher;

import domain.User;

public class Test2 {

	@Test
	public void testGetUserCount(){
		SqlSession session = MyBatisUtil.getSession();
	String statement = "mapping.usermapping.getUser";
	/*			User user =session.selectOne(statement, 1);
		System.out.println(user);
		*/
		session.update("mapping.usermapping.updateUser","123214");
		 
		User  user= session.selectOne(statement,1);
		session.commit();
 
		session.close();
		System.out.println(user);
	}
	
}
