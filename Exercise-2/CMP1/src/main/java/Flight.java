import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String flightNumber;
    @Column(name = "DepartureFrom")
    private String from;
    @Column(name = "ArriveTo")
    private String to;
    private LocalDate date;
    @ManyToOne
    private Passenger passenger;

    public Flight(String flightNumber, String from, String to, LocalDate date, Passenger passenger) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.date = date;
        this.passenger = passenger;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
