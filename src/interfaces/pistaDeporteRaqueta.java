package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

import gymGest.Cliente;
import gymGest.Reserva;

/**
 * Created by ignaciosantonjamolina on 11/5/16.
 */
public interface pistaDeporteRaqueta {
    void crearReserva(String pista, LocalDate dia, LocalTime hora, Cliente cli);


}
