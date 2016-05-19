package persistencia_dto;

import gymGest.Gimnasio;
import gymGest.Monitor;

public class MonitorDTO {
	
	int id;
	String dni;
	String nombre;
	boolean monitorNatacion;
	boolean monitorRaqueta;
	boolean monitorSala;
	
	public MonitorDTO(int id, String dni, String nombre, boolean monitorNatacion, boolean monitorRaqueta, boolean monitorSala) {
		this.id=id; 
		this.nombre=nombre;
		this.monitorNatacion=monitorNatacion;
		this.monitorRaqueta=monitorNatacion;
		this.monitorSala=monitorSala;	
	}
	
	public MonitorDTO(Monitor monitor){
		this.id=monitor.getId();
		this.nombre=monitor.getNombre();
		this.monitorNatacion=monitor.isMonitorNatacion();
		this.monitorRaqueta=monitor.isMonitorRaqueta();
		this.monitorSala=monitor.isMonitorSala();
	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMonitorNatacion() {
		return monitorNatacion;
	}

	public void setMonitorNatacion(boolean monitorNatacion) {
		this.monitorNatacion = monitorNatacion;
	}

	public boolean isMonitorRaqueta() {
		return monitorRaqueta;
	}

	public void setMonitorRaqueta(boolean monitorRaqueta) {
		this.monitorRaqueta = monitorRaqueta;
	}

	public boolean isMonitorSala() {
		return monitorSala;
	}

	public void setMonitorSala(boolean monitorSala) {
		this.monitorSala = monitorSala;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
