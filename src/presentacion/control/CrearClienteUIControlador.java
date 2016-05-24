package presentacion.control;
	
	import java.awt.Label;
	import java.net.URL;
	import java.time.LocalDateTime;
	import java.time.LocalTime;
	import java.util.ResourceBundle;
	
	import gymGest.Cliente;
	import gymGest.GymGest;
	import javafx.fxml.FXML;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextField;
	import javafx.scene.control.DatePicker;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	import javafx.stage.StageStyle;
	
	
	public class CrearClienteUIControlador extends DialogUIController {
	
	enum gamaPalas {noPala, ninyo, baja, media, alta};
		
	@FXML
	private TextField dni;
	
	@FXML
	private TextField nombre;
	
	@FXML
	private TextField direccion;
	
	@FXML
	private TextField telefono;
	
	@FXML
	private ComboBox gama;
	
	@FXML
	private TextField material;
	
	@FXML
	private Button accept;
	
	@FXML
	private Button cancel;
	
	public void fillboxes(){
		gama.getItems().setAll(gamaPalas.values());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		GymGest=GymGest.getGymGest();
		
		dialog = new Stage(StageStyle.DECORATED);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Crear Cliente");
		
		fillboxes();
	    
		cancel.setOnAction(event -> dialog.close());
		accept.setOnAction(event -> {
				
			
			if(GymGest.getCliente(dni.getText()) != null){ 				// Ese cliente ya está introducido
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Customer with this dni is already registered");
	
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
						 
						
						GymGest.crearCliente(dni.getText(), nombre.getText(), direccion.getText(), telefono.getText(), (gama.getValue()).toString());
			     
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