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
}
