package ch.fhnw.haggis.client;

//Client
import java.io.*;
import java.net.*;


//Client class
public class Client {
	
	private Socket cSocket;
	//public ObjectInputStream input;
	//public ObjectOutputStream output;
	public String address;

	// Make connection to server
	public void startClient() {
		try {
		address = Inet4Address.getLocalHost().getHostAddress();
						
			cSocket = new Socket("localhost", 5000);
			System.out.println("Client gestartet");
			
			//input = new ObjectInputStream(cSocket.getInputStream());
			
			//output = new ObjectOutputStream(cSocket.getOutputStream());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void main(String args[]) {
		Client c = new Client ();
		c.startClient();
		
		
	}


}