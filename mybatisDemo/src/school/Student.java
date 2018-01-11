package school;

public class Student {
private int id;
private String name;
private int class_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getClass_id() {
	return class_id;
}
public void setClass_id(int class_id) {
	this.class_id = class_id;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", class_id=" + class_id
			+ "]";
}

}
