package controladoresBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import modelosBD.FilmCategory;


public class FilmCategoryController implements Patron_DAO<FilmCategory>{
	private static final String SQL_INSERT = "INSERT INTO film_category (film_id, category_id, last_update) VALUES (?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM film_category WHERE film_id = ?";
	private static final String SQL_UPDATE = "UPDATE film_category SET film_id = ?, category_id = ?, last_update = ? WHERE film_id = ?";
	private static final String SQL_SELECT = "SELECT * FROM film_category WHERE film_id = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM film_category";
	
	// Connection object creation
	private Conexion con = Conexion.getInstancia();

	@Override
	public boolean insertar(FilmCategory t) {
		PreparedStatement ps = null;
		
		try {
			ps = con.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getFilm_id());
			ps.setInt(2, t.getCategory_id());
			ps.setTimestamp(3, t.getLast_update());

			if (ps.executeUpdate() > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (ps != null)
					ps.close(); // Close the PreparedStatement
			} catch (Exception e2) {
				e2.printStackTrace();
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
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		finally {
			try {
				if (ps != null)
					ps.close(); // Close the PreparedStatement
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean actualizar(FilmCategory t) {
		PreparedStatement ps = null;
		
		try {
			ps = con.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getFilm_id());
			ps.setInt(2, t.getCategory_id());
			ps.setTimestamp(3, t.getLast_update());
			ps.setInt(4, t.getFilm_id());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (ps != null)
					ps.close(); // Close the PreparedStatement
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public FilmCategory buscar(Object pk) {
		PreparedStatement ps = null;
		FilmCategory film = null;
		try {
            ps = con.getCon().prepareStatement(SQL_SELECT);
            ps.setInt(1, (int)pk);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return film = new FilmCategory(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3));
            }
		} catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (ps != null)
                    ps.close(); // Close the PreparedStatement
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return film;
	}

	@Override
	public ArrayList<FilmCategory> listarTodos() {
		PreparedStatement ps = null;
		
		try {
			ps = con.getCon().prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = ps.executeQuery();

			ArrayList<FilmCategory> film_category = new ArrayList<FilmCategory>();

			while (rs.next()) {
				film_category.add(new FilmCategory(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3)));
			}
			return film_category;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (ps != null)
					ps.close(); // Close the PreparedStatement
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	

}