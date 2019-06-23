package mainPackage;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendmail {

	public static boolean sendMailFunc(String recover_mail, String new_password) {
		boolean email_sent=false;
		final String username = "lefterismarin92@gmail.com";
		final String password = "thelw1pitsa!";

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		 Authenticator auth = new Authenticator(){
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
	    };
	    
	    Session session = Session.getInstance(prop, auth);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lefterismarin92@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recover_mail));
			message.setSubject("FOODTAILS Recover Password");
			message.setContent("Your password: "+new_password, "text/html; charset=utf-8");
			Transport.send(message);
			email_sent=true;

		}
		catch(MessagingException e) {
			System.out.println(e);
			return email_sent;

			
		}
		
		
		return email_sent;
	}
	public static void ContactMailFunc(String user, String text) {
		final String username = "lefterismarin92@gmail.com";
		final String password = "thelw1pitsa!";

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		 Authenticator auth = new Authenticator(){
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
	    };
	    
	    Session session = Session.getInstance(prop, auth);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lefterismarin92@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lefterismarin92@gmail.com"));
			message.setSubject("Message Received From User: "+user);
			message.setContent(user+": "+text, "text/html; charset=utf-8");
			Transport.send(message);

		}
		catch(MessagingException e) {
			System.out.println(e);

			
		}
		
	
	}
}


