package mscs.mum.edu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	@GeneratedValue
	private int id;
	private String doctortype;
	private String firstname;
	private String lastname;
	public String getDoctortype() {
		return doctortype;
	}
	
	public Doctor(String doctortype, String firstname, String lastname) {
		super();
		this.doctortype = doctortype;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void setDoctortype(String doctortype) {
		this.doctortype = doctortype;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
