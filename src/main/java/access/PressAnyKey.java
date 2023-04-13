package access;

import java.io.IOException;
import java.util.Scanner;

public class PressAnyKey {

    static void anyKey() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------");
        System.out.println("Press Enter <- to return to main menu...");
        while (System.in.available() == 0) {
            // Wait for any key to be pressed
        }
        System.in.read(); // Discard the key that was pressed

        MainMenu.mainMenu();

//        System.out.println("Press Enter key to continue...");
//        try
//        {
//            System.in.read();
//            scanner.next();
//        }
//        catch(Exception e)
//        {}
//        MainMenu.mainMenu();

//        Console console = System.console();
//        if (console == null) {
//            System.err.println("Unable to obtain console");
//            return;
//        }
//
//        System.out.println("Press any key to continue...");
//        console.readPassword(); // Discard the result
//        System.out.println("Returning to menu...");
//        MainMenu.mainMenu();

//        System.setProperty("jline.terminal", "unix");
//
//        Terminal terminal = TerminalBuilder.terminal();
//        LineReader lineReader = LineReaderBuilder.builder()
//                .terminal(terminal)
//                .build();
//
//        System.out.println("Press any key to continue...");
//        lineReader.read
//        System.out.println("Returning to menu");
//        MainMenu.mainMenu();
    }
}
