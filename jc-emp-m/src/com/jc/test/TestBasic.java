package com.jc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBasic {
	private static ApplicationContext ac=null;
	
	static{
		String conf="applicationContext.xml";
		ac=new ClassPathXmlApplicationContext(conf);
	}
	
	public static ApplicationContext getContext(){
		return ac;
	}

}
