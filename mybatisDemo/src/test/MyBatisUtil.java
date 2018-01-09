
package test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisUtil {
	
	
	 
	public static  SqlSession getSession(){
		return getSqlSessionFactory().openSession();
	}
	
	public static SqlSession getSession(boolean isAutoCommit){
		return getSqlSessionFactory().openSession(isAutoCommit);
	}

	private static SqlSessionFactory getSqlSessionFactory() {
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}
}
