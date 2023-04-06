package access;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

import static access.User.userList;

public class ForgottenPassword {

    static void sendPasswordReminderToEmail(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------");
        System.out.println("Send password reminder to Email address");

        System.out.println("Enter your Username:");
        String inputLogin = scanner.nextLine();

        User findUser = userList.stream()
                .filter(user -> user.getUserName().equals(inputLogin))
                .findFirst()
                .orElse(null);

        if (findUser != null){
            // from email - config
            String emailClient = "smtp.wp.pl";
            String fromEmail = "leerichie@wp.pl";
            String fromPass = "poczta5568";

            System.out.println("Enter your Email address:");
            String toEmail = scanner.nextLine();

            // Get system properties
            Properties properties = System.getProperties();

            // Set email server
            properties.put("mail.smtp.host", emailClient);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            // Get the Session object.
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, fromPass);
                }
            });

            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(fromEmail));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

                // Email subject
                message.setSubject("!! PASSWORD REMINDER !!");

                // Message content
                message.setText("You have requested a password reminder.\n" +
                        "Your associated password is below:\n\n" +
                        "Username: " + findUser.getUserName() +
                        "\nPassword: " + findUser.getPassword() +
                        "\n\n DO NOT SHARE THESE DETAILS!");

                // Send message
                System.out.println("Send reminder to provided email? (y/n)");
                String confirmSend = scanner.nextLine();
                if (confirmSend.equals("y")) {
                    Transport.send(message);
                    System.out.println("Email sent successfully, check your inbox then try and log-in again.\n");
                } else {
                    System.out.println("Goodbye :)");
                    MainMenu.mainMenu();
                }
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }

        } else {
            System.out.println("User not found!");

        }
    }
}
