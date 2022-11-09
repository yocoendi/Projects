package ejercicio2;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;



public class contar {

    public static void main(String[] args) {



        

       

        Scanner lector;

        int contador = 0;

        try {

            lector = new Scanner(new File("c:/ficheros/archivo1.txt"));

           

            while(lector.hasNext()) {

                lector.next();

                contador++; //La contamos

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

       

        System.out.println("\nTotal palabras contadas: " + contador);
        System.out.println("Hola mundo");

    }


       

  

}