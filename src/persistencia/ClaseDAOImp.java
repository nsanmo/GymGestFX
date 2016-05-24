package persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOException;
import gymGest.Monitor;
import persistencia_dto.ClaseDTO;
import persistencia_dto.ClienteDTO;
import gymGest.Clase.tipoClase;

public class ClaseDAOImp implements IClaseDAO {
	protected ConnectionManager connManager;

    public ClaseDAOImp() throws DAOException {
        super();

        try {
            connManager = new ConnectionManager("gimGest");
        }
        catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }
    
    public void crearClase(ClaseDTO clase) throws DAOException{
    	
    	 try{
    		//String ld = clase.getHora().toString(); 
         	//Time hora = Time.valueOf(ld);
    		String lt = clase.getHora().toString();
    		//Time hora = Time.valueOf(lt);
    		 
    		 
         	String ins = "INSERT INTO PUBLIC.CLASE VALUES ("
         	+clase.getId()+", '"
         	+clase.getDw1().toString()+"', '"
         	+clase.getDw2().toString()+"', '"
         	+clase.gettC().toString()+"', '"
         	+"10:00:00"+"', " // ARREGLAR
         	+clase.getDuracion()+", "
         	+clase.getMonitor()+");";
         
             connManager.connect();
             connManager.updateDB(ins);
             connManager.close();

         }
         catch (SQLException e){ System.out.println("error"); throw new DAOException(e); }
    	
    }

    public List<ClaseDTO> getClases() throws DAOException{
    	try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from CLASE");
			connManager.close();

			List<ClaseDTO> listaClaseDTO = new ArrayList<ClaseDTO>();

			try {
				while (rs.next()) {
					
					String diasemana1 = (rs.getString("DIASEMANA1")).trim();
					String diasemana2 = (rs.getString("DIASEMANA2")).trim();
					
					DayOfWeek d1 = DayOfWeek.valueOf(diasemana1);
					DayOfWeek d2 = DayOfWeek.valueOf(diasemana2);
					

					ClaseDTO claseDTO = new ClaseDTO(
							rs.getInt("ID"), 
						//	DayOfWeek.valueOf(rs.getString("DIASEMANA1")),
							d1,
						//	DayOfWeek.valueOf(rs.getString("DIASEMANA2")),
							d2,
							tipoClase.valueOf(rs.getString("ACTIVIDAD").trim()),
							(rs.getTime("HORA")).toLocalTime(),
							rs.getInt("DURACION"),
							rs.getInt("MONITOR"));					
					
					listaClaseDTO.add(claseDTO);
				}
				return listaClaseDTO;
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
