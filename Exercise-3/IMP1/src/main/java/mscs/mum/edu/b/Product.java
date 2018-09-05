package mscs.mum.edu.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Product {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;

}
