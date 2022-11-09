package ejercicio4.src;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Scanner;

public class password {
	
	static Properties conf;
	static int nivelSeguridad;
	static int MaxCarPassword;
	static int MinCarPassword;
		
	public static void main(String[] args) {
		loadConfiguration(".\\Conf.txt");
		
		String[] nivelesPassword= {"Muy Debil","Debil","Moderada", "Fuerte", "Muy Fuerte"};
		
		if (args.length>0 && args[0].length()>=MinCarPassword && args[0].length()<=MaxCarPassword) {
			
			String newPassword=args[0];
			
			int passwordLevel = ComprobacionPassword(newPassword);
			
			System.out.printf("El nivel de seguridad de su password es: %s-%s\n",
					passwordLevel,
					passwordLevel < 10 ? nivelesPassword[(passwordLevel+1)/3]
							: nivelesPassword[4]);
			
			String confirmacion="";
			if (passwordLevel<nivelSeguridad) {
				confirmacion=pedirString("Su password es debil si desea continuar introduzca [Y]es");		
			}
			if("Yes".equalsIgnoreCase(confirmacion) || "Y".equalsIgnoreCase(confirmacion) || passwordLevel>=nivelSeguridad) {
				if(AlmacenarPassword(newPassword)) {
					System.out.println("Password Guardado");
				}
				else {
					System.out.println("Se produjo un error guardando el Password, intentelo de nuevo");
				}
			}
			else {
				System.out.println("Password No Guardado");
			}
		}
		else {
			System.out.println("Debe Introducir un Password Correcto"
					+ "\n("+MinCarPassword+"-"+MaxCarPassword+" caracteres)"
					+ "\nAdmite:\nNumeros\nLetras(Mayusculas y Minisculas)\nCaracteres Especiales");
		}
	}
	
	

	private static int ComprobacionPassword(String newPassword) {
		int numero =0;
		String caracteresEspeciales ="(.*[!\"#$%&'()*+,\\-./:;<=>?@[\\\\]^_`{|}~]+.*)";
		
		//System.out.println(Math.min((newPassword.length()-3)/3, 3)+" "+newPassword.length());
		
		String[][] ListaPatrones = {
				{"(.*[a-zA-Z]+.*)","1"},
				{"(.*\\d+.*)", "1"},
				{"(?=.*[A-Z]+.*)(.*[a-z]+.*)","2"},
				{caracteresEspeciales, "2"}
				};		
		
		// longitud [+0 0-6],[+1 7-8],[+2 9-11],[+3 12+]
		if(newPassword.length()>6) {
			numero+=( Math.min((newPassword.length()-3)/3, 3));
		}
		
		for (int i=0;i<ListaPatrones.length;i++) {
			numero+=CompSingelPattern(newPassword,ListaPatrones[i][0],
					Integer.parseInt(ListaPatrones[i][1]));
		}

		if(newPassword.length()==MaxCarPassword) {
			numero += CompSingelPattern(newPassword,
				"(?=" + ListaPatrones[0][0] + "+)" +
				"(?=" +ListaPatrones[1][0] + "+)" +		
				"(?=" +ListaPatrones[2][0] + "+)" +
				"(" +ListaPatrones[3][0] + "+)", 1);
		}
		return numero;
	}
	
	private static int CompSingelPattern(String newPassword, String patron, int numero) {
		if(newPassword.matches(patron)) {
			//System.out.println(numero+" "+patron);
			return numero;
		}
		return 0;
	}

	private static void loadConfiguration(String file) {
		conf = new Properties();
		File f = new File(file);
		FileReader fr = null;
		try {
			
			if(f.exists()) {
				fr = new FileReader(f);
				conf.load(fr);
			}
			else {
				conf.setProperty("NivelSeguridadMin", "8");
				conf.setProperty("MaximoCaracterPass", "16");
				conf.setProperty("MinimoCaracterPass", "7");
				
				conf.store(new FileWriter(f),"Archivo Conf NuevoPassword");
			}
		}catch (Exception e) {
			System.out.println("Error en la carga de la configuracion inicial");
		}finally {
			try {
				fr.close();
			}catch (Exception e) {
				System.out.println("Error cerrando el archivo de configuracion.");
			}
		}
		
		//Bloque Carga Variables;
		nivelSeguridad = Integer.parseInt(conf.getProperty("NivelSeguridadMin"));
		MaxCarPassword = Integer.parseInt(conf.getProperty("MaximoCaracterPass"));
		MinCarPassword = Integer.parseInt(conf.getProperty("MinimoCaracterPass"));
		
	}
	
	private static boolean AlmacenarPassword(String newPassword) {
		// TODO Almacenar el Password
		return true;
	}
	
	public static String pedirString(String cadena) {
		String texto;
		Scanner entradaLine = new Scanner(System.in);
		System.out.println(cadena);
		texto = entradaLine.nextLine();
		return texto;
	}
}