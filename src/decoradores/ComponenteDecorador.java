package decoradores;

import interfaces.Recibo;

/**
 * Created by javia_000 on 21/04/2016.
 */
public abstract class ComponenteDecorador implements Recibo {
    protected Recibo recibo;

    public ComponenteDecorador(Recibo recibo){
        this.recibo=recibo;
    }
    public double calcularMensualidad(){ return recibo.calcularMensualidad();}
}