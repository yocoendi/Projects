package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Metodos {

	public static void listarDirectorio(File archivo) {

		String sDirectorio = "c:/ficheros";
		File f = new File(sDirectorio);

		if (f.exists()) {
			System.out.println("El directorios existe y su contenido es: ");

			String[] lista = f.list();

			for (int i = 0; i < lista.length; i++) {

				System.out.println(lista[i]);

			}
		}
		// Directorio existe }
		else {
			System.out.println("el directorio no existe");
		} // Directorio no existe

	}

	public static void crearFichero() throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		PrintWriter salida = null;
		System.out.println("Introduce el nombre del archivo");
		String nombreArchivo = sc.nextLine();

		File fic = new File("c:/ficheros/" + nombreArchivo);

		salida = new PrintWriter(fic);
		String cadena;
		System.out.println("Introduce texto. Para terminar con la escritura introcude la palabra FIN:");
		cadena = sc.nextLine();
		while (!cadena.equalsIgnoreCase("FIN")) {
			salida.println(cadena);
			cadena = sc.nextLine();
		}

		salida.flush();

		salida.close();
	}

	public static void muestraContenido(File fichero) throws FileNotFoundException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		listarDirectorio(fichero);

		System.out.println("Introduce el nombre del archivo que deseas mostrar en pantalla.");
		String nombreArchivo = sc.nextLine();
		
		String cadena;
		FileReader f = new FileReader("C:\\ficheros\\" + nombreArchivo);
		
		BufferedReader b = new BufferedReader(f);

		while ((cadena = b.readLine()) != null) {
			
			System.out.println(cadena);
		}

		b.close();
		f.close();
	}

	public static void eliminarFichero(File fichero) {
		
		
		Scanner sc = new Scanner(System.in);
		
		listarDirectorio(fichero);

		System.out.println("Introduce el nombre del archivo que deseas eliminar.");
		String nombreArchivo = sc.nextLine();
		File archivo = new File("C:\\ficheros\\" + nombreArchivo);

		
		String opcion = "";

		if (!archivo.exists()) {
			System.out.println("El archivo data no existe.");
		} else {

			System.out.println("Estas seguro que deseas eliminar el archivo? S/N");
			opcion = sc.nextLine();
			if (opcion.equalsIgnoreCase("S")) {
				archivo.delete();
				
				System.out.println("El archivo data fue eliminado correctamentes.");
			}
			}

			

		
	}

	public static void copiaContenido(File archivo) {

		int car;

		Scanner sc = new Scanner(System.in);
			try {

				
				listarDirectorio(archivo);

				System.out.println("¿Cual archivo del directorio quieres copiar?");
				String nombreArchivo = sc.nextLine();
				FileReader f = new FileReader("C:\\ficheros\\" + nombreArchivo);

				////
				int contador = 0;
				File f2 = new File("C:\\ficheros");
				String[] files = f2.list();
				for (int i = 0; i < files.length; i++) {
					if (files[i].contains(nombreArchivo)) {
						contador++;
					}
				}
				contador++;
				////

				File f3 = new File("C:\\ficheros\\"+"copia-"+"("+ contador +")"+ nombreArchivo );
				FileWriter fw = new FileWriter(f3);
				while ((car = f.read()) != -1) {
					fw.write(car);
				}

				f.close();
				fw.close();

				System.out.println("El archivo se ha copiado correctamente.");

			} catch (FileNotFoundException e1) {
				System.err.println("Error: No se encuentra el fichero");
			} catch (IOException e2) {

				System.err.println("Error leyendo/escribiendo fichero");
			}
	}

	public static void condicionesArchivos(File fichero) {

		File fic = new File("c:/ficheros/archivo1.txt");

		boolean exists = fic.exists();
		if (exists == true) {

			// printing the permissions associated with the file
			System.out.println("Executable: " + fic.canExecute());
			System.out.println("Readable: " + fic.canRead());
			System.out.println("Writable: " + fic.canWrite());
		} else {
			System.out.println("File not found.");
		}

	}

}
