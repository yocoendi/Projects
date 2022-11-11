import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppCarlos {

    public static void main(String[] args) throws Exception {

        String name = "";
        int age = 0;
        String nameMax = "";
        int ageMax = 0;
        String nameMin = "";
        int ageMin = 100;
        int total = 0;

        do {

            name = getName("Introduzca el nombre del alumno (* para terminar):");

            if (!name.equals("*")) {

                age = getAge("Introduzca la edad del alumno:");

                total++;

                if (age > ageMax) {
                    ageMax = age;
                    nameMax = name;
                }

                if (age < ageMin) {
                    ageMin = age;
                    nameMin = name;
                }

            }

        } while (!name.equals("*"));

        if (total > 0) {
            System.out.println("El total de almunos introducidos es " + total);
            System.out.println(String.format("El alumno mayor es %s con una edad de %d años", nameMax, ageMax));
            System.out.println(String.format("El alumno menor es %s con una edad de %d años", nameMin, ageMin));
        }

    }

    public static String getName(String message) {

        String name;

        do {
            name = askText(message);
        } while (!checkName(name));

        return name;
    }

    public static String askText(String message) {

        Scanner sc = new Scanner(System.in);
        System.out.print(message + " ");
        return sc.nextLine();
    }

    public static boolean checkName(String name) {

        if (name.isBlank()) {
            System.err.println("El texto introducido no puede estar vacío o contener espacios en blanco");
            return false;
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z]+$|^\\*$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) {
            System.err.println("El nombre es incorrecto");
            return false;
        }

        return true;
    }

    public static int getAge(String message) {

        int age;

        do {
            age = askInt(message);
        } while (!checkAge(age));

        return age;
    }

    public static int askInt(String message) {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(message + " ");
            try {
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("Error, debe introducir un número entero.");
                sc.next();
            }
        } while (true);

    }

    public static boolean checkAge(int age) {

        int min = 1;
        int max = 99;

        if (age < min || age > max) {
            System.err.println("Error, el número debe estar entre '" + min + "' y '" + max + "', incluidos.");
            return false;
        }

        return true;
    }

}
