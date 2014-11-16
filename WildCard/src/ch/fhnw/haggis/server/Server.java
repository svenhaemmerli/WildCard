package ch.fhnw.haggis.server;

import java.net.*;
import java.io.*;

public class Server {

	private Player players[];
	private ServerSocket sSocket;
	public String Localhost;
	public Socket cSocket;

	public Server() {

		players = new Player[3];

		// ServerSocket
		try {
			sSocket = new ServerSocket(5000);
			System.out.println("Server gestartet");
			
			cSocket = sSocket.accept();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			Localhost = Inet4Address.getLocalHost().getHostAddress();
			System.out.println(Localhost);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		Server game = new Server();
	}
}