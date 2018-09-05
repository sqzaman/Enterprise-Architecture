package mscs.mum.edu.b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
//@DiscriminatorValue("DVD")
public class DVD extends Product {
	private String genre;

	/**
	 * 
	 */
	public DVD() {
		super();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public DVD(String genre) {
		super();
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	

}
