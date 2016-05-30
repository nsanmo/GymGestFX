package presentacion.control;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CrearMonitorUIControlador extends DialogUIController {
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField dni;
	
	@FXML
	private TextField nombre;
	
	@FXML
	private TextField monitorNatacion;
	
	@FXML
	private TextField monitorRaqueta;
	
	@FXML
	private TextField monitorSala;
	
	@FXML
	private Button accept;
	
	@FXML
	private Button cancel;
	
	//private Monitor newMonitor;
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		GymGest=GymGest.getGymGest();
		
		dialog = new Stage(StageStyle.DECORATED);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Crear Monitor");
	    
		cancel.setOnAction(event -> dialog.close());
		accept.setOnAction(event -> {
				
			
			if(GymGest.getMonitor(Integer.parseInt(id.getText())) != null){ 				// Ese monitor ya está introducido
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Esta id ya está utilizada");
	
					alert.showAndWait();
					dialog.close();
					
					
			}else{
					
					if(dni.getText().length()>10){						// Dni inválido
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning Dialog");
						alert.setHeaderText("WARNING");
						alert.setContentText("DNI field can only have a maximum of 10 characters");
	
						alert.showAndWait();
			
			}else{
					
					try{			
	      
						 
						GymGest.crearMonitor(Integer.parseInt(id.getText()), dni.getText(), nombre.getText(),
								Boolean.getBoolean(monitorNatacion.getText()), Boolean.getBoolean(monitorRaqueta.getText()), 
										Boolean.getBoolean(monitorSala.getText())); 
						
					
		            	dialog.close();
		            	Alert alert = new Alert(AlertType.INFORMATION);
		            	alert.setTitle("Information Dialog");
		            	alert.setHeaderText(null);
		            	alert.setContentText("Customer succesfully created");
		            	alert.showAndWait();
			        }catch(Exception e){
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Dialog");
						alert.setHeaderText("ERROR");
						alert.setContentText("Try to fill all the fields correctly");
						alert.showAndWait();	 
					}
			}
			}
			});
		}
}


