package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class Category {
	private int category_id;
	private String name;
	private Timestamp last_update;
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return category_id == other.category_id;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", last_update=" + last_update + "]";
	}
	public Category(int category_id, String name, Timestamp last_update) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.last_update = last_update;
	}
	
	
	
}
