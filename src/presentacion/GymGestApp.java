package presentacion;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import presentacion.control.MainUIController;


public class GymGestApp extends Application {

	 private Stage primaryStage; //
	 private BorderPane rootLayout;
	 @SuppressWarnings("unused")
	private MainUIController controller;

	 public static void main(String[] args) {
		 launch(args);
	 }
	 @Override
	 public void start(Stage primaryStage) {

	 this.primaryStage = primaryStage;
	 this.primaryStage.setTitle("GymGest");
	 
	 initRootLayout();
	 }

	 public void initRootLayout() {
	 try {
		 // Load root layout from fxml file.
		 FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(GymGestApp.class.getResource("view/MainView.fxml"));
		 
		 rootLayout = (BorderPane) loader.load();
		 // Show the scene containing the root layout.
		 Scene scene = new Scene(rootLayout);
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 controller = loader.getController();
		 //controller.setPrimaryStage(primaryStage);
	 	} catch (IOException e) {
	 		e.printStackTrace();
	 	}
	 }
}