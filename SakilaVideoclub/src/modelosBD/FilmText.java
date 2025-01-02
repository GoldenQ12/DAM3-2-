package modelosBD;

import java.util.Objects;

public class FilmText {
	private int film_id;
	private String title;
	private String description;
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(film_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmText other = (FilmText) obj;
		return film_id == other.film_id;
	}
	@Override
	public String toString() {
		return "FilmText [film_id=" + film_id + ", title=" + title + ", description=" + description + "]";
	}
	public FilmText(int film_id, String title, String description) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
	}
	
	
}
