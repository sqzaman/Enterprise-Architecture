package mscs.mum.edu.f;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_number")
	private long employeeNumber;
	@Column(name = "employee_name")
	private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @ManyToOne
    @JoinColumn(name="room_number")
    private Office office;


    public Employee() {
	}
	/**
	 * @param name
	 * @param department
	 */
	public Employee(String name, Department department) {
		this.name = name;
		this.department = department;
	}

    public Employee(String name, Department department, Office office) {
        this.name = name;
        this.department = department;
        this.office = office;
    }

    public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}