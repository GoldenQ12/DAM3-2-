package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class FilmActor {
	private int actor_id;
	private int film_id;
	private Timestamp last_update;
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actor_id, film_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmActor other = (FilmActor) obj;
		return actor_id == other.actor_id && film_id == other.film_id;
	}
	@Override
	public String toString() {
		return "FilmActor [actor_id=" + actor_id + ", film_id=" + film_id + ", last_update=" + last_update + "]";
	}
	public FilmActor(int actor_id, int film_id, Timestamp last_update) {
		super();
		this.actor_id = actor_id;
		this.film_id = film_id;
		this.last_update = last_update;
	}
	
	
}
