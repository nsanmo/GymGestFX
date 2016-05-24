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
	private palaPadel pa;
	private Recibo recibo = new Mensualidad();
	private Tienda tienda;
	public List<Asistencia>  asisCliente = new ArrayList<Asistencia>();
	public List<Reserva> reservasPorCliente = new ArrayList<Reserva>();
	public List<Clase> clases = new ArrayList<>();

	public Cliente(String dni, String nombre, String direccion, String telefono, String gama) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	//	this.cuota = cuotaMensual();
		this.pa = alquilarPala(gama);
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

	//Esto no deberia estar en gymgest??
	public void addReservaPorCliente(Reserva res){
		for(Reserva re: GymGest.getReservas()){
			if(res.getAño() == re.getAño() &&
					res.getMes() == re.getMes() &&
						res.getDia() == re.getDia() &&
							res.getHora() == re.getHora() &&
								res.getMinutos() == re.getMinutos() &&
									res.getPista() == re.getPista()){
										System.out.println("Ocupado");}
			else{
				reservasPorCliente.add(res);

				switch (res.getPista()) {
					case "tenis1":
						GymGest.getGim().reservaTenis();
					case "tenis2":
						GymGest.getGim().reservaTenis2();
					case "padel1":
						GymGest.getGim().reservaPadel();
					case "padel2":
						GymGest.getGim().reservaPadel2();
					case "squash1":
						GymGest.getGim().reservaSquash();
					case "squash2":
						GymGest.getGim().reservaSquash2();

				}
			}
		}

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
//	public String getGama() {
//		return gama;
//	}
//	public void setGama(String gama) {
//		this.gama = gama;
//	}
	public palaPadel getPa() {
		return pa;
	}
	public void setPa(palaPadel pa) {
		this.pa = pa;
	}

//	public final int cuotaMensual(){
//		int cuota = 0;
////		if(isMaterial()){return fijo()+alquilerMaterial();}
//		return fijo();
//	}
//
//	abstract int fijo();
//	abstract int alquilerMaterial();
	
	public palaPadel alquilarPala(String gama){
		tienda = new Tienda();
		//palaPadel pa = tienda.alquilarPalaPadel(this, gama); 
		//this.setPa(pa);
		return tienda.alquilarPalaPadel(this, gama); 
	}

	public double calcularRecibo(){
		for(Clase c : clases) {
			switch (c.gettC().name()) {
				case "PADEL":
					recibo = new DecoradorPADEL(recibo);
				case "TENIS":
					recibo = new DecoradorTENIS(recibo);
				case "NATACION":
					recibo = new DecoradorNATACION(recibo);
			}
		}
		return recibo.calcularMensualidad();
	}

	public Recibo getRecibo() {
		return recibo;
	}

	public void anyadirClase(Clase clase){
		clases.add(clase);
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
}
