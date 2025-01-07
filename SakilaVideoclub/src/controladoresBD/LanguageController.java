package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.Language;

public class LanguageController implements Patron_DAO<Language> {
	
	private static final String SQL_INSERT = "INSERT INTO language (language_id, name, last_update) VALUES (?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM language WHERE language_id = ?";
	private static final String SQL_UPDATE = "UPDATE language SET language_id = ?, name = ?, last_update = ? WHERE language_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM language";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM language WHERE language_id = ?";
	
	
	
	private Conexion con = Conexion.getInstancia();
	
	@Override
	public boolean insertar(Language t) {
		PreparedStatement ps = null;
		try {
			ps=con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getLanguage_id());
			ps.setString(2, t.getName());
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
	public boolean actualizar(Language t) {
		PreparedStatement ps=null;
		try {
			ps=con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getLanguage_id());
			ps.setString(2, t.getName());
			ps.setTimestamp(3, t.getLast_update());
			ps.setInt(4, t.getLanguage_id());
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
	public Language buscar(Object pk) {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Language language = null;
	    try {
	        ps = con.getCon().prepareStatement(SQL_SELECT_BY_ID);
	        ps.setInt(1, (int) pk);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            language = new Language(rs.getInt("language_id"), rs.getString("name"), rs.getTimestamp("last_update"));
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
	    return language;
	}

	@Override
	public ArrayList<Language> listarTodos() {
		 PreparedStatement ps = null;
		    ResultSet rs = null;
		    ArrayList<Language> lista = new ArrayList<>();
		    try {
		        ps = con.getCon().prepareStatement(SQL_SELECT);
		        rs = ps.executeQuery();
		        while (rs.next()) { 
		        	Language language = new Language(rs.getInt("language_id"), rs.getString("name"), rs.getTimestamp("last_update"));
		            lista.add(language);
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