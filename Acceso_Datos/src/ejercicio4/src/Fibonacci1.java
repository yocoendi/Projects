import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Fibonacci1 {

	public static void main(String[] args) {

		try {
			if (args.length > 0) {

				int numElementos = Integer.parseInt(args[0]);
				StringBuilder fibonaciCompleta = new StringBuilder();
				StringBuilder fibonaciPares = new StringBuilder();

				int a = 0;
				int b = 1;
				for (int i = 0; i < numElementos; i++) {
					fibonaciCompleta.append(a + " ");
					if (a % 2 == 0) {
						fibonaciPares.append(a + " ");
					}
					b = a + b;
					a = b - a;
				}
				System.out.println("Fibonaci Completa:");
				System.out.println(fibonaciCompleta.toString());
				System.out.println("\n--------------");
				System.out.println("\nFibonaci Pares:");
				System.out.println(fibonaciPares.toString());

			} else {
				System.out.println("Necesita indicar el numero de elementos a mostrar");
			}
		} catch (Exception e) {
			System.out.println("El numero de elementos debe de ser un numero entero");
		}

	}

}