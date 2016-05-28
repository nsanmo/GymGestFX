package presentacion.control;

import excepciones.LogicException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class MainUIController {

	//TODO add String constants for the views related to the use cases Create Reservation and List Reservations
// private static final String VEHICLE_PICKUP="../view/reservedVehiclePickupView.fxml";
// private static final String LIST_VEHICLE_BRANCH_OFFICE="../view/listVehicles.fxml";
// private static final String CREATE_RESERVATION="../view/createReservation.fxml";
	private static final String LISTAR_CLIENTES="../view/ListarClientes.fxml";
	private static final String CREAR_RESERVA="../view/reservaPista.fxml";
	private static final String CREAR_CLIENTE="../view/crearCliente.fxml";
	private static final String CREAR_MONITOR="../view/crearMonitor.fxml";
	private static final String CREAR_CLASE="../view/crearClase.fxml";
	
 private Stage primaryStage;
 
 private ListarClientesUIControlador listarClientesUIControlador;
// private CreateCustomerUIController createCustomerController;
 private CrearClienteUIControlador crearClienteControlador;
 private CrearMonitorUIControlador crearMonitorControlador;
 private CrearClaseUIControlador crearClaseControlador;
 private CrearReservaPistaUIControlador crearReservaPistaControlador;
// private CreateReservationUIController createReservationController;
// private ListVehiclesUIController listVehiclesController;
// private PickUpReservationUIController pickUpReservation;
 
// @FXML private MenuItem menuPickUpReservation;
// @FXML private MenuItem menuListVehicles;
 @FXML private MenuItem menuClose;
// @FXML private MenuItem menuCreateReservation;
 @FXML private MenuItem menuListarClientes;
 @FXML private MenuItem menuCrearCliente;
 @FXML private MenuItem menuCrearMonitor;
 @FXML private MenuItem menuCrearClase;
 @FXML private MenuItem menuCrearReserva;

 @FXML
 void exit(ActionEvent event) {
 Platform.exit();
 }
 
// @FXML
// void pickUpReservation(ActionEvent event) throws LogicException {
//	 
//	 pickUpReservation=DialogUIController.initDialog(VEHICLE_PICKUP,PickUpReservationUIController.class, primaryStage);
//	 pickUpReservation.showAndWait();
// }
 
// @FXML
// void listVehicles(ActionEvent event) throws LogicException {
//	 
//	 listVehiclesController=DialogUIController.initDialog(LIST_VEHICLE_BRANCH_OFFICE,ListVehiclesUIController.class, primaryStage);
//	 listVehiclesController.showAndWait();
// }
// 
 
 @FXML
 void listarClientes(ActionEvent event) throws LogicException {
	 
	 listarClientesUIControlador=DialogUIController.initDialog(LISTAR_CLIENTES,ListarClientesUIControlador.class, primaryStage);
	 listarClientesUIControlador.showAndWait();
 }

 @FXML
 void crearCliente(ActionEvent event) throws LogicException {

	 crearClienteControlador=DialogUIController.initDialog(CREAR_CLIENTE,CrearClienteUIControlador.class, primaryStage);
	 crearClienteControlador.showAndWait();

 }
 
 @FXML
 void crearMonitor(ActionEvent event) throws LogicException {

	 crearMonitorControlador=DialogUIController.initDialog(CREAR_MONITOR, CrearMonitorUIControlador.class, primaryStage);
	 crearMonitorControlador.showAndWait();

 }
 
 @FXML
 void crearClase(ActionEvent event) throws LogicException {

	 crearClaseControlador=DialogUIController.initDialog(CREAR_CLASE, CrearClaseUIControlador.class, primaryStage);
	 crearClaseControlador.showAndWait();

 }

 @FXML
 void crearReserva(ActionEvent event) throws LogicException {
	 
	 crearReservaPistaControlador=DialogUIController.initDialog(CREAR_RESERVA,CrearReservaPistaUIControlador.class, primaryStage);
	 crearReservaPistaControlador.showAndWait();

 }

 
 public void setPrimaryStage(Stage primaryStage) {
 this.primaryStage = primaryStage;
 }
}