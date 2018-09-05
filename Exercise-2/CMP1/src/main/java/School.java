import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @MapKey(name = "studentId")
    private Map<Integer,String> map = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
