package InicioSesionMVC;


import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class InicioSesion extends VBox {

	
	private TextField usuarioText;
	private PasswordField contrase�aText;
	private Label usuarioLabel;
	private Label contrase�aLabel;
	private Button accederBoton;
	private Button cancelarBoton;
	
	
	
	
	public InicioSesion() {
		usuarioText = new TextField();
		contrase�aText = new PasswordField();
		
		usuarioLabel = new Label("Ususario: ");
		contrase�aLabel = new Label("Contraseña: ");
		
		accederBoton = new Button("Acceder");
		accederBoton.setPrefWidth(100);
		cancelarBoton = new Button("Cancelar");
		cancelarBoton.setPrefWidth(100);
		
		HBox lineaBotones = new HBox();
		lineaBotones.getChildren().addAll(accederBoton, cancelarBoton);
		
		GridPane view = new GridPane();
		view.setGridLinesVisible(false);
		view.setVgap(5);
		view.setHgap(5);
		view.setAlignment(Pos.TOP_CENTER);
		view.addRow(0, usuarioLabel, usuarioText);
		view.addRow(1, contrase�aLabel, contrase�aText);
		view.addRow(2,new Label(""), lineaBotones);
		
		ColumnConstraints[] constraintBotonera = {new ColumnConstraints()};
		constraintBotonera[0].setHalignment(HPos.CENTER);
		
		view.getColumnConstraints().setAll(constraintBotonera);
		
		this.getChildren().addAll(view);
		this.setAlignment(Pos.CENTER);
	}




	public TextField getUsuarioText() {
		return usuarioText;
	}




	public PasswordField getContrase�aText() {
		return contrase�aText;
	}


	public Button getAccederBoton() {
		return accederBoton;
	}




	public Button getCancelarBoton() {
		return cancelarBoton;
	}
	
	

		
		

}
