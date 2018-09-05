import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "passenger")
    @JoinColumn(name = "passenger_id")
    private List<Flight> flightList = new ArrayList<Flight>();

    public Passenger(String name) {
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
