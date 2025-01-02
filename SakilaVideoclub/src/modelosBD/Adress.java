package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class Adress {
	private int address_id;
	private String address;
	private String address2;
	private String district;
	private int city_id;
	private String postal_code;
	private String phone;
	private Timestamp last_update;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		return address_id == other.address_id;
	}
	public Adress(int address_id, String address, String address2, String district, int city_id, String postal_code,
			String phone, Timestamp last_update) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city_id = city_id;
		this.postal_code = postal_code;
		this.phone = phone;
		this.last_update = last_update;
	}
	
	@Override
	public String toString() {
		return "Adress [address_id=" + address_id + ", address=" + address + ", address2=" + address2 + ", district="
				+ district + ", city_id=" + city_id + ", postal_code=" + postal_code + ", phone=" + phone
				+ ", last_update=" + last_update + "]";
	}
	
	
	
}
