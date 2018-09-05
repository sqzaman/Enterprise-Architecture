package mscs.mum.edu.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public Publisher() {
	}
	
	/**
	 * @param name
	 */
	public Publisher(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
