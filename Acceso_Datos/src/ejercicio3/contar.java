package ejercicio3;

import java.util.Scanner;
import java.util.StringTokenizer;
public class contar {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String frase;
       System.out.print("Introduce una frase: ");
       frase = sc.nextLine();
       StringTokenizer st = new StringTokenizer(frase);
       System.out.println("Número de palabras: " + st.countTokens());                                             
    }
}

