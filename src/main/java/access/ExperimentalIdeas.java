package access;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class ExperimentalIdeas {

    static void searchWeb() throws IOException {

        System.out.println("Enter the website name you would like to open:");
        Scanner scanner = new Scanner(System.in);
        String inputWebsiteName = scanner.nextLine();
        if (inputWebsiteName.isEmpty()){
            System.out.println("Input cannot be empty");
            PressAnyKey.anyKey();
        }
        try {
            Desktop.getDesktop().browse(new URI("https://" + inputWebsiteName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
