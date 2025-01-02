package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class Store {
	private int store_id;
	private int manager_staff_id;
	private int address_id;
	private Timestamp last_update;
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getManager_staff_id() {
		return manager_staff_id;
	}
	public void setManager_staff_id(int manager_staff_id) {
		this.manager_staff_id = manager_staff_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address_id, manager_staff_id, store_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return address_id == other.address_id && manager_staff_id == other.manager_staff_id
				&& store_id == other.store_id;
	}
	public Store(int store_id, int manager_staff_id, int address_id, Timestamp last_update) {
		super();
		this.store_id = store_id;
		this.manager_staff_id = manager_staff_id;
		this.address_id = address_id;
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", manager_staff_id=" + manager_staff_id + ", address_id=" + address_id
				+ ", last_update=" + last_update + "]";
	}
	
	
}
