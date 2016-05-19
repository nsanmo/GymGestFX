package gymGest;

import java.time.LocalDateTime;

public class Salida {

	public Salida(LocalDateTime salida) {
		this.salida = salida;
	}

	private LocalDateTime salida;

	public LocalDateTime getSalida() {
		return salida;
	}

	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}


}
