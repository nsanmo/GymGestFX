package gymGest;

public class ClienteFamilia extends Cliente{
	
	String dni, nombre, direccion, telefono;
	
	
	public ClienteFamilia(String dni, String nombre, String direccion, String telefono){
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.miembros = 1;
	}
	
	
	public int fijo() {
      return 15*getMiembros();
	}

	@Override
	public int alquilerMaterial() {
      return 20*getMiembros();
	}
}
