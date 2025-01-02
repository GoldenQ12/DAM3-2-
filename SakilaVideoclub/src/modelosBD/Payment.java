package modelosBD;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Payment {
	private int payment_id;
	private int customer_id;
	private int staff_id;
	private int rental_id;
	private float amount;
	private Date payment_date;
	private Timestamp last_update;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getRental_id() {
		return rental_id;
	}
	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer_id, payment_id, rental_id, staff_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return customer_id == other.customer_id && payment_id == other.payment_id && rental_id == other.rental_id
				&& staff_id == other.staff_id;
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", customer_id=" + customer_id + ", staff_id=" + staff_id
				+ ", rental_id=" + rental_id + ", amount=" + amount + ", payment_date=" + payment_date
				+ ", last_update=" + last_update + "]";
	}
	public Payment(int payment_id, int customer_id, int staff_id, int rental_id, float amount, Date payment_date,
			Timestamp last_update) {
		super();
		this.payment_id = payment_id;
		this.customer_id = customer_id;
		this.staff_id = staff_id;
		this.rental_id = rental_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.last_update = last_update;
	}
	
	
}
