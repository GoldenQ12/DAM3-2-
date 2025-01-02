package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Customer;

public class CustomerController implements Patron_DAO<Customer> {
	
	private static final String SQL_INSERT = "INSERT INTO customer (customer_id, store_id, first_name, last_name, email, address_id, active, create_date, last_update) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM customer WHERE customer_id = ?";
	private static final String SQL_UPDATE = "UPDATE customer SET customer_id = ?, store_id = ?, first_name = ?, last_name = ?, email = ?, address_id = ?, active = ?, create_date = ?, last_update = ? WHERE customer_id = ?";
	private static final String SQL_SELECT_BY_PAIS = "SELECT * FROM customer WHERE address_id IN (SELECT address_id FROM address WHERE city_id IN (SELECT city_id FROM city WHERE country_id IN (SELECT country_id FROM country WHERE country_id = ?)))";
	private static final String SQL_SELECT_BY_VENDEDOR = "SELECT * FROM customer WHERE store_id IN( SELECT store_id FROM store WHERE manager_staff_id IN (SELECT staff_id FROM customer WHERE staff_id = ?))";
	private static final String SQL_SELECT = "SELECT * FROM customer";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM customer WHERE customer_id = ?";
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Customer t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getCustomer_id());
			ps.setInt(2, t.getStore_id());
			ps.setString(3, t.getFirst_name());
			ps.setString(4, t.getLast_name());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getAddress_id());
			ps.setInt(7, t.getActive());
			ps.setDate(8, t.getCreate_date());
			ps.setTimestamp(9, t.getLast_update());
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
	public boolean actualizar(Customer t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getCustomer_id());
			ps.setInt(2, t.getStore_id());
			ps.setString(3, t.getFirst_name());
			ps.setString(4, t.getLast_name());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getAddress_id());
			ps.setInt(7, t.getActive());
			ps.setDate(8, t.getCreate_date());
			ps.setTimestamp(9, t.getLast_update());
			ps.setInt(10, t.getCustomer_id());
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
	public Customer buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Customer cust = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            cust = new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"), rs.getInt("active"), rs.getDate("create_date"), rs.getTimestamp("last_update"));
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
	    return cust;
	}

	@Override
	public ArrayList<Customer> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Customer> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Customer cust = new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"), rs.getInt("active"), rs.getDate("create_date"), rs.getTimestamp("last_update"));
		            lista.add(cust);
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
	
	public ArrayList<Customer> listarPorPais(Object pk){
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Customer> lista = new ArrayList<>();
	    try {
	    	ps = con.getCon().prepareStatement(SQL_SELECT_BY_PAIS);
	    	ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        while (rs.next()) { 
	        	Customer cust = new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"), rs.getInt("active"), rs.getDate("create_date"), rs.getTimestamp("last_update"));
	            lista.add(cust);
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
	
	public ArrayList<Customer> listarPorVendedor(Object pk){
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Customer> lista = new ArrayList<>();
	    try {
	    	ps = con.getCon().prepareStatement(SQL_SELECT_BY_VENDEDOR);
	    	ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        while (rs.next()) { 
	        	Customer cust = new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"), rs.getInt("active"), rs.getDate("create_date"), rs.getTimestamp("last_update"));
	            lista.add(cust);
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
