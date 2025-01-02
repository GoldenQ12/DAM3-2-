package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Adress;

public class AddressController implements Patron_DAO<Adress>{
	
	private static final String SQL_INSERT = "INSERT INTO address (address_id, address, address2, district, city_id, postal_code, phone, last_update) VALUES (?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM address WHERE address_id = ?";
	private static final String SQL_UPDATE = "UPDATE address SET address_id = ?, address = ?, address2 = ?, district = ?, city_id = ?, postal_code = ?, phone = ?, last_update = ? WHERE country_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM address";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM address WHERE address_id = ?";
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Adress t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getAddress_id());
			ps.setString(2, t.getAddress());
			ps.setString(3, t.getAddress2());
			ps.setString(4, t.getDistrict());
			ps.setInt(5, t.getCity_id());
			ps.setString(6, t.getPostal_code());
			ps.setString(7, t.getPhone());
			ps.setTimestamp(8, t.getLast_update());
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
	public boolean actualizar(Adress t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getAddress_id());
			ps.setString(2, t.getAddress());
			ps.setString(3, t.getAddress2());
			ps.setString(4, t.getDistrict());
			ps.setInt(5, t.getCity_id());
			ps.setString(6, t.getPostal_code());
			ps.setString(7, t.getPhone());
			ps.setTimestamp(8, t.getLast_update());
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
	public Adress buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Adress address = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	        	address = new Adress(rs.getInt("address_id"), rs.getString("address"), rs.getString("address2"), rs.getString("district"), rs.getInt("city_id"), rs.getString("postal_code"), rs.getString("phone"), rs.getTimestamp("last_update"));
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
	    return address;
	}

	@Override
	public ArrayList<Adress> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Adress> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Adress address = new Adress(rs.getInt("address_id"), rs.getString("address"), rs.getString("address2"), rs.getString("district"), rs.getInt("city_id"), rs.getString("postal_code"), rs.getString("phone"), rs.getTimestamp("last_update"));
		            lista.add(address);
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