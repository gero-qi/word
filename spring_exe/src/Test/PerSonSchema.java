package Test;

public class PerSonSchema {
private String id;
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId(){
	return id;
}
public void setId(String Id){
	this.id=Id;
}
@Override
public String toString() {
	return "PerSonSchema [id=" + id + ", name=" + name + "]";
}

}
