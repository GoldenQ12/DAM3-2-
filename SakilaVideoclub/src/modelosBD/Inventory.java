package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class Inventory {
	private int inventory_id;
	private int film_id;
	private int store_id;
	private Timestamp last_update;
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "Inventory [inventory_id=" + inventory_id + ", film_id=" + film_id + ", store_id=" + store_id
				+ ", last_update=" + last_update + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(film_id, inventory_id, store_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return film_id == other.film_id && inventory_id == other.inventory_id && store_id == other.store_id;
	}
	public Inventory(int inventory_id, int film_id, int store_id, Timestamp last_update) {
		super();
		this.inventory_id = inventory_id;
		this.film_id = film_id;
		this.store_id = store_id;
		this.last_update = last_update;
	}
	
	
}
