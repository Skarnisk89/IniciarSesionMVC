package InicioSesionMVC;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class Controlador {
	
	InicioSesion c = new InicioSesion();
	
	public Controlador() {
		c.getAccederBoton().setOnAction(e -> onComprobarAction(e));
		c.getCancelarBoton().setOnAction(e -> onCancelarAction(e));
	}
	
	private void onCancelarAction(ActionEvent e) {
        Stage stage = (Stage) c.getScene().getWindow();
        stage.close();
    }
	
	public InicioSesion getView(){
		return c;
	}
	
	
	public void onComprobarAction (ActionEvent e) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		Alert error = new Alert(AlertType.ERROR);
		
		Modelo datosUsuario = new Modelo(c.getUsuarioText().getText(), c.getContraseñaText().getText());
		
		
		if(datosUsuario.comprobar() == true) {
		alert.setTitle("Inicio Sesion");
		alert.setHeaderText("Acceso Permintido");
		alert.setContentText("Las credenciales de acceso son validad");
		alert.showAndWait();
		}else {
		
		error.setTitle("Inicio Sesion");
		error.setHeaderText("Acceso Denegado");
		error.setContentText("El usuario y/o la contraseÃ±a no son validos");
		error.showAndWait();
		}
		
		
	}

}
