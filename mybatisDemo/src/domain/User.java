package domain;

public class User {
	private String name;
	private String password;
	private String email;
	private int id;
	private int level;
	private int departId;
	private int responID;
	private Depart depart;
	private Responsity resp;
	public void setDepartId(int departId){
		this.departId=departId;
	}
	public int getDepartId(){
		return departId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getResponID() {
		return responID;
	}
	public void setResponID(int responID) {
		this.responID = responID;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
 
 
	public Responsity getResp() {
		return resp;
	}
	@Override
	public String toString() {
		return "User [getDepartId()=" + getDepartId() + ", getName()="
				+ getName() + ", getPassword()=" + getPassword()
				+ ", getDepart()=" + getDepart() + ", getResp()=" + getResp()
				+ "]";
	}
	public void setResp(Responsity resp) {
		this.resp = resp;
	}

}
