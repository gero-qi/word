
package www.geshiqi.log;

public class UserBean {
	private String name;
	private String password;
 
	public UserBean(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate(){
		if("".equals(this.name) || "".equals(this.password)){
			return false;
		}
		return true;
	}
	
	public boolean login(){
		if("geshiqi".equals(this.name)&&"123".equals(this.password)){
			return true;
		}else{
			return false;
		}
	}
	public String toString(){
		return "UserBean[name="+name+",password="+password+"]";
	}
	
}
