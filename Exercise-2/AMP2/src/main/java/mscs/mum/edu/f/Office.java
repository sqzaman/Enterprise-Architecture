package mscs.mum.edu.f;

import javax.persistence.*;
import java.util.List;
@Entity
public class Office {
    @Id
    @GeneratedValue
    private int roomNumber;
    private String building;
    @OneToMany(mappedBy = "office")
    //@JoinColumn(name="room_id")
    private List<Employee> employee;

    public Office(String building, List<Employee> employee) {
        this.building = building;
        this.employee = employee;
    }

    public Office(String building) {
        this.building = building;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Office() {
    }



    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void addEmployee(Employee employee) {
        employee.setOffice(this);
        this.employee.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employee.setOffice(null);;
        this.employee.remove(employee);
    }


}
