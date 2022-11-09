package ejercicio4.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Ejercicio3 {

	public static void main(String[] args) {
		System.out.println(args [0]);
		
		String password = args [0];
		
		
		
		
		
		
		
	}
	
	
		
		private static int  getPuntoslongitud (String password) {
			
			int len= password.length();
			
			
			if (len>0) {
				
			}else if (len>0){
				
			}else if (len>0){
				
			}
			
			return 0;
		
		}
	
	
	
		// TODO Apéndice de método generado automáticamente
		
		
		public static Properties config = configuracionBD(".\\src\\fichero\\configuracion");
		
		
		//metodo para leer la configuaracion de archivos y propiedades
		public static Properties configuracionBD(String archivoConfiguracion) {
			FileReader reader;
			Properties datos = new Properties();
			try {
				reader = new FileReader(archivoConfiguracion);
				
				datos.load(reader);
			} catch (FileNotFoundException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			return datos;
			
		
		

	}

}
