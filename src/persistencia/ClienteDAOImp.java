package persistencia;

import excepciones.DAOException;
import persistencia_dto.ClienteDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ignaciosantonjamolina on 13/5/16.
 */
public class ClienteDAOImp implements IClienteDAO{

    protected ConnectionManager connManager;

    public ClienteDAOImp() throws DAOException {
        super();

        try {
            connManager = new ConnectionManager("gimGest");
        }
        catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }
    
    public void crearCliente(ClienteDTO cliente) throws DAOException{
        try{
        	
        	String ins = "INSERT INTO PUBLIC.CLIENTE VALUES ('"+cliente.getDni()+"', '"+cliente.getNombre()+"', '"+cliente.getDireccion()+"', '"+cliente.getTelefono()+"',"+cliente.getPalaPadel()+")";
        
            connManager.connect();
            connManager.updateDB(ins);
            connManager.close();

        }
        catch (SQLException e){ System.out.println("error"); throw new DAOException(e); }
    }
    
    public List<ClienteDTO> getClientes() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from CLIENTE");
			connManager.close();

			List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();

			try {
				while (rs.next()) {

					ClienteDTO clienteDTO = new ClienteDTO(
							rs.getString("ID"),
							rs.getString("NOMBRE"),
							rs.getString("DIRECCION"),
							rs.getString("TELEFONO"),
							rs.getInt("PALAPADELID"));

					listaClienteDTO.add(clienteDTO);
				}
				return listaClienteDTO;
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
