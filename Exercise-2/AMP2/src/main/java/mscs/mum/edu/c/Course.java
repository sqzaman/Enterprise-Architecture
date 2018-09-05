package mscs.mum.edu.c;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String courseNumber;
	private String name;
	
	@ManyToMany(mappedBy="courses",  cascade=CascadeType.PERSIST)
	Set<Student> students = new HashSet<>();
	
	/**
	 * @param courseNumber
	 * @param name
	 */
	public Course(String courseNumber, String name) {
		this.courseNumber = courseNumber;
		this.name = name;
	}
	/**
	 * 
	 */
	public Course() {
	}
	public int getId() {
		return id;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}

}
