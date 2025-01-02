package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Country;

public class CountryController implements Patron_DAO<Country>{
	private static final String SQL_INSERT = "INSERT INTO country (country_id, country, last_update) VALUES (?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM country WHERE country_id = ?";
	private static final String SQL_UPDATE = "UPDATE country SET country_id = ?, country = ?, last_update = ? WHERE country_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM country";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM country WHERE country_id = ?";
	
	private Conexion con = Conexion.getInstancia();


	@Override
	public boolean insertar(Country t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getCountry_id());
			ps.setString(2, t.getCountry());
			ps.setTimestamp(3, t.getLast_update());
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
	public boolean actualizar(Country t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getCountry_id());
			ps.setString(2, t.getCountry());
			ps.setTimestamp(3, t.getLast_update());
			ps.setInt(4, t.getCountry_id());
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
	public Country buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Country country = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            country = new Country(rs.getInt("country_id"), rs.getString("country"), rs.getTimestamp("last_update"));
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
	    return country;
	}

	@Override
	public ArrayList<Country> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Country> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Country country = new Country(rs.getInt("country_id"), rs.getString("country"), rs.getTimestamp("last_update"));
		            lista.add(country);
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
