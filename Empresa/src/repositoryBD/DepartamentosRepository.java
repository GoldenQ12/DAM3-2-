package repositoryBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.DepartamentosDTO;

public class DepartamentosRepository implements IRepository<DepartamentosDTO> {
	
	private static final String SQL_INSERT = "INSERT INTO departamentos (id_dept,descripcion,poblacion) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM departamentos WHERE id_dept = ?";
    private static final String SQL_UPDATE = "UPDATE departamentos SET descripcion = ?, poblacion = ? WHERE id_dept = ?";
    private static final String SQL_SELECT = "SELECT id_dept, descripcion, poblacion FROM departamentos WHERE id_dept = ?";
    private static final String SQL_SELECT_TODOS = "SELECT * FROM departamentos";
    
    private Conexion con = Conexion.getInstancia();

	@Override
	public boolean insertar(DepartamentosDTO dpt) {
		PreparedStatement stmt = null;
		try {
			stmt = con.getCon().prepareStatement(SQL_INSERT);
			stmt.setInt(1, dpt.getId_dept());
			stmt.setString(2, dpt.getDescripcion());
			stmt.setString(3, dpt.getPoblacion());
		if (stmt.executeUpdate () > 0) {
			return true;
		}
		return false;
		} catch ( Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	 @Override
	    public boolean borrar(Object pk) {
		 	PreparedStatement stmt = null;
	        try {
	            stmt = con.getCon().prepareStatement(SQL_DELETE);
	            DepartamentosDTO dpt = (DepartamentosDTO) pk;
	            stmt.setInt(1, dpt.getId_dept());
	            if (stmt.executeUpdate() > 0) return true;	 
	            return false;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean actualizar(DepartamentosDTO dpt) {
	    	PreparedStatement stmt = null;
	        try {
	            stmt = con.getCon().prepareStatement(SQL_UPDATE);
	            stmt.setString(1,  dpt.getDescripcion());
	            stmt.setString(2, dpt.getPoblacion());
	            stmt.setInt(3, dpt.getId_dept());
	            if (stmt.executeUpdate() > 0) return true;	 
	            return false; 
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public DepartamentosDTO buscar(Object pk) {
	    	PreparedStatement stmt = null;
	        try {
	            stmt = con.getCon().prepareStatement(SQL_SELECT);
	            DepartamentosDTO dpt = (DepartamentosDTO) pk;
	            stmt.setInt(1, dpt.getId_dept());
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	return new DepartamentosDTO(rs.getInt("id_dept"), rs.getString("descripcion"), rs.getString("poblacion"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	        return null;
	    }

	    @Override
	    public ArrayList<DepartamentosDTO> listarTodos() {
	        ArrayList<DepartamentosDTO> departamentos = new ArrayList<>();
	        PreparedStatement stmt = null;
	        try {
	             stmt = con.getCon().prepareStatement(SQL_SELECT_TODOS);
	             ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                DepartamentosDTO dpt = new DepartamentosDTO(rs.getInt("id_dept"), rs.getString("descripcion"), rs.getString("poblacion"));
	                departamentos.add(dpt);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return departamentos; 
	    }




}
