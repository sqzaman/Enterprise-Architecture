package mscs.mum.edu.d;

import mscs.mum.edu.e.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany
    List<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    private Book book;

    public Customer() {
    }

    public Customer(String name) {
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

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void removeReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }

}
