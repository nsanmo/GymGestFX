package gymGest;

import java.util.List;

/**
 * Created by ignaciosantonjamolina on 11/5/16.
 */
public class PistaTenis extends Pista implements interfaces.pistaDeporteRaqueta {

    public PistaTenis(int id, boolean luz){

        super(id, luz);

    }

    @Override
    public void crearReserva() {

            System.out.println("Reserva en Pista de Tenis creada");

    }

}


