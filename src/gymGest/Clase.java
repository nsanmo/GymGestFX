package gymGest;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clase {

	public enum tipoClase {PADEL, TENIS, NATACIÓN}

	int id;
	private tipoClase tC;
	private DayOfWeek dw1, dw2;
	private LocalTime hora;
	private int duracion;
	private Monitor monitor;
	private int plazasLibres=PLAZAS;
	private static final int PLAZAS = 8;

	private List<Cliente> listaClienteActividad = new ArrayList<Cliente>();

	public Clase(int id, DayOfWeek dw1, DayOfWeek dw2, tipoClase tC, LocalTime hora, int duracion, Monitor monitor) {

		this.id = id;
		this.tC = tC;
		this.dw1 = dw1;
		this.dw2 = dw2;
		this.hora = hora;
		this.duracion = duracion;
		this.monitor = monitor;

	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public tipoClase gettC() {
		return tC;
	}

	public void settC(tipoClase tC) {
		this.tC = tC;
	}

	public DayOfWeek getDw1() {
		return dw1;
	}

	public void setDw1(DayOfWeek dw1) {
		this.dw1 = dw1;
	}

	public DayOfWeek getDw2() {
		return dw2;
	}

	public void setDw2(DayOfWeek dw2) {
		this.dw2 = dw2;
	}

	public DayOfWeek getDia1() {

		return dw1;
	}

	public void setFechaDia1(DayOfWeek dw) {

		this.dw1 = dw;
	}

	public DayOfWeek getDia2() {

		return dw1;
	}

	public void setFechaDia2(DayOfWeek dw) {

		this.dw2 = dw;
	}

	public LocalTime getHora() {

		return hora;
	}

	public void setHora(LocalTime hora) {

		this.hora = hora;
	}

	public int getDuracion() {

		return duracion;
	}

	public void setDuracion(int duracion) {

		this.duracion = duracion;
	}

	public Monitor getMonitor() {

		return monitor;
	}

	public void setMonitor(Monitor monitor) {

		this.monitor = monitor;
	}

	public int getPlazasLibres() {
		return plazasLibres;
	}

	public void plazasLibres(){
		System.out.println("Quedan " + getPlazasLibres() + " plazas libres en esta actividad");
	}

	public void setPlazasLibres(int plazasLibres) {
		this.plazasLibres = plazasLibres;
	}

	public void addCliente(Cliente cli){
		if(plazasLibres>0 && !listaClienteActividad.contains(cli)) {
			plazasLibres--;
			listaClienteActividad.add(cli);
		} else if(plazasLibres>0){
			System.out.println("El cliente ya está apuntado a esta actividad");
		} else
			System.out.println("No quedan plazas en este grupo");
	}

	public void removeCliente(Cliente cli){
		if(listaClienteActividad.contains(cli)) {
			plazasLibres++;
			listaClienteActividad.remove(cli);
		}
	}
}
