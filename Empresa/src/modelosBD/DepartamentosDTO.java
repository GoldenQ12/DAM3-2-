package modelosBD;

import java.util.Objects;

public class DepartamentosDTO {
	private int id_dept;
	private String descripcion;
	private String poblacion;
	
	public int getId_dept() {
		return id_dept;
	}
	public void setId_dept(int id_dept) {
		this.id_dept = id_dept;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id_dept, poblacion);
	}
	
	public DepartamentosDTO(int id_dept, String descripcion, String poblacion) {
		super();
		this.id_dept = id_dept;
		this.descripcion = descripcion;
		this.poblacion = poblacion;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentosDTO other = (DepartamentosDTO) obj;
		return Objects.equals(descripcion, other.descripcion) && id_dept == other.id_dept
				&& Objects.equals(poblacion, other.poblacion);
	}
	
	public int compareTo(String anotherString) {
		return descripcion.compareTo(anotherString);
	}
	
	@Override
	public String toString() {
		return "DepartamentoDTO [id_dept=" + id_dept + ", descripcion=" + descripcion + ", poblacion=" + poblacion
				+ "]";
	}
	
	
	
}
