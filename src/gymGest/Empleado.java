package gymGest;

public class Empleado {
	
	String dni;
	String nombre;
	int sueldo = 1000;

	public Empleado(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	
	

}
