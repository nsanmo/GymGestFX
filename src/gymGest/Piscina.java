package gymGest;

import java.util.List;

public class Piscina {
	
	private int longitud; 

	public Piscina(String nombre, List<Monitor> monitoresInstalacion, double precioAlquiler, int longitud){
		//super(nombre, monitoresInstalacion, precioAlquiler);
		this.longitud=longitud;
	}

	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

}
