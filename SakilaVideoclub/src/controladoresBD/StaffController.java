package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Staff;

public class StaffController implements Patron_DAO<Staff> {
	
	private static final String SQL_INSERT = "INSERT INTO staff (staff_id, first_name, last_name, address_id, picture, email, store_id, active, username, password, last_update) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM staff WHERE staff_id = ?";
	private static final String SQL_UPDATE = "UPDATE staff SET staff_id = ?, first_name = ?, last_name = ?, address_id = ?, picture = ?, email = ?, store_id = ?, active = ?, username = ?, password = ?, last_update = ? WHERE staff_id = ? ";
	private static final String SQL_SELECT = "SELECT * FROM staff";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM staff WHERE staff_id = ?";
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Staff t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getStaff_id());
			ps.setString(2, t.getFirst_name());
			ps.setString(3, t.getLast_name());
			ps.setInt(4, t.getAddress_id());
			ps.setBlob(5, t.getPicture());
			ps.setString(6, t.getEmail());
			ps.setInt(7, t.getStore_id());
			ps.setInt(8, t.getActive());
			ps.setString(9, t.getUsername());
			ps.setString(10, t.getPassword());
			ps.setTimestamp(11, t.getLast_update());
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
	public boolean actualizar(Staff t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getStaff_id());
			ps.setString(2, t.getFirst_name());
			ps.setString(3, t.getLast_name());
			ps.setInt(4, t.getAddress_id());
			ps.setBlob(5, t.getPicture());
			ps.setString(6, t.getEmail());
			ps.setInt(7, t.getStore_id());
			ps.setInt(8, t.getActive());
			ps.setString(9, t.getUsername());
			ps.setString(10, t.getPassword());
			ps.setTimestamp(11, t.getLast_update());
			ps.setInt(12, t.getStaff_id());
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
	public Staff buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Staff staff = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            staff = new Staff(rs.getInt("staff_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("address_id"), rs.getBlob("picture"), rs.getString("email"), rs.getInt("store_id"), rs.getInt("active"), rs.getString("username"), rs.getString("password"), rs.getTimestamp("last_update"));
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
	public ArrayList<Staff> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Staff> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Staff staff = new Staff(rs.getInt("staff_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("address_id"), rs.getBlob("picture"), rs.getString("email"), rs.getInt("store_id"), rs.getInt("active"), rs.getString("username"), rs.getString("password"), rs.getTimestamp("last_update"));
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
