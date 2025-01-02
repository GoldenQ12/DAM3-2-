package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class Country {
	private int country_id;
	private String country;
	private Timestamp last_update;
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(country_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return country_id == other.country_id;
	}
	public Country(int country_id, String country, Timestamp last_update) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", last_update=" + last_update + "]";
	}
	
	
}
