package decoradores;

import interfaces.Recibo;

/**
 * Created by javia_000 on 25/05/2016.
 */
public class DecoradorNATACION extends ComponenteDecorador {
        public DecoradorNATACION(Recibo recibo){
            super(recibo);
        }

        public double calcularMensualidad(){
            return super.calcularMensualidad()+ 25;
        }
}
