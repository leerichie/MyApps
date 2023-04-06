package access;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    static void mainMenu() throws IOException {

        while(true){
            System.out.println("*--- Ash's Authentication App --*");
            System.out.println(" Choose a menu option:");
            System.out.println(" 1 - Login");
            System.out.println(" 2 - Register new user");
            System.out.println(" 3 - Open website");
            System.out.println(" 0 - Exit");
            System.out.println("*-------------------------------*");

            int menuChoice = scanner.nextInt();

            switch (menuChoice){
                case 1 -> UserAccounts.checkAuthentication();
                case 2 -> UserAccounts.registerUser();
                case 3 -> ExperimentalIdeas.searchWeb();
                case 0 -> {
                    System.out.println("Goodbye :)");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
//    static void returnToMenu(){
//
//        System.out.println("Press any key to return to the Main Menu and log-in");
//        String returnToMenu = scanner.next();
//        if (!returnToMenu.equals("")){
//            mainMenu();
//        } else {
//            scanner.close();
//        }
//    }
}
