package repositoryBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.DepartamentosDTO;
import modelosBD.EmpleadosDTO;

public class EmpleadosRepository implements IRepository<EmpleadosDTO>{
	
	private static final String SQL_INSERT = "INSERT INTO empleados (id_emp,nombre, apellido, fechaAlta, sueldo, cod_dept_emp) VALUES (?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE id_emp = ?";
    private static final String SQL_UPDATE = "UPDATE empleados SET nombre = ?, apellido = ?, fechaAlta = ?, sueldo = ?, cod_dept_emp = ? WHERE id_emp = ?";
    private static final String SQL_SELECT = "SELECT id_emp, nombre, apellido, fechaAlta, sueldo, cod_dept_emp FROM empleados WHERE id_emp = ?";
    private static final String SQL_SELECT_TODOS = "SELECT * FROM empleados";
    
	
	
	private Conexion con = Conexion.getInstancia();

	@Override
	public boolean insertar(EmpleadosDTO emp) {
		PreparedStatement stmt = null;
		try {
			stmt = con.getCon().prepareStatement(SQL_INSERT);
			stmt.setInt(1, emp.getId_emp());
			stmt.setString(2, emp.getNombre());
			stmt.setString(3, emp.getApellido());
			stmt.setDate(4, emp.getFechaAlta());
			stmt.setDouble(5, emp.getSueldo());
			stmt.setInt(6, emp.getCod_dept_emp());
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
            EmpleadosDTO emp = (EmpleadosDTO) pk;
            stmt.setInt(1, emp.getId_emp());
            if (stmt.executeUpdate() > 0) return true;	 
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean actualizar(EmpleadosDTO emp) {
		PreparedStatement stmt = null;
        try {
            stmt = con.getCon().prepareStatement(SQL_UPDATE);
            stmt.setInt(1, emp.getId_emp());
			stmt.setString(2, emp.getNombre());
			stmt.setString(3, emp.getApellido());
			stmt.setDate(4, emp.getFechaAlta());
			stmt.setDouble(5, emp.getSueldo());
			stmt.setInt(6, emp.getCod_dept_emp());
            if (stmt.executeUpdate() > 0) return true;	 
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public EmpleadosDTO buscar(Object pk) {
		PreparedStatement stmt = null;
        try {
            stmt = con.getCon().prepareStatement(SQL_SELECT);
            DepartamentosDTO dpt = (DepartamentosDTO) pk;
            stmt.setInt(1, dpt.getId_dept());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	return new EmpleadosDTO(rs.getInt("id_emp"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fechaAlta"), rs.getDouble("sueldo"), rs.getInt("cod_dept_emp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
	}

	@Override
	public ArrayList<EmpleadosDTO> listarTodos() {
		ArrayList<EmpleadosDTO> empleados = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
             stmt = con.getCon().prepareStatement(SQL_SELECT_TODOS);
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	EmpleadosDTO emp = new EmpleadosDTO(rs.getInt("id_emp"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fechaAlta"), rs.getDouble("sueldo"), rs.getInt("cod_dept_emp"));
                empleados.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados; 
	}

	

}
