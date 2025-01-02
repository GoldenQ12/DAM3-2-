package modelosBD;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

public class Staff {
	private int staff_id;
	private String first_name;
	private String last_name;
	private int address_id;
	private Blob picture;
	private String email;
	private int store_id;
	private int active;
	private String username;
	private String password;
	private Timestamp last_update;
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address_id, staff_id, store_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return address_id == other.address_id && staff_id == other.staff_id && store_id == other.store_id;
	}
	public Staff(int staff_id, String first_name, String last_name, int address_id, Blob picture, String email,
			int store_id, int active, String username, String password, Timestamp last_update) {
		super();
		this.staff_id = staff_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address_id = address_id;
		this.picture = picture;
		this.email = email;
		this.store_id = store_id;
		this.active = active;
		this.username = username;
		this.password = password;
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", address_id=" + address_id + ", picture=" + picture + ", email=" + email + ", store_id=" + store_id
				+ ", active=" + active + ", username=" + username + ", password=" + password + ", last_update="
				+ last_update + "]";
	}
	
	
}
