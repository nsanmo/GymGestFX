package gymGest;


import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import fabricas.*;
import gymGest.Clase.tipoClase;
//import fabricas.fabricaPalas;
import interfaces.palaPadel;
import persistencia.ClienteDAOImp;
import persistencia.DAL;
import persistencia_dto.ClaseDTO;
import persistencia_dto.ClienteDTO;
import persistencia_dto.MonitorDTO;

public class GymGest {
	private List<Cliente> clientes;
	private List<Monitor> monitores;
	private List<Clase> clases;
	private List<Asistencia> asistencia;
	private static List<Reserva> reservas;
	private static Gimnasio gim;
	private static DAL dal;

	//singleton
	private static GymGest INSTANCE = new GymGest();
	
	//Para systemload...
	int a;

	public GymGest(){
		this.clientes = new ArrayList<Cliente>();
		this.monitores = new ArrayList<Monitor>();
		this.clases = new ArrayList<Clase>();
		this.asistencia = new ArrayList<Asistencia>();
		this.reservas = new ArrayList<Reserva>();
		this.gim = new Gimnasio();
		dal = DAL.getDal();
		systemLoad();
	}

	public DAL getDal() {
		return dal;
	}
	public void setDal(DAL dal) {
		this.dal = dal;
	}
	
	// Control class code
    private void systemLoad(){
    	loadMonitores();
    	loadClientes();
    	loadClases();
    	
    }
    
	
    
    
    
    
    
    //List clientes

    private void loadClientes(){
		List<ClienteDTO> listaClienteDTO = dal.getClientes();
		Cliente cliente;
		for(ClienteDTO cli: listaClienteDTO){
			cliente = new ClienteTotal(cli.getDni(), cli.getNombre(), cli.getDireccion(), cli.getTelefono(), cli.getGama(), cli.isMaterial());
			addCliente(cliente);
		}
	}
	
	// Refactoring: crear constructor en ClienteDTO donde se le pase Cliente
	public void crearCliente(String dni, String nombre, String direccion, String telefono, String gama,
							 boolean material, boolean mañanas, int miembros){
		Cliente cli;

		if(miembros == 1 && mañanas){
			cli = new ClienteMañanas(dni, nombre, direccion, telefono, gama, material);
		} else if (miembros == 1 && !mañanas){
			cli = new ClienteTotal(dni, nombre, direccion, telefono, gama, material);
		} else {cli = new ClienteFamilia(dni, nombre, direccion, telefono, gama, material, miembros);}

		ClienteDTO clienteDTO = new ClienteDTO(dni, nombre, direccion, telefono, gama, material);
		dal.crearCliente(clienteDTO);
		addCliente(cli);
		
	}	

