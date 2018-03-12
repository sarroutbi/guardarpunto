package es.sidelab.guardar_punto;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EviarMail {
	public int sendEmail(String name, String mail) {
		Socket socket;
		ObjectOutputStream salidaDatos;
		DataInputStream entradaDatos;

		try {

			socket = new Socket("127.0.0.1", 1025);
			salidaDatos = new ObjectOutputStream(socket.getOutputStream());
			entradaDatos = new DataInputStream(socket.getInputStream());

			List<String> ls = new ArrayList<String>();

			ls.add(name);
			ls.add(mail);

			salidaDatos.writeObject(ls);

			System.out.println(entradaDatos.readUTF());

			salidaDatos.close();

			socket.close();

		} catch (IOException e) {

			e.printStackTrace();
			return -1;
		}

		return 0;
	}
}
