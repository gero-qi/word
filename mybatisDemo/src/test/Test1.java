package test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.User;

public class Test1 {
public static void main (String[] args){
	
	InputStream is = Test1.class.getClassLoader().getResourceAsStream("conf.xml");
	
	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	System.out.println("111");
	SqlSession session = sessionFactory.openSession();
	int i=1;
	User user= session.selectOne("getUser",i);
	System.out.println(user);
}
}
