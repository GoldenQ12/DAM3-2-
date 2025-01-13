package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Payment;

public class PaymentController implements Patron_DAO<Payment> {
	private static final String SQL_INSERT = "INSERT INTO payment (payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update) VALUES (?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM payment WHERE payment_id = ?";
	private static final String SQL_UPDATE = "UPDATE payment SET payment_id = ?, customer_id = ?, staff_id = ?, rental_id = ?, amount = ?, payment_date = ?, last_update = ? WHERE payment_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM payment";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM payment WHERE payment_id = ?";
	
	private Conexion con = Conexion.getInstancia();

	@Override
	public boolean insertar(Payment t) {
		PreparedStatement ps = null;
		try {
			ps = con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getPayment_id());
			ps.setInt(2, t.getCustomer_id());
			ps.setInt(3, t.getStaff_id());
			ps.setInt(4, t.getRental_id());
			ps.setFloat(5, t.getAmount());
			ps.setDate(6, t.getPayment_date());
			ps.setTimestamp(7, t.getLast_update());
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
		PreparedStatement ps = null;
		try {
			ps = con.getCon().prepareStatement(SQL_DELETE);
			ps.setInt(1, (int)pk);
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
	public boolean actualizar(Payment t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getPayment_id());
			ps.setInt(2, t.getCustomer_id());
			ps.setInt(3, t.getStaff_id());
			ps.setInt(4, t.getRental_id());
			ps.setFloat(5, t.getAmount());
			ps.setDate(6, t.getPayment_date());
			ps.setTimestamp(7, t.getLast_update());
			ps.setInt(8, t.getPayment_id());
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
	public Payment buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Payment payment = null;
	    try {
	    	ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	    	ps.setInt(1, (int)pk);
	    	rs = ps.executeQuery();
	    	if(rs.next()) {
	    		payment = new Payment(rs.getInt("payment_id"),rs.getInt("customer_id"),rs.getInt("staff_id"),rs.getInt("rental_id"),rs.getFloat("amount"),rs.getDate("payment_date"),rs.getTimestamp("last_update"));
	    	}
	    }catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		return payment;
	}

	@Override
	public ArrayList<Payment> listarTodos() {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Payment> lista = new ArrayList<>();
	    try {
	    	ps = con.getCon().prepareStatement(SQL_SELECT);
	        rs = ps.executeQuery();
	        while(rs.next()) {
	        	Payment payment = new Payment(rs.getInt("payment_id"),rs.getInt("customer_id"),rs.getInt("staff_id"),rs.getInt("rental_id"),rs.getFloat("amount"),rs.getDate("payment_date"),rs.getTimestamp("last_update"));
	        	lista.add(payment);
	        }
	    }catch (Exception e) {
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
