package persistencia_dto;


import gymGest.Cliente;
import interfaces.palaPadel;

/**
 * Created by ignaciosantonjamolina on 13/5/16.
 */
public class ClienteDTO{

    String dni;
    String nombre;
    String direccion;
    String telefono;
    String gama;
    boolean material;

    public ClienteDTO(String dni, String nombre, String direccion, String telefono, String gama, boolean material) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gama = gama;
        this.material = material;
    }
    
    //Refactoring
    public ClienteDTO(Cliente cliente){
    	this.dni=cliente.getDni();
    	this.nombre=cliente.getNombre();
    	this.direccion=cliente.getDireccion();
    	this.telefono=cliente.getTelefono();
    	this.gama=cliente.getGama();
    	this.material=cliente.isMaterial();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public boolean isMaterial() {
        return material;
    }

    public void setMaterial(boolean material) {
        this.material = material;
    }
}
