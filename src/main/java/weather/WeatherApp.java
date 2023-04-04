package weather;

import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) throws Exception {

        WeatherEN weatherEN = new WeatherEN();
        WeatherPL weatherPL = new WeatherPL();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("*------ Welcome / Witamy ------*");
            System.out.println("Choose language / Wybierz jezyk:");
            System.out.println("1 - English");
            System.out.println("2 - Polski");
            System.out.println("0 - Exit / Wyjdz");

            int langChoice = scanner.nextInt();

            switch (langChoice) {
                case 1 -> weatherEN.weatherLogicEN();
                case 2 -> weatherPL.weatherLogicPL();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}

