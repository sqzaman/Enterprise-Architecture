package mscs.mum.edu.b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Book")
public class Book extends Product {
	private String title;
	
	/**
	 * 
	 */
	public Book() {
		super();
	}
	
	/**
	 * @param nameBook
	 * @param description
	 */
	public Book(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
