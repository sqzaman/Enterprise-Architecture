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
}
