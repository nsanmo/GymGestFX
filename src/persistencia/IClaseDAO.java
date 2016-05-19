package persistencia;

import java.util.List;

import excepciones.DAOException;
import persistencia_dto.ClaseDTO;

public interface IClaseDAO {
	 public void crearClase(ClaseDTO clase) throws DAOException;
	 public List<ClaseDTO> getClases() throws DAOException;
	 
}
