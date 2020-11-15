package InicioSesionMVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	private Controlador cont;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		cont = new Controlador();
		
		Scene scene = new Scene(cont.getView(), 480, 320);
		primaryStage.setTitle("Inicio Sesion"); // nombre de arriba de la caja
		primaryStage.setScene(scene); // mostrar caja
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);


	}

}
