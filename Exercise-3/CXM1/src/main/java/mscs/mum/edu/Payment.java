package mscs.mum.edu;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Payment {
	private String paydate;
	private double amount;
	
	/**
	 * 
	 */
	public Payment() {
	}
	/**
	 * @param paydate
	 * @param amount
	 */
	public Payment(String paydate, double amount) {
		this.paydate = paydate;
		this.amount = amount;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
