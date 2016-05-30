package gymGest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ignaciosantonjamolina on 14/5/16.
 */
public class Reserva {

    int año;
    Month mes;
    LocalDate dia;
    LocalTime hora;
    int minutos;
    Cliente cli;
    String pista;
    
    public Reserva(String pista, LocalDate dia, LocalTime hora, Cliente cli){
    	this.pista = pista;
    	this.dia = dia;
    	this.hora = hora; 
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

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
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
