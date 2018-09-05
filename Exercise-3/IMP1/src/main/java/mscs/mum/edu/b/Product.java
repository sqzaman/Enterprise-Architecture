package mscs.mum.edu.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "products")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	/**
	 * 
	 */
	public Product() {
		super();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	
	

}