package InicioSesionMVC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class Modelo {

	String nombre;
	String contraseña;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Modelo(String usuario, String password) {
		nombre = usuario;
		contraseña = password;
	}
	
	public boolean comprobar() {
        boolean usuarioExiste = false;
        boolean passExiste = false;
        boolean coincide = false;
        
        int userPosition = 0, passPosition = 0;

        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> passcodes = new ArrayList<String>();
        
        try {
            String nombreArchivo = "datos.csv";
            File file = new File(nombreArchivo);
            Scanner entrada = new Scanner(file);
            
            while(entrada.hasNext()) {
                String datos = entrada.next();//Se meten los datos leidos en una variable
                String [] separador = datos.split(",");
                //recojo los datos del usuario
                users.add(separador[0]);
                //Recojo los datos de la contraseÃ±a
                passcodes.add(separador[1]);
            }
            entrada.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < users.size(); i++) {
            //Recorro el ArrayList comprobando si el usuario coincide con el introducido
            if (users.get(i).equals(nombre) == true) {
                userPosition = i;
                usuarioExiste = true;
            }
            //Recorro el ArrayList comprobando si la contraseÃ±a coincide con el introducido
            if (passcodes.get(i).equals(stringToMd5(getContraseña())) == true) {
                passPosition = i;
                passExiste = true;
            }

        }
        coincide = (userPosition == passPosition && usuarioExiste == true && passExiste == true) ? true : false;
        return coincide;

    }
	
	private String stringToMd5(String pass) { //descodificar contraseÃ±a
        String md5 = DigestUtils.md5Hex(pass).toUpperCase();
        return md5;
    }
	
	
}
