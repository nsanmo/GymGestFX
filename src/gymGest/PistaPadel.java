package gymGest;

import java.time.LocalDate;
import java.time.LocalTime;

public class PistaPadel extends Pista implements interfaces.pistaDeporteRaqueta  {

	
	GymGest gg;
	
	public PistaPadel(int id, boolean luz){
		super(id, luz);
	}

	@Override
	public void crearReserva(String pista, LocalDate dia, LocalTime hora, Cliente cli) {
		gg = GymGest.getGymGest();
		Reserva re = new Reserva(pista , dia, hora, cli);
		gg.addReserva(re);
	}

}
