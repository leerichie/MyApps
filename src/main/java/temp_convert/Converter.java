package temp_convert;

import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        do {
            System.out.println("*-- Temperature Converter --*");
            System.out.println("  1 - Fahrenheit to Celsius");
            System.out.println("  2 - Celsius to Fahrenheit");
            System.out.println("  0 - Exit");
            menuChoice = scanner.nextInt();

            switch (menuChoice){
                case 1 -> {
                    System.out.println("Enter temperature in Fahrenheit:");
                    int fahren = scanner.nextInt();
                    System.out.println(fahren + "ºF is " + fahrenheitToCelsius(fahren) + "ºC");
                }
                case 2 -> {
                    System.out.println("Enter temperature in Celsius:");
                    int cels = scanner.nextInt();
                    System.out.println(cels + "ºF is " + celsiusToFahrenheit(cels) + "ºC");
                }
            }
        }
        while (menuChoice != 0);


    }

    public static int fahrenheitToCelsius(int fahrenheit){
        return (fahrenheit -32) * 5/9;
    }

    public static int celsiusToFahrenheit(int celsius){
        return (celsius + 32) * 5/9;
    }
}
