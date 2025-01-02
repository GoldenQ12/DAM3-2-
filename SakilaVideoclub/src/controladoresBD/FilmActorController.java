package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.FilmActor;

public class FilmActorController implements Patron_DAO<FilmActor> {
	
	private static final String SQL_INSERT = "INSERT INTO film_actor (actor_id, film_id, last_update) VALUES (?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM film_actor WHERE actor_id = ?";
	private static final String SQL_UPDATE = "UPDATE film_actor SET actor_id = ?, film_id = ?, last_update = ? WHERE actor_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM film_actor";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM film_actor WHERE actor_id = ?";
	
	
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(FilmActor t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getActor_id());
			ps.setInt(2, t.getFilm_id());
			ps.setTimestamp(4, t.getLast_update());
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
	public boolean actualizar(FilmActor t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getActor_id());
			ps.setInt(2, t.getFilm_id());
			ps.setTimestamp(3, t.getLast_update());
			ps.setInt(4, t.getActor_id());
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
	public FilmActor buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    FilmActor film_actor = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            film_actor = new FilmActor(rs.getInt("actor_id"), rs.getInt("film_id"), rs.getTimestamp("last_update"));
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
	    return film_actor;
	}

	@Override
	public ArrayList<FilmActor> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<FilmActor> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	FilmActor film_actor = new FilmActor(rs.getInt("actor_id"), rs.getInt("film_id"), rs.getTimestamp("last_update"));
		            lista.add(film_actor);
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
