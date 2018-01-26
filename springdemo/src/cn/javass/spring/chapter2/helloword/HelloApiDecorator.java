package cn.javass.spring.chapter2.helloword;

public class HelloApiDecorator implements HelloApi {
	
	
	private HelloApi helloApi;
	public HelloApiDecorator(){};
	public HelloApiDecorator(HelloApi helloApi){
		this.helloApi=helloApi;
	}
	
	public void setHelloApi(HelloApi helloApi){
		this.helloApi=helloApi;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("装饰一下");
		helloApi.sayHello();
		System.out.println("装饰一下");
	}

}
