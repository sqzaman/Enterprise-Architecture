import javax.persistence.*;

@Entity
public class Student {
    @Id
    private long studentId;
    private String firstname;
    private String lastname;
    @ManyToOne
    private School school;

    public Student(long studentId, String firstname, String lastname) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
