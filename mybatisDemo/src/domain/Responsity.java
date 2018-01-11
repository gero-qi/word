package domain;

public class Responsity {
private int ResId;
private String ResName;
@Override
public String toString() {
	return "Responsity [ResId=" + ResId + ", ResName=" + ResName + "]";
}
public int getResId() {
	return ResId;
}   
public void setResId(int resId) {
	ResId = resId;
}
public String getResName() {
	return ResName;
}
public void setResName(String resName) {
	ResName = resName;
}

}
