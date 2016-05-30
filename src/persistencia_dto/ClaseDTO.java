package persistencia_dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import gymGest.Clase;
import gymGest.Clase.tipoClase;
import gymGest.Cliente;
import gymGest.Monitor;

public class ClaseDTO{
	
	private int id;
	private tipoClase tC;
	private DayOfWeek dw1, dw2;
	private LocalTime hora;
	private int duracion;
	private int monitor;


	public ClaseDTO(int id, DayOfWeek dw1, DayOfWeek dw2, tipoClase tC, LocalTime hora, int duracion, int monitor) {

		this.id = id;
		this.tC = tC;
		this.dw1 = dw1;
		this.dw2 = dw2;
		this.hora = hora;
		this.duracion = duracion;
		this.monitor = monitor;

	}
	
	public ClaseDTO(Clase clase){
		
		this.id = clase.getId();
		this.tC = clase.gettC();
		this.dw1 = clase.getDw1();
		this.dw2 = clase.getDw2();
		this.hora = clase.getHora();
		this.duracion = clase.getDuracion();
		this.monitor = clase.getMonitor().getId();
		
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


	public int getMonitor() {
		return monitor;
	}


	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}
}
