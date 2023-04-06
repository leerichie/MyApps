package access;

import java.util.Scanner;

import static access.User.userList;

public class UserAccounts {

    static void checkAuthentication() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String inputUserName = scanner.nextLine();

        User findUser = userList.stream()
                .filter(user -> user.getUserName().equals(inputUserName))
                .findFirst()
                .orElse(null);

        if (findUser != null) {
            System.out.println("Enter password:");
            String inputPassword = scanner.nextLine();

            if (findUser.getPassword().equals(inputPassword)) {
                System.out.println("Login successful\n" +
                        "Hello " + findUser.getUserName() + "!\n" +
                        "What next...?");
                // todo further implementation

            } else {
                System.out.println("Wrong login details...");
                System.out.println("Forgotten password, send reminder? (y/n)");
                String yesNo = scanner.nextLine();
                if (yesNo.equals("y")) {
                    ForgottenPassword.sendPasswordReminderToEmail();
                } else {
                    System.out.println(" ");
                }
            }

        } else {
            System.out.println("User not found!");
        }
    }

    static void registerUser() {

    }
}
