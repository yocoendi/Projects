package ejercicio4.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		 LocalDateTime now = LocalDateTime.now();
		 
		 System.out.println("¿Cual es su nombre?");
		 
		 Scanner sc = new Scanner(System.in);
		 
		 String name = sc.nextLine();
		 
	
		String resultado = "";
		
		if (now.getHour() > 0 && now.getHour() <= 12) {
			
		System.out.println( resultado="Buenos dias " + name);   
		
		}else if (now.getHour() > 12 && now.getHour() < 20) {
			
		System.out.println(resultado="Buenos tardes " + name);
			
		}else if (now.getHour() > 21 && now.getHour() < 00) {
			
			System.out.println(resultado="Buenos noches " + name);
			
		}
		

		
	}
			

		

}
