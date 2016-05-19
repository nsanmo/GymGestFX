package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOException;
import persistencia_dto.MonitorDTO;

public class MonitorDAOImp implements IMonitorDAO{
	protected ConnectionManager connManager;
	
	public MonitorDAOImp() throws DAOException {
        super();

        try {
            connManager = new ConnectionManager("gimGest");
        }
        catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }

	@Override
	public void crearMonitor(MonitorDTO monitorDTO) throws DAOException {
		
		try{
        	
        	String ins = "INSERT INTO PUBLIC.MONITOR VALUES ('"+monitorDTO.getId()+"', '"+monitorDTO.getNombre()+
        			"', "+monitorDTO.isMonitorNatacion()+","+monitorDTO.isMonitorRaqueta()+","+monitorDTO.isMonitorSala()+")";
        
            connManager.connect();
            connManager.updateDB(ins);
            connManager.close();
            
        }
        catch (SQLException e){ System.out.println("error"); throw new DAOException(e);}
	}

	@Override
	public List<MonitorDTO> getMonitores() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from MONITOR");
			connManager.close();

			List<MonitorDTO> listaMonitorDTO = new ArrayList<MonitorDTO>();

			try {
				while (rs.next()) {

					MonitorDTO MonitorDTO = new MonitorDTO(
							rs.getInt("ID"),
							null, 
							rs.getString("NAME"),
							rs.getBoolean("ISNATACION"),
							rs.getBoolean("ISRAQUETA"),
							rs.getBoolean("ISSALA"));

					listaMonitorDTO.add(MonitorDTO);
				}
				return listaMonitorDTO;
			} catch (Exception e) {
				throw new DAOException(e);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (DAOException e) {
			throw e;
		}
	}

}
