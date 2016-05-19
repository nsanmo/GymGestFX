package persistencia;

import java.util.List;

import excepciones.DAOException;
import persistencia_dto.MonitorDTO;

public interface IMonitorDAO {
	
	public void crearMonitor(MonitorDTO monitorDTO) throws DAOException; 
	public List<MonitorDTO> getMonitores() throws DAOException;
	
}
