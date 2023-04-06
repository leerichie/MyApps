package access;

import java.awt.*;
import java.net.URI;
import java.util.Scanner;

public class ExperimentalIdeas {

    static void searchWeb(){

        System.out.println("Enter the website name you would like to open:");
        Scanner scanner = new Scanner(System.in);
        String inputWebsiteName = scanner.nextLine();
        try {
            Desktop.getDesktop().browse(new URI("https://" + inputWebsiteName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
