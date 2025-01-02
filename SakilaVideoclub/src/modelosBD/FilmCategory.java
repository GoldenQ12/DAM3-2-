package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class FilmCategory {
	private int film_id;
	private int category_id;
	private Timestamp last_update;
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category_id, film_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmCategory other = (FilmCategory) obj;
		return category_id == other.category_id && film_id == other.film_id;
	}
	@Override
	public String toString() {
		return "FilmCategory [film_id=" + film_id + ", category_id=" + category_id + ", last_update=" + last_update
				+ "]";
	}
	public FilmCategory(int film_id, int category_id, Timestamp last_update) {
		super();
		this.film_id = film_id;
		this.category_id = category_id;
		this.last_update = last_update;
	}
	
	
}
