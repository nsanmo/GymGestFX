package gymGest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.LocalTime;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static org.junit.Assert.*;

/**
 * Created by javia_000 on 31/05/2016.
 */
public class ClaseTest {
    Cliente c;
    Clase cl;

    @BeforeClass
    public void setUp(){
        c = new Cliente("26748341J", "Ignacio Santonja Molina", "Calle San Fermin 3-17", "695192918");
        Monitor mPadel = new Monitor(111,"38492054Z","Ferran",false,true,false);
        cl = new Clase(1, MONDAY, THURSDAY, Clase.tipoClase.PADEL, LocalTime.of(16,00,00), 120, mPadel );
    }
    @Test
    public void testClase(){
        int plazas = cl.getPlazasLibres();
        cl.addCliente(c);
        assertEquals(plazas-1, cl.getPlazasLibres());
        cl.addCliente(c);
        assertEquals(plazas-1, cl.getPlazasLibres());
    }

}