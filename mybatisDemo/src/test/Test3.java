package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;



import domain.MyBatisUser; 

public class Test3 {
@Test
public void test(){
SqlSession session= MyBatisUtil.getSession();
String statement = "mapping.mappingMyUser.getUser";
MyBatisUser user = session.selectOne(statement,1);
System.out.println(user);
	} 
}
