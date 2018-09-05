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
	@OneToOne
	private Patient patient;
	
	
	public Appointment(String appdate, Payment payment, Doctor doctor, Patient patient) {
		super();
		this.appdate = appdate;
		this.payment = payment;
		this.doctor = doctor;
		this.patient = patient;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
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
