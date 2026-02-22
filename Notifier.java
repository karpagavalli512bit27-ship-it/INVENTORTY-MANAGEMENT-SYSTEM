package gui;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class Notifier {
    public static void sendEmail(String recipientEmail, String subject, String messageBody) {
        final String senderEmail = "karpagavalli512_bit27@mepcoeng.ac.in"; 
        final String senderPassword = "icecream";       
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            message.setText(messageBody);
            Transport.send(message);
            System.out.println("Notification email sent to: " + recipientEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
