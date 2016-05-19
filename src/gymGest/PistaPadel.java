package gymGest;

import java.util.ArrayList;
import java.util.List;

public class PistaPadel extends Pista implements interfaces.pistaDeporteRaqueta  {

	public List<Reserva> reservaPadel = new ArrayList<Reserva>();

	public PistaPadel(int id, boolean luz){
		super(id, luz);
	}

	public List<Reserva> getReservaPadel(){
		return reservaPadel;
	}

	public void addReservaPadel(Reserva res){
		reservaPadel.add(res);
	}

	@Override
	public void crearReserva() {

		System.out.println("Reserva en Pista de Padel creada");

	}

}
