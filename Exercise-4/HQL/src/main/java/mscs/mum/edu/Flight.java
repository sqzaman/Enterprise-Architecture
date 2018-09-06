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
	
	public Flight() {
	}
	public Flight(Date departureDate, Date departureTime, Date arrivalDate, Date arrivalTime, Airline airline,
			Airport airport, Airplane airplane) {
		super();
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.airport = airport;
		this.airplane = airplane;
	}
	public long getFlightnr() {
		return flightnr;
	}
	public void setFlightnr(long flightnr) {
		this.flightnr = flightnr;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Airport getAirport() {
		return airport;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
	
}
