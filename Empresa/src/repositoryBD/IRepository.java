package repositoryBD;

import java.util.ArrayList;

public interface IRepository <T>{
	
	public boolean insertar(T t); 
	
	public boolean borrar(Object pk);
	
	public boolean actualizar(T t); 
	
	public T buscar (Object pk);
	
	public ArrayList<T> listarTodos();
}