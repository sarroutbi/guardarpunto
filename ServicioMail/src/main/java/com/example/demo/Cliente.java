package com.example.demo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class Cliente extends Thread implements Observer {
	private Socket socket;

	private ObjectInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	private final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	public Cliente(Socket serverSocket) {
		this.socket= serverSocket;
		try {

			entradaDatos = new ObjectInputStream(socket.getInputStream());
			salidaDatos = new DataOutputStream(socket.getOutputStream());

		} catch (IOException ex) {
			System.out.println("Fallo creada stream");
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run()  {
		System.out.println("Cliente Dansando Capoeira do morte");
		List<String> mensajeRecibido = new ArrayList<>();
		boolean conectado = true;

		System.out.println("Comprobaçao");
		
		while(conectado) {
			try {
				mensajeRecibido= (List<String>) entradaDatos.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (mensajeRecibido != null) {

				try {
					salidaDatos.writeUTF("Datos recibidos con exito");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(mensajeRecibido.get(0));
				System.out.println(mensajeRecibido.get(1));
				Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				Properties props = System.getProperties();
				props.setProperty("mail.smtps.host", "smtp.gmail.com");
				props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
				props.setProperty("mail.smtp.socketFactory.fallback", "false");
				props.setProperty("mail.smtp.port", "587");
				props.setProperty("mail.smtp.socketFactory.port", "587");
				props.setProperty("mail.smtps.auth", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, null);

				final MimeMessage msg = new MimeMessage(session);

				// -- Set the FROM and TO fields --
				try {
					msg.setFrom(new InternetAddress("guardarpuntomail@gmail.com"));
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(mensajeRecibido.get(1), false));

				msg.setSubject("¡¡Bienvenido a GuardarPunto!!");
				msg.setText(
						"Saludos, " + mensajeRecibido.get(0)
								+ "\n\n Bienvenido a GuardarPunto, "
								+ "esperamos que realices reviews pronto y aproveches el resto de servicios\n"
								+ "\n \n Su fiesta le espera en el piso 2 ",
						"utf-8");
				msg.setSentDate(new Date());

				SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

				t.connect("smtp.gmail.com", "guardarpuntomail@gmail.com", "muybienallevoy");
				t.sendMessage(msg, msg.getAllRecipients());
				t.close();
				conectado = false;
				entradaDatos.close();
				salidaDatos.close();
				System.out.println("Client out");
				conectado = false;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else 
			{
				
				
			}
			}
		


		}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		try {
			// Envia el mensaje al cliente
			salidaDatos.writeUTF("Datos recibidos con exitooooo");
		} catch (IOException ex) {
			System.out.println("Fallo update");
			ex.printStackTrace();
		}
		
	}

}
