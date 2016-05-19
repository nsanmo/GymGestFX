package gymGest;

public class Administrativo extends Empleado{

	public Administrativo(String dni, String nombre) {
		super(dni, nombre);
	}

	public int getSueldo() {
		return super.getSueldo()+100;
	}

}
