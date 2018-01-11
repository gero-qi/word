package domain;

public class Depart {
private int departId;
private String departName;
public int getDepartId() {
	return departId;
}
@Override
public String toString() {
	return "Depart [getDepartId()=" + getDepartId() + ", getDepartName()="
			+ getDepartName() + "]";
}
public void setDepartId(int departId) {
	this.departId = departId;
}
public String getDepartName() {
	return departName;
}
public void setDepartName(String departName) {
	this.departName = departName;
}

}
