package mscs.mum.edu;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private int id;
	private String appdate;
	@Embedded
	private Payment payment;
	@OneToOne
	private Doctor doctor;
	
	public Appointment(String appdate, Payment payment, Doctor doctor) {
		super();
		this.appdate = appdate;
		this.payment = payment;
		this.doctor = doctor;
	}
	public String getAppdate() {
		return appdate;
	}
	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
