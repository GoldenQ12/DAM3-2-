package modelosBD;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Film {
	
	private int film_id;
	private String film;
	private String description;
	private Date release_year;
	private int language_id;
	private int original_language_id;
	private int rental_duration;
	private float rental_rate;
	private int length;
	private float replacement_cost;
	private String rating;
	private String special_feature;
	private Timestamp last_update;
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRelease_year() {
		return release_year;
	}
	public void setRelease_year(Date release_year) {
		this.release_year = release_year;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public int getOriginal_language_id() {
		return original_language_id;
	}
	public void setOriginal_language_id(int original_language_id) {
		this.original_language_id = original_language_id;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public float getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(float rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(float replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecial_feature() {
		return special_feature;
	}
	public void setSpecial_feature(String special_feature) {
		this.special_feature = special_feature;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", film=" + film + ", description=" + description + ", release_year="
				+ release_year + ", language_id=" + language_id + ", original_language_id=" + original_language_id
				+ ", rental_duration=" + rental_duration + ", rental_rate=" + rental_rate + ", length=" + length
				+ ", replacement_cost=" + replacement_cost + ", rating=" + rating + ", special_feature="
				+ special_feature + ", last_update=" + last_update + "]";
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
		Film other = (Film) obj;
		return film_id == other.film_id;
	}
	public Film(int film_id, String film, String description, Date release_year, int language_id,
			int original_language_id, int rental_duration, float rental_rate, int length, float replacement_cost,
			String rating, String special_feature, Timestamp last_update) {
		super();
		this.film_id = film_id;
		this.film = film;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.original_language_id = original_language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_feature = special_feature;
		this.last_update = last_update;
	} 
	
	
	
}
