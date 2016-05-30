package gymGest;


import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
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
import persistencia_dto.PalaDTO;

public class GymGest {
	private List<Cliente> clientes;
	private static List<Monitor> monitores;
	private List<Clase> clases;
	private List<Asistencia> asistencia;
	public List<Reserva> reservas;
	private static List<palaPadel> palas;
	private static Gimnasio gim;
	private static DAL dal;
	
	//singleton
	private static GymGest INSTANCE = new GymGest();	

	public GymGest(){
		this.clientes = new ArrayList<Cliente>();
		this.monitores = new ArrayList<Monitor>();
		this.clases = new ArrayList<Clase>();
		this.asistencia = new ArrayList<Asistencia>();
		this.reservas = new ArrayList<Reserva>();
		this.palas = new ArrayList<palaPadel>();
		this.gim = new Gimnasio();
		dal = DAL.getDal();
		systemLoad();
	}
	
	public static GymGest getGymGest(){
		return INSTANCE;
	}

	public DAL getDal() {
		return dal;
	}
	public void setDal(DAL dal) {
		this.dal = dal;
	}
	
	// Control class code
    private void systemLoad(){
    	loadPalas();
    	loadMonitores();
    	loadClientes();
    	loadClases();
    	//loadReservas();
    }

    //List clientes

    private void loadClientes(){
		List<ClienteDTO> listaClienteDTO = dal.getClientes(); 
	
		String gama;
		for(ClienteDTO cli: listaClienteDTO){
			if(cli.getPalaPadel() < 1000) gama = "ninyo";
			else if (cli.getPalaPadel() > 1000 && cli.getPalaPadel() < 2000) gama = "baja";
			else if (cli.getPalaPadel() > 2000 && cli.getPalaPadel() < 3000) gama = "media";
			else if (cli.getPalaPadel() > 3000) gama = "baja";
			else gama = null;
			
			anyadirClientesLista(cli.getDni(), cli.getNombre(), cli.getDireccion(), cli.getTelefono(), gama);
		
		}
	}
    
    public void anyadirClientesLista(String dni, String nombre, String direccion, String telefono, String gama){
    	Cliente cliente = new Cliente(dni, nombre, direccion, telefono, gama);
    	addCliente(cliente);
    }
    
	public void crearCliente(String dni, String nombre, String direccion, String telefono, String gama){
		
		Cliente cli = new Cliente(dni, nombre, direccion, telefono, gama);
		int numPal = cli.getPa().getCodigo(); 	// Refactoring
		ClienteDTO clienteDTO = new ClienteDTO(dni, nombre, direccion, telefono, numPal);
		PalaDTO palaDTO = new PalaDTO(numPal);
		dal.crearPala(palaDTO);
		dal.crearCliente(clienteDTO);
		addCliente(cli);
		
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
			if ((cliente.getDni().trim()).equals(dni.trim())) {
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
	public List<Monitor> getMonitores() {
		return monitores;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.monitores = monitores;
	}
	
	public Monitor getMonitor(int id) {
		for (Monitor monitor : monitores) {
			if (monitor.getId()==id) {
				return monitor;
			}
		}
		return null;
	}


	//List Clases
	private void loadClases(){
		List<ClaseDTO> listaClaseDTO = dal.getClases();
		Clase clase;
		for(ClaseDTO cla: listaClaseDTO){
			clase = new Clase(cla.getId(), cla.getDw1(), cla.getDw2(), cla.gettC(), cla.getHora(), cla.getDuracion(), (Monitor)null);
			addClase(clase);
		}
		
	}
	
	public void crearClase(int id, DayOfWeek dw1, DayOfWeek dw2, tipoClase tC, LocalTime hora, int duracion, Monitor monitor){
			Clase clas = new Clase(id, dw1, dw2, tC, hora, duracion, monitor); 
			ClaseDTO cla = new ClaseDTO(id, dw1, dw2, tC, hora, duracion, monitor.getId());
			
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
	
	public Clase getClase (int id){
		for (Clase clase : this.clases) {
			if (clase.getId() == id){
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

	public List<Reserva> getReservas(){
		return reservas;
	}
	public void addReserva(Reserva res){
		reservas.add(res);
	}
	
	public int mostrarReservas(){
		return reservas.size();
	}
	
	public void reservaPista(String pista, LocalDate dia, LocalTime hora, String dni){
		switch(pista){
			case "tenis1": gim.reservaTenis(dia, hora, getCliente(dni)); break;
			case "tenis2": gim.reservaTenis2(dia, hora, getCliente(dni)); break;
			case "padel1": gim.reservaPadel(dia, hora, getCliente(dni)); break;
			case "padel2": gim.reservaPadel2(dia, hora, getCliente(dni)); break;
			case "squash1": gim.reservaSquash(dia, hora, getCliente(dni)); break;
			case "squash2": gim.reservaSquash2(dia, hora, getCliente(dni)); break;
		}
	}
	
	

	public static Gimnasio getGim() {
		return gim;
	}

	public static void setGim(Gimnasio gim) {
		GymGest.gim = gim;
	}

	
	public void apuntarclase(Clase cla, Cliente cli){
		cla.addCliente(cli);
		System.out.println("Quedan " + cla.getPlazasLibres() + " plazas libres ");
	}


	// Palas
	
	public void loadPalas(){
		List<PalaDTO> listaPalaDTO = dal.getPalas();
		palaPadel pala;
		int cod;
		for(PalaDTO pa: listaPalaDTO){
			cod = pa.getCodigo();
			if(cod < 1000) {pala = new PalaNinyo(); pala.setCodigo(cod);}
			else if (cod > 1000 && cod < 2000){pala = new PalaGamaBaja(); pala.setCodigo(cod);}
			else if (cod > 2000 && cod < 3000){ pala = new PalaGamaMedia();  pala.setCodigo(cod);}
			else if (cod > 4000){ pala = new PalaGamaAlta();  pala.setCodigo(cod);}
			else pala = null;
			palas.add(pala);
		}
	}
	
	public static void main(String args[]){

		GymGest gg = new GymGest();
		
		

		
	}
}
