package mscs.mum.edu;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Flight {
	private long flightnr;
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	private Date departureTime;
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	private Date arrivalTime;
	
}
