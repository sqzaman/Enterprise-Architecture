package mscs.mum.edu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Airport {
	private String name;
	private String city;
	private String country;
	private String airportCode;
	@OneToMany(mappedBy="airport")
	private List<Flight> listOfFlights = new ArrayList<Flight>();
	
	
}
