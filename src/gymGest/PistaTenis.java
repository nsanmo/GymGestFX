package gymGest;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by ignaciosantonjamolina on 11/5/16.
 * 
 */
public class PistaTenis extends Pista implements interfaces.pistaDeporteRaqueta {

	GymGest gg;
	
    public PistaTenis(int id, boolean luz){
        super(id, luz);
    }

    @Override
    public void crearReserva(String pista, LocalDate dia, LocalTime hora, Cliente cli) {
    	gg = GymGest.getGymGest();
		Reserva re = new Reserva(pista , dia, hora, cli);
		gg.addReserva(re);
	}
}


