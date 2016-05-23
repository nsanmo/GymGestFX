package gymGest;

public class ClienteMañanas extends Cliente{
	
	String dni, nombre, direccion, telefono;
	
	public ClienteMañanas(String dni, String nombre, String direccion, String telefono){
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.miembros = 1;
	}
	
	public int fijo() {
      return 20;
	}

	@Override
	public int alquilerMaterial() {
      return 25;
	}

}
