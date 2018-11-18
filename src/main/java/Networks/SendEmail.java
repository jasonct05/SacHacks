package Networks;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class SendEmail {
    private static final String FROM = "KingScoopNotification@gmail.com";
    private static final String FROM_PASS = "SacHacks2019";
    private static final String HOST = "smtp.gmail.com";
    private static final String[] TO_RIDER = {"jason.96@hotmail.com"};
    private static final String[] TO_DRIVER = {"ryanefendy95@gmail.com"};
    private static final String RIDER_SUBJECT = "Congrats! You've been scooped for ";
    private static final String DRIVER_SUBJECT = "Congrats! We've found you fellow fans for !";
    private static final String DEFAULT_CONTENT = "Please refer to the app for more information.";

    public static void sendNotificationEmail(String event) {
        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", FROM);
        props.put("mail.smtp.password", FROM_PASS);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        // send messages for riders
        sendEmail(TO_RIDER, RIDER_SUBJECT, props, event);
        sendEmail(TO_DRIVER, DRIVER_SUBJECT, props, event);
    }

    private static void sendEmail(String[] emails, String Subject, Properties currentProps, String event) {
        Session session = Session.getDefaultInstance(currentProps);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(FROM));
            InternetAddress[] toAddress = new InternetAddress[emails.length];

            // To get the array of addresses
            for( int i = 0; i < emails.length; i++ ) {
                toAddress[i] = new InternetAddress(emails[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(Subject + " " + event);
            message.setText(DEFAULT_CONTENT);
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, FROM, FROM_PASS);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}