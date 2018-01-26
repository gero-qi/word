package cn.javass.spring.chapter2.helloword;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.HelloCollection;

public class HelloTest {
	@Test
	public void testHelloWorld(){
		//ApplicationContext context=new ClassPathXmlApplicationContext("/chapter2/helloworld.xml");
		BeanFactory context=new ClassPathXmlApplicationContext("/chapter2/helloworld.xml");
		//ApplicationContext完全继承BeanFactory，因而BeanFactory所具有的语义也适用于ApplicationContext。
/* 		HelloApi HelloImpl=context.getBean("HelloImpl",HelloApi.class);
 		HelloImpl.sayHello(); */
		
/*		HelloApi helloImpl1=context.getBean("helloImpl1",HelloApi.class);
		helloImpl1.sayHello();
		
		HelloApi helloImpl2=context.getBean("helloImpl2",HelloApi.class);
		helloImpl2.sayHello();
		
		HelloApi helloImpl3=context.getBean("helloImpl3",HelloApi.class);
		helloImpl3.sayHello();*/
		
/* 		
 		IdRefBean idrefbean=context.getBean("idrefbean", IdRefBean.class);
 		idrefbean.show();*/
		
/*		HelloCollection helloCollection=context.getBean("listBeans",HelloCollection.class);
		int i=helloCollection.getValues().size();
		System.out.println(i);
		Assert.assertEquals(2, helloCollection.getValues().size()); */
		
		
		HelloApi bean1=context.getBean("bean1",HelloApi.class);
		bean1.sayHello();
		HelloApi bean2=context.getBean("bean2",HelloApi.class);
	
	}
	
	
}
