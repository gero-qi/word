package cn.javass.spring.chapter2.helloword;

public class HelloImpl implements HelloApi {
	
	private int i;
	private String h;
	public HelloImpl(){	
	}
	@java.beans.ConstructorProperties({"h","i"})
	public  HelloImpl(String h,int i){
		this.h=h;
		this.i=i;
	}
	@Override
 
	

	
	
	public void sayHello( ) {
		System.out.println("hellow"+h+i);
		
	}

}
