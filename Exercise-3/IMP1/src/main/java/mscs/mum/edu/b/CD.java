package mscs.mum.edu.b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("CD")
public class CD extends Product {
	/**
	 * 
	 */
	public CD() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param description
	 */
	public CD(String artist) {
		super();
		this.artist = artist;
	}
	private String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
