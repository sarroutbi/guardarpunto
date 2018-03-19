package es.sidelab.MailRestPost;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sun.mail.smtp.SMTPTransport;


@RestController
public class MailController {
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	@PostMapping(value="/mail")
	@ResponseStatus(HttpStatus.CREATED)
	public Mail newMail(@RequestBody Mail mail) {
		try {
			//Proveedor de conexion, que es Sun
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			
			//Propiedades del objeto
			Properties props = System.getProperties();
			props.setProperty("mail.smtps.host", "smtp.gmail.com"); //SMTP de gmail
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false"); //
			props.setProperty("mail.smtp.port", "465"); //Puerto del correo, el 465 porque es el SSL de gmail
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtps.auth", "true");
			
			props.put("mail.smtps.quitwait", "false");

			Session session = Session.getInstance(props, null);

			final MimeMessage msg = new MimeMessage(session);
			
			//Mail del emisor
			msg.setFrom(new InternetAddress("guardarpuntomail@gmail.com"));
			//Mail del receptor
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getMail(), false));
			msg.setSubject("¡Bienvenido a GuardarPunto!");
			msg.setText(
					"Hola " + mail.getUser()
							+ "\n\n Bienvenido a GuardarPunto. Esperamos que disfrutes de nuestros servicios de reseña de videojuegos"
							+ "\n\n Su fiesta le espera arriba",
					"utf-8");
			msg.setSentDate(new Date());
			//Elegir protocolo de envio
			SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

			t.connect("smtp.gmail.com", "guardarpuntomail@gmail.com", "muybienallevoy");
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
			
		}catch(MessagingException ex) {
			ex.printStackTrace();
		}
		return mail;
	}
	

	
}
