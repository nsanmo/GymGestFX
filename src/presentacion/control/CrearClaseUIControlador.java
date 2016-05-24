	package presentacion.control;
		
	import java.net.URL;
	import java.time.DayOfWeek;
	import java.time.LocalTime;
	import java.util.ResourceBundle;

	import gymGest.Clase;
	import gymGest.Monitor;
	import javafx.fxml.FXML;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextField;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	import javafx.stage.StageStyle;
	 
	
	public class CrearClaseUIControlador extends DialogUIController {
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField diaSemana1;
	
	@FXML
	private TextField diaSemana2;
	
	@FXML
	private TextField hora;
	
	@FXML
	private TextField duracion;
	
	@FXML
	private ComboBox tipoClase; 
	
	@FXML
	private ComboBox monitor; 
	
	@FXML
	private Button accept;
	
	@FXML
	private Button cancel;
	
	public void fillboxes(){
		for(Monitor moni: GymGest.getMonitores()){
			monitor.getItems().add(moni.getId()); 	// MEJORAR ESTO
		}
		tipoClase.getItems().setAll(Clase.tipoClase.values());
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		GymGest=GymGest.getGymGest();
		
		dialog = new Stage(StageStyle.DECORATED);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Crear Clase");
		
		fillboxes();
		
		
	    
		cancel.setOnAction(event -> dialog.close());
		
		accept.setOnAction(event -> {
			
				
			
//		if(GymGest.getClase(Integer.parseInt(id.getText())) != null){ 	// Ya hay una clase con ese id
//				Alert alert = new Alert(AlertType.INFORMATION);
//				alert.setTitle("Information Dialog");
//				alert.setHeaderText(null);
//				alert.setContentText("Ya existe una clase con ese id, elija otro");
//
//				alert.showAndWait();
//				dialog.close();	
//			
//		}else{
				int _id;
				DayOfWeek d1, d2;
				
				
		try{			
			String i = id.getText();
			_id = Integer.parseInt(i);
			
			String dS1 = diaSemana1.getText();
			d1 = DayOfWeek.valueOf(dS1);
			String dS2 = diaSemana2.getText();
			d2 = DayOfWeek.valueOf(dS2);
			String h = hora.getText();
			
			Clase.tipoClase tC = (Clase.tipoClase)tipoClase.getValue();
			LocalTime lt = LocalTime.parse(h);
			int idMonitor = (int)(monitor.getValue());
			int dur = Integer.parseInt(duracion.getText());
			Monitor mo = GymGest.getMonitor(idMonitor);
			
			GymGest.crearClase(
					_id,
					d1,
					d2,
					tC,
					lt,
					dur,
					mo);
     
        	dialog.close();
        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Information Dialog");
        	alert.setHeaderText(null);
        	alert.setContentText("Clase creada correctamente");
        	alert.showAndWait();
        	
        }catch(Exception e){
        	
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("ERROR");
			alert.setContentText("Try to fill all the fields correctly");
			alert.showAndWait();	 
		}
	//	}
		
		});
		}
}