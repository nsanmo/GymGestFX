package persistencia;

import java.util.List;

import excepciones.DAOException;
import persistencia_dto.ClaseDTO;
import persistencia_dto.ClienteDTO;
import persistencia_dto.MonitorDTO;
import persistencia_dto.PalaDTO;

/**
 * Created by ignaciosantonjamolina on 13/5/16.
 */
public final class DAL {

    private IClienteDAO cliDAO;
    private IClaseDAO claDAO;
    private IMonitorDAO moDAO;
    private IPalaDAO paDAO;

    private static DAL INSTANCE = new DAL();

    private DAL() {
        try {
            this.cliDAO = new ClienteDAOImp();
            this.claDAO = new ClaseDAOImp();
            this.moDAO = new MonitorDAOImp();
            this.paDAO = new PalaDAOImp();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static DAL getDal() {
        return INSTANCE;
    }

    public boolean crearCliente(ClienteDTO clienteDTO){
        try{
            cliDAO.crearCliente(clienteDTO);
            return true;
        }catch(DAOException e){ return false;}
    }
    
    public List<ClienteDTO> getClientes(){
    	try{
    		return cliDAO.getClientes();
    	}catch (DAOException e){
    		return null;
    	}
    }

    public boolean crearClase(ClaseDTO claseDTO){
    	 try{
             claDAO.crearClase(claseDTO);
             return true;
         }catch(DAOException e){ return false;}
    }
    
    public List<ClaseDTO> getClases(){
    	try{
    		return claDAO.getClases();
    	}catch (DAOException e){
    		return null;
    	}
    }
   
    public boolean crearMonitor(MonitorDTO monitorDTO){
    	try{
            moDAO.crearMonitor(monitorDTO);
            return true;
        }catch(DAOException e){ return false;}
	}

	public List<MonitorDTO> getMonitores(){
		try{
    		return moDAO.getMonitores();
    	}catch (DAOException e){
    		return null;
    	}
	}
	public boolean crearPala(PalaDTO pala){
    	try{
            paDAO.crearPala(pala);
            return true;
        }catch(DAOException e){ return false;}
	}

	public List<PalaDTO> getPalas(){
		try{
    		return paDAO.getPalas();
    	}catch (DAOException e){
    		return null;
    	}
	}
    


}