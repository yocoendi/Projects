package ejercicio4.src;

import java.util.*;

public class Fibonacci3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero;
		int x = 1;
		int y = 1;
		int i;

		System.out.println("Introduce el largo del array");
		numero = sc.nextInt();

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		ArrayList<Integer> pares = new ArrayList<Integer>();

		System.out.println("Los " + numero + " primeros numeros son:");

		for (i = 2; i <= numero; i++) {
			numeros.add(y);

			if (y % 2 == 0)
				pares.add(y);

			y = x + y;
			x = y - x;
		}

		for (int j = 0; j < numeros.size(); j++) {
			Integer num = numeros.get(j);
			System.out.print(num + " ");
		}

		System.out.println();
		System.out.println("Los pares:");
		for (int j = 0; j < pares.size(); j++) {
			Integer num = pares.get(j);
			System.out.print(num + " ");
		}
	}
}
