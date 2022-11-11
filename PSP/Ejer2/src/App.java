import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        String cadena = null;
        boolean isPalindromo = false;

        cadena = getCadena();
        isPalindromo = setPalindromo(cadena);
        System.out.println(
                isPalindromo ? "La cadena introducida es un palindromo" : "La cadena introducida no es un palindromo");
    }

    public static String getCadena() {
        Scanner sc = new Scanner(System.in);
        String cadena;
        do {
            System.out.println("Introduce una cadena");
            cadena = sc.nextLine();
            if (cadena.length() < 1) {
                System.out.println("Se ha introducido una cadena longitud 0");
            }
            if (cadena.isBlank()) {
                System.out.println("Se ha introducido una cadena Vacia");
            }
        } while (cadena.isBlank());
        return cadena;
    }

    public static boolean setPalindromo(String cadena) {
        cadena = cadena.toLowerCase().replace(" ", "");
        String invertida = new StringBuilder(cadena).reverse().toString();
        System.out.println(invertida);
        return invertida.equals(cadena);
    }
}
