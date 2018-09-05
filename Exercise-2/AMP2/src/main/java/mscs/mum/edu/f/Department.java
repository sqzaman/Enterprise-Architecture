package mscs.mum.edu.f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue
	@Column(name = "department_id")
	private int id;
	@Column(name = "department_name")
	private String name;

	@OneToMany
	private List<Employee> employees = new ArrayList<Employee>();

	public Department() {

	}

	/**
	 * @param name
	 */
	public Department(String name) {
		this.name = name;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee employee) {
		employee.setDepartment(this);
		this.employees.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		employee.setDepartment(null);;
		this.employees.remove(employee);
	}
	
}
