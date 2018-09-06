package mscs.mum.edu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Airline {
	private String name;
	@OneToMany(mappedBy="airline")
	List<Flight> listOfFlights = new ArrayList<Flight>();
	
	public Airline() {
	}
	public Airline(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Flight> getListOfFlights() {
		return listOfFlights;
	}
	public void setListOfFlights(List<Flight> listOfFlights) {
		this.listOfFlights = listOfFlights;
	}
	
}
