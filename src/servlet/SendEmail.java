package servlet;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	 public void sendingEmail(String product, String emailadd, String size, String orientation, String papertype, String paperweight, String lamination){
//   public static void main(String[] args) {
	   System.out.println("test");
      // Recipient's email ID needs to be mentioned.
      String to = "seathonglang@gmail.com," + emailadd;

      // Sender's email ID needs to be mentioned
      String from = "seathonglang@gmail.com";
      final String username = "seathonglang@gmail.com";//change accordingly
      final String password = "Orange1234";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.ssl.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "465");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

      try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: header field
	   message.setSubject("YSC Printing");
	
	   // Now set the actual message
	   message.setText("Hello, thank you for your interest in our service. " +
		"We have received your inquiries and will reply you within three working days. " + "\n" +
		"\n" +
		"Product: " + product + "\n" +
		"Size: " + size);

	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}