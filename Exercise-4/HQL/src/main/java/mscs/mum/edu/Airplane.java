package mscs.mum.edu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Airplane {
	@Id
	@GeneratedValue
	private long serialnr;
	private String model;
	private int capacity;
	@OneToMany(mappedBy="airplane")
	private List<Flight> listOfFlights = new ArrayList<Flight>();
	
	public Airplane() {
	}
	public Airplane(String model, int capacity, List<Flight> listOfFlights) {
		super();
		this.model = model;
		this.capacity = capacity;
		this.listOfFlights = listOfFlights;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<Flight> getListOfFlights() {
		return listOfFlights;
	}
	public void setListOfFlights(List<Flight> listOfFlights) {
		this.listOfFlights = listOfFlights;
	}
	
}
