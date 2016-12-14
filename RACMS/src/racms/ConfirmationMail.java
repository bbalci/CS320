package racms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ConfirmationMail {

	public static void sendEmailWithAttachments(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message)
					throws AddressException, MessagingException, FileNotFoundException {
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message + "<br><br>", "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);




		//PUT EMAIL ADDRESS into InternetAddress(_____)
		InternetAddress[] toAddresses = { new InternetAddress() };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		Transport.send(msg);
		System.out.println("Sent ");

	}


	/**
	 * Test sending e-mail with attachments
	 * @throws FileNotFoundException
	 */
	public static void sendMail(String s) throws FileNotFoundException {
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "cs320racms";
		String password = "Merhaba123";

		// message info
		String subject = "RACMS CONFIRMATION MAIL";
		String message = "Your payment was accepted.";

		try {
			sendEmailWithAttachments(host, port, mailFrom, password, s,
					subject, message);
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}


}