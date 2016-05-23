package decoradores;

import interfaces.Recibo;

/**
 * Created by javia_000 on 21/04/2016.
 */
public class DecoradorPadel extends ComponenteDecorador {
    public DecoradorPadel(Recibo recibo){
        super(recibo);
    }

    public double calcularMensualidad(){
        return super.calcularMensualidad()+ 27.20;
    }
}