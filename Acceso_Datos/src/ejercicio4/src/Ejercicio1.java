import java.time.LocalDateTime;
import java.util.Scanner;

public class Ejercicio1 {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();
		String resultado = "";

		Scanner sc = new Scanner(System.in);

		String name = sc.nextLine();

		if (now.getHour() > 0 && now.getHour() <= 12) {

			System.out.println(resultado = "Buenos dias " + name);

		} else if (now.getHour() > 12 && now.getHour() < 20) {

			System.out.println(resultado = "Buenos tardes " + name);

		} else if (now.getHour() > 21 && now.getHour() < 00) {

			System.out.println(resultado = "Buenos noches " + name);

		}

	}

}
