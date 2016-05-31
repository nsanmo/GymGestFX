package gymGest;

import interfaces.pistaDeporteRaqueta;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Created by ignaciosantonjamolina on 11/5/16.
 */

public class Gimnasio{

        private pistaDeporteRaqueta pistaDeTenis;
        private pistaDeporteRaqueta pistaDePadel;
        private pistaDeporteRaqueta pistaDeSquash;
        private pistaDeporteRaqueta pistaDeTenis2;
        private pistaDeporteRaqueta pistaDePadel2;
        private pistaDeporteRaqueta pistaDeSquash2;


        public Gimnasio(){
            pistaDeTenis = new PistaTenis(1, true);
            pistaDeTenis2 = new PistaTenis(2, true);
            pistaDePadel = new PistaPadel(1, true);
            pistaDePadel2 = new PistaPadel(2, true);
            pistaDeSquash = new PistaSquash(1, true);
            pistaDeSquash2 = new PistaSquash(2, true);
        }

        public void reservaTenis(LocalDate dia, LocalTime hora, Cliente cli){
            pistaDeTenis.crearReserva("pistaTenis_1", dia, hora, cli );
        }
        public void reservaTenis2(LocalDate dia, LocalTime hora, Cliente cli){
        pistaDeTenis2.crearReserva("pistaTenis_2", dia, hora, cli);
    }
        public void reservaPadel(LocalDate dia, LocalTime hora, Cliente cli){
            pistaDePadel.crearReserva("pistaPadel_1", dia, hora, cli);
        }
        public void reservaPadel2(LocalDate dia, LocalTime hora, Cliente cli){
        pistaDePadel2.crearReserva("pistaPadel_2", dia, hora, cli);
    }
        public void reservaSquash(LocalDate dia, LocalTime hora, Cliente cli){
           pistaDeSquash.crearReserva("pistaSquash_1", dia, hora, cli);
        }
        public void reservaSquash2(LocalDate dia, LocalTime hora, Cliente cli){
        	pistaDeSquash2.crearReserva("pistaSquash_2", dia, hora, cli);
        }

}



