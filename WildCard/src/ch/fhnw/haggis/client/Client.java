package ch.fhnw.haggis.client;

//Client
import java.io.*;
import ch.fhnw.haggis.server.*;
import java.net.*;


//Client class
public class Client {
	
	private Socket cSocket;
	public ObjectInputStream input;
	public ObjectOutputStream output;
	public String address;
	public int [] rob = {5};
	

	// Make connection to server
	public void startClient() {
		try {
		//get Local Host address 	
		address = Inet4Address.getLocalHost().getHostAddress(); 
		
			//Inizialise socket and connect to ServerSocket
			cSocket = new Socket("localhost", 5000);
			System.out.println("Client gestartet");
			
			Gameplay g1 = new Gameplay();
			
				
			
			//Instanciate Object input and output stream
			
								
			output = new ObjectOutputStream(cSocket.getOutputStream());
		
			output.writeObject(g1);
			output.flush();
			
			System.out.println("Objekt versendet");
			
			output.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
		
		public static void main(String args[]) {
			

			Client c = new Client ();
			c.startClient();
			
				
			
		
	}


}