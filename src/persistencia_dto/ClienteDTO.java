package persistencia_dto;


/**
 * Created by ignaciosantonjamolina on 13/5/16.
 */
public class ClienteDTO{

    String dni;
    String nombre;
    String direccion;
    String telefono;
    int palaPadel;
    
    

    public ClienteDTO(String dni, String nombre, String direccion, String telefono, int palaPadel) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.palaPadel=palaPadel;
        
    }
    
//    //Refactoring
//    public ClienteDTO(Cliente cliente){
//    	this.dni=cliente.getDni();
//    	this.nombre=cliente.getNombre();
//    	this.direccion=cliente.getDireccion();
//    	this.telefono=cliente.getTelefono();
//    
//    }

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

    public int getPalaPadel() {
        return palaPadel;
    }

    public void setPalaPadel(int palaPadel) {
        this.palaPadel=palaPadel;
    }
}
