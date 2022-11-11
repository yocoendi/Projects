
/*En esta actividad se utilizarán las librerías ProcessBuilder, Process y Runtime 
Realiza un programa Java que lea por teclado en un proceso repetitivo datos del alumnado: 
Los datos del alumnado a leer son el nombre y la edad. 
El proceso repetitivo finaliza cuando el nombre sea = *. 
Si el nombre es un blanco o su longitud de caracteres es 0, se debe volver a leer. 
Si la edad no está comprendida entre 1 y 99, se debe volver a leer. 
Igualmente se vuelve a leer la edad si se introduce una cadena en vez de un número en dicho campo. 
Se debe visualizar mensajes al pedir los datos y cuando no son correctos. 
Una vez finalizado el proceso de lectura de datos, se debe mostrar al final del mensaje, el número de la totalidad del alumnado leído, el nombre del que tiene más edad y del que tiene menor edad. */
import java.lang.ProcessBuilder;
import java.lang.Process;
import java.lang.Runtime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        String name= null, nameMayor=null, nameMenor= null;
        int age, ageMayor = 0, ageMenor = 100, count=0;
        try {

            do {

                name = pedirnombre();

                if (!name.equals("*")) {
                    count++;

                age = pedirnumero(1, 99, "Dime tu edad");
                

                if (age > ageMayor) {

                    ageMayor = age;

                    nameMayor = name;

                }

                if (age < ageMenor) {

                    ageMenor = age;

                    nameMenor = name;

                }
            }

            } while (!pedirnombre().equals("*"));

            System.out.println("El número total de alumnos son " + count);
            System.out.println("el nombre del que tiene más edad es "+ nameMayor);
            System.out.println("El nombre del que tiene menos edad es "+ nameMenor);

        } catch (Exception e) {
           
        }

    }

    public static int pedirnumero(int desde, int hasta, String Texto) {
        int N = 0;
        Scanner sc = new Scanner(System.in);

        // Leer un número entero >= 0
        do {
            try {
                System.out.print(Texto + ". Introduce la edad >" + desde + " y menor que " + hasta + ": ");
                N = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.err.println("¡Cuidado! Solo puedes insertar números. ");
                sc.next();
            }
        } while (N < desde || N > hasta);
        return N;

    }

    public static String pedirnombre() {
        String name = null;
        Scanner sc = new Scanner(System.in);

        do {
                System.out.print("Introduce tu nombre o * para cerrar.");
                name = sc.nextLine();
          
        } while (name.isBlank());
        return name;

    }

}
