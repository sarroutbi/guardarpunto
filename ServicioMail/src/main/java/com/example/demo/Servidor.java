package com.example.demo;

import java.net.*;
import java.io.*;
public class Servidor {
	/*Numero del puerto del servidor y máximo de conexiones que acepta*/
	private static final int PORT= 1025;
	private static final int MAX_CONEXIONES=16;
	
	public static void main(String[] args){
		/*Socket del servidor*/
		ServerSocket server= null;
		Socket socket = null;
		
		
			try {
			server= new ServerSocket(PORT, MAX_CONEXIONES);
			while (true) {

				System.out.println("Servidor Activo");
				
				socket = server.accept();

				Cliente client = new Cliente(socket);
				client.start();

			}


		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
