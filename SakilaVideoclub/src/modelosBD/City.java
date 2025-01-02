package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class City {
	private int city_id;
	private String city;
	private int country_id;
	private Timestamp last_update;
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return city_id == other.city_id;
	}
	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", country_id=" + country_id + ", last_update="
				+ last_update + "]";
	}
	public City(int city_id, String city, int country_id, Timestamp last_update) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.country_id = country_id;
		this.last_update = last_update;
	}
	
	
}
