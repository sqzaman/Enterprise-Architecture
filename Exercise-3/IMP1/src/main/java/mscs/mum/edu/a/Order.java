package mscs.mum.edu.a;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="`Order`")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private int orderid;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void addOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
    }

    public void removeOrderlIne(OrderLine orderLine){
        orderLines.remove(orderLine);
    }

    private Date date;

    public Order() {
    }

    public Order(Date date) {
        this.date = date;
        orderLines = new ArrayList<OrderLine>();
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
