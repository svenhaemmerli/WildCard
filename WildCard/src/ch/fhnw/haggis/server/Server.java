package ch.fhnw.haggis.server;


import java.net.*;

import java.io.*;


public class Server implements Runnable{

	private Player players[];
	private ServerSocket sSocket;
	public String Localhost;
	public Socket cSocket;
	public ObjectInputStream input;
	public ObjectOutputStream output;
	public Thread t;
	public int [] c;
	
	
	public void run() {

		players = new Player[3];

		// ServerSocket
		try {
			sSocket = new ServerSocket(5000);
			System.out.println("Server gestartet");
			
			while (true){
			cSocket = sSocket.accept();
			
			//Instanciate Object input and output stream
			
			input = new ObjectInputStream(cSocket.getInputStream());
			
			c = (int[]) input.readObject();	
			System.out.println("Listenelement: "+ c[0]);
									
		
			input.close();
			}
		
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		
		Server s = new Server();
	
		Thread t = new Thread(s);
		t.start();

		
		
	
	}
}