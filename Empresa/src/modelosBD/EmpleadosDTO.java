package modelosBD;

import java.sql.Date;
import java.util.Objects;

public class EmpleadosDTO {
	private int id_emp;
	private String nombre;
	private String apellido;
	private Date fechaAlta;
	private double sueldo;
	private int cod_dept_emp;
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public int getCod_dept_emp() {
		return cod_dept_emp;
	}
	public void setCod_dept_emp(int cod_dept_emp) {
		this.cod_dept_emp = cod_dept_emp;
	}
	
	public int compareTo(String anotherString) {
		return nombre.compareTo(anotherString);
	}
	public EmpleadosDTO(int id_emp, String nombre, String apellido, Date fechaAlta, double sueldo, int cod_dept_emp) {
		super();
		this.id_emp = id_emp;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaAlta = fechaAlta;
		this.sueldo = sueldo;
		this.cod_dept_emp = cod_dept_emp;
	}
	
	@Override
	public String toString() {
		return "EmpleadosDTO [id_emp=" + id_emp + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaAlta="
				+ fechaAlta + ", sueldo=" + sueldo + ", cod_dept_emp=" + cod_dept_emp + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_emp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadosDTO other = (EmpleadosDTO) obj;
		return id_emp == other.id_emp;
	}
	

}
