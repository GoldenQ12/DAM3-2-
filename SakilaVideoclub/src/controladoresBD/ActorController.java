package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Actor;

public class ActorController implements Patron_DAO<Actor> {
	
	private static final String SQL_INSERT = "INSERT INTO actor (actor_id, first_name, last_name, last_update) VALUES (?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM actor WHERE actor_id = ?";
	private static final String SQL_UPDATE = "UPDATE actor SET actor_id = ?, first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM actor";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM actor WHERE actor_id = ?";
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Actor t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getActor_id());
			ps.setString(2, t.getFirst_name());
			ps.setString(2, t.getLast_name());
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
	public boolean actualizar(Actor t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getActor_id());
			ps.setString(2, t.getFirst_name());
			ps.setString(3, t.getLast_name());
			ps.setTimestamp(4, t.getLast_update());
			ps.setInt(5, t.getActor_id());
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
	public Actor buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Actor actor = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            actor = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getTimestamp("last_update"));
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
	    return actor;
	}

	@Override
	public ArrayList<Actor> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Actor> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Actor actor = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getTimestamp("last_update"));
		            lista.add(actor);
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