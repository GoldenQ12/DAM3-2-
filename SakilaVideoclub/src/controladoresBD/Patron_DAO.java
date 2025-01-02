package controladoresBD;

import java.util.ArrayList;

public interface Patron_DAO <TipoGen>{
public boolean insertar(TipoGen t); 
public boolean borrar(Object pk);
public boolean actualizar(TipoGen t); 
public TipoGen buscar (Object pk); 
public ArrayList<TipoGen> listarTodos();

}