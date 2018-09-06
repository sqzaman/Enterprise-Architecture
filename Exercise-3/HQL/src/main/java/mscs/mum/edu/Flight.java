package mscs.mum.edu;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Flight {
	@Id
	@GeneratedValue
	private long flightnr;
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	private Date departureTime;
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	private Date arrivalTime;
	@ManyToOne
	@JoinColumn(name="airline_id")
	private Airline airline = new Airline();
	@ManyToOne
	@JoinColumn(name="airport_id")
	private Airport airport = new Airport();
	@ManyToOne
	@JoinColumn(name="airplane_id")
	private Airplane airplane = new Airplane();
	
	
}
