package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Film;

public class FilmController implements Patron_DAO<Film> {
	
	public enum Rating{
		G,PG,PG_13, R, NC_17
	}
	public enum SpecialFeature {
	    Trailers, Commentaries, Deleted_Scenes, Behind_the_Scenes
	}
	
	private static final String SQL_INSERT = "INSERT INTO film (film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_feature, last_update VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM film WHERE film_id = ?";
	private static final String SQL_UPDATE = "UPDATE film SET film_id = ?, title = ?, description = ?, release_year = ?, language_id = ?, original_language_id = ?, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_feature = ?, last_update = ? WHERE film_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM film";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM film WHERE film_id = ?";
	
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Film t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getFilm_id());
			ps.setString(2, t.getFilm());
			ps.setString(3, t.getDescription());
			ps.setDate(4, t.getRelease_year());
			ps.setInt(5, t.getLanguage_id());
			ps.setInt(6, t.getOriginal_language_id());
			ps.setInt(7, t.getRental_duration());
			ps.setFloat(8, t.getRental_rate());
			ps.setInt(9, t.getLength());
			ps.setFloat(10, t.getReplacement_cost());
			ps.setString(11, t.getRating());
			ps.setString(12, t.getSpecial_feature());
			ps.setTimestamp(13, t.getLast_update());
			if (ps.executeUpdate()> 0) return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean borrar(Object pk) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_DELETE);
			ps.setInt(1,(int)pk);
			if(ps.executeUpdate()>0)return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean actualizar(Film t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getFilm_id());
			ps.setString(2, t.getFilm());
			ps.setString(3, t.getDescription());
			ps.setDate(4, t.getRelease_year());
			ps.setInt(5, t.getLanguage_id());
			ps.setInt(6, t.getOriginal_language_id());
			ps.setInt(7, t.getRental_duration());
			ps.setFloat(8, t.getRental_rate());
			ps.setInt(9, t.getLength());
			ps.setFloat(10, t.getReplacement_cost());
			ps.setString(11, t.getRating());
			ps.setString(12, t.getSpecial_feature());
			ps.setTimestamp(13, t.getLast_update());
			ps.setInt(1, t.getFilm_id());
			if(ps.executeUpdate()>0) return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Film buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Film film = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            film = new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"), rs.getDate("release_year"), rs.getInt("language_id"), rs.getInt("original_language_id"), rs.getInt("rental_duration"), rs.getFloat("rental_rate"), rs.getInt("length"), rs.getFloat("replacement_cost"), rs.getString("rating"), rs.getString("special_feature"), rs.getTimestamp("last_update"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return film;
	}

	@Override
	public ArrayList<Film> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Film> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Film film = new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"), rs.getDate("release_year"), rs.getInt("language_id"), rs.getInt("original_language_id"), rs.getInt("rental_duration"), rs.getFloat("rental_rate"), rs.getInt("length"), rs.getFloat("replacement_cost"), rs.getString("rating"), rs.getString("special_feature"), rs.getTimestamp("last_update"));
		        	lista.add(film);		        	
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null) rs.close(); 
		            if (ps != null) ps.close(); 
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    return lista; 
	}
}
