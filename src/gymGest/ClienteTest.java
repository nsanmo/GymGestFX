package gymGest;

import decoradores.DecoradorNATACION;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.THURSDAY;
import static org.junit.Assert.*;

/**
 * Created by javia_000 on 30/05/2016.
 */
public class ClienteTest {
    Cliente c;
    Clase padel;
    Clase natacion;
    Clase tenis;
    @BeforeClass
    public void setUp(){
        c = new Cliente("26749741M", "Javier Andrés Pérez", "Calle Antoni Tapies 3-17", "695141007");
        Monitor mPadel = new Monitor(111,"38492054Z","Ferran",false,true,false);
        Monitor mNatacion = new Monitor(111,"384122054Z","Ramon",true,false,false);
        Monitor mTenis = new Monitor(111,"38492114Z","Tomas",false,true,false);
        padel = new Clase(1, MONDAY, THURSDAY, Clase.tipoClase.PADEL, LocalTime.of(16,00,00), 120, mPadel );
        natacion= new Clase(1, TUESDAY, FRIDAY, Clase.tipoClase.NATACIÓN, LocalTime.of(16,00,00), 120, mNatacion );
        tenis= new Clase(1, TUESDAY, FRIDAY, Clase.tipoClase.TENIS, LocalTime.of(16,00,00), 120, mTenis );

    }
    @Test
    public void calcularRecibo() throws Exception {
        c.anyadirClase(padel);
        assertEquals(27.20, c.calcularRecibo(), 0.001);
        c.anyadirClase(natacion);
        assertEquals(27.20+25, c.calcularRecibo(), 0.001);
        c.anyadirClase(tenis);
        assertEquals(27.20+25+34.5, c.calcularRecibo(), 0.001);

    }

}