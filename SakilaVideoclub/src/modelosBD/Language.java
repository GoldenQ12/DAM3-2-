package modelosBD;

import java.sql.Timestamp;
import java.util.Objects;

public class Language {
	private int language_id;
	private String name;
	private Timestamp last_update;
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
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
		return Objects.hash(language_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		return language_id == other.language_id;
	}
	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", name=" + name + ", last_update=" + last_update + "]";
	}
	public Language(int language_id, String name, Timestamp last_update) {
		super();
		this.language_id = language_id;
		this.name = name;
		this.last_update = last_update;
	}
	
	
}
