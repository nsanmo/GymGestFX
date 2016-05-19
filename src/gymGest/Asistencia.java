package gymGest;


import java.time.LocalDateTime;
import java.util.List;

public class Asistencia {

    Entrada entrada;
    Salida salida;
    Cliente cli;

    public Asistencia(Entrada e, Salida s, Cliente cli) {
        this.entrada = e;
        this.salida = s;
        this.cli = cli;

    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime e) {

        this.entrada = entrada;
    }

    public Salida getSalida() {

        return salida;
    }

    public void setSalida(LocalDateTime s) {

        this.salida = salida;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

}