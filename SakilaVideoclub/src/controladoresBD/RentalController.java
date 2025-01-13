package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Date;
import conexion.Conexion;
import modelosBD.Rental;

public class RentalController implements Patron_DAO<Rental> {

    private static final String SQL_INSERT = "INSERT INTO rental (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM rental WHERE rental_id = ?";
    private static final String SQL_UPDATE = "UPDATE rental SET rental_date = ?, inventory_id = ?, customer_id = ?, return_date = ?, staff_id = ?, last_update = ? WHERE rental_id = ?";
    private static final String SQL_SELECT = "SELECT * FROM rental";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM rental WHERE rental_id = ?";

    private Conexion con = Conexion.getInstancia();

    @Override
    public boolean insertar(Rental t) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setInt(1, t.getRental_id());
            ps.setDate(2, t.getRental_date());
            ps.setInt(3, t.getInventory_id());
            ps.setInt(4, t.getCustomer_id());
            ps.setDate(5, t.getReturn_date());
            ps.setInt(6, t.getStaff_id());
            ps.setTimestamp(7, t.getLast_update());
            if (ps.executeUpdate() > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
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
            ps.setInt(1, (int) pk);
            if (ps.executeUpdate() > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(Rental t) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setDate(1, t.getRental_date());
            ps.setInt(2, t.getInventory_id());
            ps.setInt(3, t.getCustomer_id());
            ps.setDate(4, t.getReturn_date());
            ps.setInt(5, t.getStaff_id());
            ps.setTimestamp(6, t.getLast_update());
            ps.setInt(7, t.getRental_id());
            if (ps.executeUpdate() > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Rental buscar(Object pk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rental rental = null;
        try {
            ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, (int) pk);
            rs = ps.executeQuery();
            if (rs.next()) {
                rental = new Rental(
                    rs.getInt("rental_id"),
                    rs.getDate("rental_date"),
                    rs.getInt("inventory_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("return_date"),
                    rs.getInt("staff_id"),
                    rs.getTimestamp("last_update")
                );
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
        return rental;
    }

    @Override
    public ArrayList<Rental> listarTodos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Rental> lista = new ArrayList<>();
        try {
            ps = con.getCon().prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
            	Rental rental = new Rental(
                    rs.getInt("rental_id"),
                    rs.getDate("rental_date"),
                    rs.getInt("inventory_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("return_date"),
                    rs.getInt("staff_id"),
                    rs.getTimestamp("last_update")
                );
                lista.add(rental);
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