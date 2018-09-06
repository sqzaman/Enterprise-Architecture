package mscs.mum.edu.b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue
	private Long orderId;
	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	/**
	 * 
	 */
	public Order() {
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @param customer
	 * @param orderLines
	 */
	public Order(Customer customer, List<OrderLine> orderLines) {
		this.customer = customer;
		this.orderLines = orderLines;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}
	public void removeOrderLine(OrderLine orderLine) {
		this.orderLines.remove(orderLine);
	}
	public Customer getCustomer() {
		return customer;
	}
	
	

}