	private void mostrarClientes(){
		for(Cliente cli: clientes){
			System.out.println("Nombre: "+cli.nombre+" Dirección"+cli.direccion+"  pala:"+cli.getPa() +"\n");
		}
	}
	
	
    
    
	public boolean addCliente(Cliente cliente){
		return clientes.add(cliente);
	}
	public boolean borrar_cliente(Cliente client) {
		return clientes.remove(client);
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Cliente getCliente(String dni) {
		for (Cliente cliente : this.clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}
	
	
	

	
	//List monitores

	public void loadMonitores(){
		List<MonitorDTO> listaMonitorDTO = dal.getMonitores();
		Monitor monitor;
		for (MonitorDTO mon: listaMonitorDTO){
			monitor = new Monitor(mon.getId(), mon.getDni(), mon.getNombre(), mon.isMonitorNatacion(), mon.isMonitorRaqueta(), mon.isMonitorSala());
			addMonitor(monitor);
		}
	}
		
	public void crearMonitor(int id, String dni, String nombre, boolean monitorNatacion, boolean monitorRaqueta, boolean monitorSala){
		Monitor mon = new Monitor(id, dni, nombre, monitorNatacion, monitorRaqueta, monitorSala);
		MonitorDTO monDTO = new MonitorDTO(mon);
		addMonitor(mon);
		dal.crearMonitor(monDTO);
	}
	
	public void mostrarMonitores(){
		for(Monitor mon: monitores){
			System.out.println("Monitor" + mon.id + "  Nombre: "+ mon.nombre);
		}
	}
	
	public boolean addMonitor(Monitor monitor){
		return monitores.add(monitor);
	}
	public boolean removeMonitor(Monitor monitor) {return monitores.remove(monitor);}
	public List<Monitor> getEmpleados() {
		return monitores;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.monitores = monitores;
	}
	public Empleado getEmpleado(String dni) {
		for (Empleado empleado : this.monitores) {
			if (empleado.getDni().equals(dni)) {
				return empleado;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

	//List Clases
	private void loadClases(){
		List<ClaseDTO> listaClaseDTO = dal.getClases();
		Clase clase;
		for(ClaseDTO cla: listaClaseDTO){
			clase = new Clase(cla.getDw1(), cla.getDw2(), cla.gettC(), cla.getHora(), cla.getDuracion(), (Monitor)null);
			addClase(clase);
		}
		
	}
	
	public void crearClase(int id, DayOfWeek dw1, DayOfWeek dw2, tipoClase tC, LocalTime hora, int duracion, int monitor){
			Clase clas = new Clase(dw1, dw2, tC, hora, duracion, (Monitor)(Object)monitor); // GUARRADA
			ClaseDTO cla = new ClaseDTO(id, clas);
			
			dal.crearClase(cla);
			addClase(clas);
	}		
	
	public void mostrarClases(){
		for (Clase clase : this.clases) {
			System.out.println(clase.getDw1().toString()+" y "+clase.getDw2().toString()+" clase de "+ clase.gettC().toString()
			+" Hora: " + clase.getHora().toString() + " Duración "+ clase.getDuracion());
		}

	}
	
	public boolean addClase(Clase clase) { return clases.add(clase);}
	
	public boolean removeClase(Clase clase) { return clases.remove(clase);}
	
	public List<Clase> getClases(){ return clases; }
	
	public Clase getClase (DayOfWeek dw, LocalTime lt ){
		for (Clase clase : this.clases) {
			if (clase.getDw1().equals(dw) && clase.getHora().equals(lt)){
				return clase;
			}
		}
		return null;
	}

	
	
	
	
	
		
	
	
	
	
	
	
	





	//List Asistencia
	public boolean addAsistencia(Asistencia asis){
		return asistencia.add(asis);
	}

	// este método no sé si vale para algo, pero hace lo que dice el nombre
	public String getAsistenciaPorCliente(Cliente cli){
		String aPorCli="";
		for(Asistencia aCli : asistencia){
			if(aCli.getCli().equals(cli)) aPorCli+= aCli.getEntrada()+"";
		}
		return aPorCli;
	}

	public String mostrarAsistenciasCliente(Cliente cli){
		String muestra = "";
		for (Asistencia asis : cli.getAsisCliente()){
			muestra += "Entrada "+(asis.getEntrada().getEntrada()).toString()+" Salida "+(asis.getSalida().getSalida()).toString();
		}
		System.out.println(muestra);
		return muestra;
	}

	
	
	// List Reserva

	public static List<Reserva> getReservas(){
		return reservas;
	}
	public void addReserva(Reserva res){
		reservas.add(res);
	}

	//

	public static Gimnasio getGim() {
		return gim;
	}

	public static void setGim(Gimnasio gim) {
		GymGest.gim = gim;
	}


	
	
	public void palaParaTodos(){
		for(Cliente cli: clientes){
			{cli.alquilarPala("media");}
			
		}
		this.mostrarClientes();
	}
	
	
	
	




	public void apuntarclase(Clase cla, Cliente cli){
		cla.addCliente(cli);
		System.out.println("Quedan " + cla.getPlazasLibres() + " plazas libres ");
	}



	public void crearAsistencia(LocalDateTime e, LocalDateTime s, Cliente cli){
		Entrada en;
		Salida sa;
		Asistencia asis = new Asistencia(en = new Entrada(e), sa = new Salida(s), cli);

	}





	
	
	public static void main(String args[]){

		GymGest gg = new GymGest();
		gg.palaParaTodos();

		
	}
}
