	package presentacion.control;
	
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import java.io.IOException;
	import gymGest.GymGest;
	
	public abstract class DialogUIController implements Initializable{ // Controller initialization interface
	
	
	 protected Stage dialog; // top level JavaFX container
	 protected Parent root;
	 protected GymGest GymGest;
	 
	 public void setOwner(Stage owner) {
		 dialog.initOwner(owner);	// Specifies the owner Window for this stage, or null for a top-level, unowned stage.
	 }
	 public void setTitle(String title) {
		 dialog.setTitle(title);
	 }
	 public void setRoot(Parent root) {
		 this.root = root;
	 }
	
	 public void setLogicController(GymGest gg) {
		 this.GymGest = gg;
	 }
	 public void showAndWait() {
		 dialog.setScene(new Scene(root)); 	// Specify the scene to be used on this stage.
		 dialog.showAndWait();				// Shows this stage and waits for it to be hidden (closed) before returning to the caller.
	 }
	
	
	 @FXML
	 public void initialize(){
		 setLogicController(GymGest.getGymGest());
	 }
	
	 public static <T extends DialogUIController> T initDialog(String urlView, Class<T> controlClass, Stage owner) {
		 FXMLLoader fxmlLoader = new FXMLLoader();
		 fxmlLoader.setLocation(DialogUIController.class.getResource(urlView));
		 T controller = null;
	
	 try {
		 Parent root =fxmlLoader.load();
		 controller = fxmlLoader.getController();
		 controller.setRoot(root);
		 controller.setOwner(owner);
	 } catch (NullPointerException | IOException e) {
	 		e.printStackTrace();
	 }
	 	return controller;
	 }
	 
	 public static <T extends DialogUIController> T initDialog(String urlView,Class<T> controlClass, Stage owner,int o) {
		 FXMLLoader fxmlLoader = new FXMLLoader();
		 fxmlLoader.setLocation(DialogUIController.class.getResource(urlView));
		 T controller = null;
	
		 try {
			 Parent root =fxmlLoader.load();
			 controller = fxmlLoader.getController();
			 controller.setRoot(root);
			 controller.setOwner(owner);
		 } catch (NullPointerException | IOException e) {
			 e.printStackTrace();
		 }
		 return controller;
		 }
	}