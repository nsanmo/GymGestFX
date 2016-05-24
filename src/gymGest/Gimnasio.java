package gymGest;

import interfaces.pistaDeporteRaqueta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ignaciosantonjamolina on 11/5/16.
 */

public class Gimnasio{

    //Anterior public class pistaDeporteRaquetaMaker {

        // A modo de systemload
        // No se deberían crear pistas fuera de esta clase

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

        public void reservaTenis(){
            pistaDeTenis.crearReserva();
        }
        public void reservaTenis2(){
        pistaDeTenis2.crearReserva();
    }
        public void reservaPadel(){
            pistaDePadel.crearReserva();
        }
        public void reservaPadel2(){
        pistaDePadel2.crearReserva();
    }
        public void reservaSquash(){
            pistaDeSquash.crearReserva();
        }
        public void reservaSquash2(){
        	pistaDeSquash2.crearReserva();
        }

}



