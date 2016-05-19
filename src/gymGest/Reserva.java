package gymGest;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ignaciosantonjamolina on 14/5/16.
 */
public class Reserva {

    int año;
    Month mes;
    int dia;
    int hora;
    int minutos;
    Cliente cli;
    String pista;

    public Reserva(int año, Month mes, int dia, int hora, int minutos, String pista, Cliente cli) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
        this.pista = pista;
        this.cli=cli;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Month getMes() {
        return mes;
    }

    public void setMes(Month mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }
}
