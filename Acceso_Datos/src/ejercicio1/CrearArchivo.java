package ejercicio1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;




public class CrearArchivo {



   public static void main(String[] args) throws IOException {
	   
			   File fic1 = new File("c:\\ficheros\\");
	   		   File fic = new File("c:/ficheros/archivo1.txt");
	           Scanner sn = new Scanner(System.in);
	           boolean salir = false;
	           int opcion; //Guardaremos la opcion del usuario
	    
	           while (!salir) {
	    
	     
	    
	               try {
	    
	                   System.out.println("Escribe una de las opciones del Menu: ");
	                   Menus.ImprimirMenu();
	                   opcion = sn.nextInt();
	    
	                   switch (opcion) {
	                   
	                       case 0:
	                            Menus.ImprimirMenu();
	                    	   break;
	                       case 1:
	                           Metodos.crearFichero();
	                           break;
	                       case 2:
						   	   Metodos.listarDirectorio(fic1);
	                           break;
	                       case 3:
						   	   Metodos.muestraContenido(fic1);
	                           break;
	                           
	                       case 4:
	                           Metodos.copiaContenido(fic1);
	                           break;

							case 5:
							   Metodos.condicionesArchivos(fic);
	                           break;
	                                                   
	                       case 6:
	                           Metodos.eliminarFichero(fic1);
	                           break;
	                       case 7:
	                           salir = true;
	                           break;
	                       default:
	                           System.out.println("Solo numeros entre 1 y 6");
	                   }
	               } catch (InputMismatchException e) {
	                   System.out.println("Debes insertar un numero");
	                   sn.next();
	               }
	           }
	    
	   
      
        
          
    }





}