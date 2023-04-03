package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class EmailBasic {

    public void emailer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("*-- Ash's Email App --*");

        // User inputs sender email and password
        System.out.println("Enter your email:");
        String from = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // USER inputs recipient's email.
        System.out.println("Enter recipient's email:");
        String to = scanner.nextLine();

        // Outgoing email server
        String host = "smtp.wp.pl";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Ask for email subject
            System.out.println("--------------------");
            System.out.println("Enter email subject:");
            String mailSubject = scanner.nextLine();
            message.setSubject(mailSubject);

            // Ask for message content
            System.out.println("--------------------");
            System.out.println("Enter email message:");
            String mailMsg = scanner.nextLine();
            message.setText(mailMsg);

            // Send message
            System.out.println("--------------------");
            System.out.println("Send email? (y/n)");
            String confirmSend = scanner.nextLine();
            if (confirmSend.equals("y")) {
                Transport.send(message);
                System.out.println("Email sent successfully... :)");
                System.out.println("-----------------------------");
                System.out.println("Send another? (y/n)");
                String sendAnother = scanner.nextLine();
                if (sendAnother.equals("y")){
                    emailer();
                } else {
                    System.out.println("Goodbye :)");
                }
            } else {
                System.out.println("Goodbye :)");
            }
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
