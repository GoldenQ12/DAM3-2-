package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.City;

public class CityController implements Patron_DAO<City> {
	
	private static final String SQL_INSERT = "INSERT INTO city (city_id, city, country_id, last_update) VALUES (?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM city WHERE city_id = ?";
	private static final String SQL_UPDATE = "UPDATE city SET city_id = ?, city = ?, country_id = ?, last_update = ? WHERE city_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM city";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM city WHERE city_id = ?";
	
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(City t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getCity_id());
			ps.setString(2, t.getCity());
			ps.setInt(3, t.getCountry_id());
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
	public boolean actualizar(City t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getCity_id());
			ps.setString(2, t.getCity());
			ps.setInt(3, t.getCountry_id());
			ps.setTimestamp(4, t.getLast_update());
			ps.setInt(5, t.getCity_id());
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
	public City buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    City city = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	        	city = new City(rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_id"), rs.getTimestamp("last_update"));
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
	    return city;
	}

	@Override
	public ArrayList<City> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<City> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	City city = new City(rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_id"), rs.getTimestamp("last_update"));
		            lista.add(city);
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