package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Store;

public class StoreController implements Patron_DAO<Store> {
	
	private static final String SQL_INSERT = "INSERT INTO store (store_id, manager_staff_id, address_id, last_update) VALUES (?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM store WHERE store_id = ?";
	private static final String SQL_UPDATE = "UPDATE store SET store_id = ?, manager_staff_id = ?, address_id = ?, last_update = ? WHERE store_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM store";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM store WHERE store_id = ?";
	
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Store t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getStore_id());
			ps.setInt(2, t.getManager_staff_id());
			ps.setInt(3, t.getAddress_id());
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
	public boolean actualizar(Store t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getStore_id());
			ps.setInt(2, t.getManager_staff_id());
			ps.setInt(3, t.getAddress_id());
			ps.setTimestamp(4, t.getLast_update());
			ps.setInt(5, t.getStore_id());
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
	public Store buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Store staff = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            staff = new Store(rs.getInt("store_id"), rs.getInt("manager_staff_id"), rs.getInt("address_id"), rs.getTimestamp("last_update"));
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
	    return staff;
	}

	@Override
	public ArrayList<Store> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Store> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Store staff = new Store(rs.getInt("store_id"), rs.getInt("manager_staff_id"), rs.getInt("address_id"), rs.getTimestamp("last_update"));
		            lista.add(staff);
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
