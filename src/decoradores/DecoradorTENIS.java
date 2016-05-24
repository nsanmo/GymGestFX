package decoradores;

import interfaces.Recibo;

/**
 * Created by javia_000 on 25/05/2016.
 */
public class DecoradorTENIS extends ComponenteDecorador {
    public DecoradorTENIS(Recibo recibo){
        super(recibo);
    }

    public double calcularMensualidad(){
        return super.calcularMensualidad()+ 34.5;
    }
}
