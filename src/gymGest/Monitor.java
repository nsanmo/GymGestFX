package gymGest;

public class Monitor extends Empleado{
	
	int id;
	boolean monitorNatacion;
	boolean monitorRaqueta;
	boolean monitorSala;
	Gimnasio moniGim;

	public Monitor(int id, String dni, String nombre, boolean monitorNatacion, boolean monitorRaqueta, boolean monitorSala) {
		super(dni, nombre);
		this.id=id;
		this.monitorNatacion=monitorNatacion;
		this.monitorRaqueta=monitorRaqueta;
		this.monitorSala=monitorSala;
	}

	public int getSueldo() {
		return super.getSueldo()+150;
	}

	public boolean isMonitorNatacion() {
		return monitorNatacion;
	}

	public void setMonitorNatacion(boolean monitorNatacion) {
		this.monitorNatacion = monitorNatacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
}
