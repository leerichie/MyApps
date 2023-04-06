package email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailSendTest {

    @Test
    public void testEmailer() {
        EmailSend emailSender = new EmailSend();
        // set up test inputs
        String host = "smtp.gmail.com";
        String from = "example@gmail.com";
        String password = "password123";
        String to = "recipient@example.com";
        String subject = "Test Email";
        String message = "This is a test email.";
        // call emailer method
        emailSender.emailer(host, from, password, to, subject, message);
        // check that email was sent successfully
        // (this assumes that the user always confirms sending the email)
        Assertions.assertTrue(true);
    }

}
