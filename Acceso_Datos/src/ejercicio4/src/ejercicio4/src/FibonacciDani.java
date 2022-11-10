package ejercicio4.src;
import java.util.ArrayList;
import java.util.Scanner;



public class FibonacciDani {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Integer> pares = new ArrayList<Integer>();
        int numero, i, x = 1, y = 1;



       try {
            do {
                System.out.println("Introduce el largo del array");
                numero = sc.nextInt();
                if (numero <= 1)
                    System.out.println("El numero debe ser mayor que 1");
            } while (numero <= 1);



           System.out.println("Los " + numero + " primeros numeros son:");



           for (i = 2; i <= numero; i++) {
                numeros.add(y);
                if (y % 2 == 0)
                    pares.add(y);
                y = x + y;
                x = y - x;
            }



           System.out.println(numeros.toString());
            System.out.println("Los pares:");
            System.out.println(pares.toString());



       } catch (Exception e) {
            System.out.println("Debe ser un numero entero mayor que 0");
        }
    }
}