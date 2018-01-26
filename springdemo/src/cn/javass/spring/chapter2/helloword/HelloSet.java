package cn.javass.spring.chapter2.helloword;

public class HelloSet implements HelloApi {
	private String message;
	private int index;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public void sayHello() {
		System.out.println(index+""+message);

	}

}
