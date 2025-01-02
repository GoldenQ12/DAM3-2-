package modelosBD;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Rental {
	private int rental_id;
	private Date rental_date;
	private int inventory_id;
	private int customer_id;
	private Date return_date;
	private int staff_id;
	private Timestamp last_update;
	public int getRental_id() {
		return rental_id;
	}
	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}
	public Date getRental_date() {
		return rental_date;
	}
	public void setRental_date(Date rental_date) {
		this.rental_date = rental_date;
	}
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "Rental [rental_id=" + rental_id + ", rental_date=" + rental_date + ", inventory_id=" + inventory_id
				+ ", customer_id=" + customer_id + ", return_date=" + return_date + ", staff_id=" + staff_id
				+ ", last_update=" + last_update + "]";
	}
	public Rental(int rental_id, Date rental_date, int inventory_id, int customer_id, Date return_date, int staff_id,
			Timestamp last_update) {
		super();
		this.rental_id = rental_id;
		this.rental_date = rental_date;
		this.inventory_id = inventory_id;
		this.customer_id = customer_id;
		this.return_date = return_date;
		this.staff_id = staff_id;
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer_id, inventory_id, rental_id, staff_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rental other = (Rental) obj;
		return customer_id == other.customer_id && inventory_id == other.inventory_id && rental_id == other.rental_id
				&& staff_id == other.staff_id;
	}
	
	
}	
