package presentacion.control;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CrearReservaPistaUIControlador extends DialogUIController{

	@FXML
	private TextField dni;
	
	@FXML
	private TextField hora;
	
	@FXML 
	private DatePicker dia;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox pista; 
	
	@FXML 
	private Button Reservar; 
	
	@FXML 
	private Button Cancelar; 
	
	enum pistas {tenis1, tenis2, padel1, padel2, squash1, squash2 };
	
	@SuppressWarnings("unchecked")
	private void fillboxes(){
		
		this.pista.getItems().setAll(pistas.values());
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		GymGest=GymGest.getGymGest();
		
		dialog = new Stage(StageStyle.DECORATED);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Crear Reserva");
		
		fillboxes();
	    
		Cancelar.setOnAction(event -> dialog.close());
		Reservar.setOnAction(event -> {
			
			if(GymGest.getCliente((dni.getText())) == null){ 				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Primero debe darse de alta");

				alert.showAndWait();
				dialog.close();
				
				
			}else if(dni.getText().length()>10){						// Dni inválido
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("WARNING");
					alert.setContentText("DNI field can only have a maximum of 10 characters");
					alert.showAndWait();
		
			}else{
				try{	
					
					String h = hora.getText();
					LocalTime lt = LocalTime.parse(h);
					
					GymGest.reservaPista(pista.getValue().toString(),
								dia.getValue(), lt , dni.getText());
					
					dialog.close();
	            	Alert alert = new Alert(AlertType.INFORMATION);
	            	alert.setTitle("Information Dialog");
	            	alert.setHeaderText(null);
	            	alert.setContentText("Reserva de pista creada");
	            	alert.showAndWait();
				}catch(Exception e){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog");
					alert.setHeaderText("ERROR");
					alert.setContentText("Try to fill all the fields correctly");
					alert.showAndWait();
				} 
			}
		});
	}
}	
