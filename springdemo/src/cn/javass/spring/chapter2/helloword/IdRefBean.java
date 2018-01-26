package cn.javass.spring.chapter2.helloword;

public class IdRefBean {
	private String id;
	public String getId(){
		return id;
	}
 
	public void setId(String id){
		this.id=id;
	}
	public void show(){
		System.out.println("ddd"+id);
	}
	
}
