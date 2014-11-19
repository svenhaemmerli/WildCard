package ch.fhnw.haggis.server;

import java.net.*;
import java.io.*;

import ch.fhnw.haggis.client.Client;

public class Server {

	private Player players[];
	private ServerSocket sSocket;
	public String Localhost;
	public Socket cSocket;
	public ObjectInputStream input;
	public ObjectOutputStream output;
	
	
	
	public Server() {

		players = new Player[3];

		// ServerSocket
		try {
			sSocket = new ServerSocket(5000);
			System.out.println("Server gestartet");
			
			cSocket = sSocket.accept();
			
			//Instanciate Object input and output stream
			
			input = new ObjectInputStream(cSocket.getInputStream());
					
			output = new ObjectOutputStream(cSocket.getOutputStream());
			
			Card ob = new Card ("joker_queen1",3,12,"joker");
			output.writeObject(ob);
			output.flush();
			System.out.println("Objekt gesendet");
			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);

		}

	}

	public static void main(String args[]) {
		Server game = new Server();
	
	}
}