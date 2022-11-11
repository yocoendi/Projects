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
        sc.close();
        return N;
        

    }

    public static String pedirnombre() {
        String name = null;
        Scanner sc = new Scanner(System.in);

        do {
                System.out.print("Introduce tu nombre o * para cerrar.");
                name = sc.nextLine();
          
        } while (name.isBlank());
        sc.close();
        return name;

    }

}
