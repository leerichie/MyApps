package email;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class EmailInbox {
    public static void main(String[] args) throws Exception {
        String host = "imap.wp.pl";
        String username = "leerichie@wp.pl";
        String password = "poczta5568";

        // Set the properties of the email server
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", host);
        props.setProperty("mail.imaps.port", "993");
        props.setProperty("mail.imaps.starttls.enable", "true");

        // Connect to the email server
        Session session = Session.getInstance(props);
        Store store = session.getStore();
        store.connect(host, username, password);

        // Open the INBOX folder and get the messages
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message[] messages = inbox.getMessages();

        // Print the messages
        for (int i = 0; i < messages.length; i++) {
            Message message = messages[i];
            System.out.println("Message #" + (i + 1) + ":");
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom()[0]);
            System.out.println("Sent Date: " + message.getSentDate());
//            System.out.println("Content: " + message.getContent().toString());
            System.out.println();
        }

        // Close the folder and the store
        inbox.close(false);
        store.close();
    }
}
