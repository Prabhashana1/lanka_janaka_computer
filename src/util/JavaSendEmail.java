package util;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 * @author prabhashana
 */
public class JavaSendEmail {
    
    public static void sendMail(String recepient, String subject, String emailBody){
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String username = "lankajanaka97@gmail.com";
        String password = "zjan gtbg juvx sgrn";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username , password);
                
            }
        });
        
        Message message = prepareMessage(session,username,recepient, subject,emailBody);
        try {
            Transport.send(message);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"The registration email has been successfully sent to the customer");
        
    }

    private static Message prepareMessage(Session session, String username, String recepient, String subject, String emailBody) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(emailBody);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return message;
    }
}
