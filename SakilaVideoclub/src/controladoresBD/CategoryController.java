package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Category;

public class CategoryController implements Patron_DAO<Category> {
	
	private static final String SQL_INSERT = "INSERT INTO category (category_id, name, last_update) VALUES (?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM category WHERE category_id = ?";
	private static final String SQL_UPDATE = "UPDATE category SET category_id = ?, name = ?, last_update = ? WHERE category_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM category";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM category WHERE category_id = ?";
	
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Category t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getCategory_id());
			ps.setString(2, t.getName());
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
	public boolean actualizar(Category t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getCategory_id());
			ps.setString(2, t.getName());
			ps.setTimestamp(3, t.getLast_update());
			ps.setInt(4, t.getCategory_id());
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
	public Category buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Category category = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            category = new Category(rs.getInt("category_id"), rs.getString("name"), rs.getTimestamp("last_update"));
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
	    return category;
	}

	@Override
	public ArrayList<Category> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Category> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Category category = new Category(rs.getInt("category_id"), rs.getString("name"), rs.getTimestamp("last_update"));
		            lista.add(category);
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
