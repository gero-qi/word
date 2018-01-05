package com.jc.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public static SqlSession getSqlSession(){
		
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//加载SqlMapConfig.xml文件
		String conf="SqlMapConfig.xml";
		 
		InputStream instr=MyBatisUtil.class.getClassLoader().getResourceAsStream(conf);
		
		//获取SqlSessionFactory
		SqlSessionFactory factory=builder.build(instr);
		//获取sqlSession
		SqlSession session=factory.openSession();
		return session;
		
	}
	//测试getSqlSession()
	public static void main(String[] args){
		System.out.println(getSqlSession());
	}
	
}
