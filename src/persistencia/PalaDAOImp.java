package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOException;
import persistencia_dto.PalaDTO;

public class PalaDAOImp implements IPalaDAO{

	protected ConnectionManager connManager;

    public PalaDAOImp() throws DAOException {
        super();

        try {
            connManager = new ConnectionManager("gimGest");
        }
        catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }
    
	@Override
	public void crearPala(PalaDTO pala) throws DAOException {
		try{
        	
        	String ins = "INSERT INTO PUBLIC.PALAPADEL VALUES ("+pala.getCodigo()+")";
        
            connManager.connect();
            connManager.updateDB(ins);
            connManager.close();

        }
        catch (SQLException e){ System.out.println("error"); throw new DAOException(e); }
	
	}

	@Override
	public List<PalaDTO> getPalas() throws DAOException {
		
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from PALAPADEL");
			connManager.close();

			List<PalaDTO> listaPalaDTO = new ArrayList<PalaDTO>();

			try {
				while (rs.next()) {

					PalaDTO PalaDTO = new PalaDTO(rs.getInt("ID"));
					listaPalaDTO.add(PalaDTO);
				}
				return listaPalaDTO;
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
