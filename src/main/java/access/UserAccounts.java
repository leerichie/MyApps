package access;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static access.User.userList;

public class UserAccounts {
    private static final Scanner scanner = new Scanner(System.in);

    static void checkAuthentication() throws IOException {

        System.out.println("Enter username:");
        String inputUserName = scanner.nextLine();
        if (inputUserName.isEmpty()){
            System.out.println("Username cannot be empty!");
            PressAnyKey.anyKey();
        }

        User findUser = userList.stream()
                .filter(user -> user.getUserName().equals(inputUserName))
                .findFirst()
                .orElse(null);

        if (findUser != null) {
            System.out.println("Enter password:");
            String inputPassword = scanner.nextLine();

            if (findUser.getPassword().equals(inputPassword)) {
                System.out.println("Login successful!\n" +
                        "Hello... " + findUser.getUserName() + "!\n" +
                        "What next...?\n");
                // todo more project build


            } else {
                System.out.println("Wrong login details...");
                System.out.println("Forgotten password, send reminder? (y/n)");
                String yesNo = scanner.nextLine();
                if (yesNo.equals("y")) {
                    ForgottenPassword.sendPasswordReminderToEmail();
                } else {
                    PressAnyKey.anyKey();
                }
            }

        } else {
            System.out.println("User not found!");
            PressAnyKey.anyKey();
        }
    }

    static void registerUser() throws IOException {

        System.out.println("-------------------");
        System.out.println("Register new user");
        System.out.println("Enter username:");
        String inputUsername = scanner.nextLine();
        if (inputUsername.isEmpty()){
            System.out.println("Username cannot be empty!");
            PressAnyKey.anyKey();
        }

        boolean userExists = userList.stream()
                .anyMatch(user -> user.getUserName()
                        .equals(inputUsername));
        if (userExists) {
            System.out.println("Username already taken");
            registerUser();
        } else {
            String inputPassword;
            String inputConfirmPassword;

            do {
                System.out.println("Enter password:");
                inputPassword = scanner.nextLine();
                System.out.println("Confirm password:");
                inputConfirmPassword = scanner.nextLine();
                System.out.println("Passwords do not match, try again!");
            }
            while (!inputPassword.equals(inputConfirmPassword));

            userList.add(new User(inputUsername, inputPassword));

            System.out.println("Username created successfully!");

            // any key method returns to main menu
            PressAnyKey.anyKey();
        }
    }

    static void listUsers() throws IOException {

        System.out.println("Enter admin password:");
        String adminPass = scanner.nextLine();
        // for numbering and incrementing
        AtomicInteger numbering = new AtomicInteger();

        if (adminPass.equals("admin")){
            System.out.printf("%-4s %-20s %s\n", "No.", "Username", "Password");
            System.out.println("---------------------------------------");
            userList.stream()
                    .forEach(user -> System.out.printf("%-4s %-20s %s\n", numbering.getAndIncrement()+1, user.getUserName(), user.getPassword()));

            PressAnyKey.anyKey();

        } else {
            System.out.println("Incorrect password!");
            PressAnyKey.anyKey();
        }
    }
}
