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
	
	public Airport() {
		super();
	}

	public Airport(String name, String city, String country, String airportCode) {
		super();
		this.name = name;
		this.city = city;
		this.country = country;
		this.airportCode = airportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public List<Flight> getListOfFlights() {
		return listOfFlights;
	}

	public void setListOfFlights(List<Flight> listOfFlights) {
		this.listOfFlights = listOfFlights;
	}
	
	
}
