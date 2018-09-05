import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String type;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Employee owner;

    public Laptop(String brand, String type, Employee owner) {
        this.brand = brand;
        this.type = type;
        this.owner = owner;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
