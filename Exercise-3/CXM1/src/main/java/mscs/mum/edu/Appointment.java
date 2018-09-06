package mscs.mum.edu;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String appdate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="patient")
	private Patient patient;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="doctor")
	private Doctor doctor;

	@Embedded
	private Payment payment;

	/**
	 * @param appdate
	 * @param patient
	 * @param doctor
	 * @param payment
	 */
	public Appointment(String appdate, Patient patient, Doctor doctor, Payment payment) {
		this.appdate = appdate;
		this.patient = patient;
		this.doctor = doctor;
		this.payment = payment;
	}
	
	public Appointment() {		
	}

	public String getAppdate() {
		return appdate;
	}

	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}
	

}
