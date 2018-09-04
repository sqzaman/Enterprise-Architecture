package mscs.mum.edu.c;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	private int studentId;
	private String firstName;
	private String lastName;
	
	@ManyToMany( cascade=CascadeType.PERSIST)
	Set<Course> courses = new HashSet<>();

	/**
	 * 
	 */
	public Student() {
	}

	/**
	 * @param studentId
	 * @param firstName
	 * @param lastName
	 */
	public Student(int studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	public int getStudentId() {
		return studentId;
	}
	
	
	
	

}
