package school;

import java.util.List;

public class Classes {
private int id;
private String name;
private int teacher_id;

public Classes() {
	super();
}
public Classes(int id, String name, int teacher_id) {
	super();
	this.id = id;
	this.name = name;
	this.teacher_id = teacher_id;
}
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
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}
private Teacher teacher;

private List<Student> students;
@Override
public String toString() {
	return "Classes [id=" + id + ", name=" + name + ", teacher_id="
			+ teacher_id + ", teacher=" + teacher + ", students=" + students
			+ "]";
}

}