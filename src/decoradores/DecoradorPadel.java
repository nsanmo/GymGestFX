package decoradores;

import interfaces.Recibo;

/**
 * Created by javia_000 on 21/04/2016.
 */
public class DecoradorPADEL extends ComponenteDecorador {
    public DecoradorPADEL(Recibo recibo){
        super(recibo);
    }

    public double calcularMensualidad(){
        return super.calcularMensualidad()+ 27.2;
    }
}