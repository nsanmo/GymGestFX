package gymGest;

import decoradores.DecoradorNATACION;
import decoradores.DecoradorPADEL;
import decoradores.DecoradorTENIS;
import interfaces.Recibo;
import interfaces.palaPadel;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private palaPadel pala;
	private Recibo recibo = new Mensualidad();
	private Tienda tienda;
	public List<Asistencia>  asisCliente = new ArrayList<Asistencia>();
	public List<Reserva> reservasPorCliente = new ArrayList<Reserva>();
	public List<Clase> clases = new ArrayList<>();

	public Cliente(String dni, String nombre, String direccion, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	//	this.cuota = cuotaMensual();
		//this.pala = alquilarPala(gama);
	}

	public List<Asistencia> getAsisCliente() {
		return asisCliente;
	}

	public void setAsisCliente(List<Asistencia> asisCliente) {
		this.asisCliente = asisCliente;
	}

	public void addAsisCliente(Asistencia asis){
		asisCliente.add(asis);
	}

	public List<Reserva> getReservasPorCliente() {
		return reservasPorCliente;
	}

	public void setReservasPorCliente(List<Reserva> reservasPorCliente) {
		this.reservasPorCliente = reservasPorCliente;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public palaPadel getPa() {
		return pala;
	}
	public void setPa(palaPadel pala) {
		this.pala = pala;
	}
	
	public palaPadel alquilarPala(String gama){
		tienda = new Tienda();
		//palaPadel pa = tienda.alquilarPalaPadel(this, gama); 
		//this.setPa(pa);
		return tienda.alquilarPalaPadel(this, gama); 
	}

	public double calcularRecibo(){
//		for(Clase c : clases) {
//			switch (c.gettC()) {
//				case PADEL:
//					recibo = new DecoradorPADEL(recibo);
//				case TENIS:
//					recibo = new DecoradorTENIS(recibo);
//				case NATACIÓN:
//					recibo = new DecoradorNATACION(recibo);
//			}
//		}
		return recibo.calcularMensualidad();
	}

	public Recibo getRecibo() {
		return recibo;
	}

	public void anyadirClase(Clase clase){
		clases.add(clase);
		if(clase.gettC().equals(Clase.tipoClase.PADEL)) recibo = new DecoradorPADEL(recibo);
		else if(clase.gettC().equals(Clase.tipoClase.TENIS)) recibo = new DecoradorTENIS(recibo);
		else recibo = new DecoradorNATACION(recibo);
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
}
