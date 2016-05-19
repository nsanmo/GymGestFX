package persistencia;

import java.util.List;

import excepciones.DAOException;
import persistencia_dto.ClienteDTO;


/**
 * Created by ignaciosantonjamolina on 13/5/16.
 */
public interface IClienteDAO {

    public void crearCliente(ClienteDTO cliente) throws DAOException;
    public List<ClienteDTO> getClientes() throws DAOException;

}
