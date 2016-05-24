package persistencia;

import java.util.List;

import excepciones.DAOException;
import persistencia_dto.PalaDTO;

public interface IPalaDAO {
	public void crearPala(PalaDTO pala) throws DAOException;
    public List<PalaDTO> getPalas() throws DAOException;

}
