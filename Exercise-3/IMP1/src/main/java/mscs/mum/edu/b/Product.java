package mscs.mum.edu.b;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name = "products")
/*
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		 name="product_type",
		 discriminatorType=DiscriminatorType.STRING
		)
		*/
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
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
