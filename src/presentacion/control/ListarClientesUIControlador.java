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



public class ListarClientesUIControlador extends DialogUIController {

	
private int id;
private Stage primaryStage;
private static final String LISTAR_CLIENTES="../view/ListarClientes.fxml";	
	

	
public void setPrimaryStage(Stage primaryStage) {
	 this.primaryStage = primaryStage;
	 }

@FXML
private TextField selectCli;

@FXML 
private TableView<Cliente> table1;

@FXML
private TableView<Clase> table2;

@FXML
private TableColumn <Cliente,String> column1;

@FXML
private TableColumn <Cliente,String> column2;

@FXML
private TableColumn <Cliente,Integer> column3;

//@FXML
//private TableColumn<Clase,String> column4;
//
//@FXML 
//private TableColumn<Clase,String> column5;

@FXML
private Button accept;

@FXML
private Button cancel;



@Override
public void initialize(URL location, ResourceBundle resources) {
	GymGest=GymGest.getGymGest();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("LISTAR CLIENTES");
	
	column1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDni()));
	column2.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
	column3.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPa().getCodigo()));

	//	column4.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getTelefono()));
//	column5.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getGama()));
	
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
		Cliente cli = table1.getSelectionModel().getSelectedItem();
//		id = bo.getId();
//		if(vehicleRental.listReservationByBranchOffice(id) == null){
//			
//			
//			table2.getItems().clear();
		//}
//		
//		table2.getItems().setAll(vehicleRental.listReservationByBranchOffice(id));
//		
	});
	
	
		
	    table1.getItems().addAll(GymGest.getClientes());
	}
  }
