package model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Mail;

@Singleton
public class MailSenderService {
	
	
	private final String host = "smtp.gmail.com";
	private final String port = "587";
	
	@Inject
	private MailSenderService() {
		
	}
	
	public void send(Mail email) throws AddressException, MessagingException{
		String username = "megafono.app@gmail.com";
		String password = "vacrilealu";
		
		Properties p = getPropertie();

		Session session =  Session.getInstance(p,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		
		Transport.send(message);
		
		
	}

	private Properties getPropertie() {
		Properties p = System.getProperties();

		p.setProperty("mail.smtp.host", host);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.port", port);
		return p;
	}

}
