package presentacion.control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gymGest.Clase;
import gymGest.Cliente;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class ListarClasesUIControlador extends DialogUIController {

	
private int id;
private Stage primaryStage;
private static final String LISTAR_CLASES="../view/ListarClases.fxml";	
	

	
public void setPrimaryStage(Stage primaryStage) {
	 this.primaryStage = primaryStage;
	 }



@FXML 
private TableView<Clase> table1;

@FXML
private TableColumn <Clase,Integer> column1;

@FXML
private TableColumn <Clase,String> column2;

@FXML
private TableColumn <Clase,String> column3;

@FXML
private TableColumn <Clase,String> column4;

@FXML
private TableColumn <Clase,String> column5;


@FXML
private Button accept;

@FXML
private Button cancel;




@Override
public void initialize(URL location, ResourceBundle resources) {
	GymGest=GymGest.getGymGest();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("LISTAR CLASES");
	
	column1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
	column2.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDw1().toString()));
	column3.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDw2().toString()));
	column4.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().gettC().toString()));
	column5.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getMonitor().getNombre()));

	
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
//		Clase cla = table1.getSelectionModel().getSelectedItem();
////		id = bo.getId();
////		if(vehicleRental.listReservationByBranchOffice(id) == null){
////			
////			
////			table2.getItems().clear();
//		//}
////		
////		table2.getItems().setAll(vehicleRental.listReservationByBranchOffice(id));
////		
	});
	
	
		
	    table1.getItems().addAll(GymGest.getClases());
	}
  }
