package mscs.mum.edu.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_lines")
public class OrderLine {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(optional = false)
	private Product product;
	private Integer quantity;
	
	/**
	 * 
	 */
	public OrderLine() {
	}

	/**
	 * @param product
	 * @param quantity
	 */
	public OrderLine(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}
	

}
