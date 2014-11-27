//package ch.fhnw.haggis.deprecated;
//
////Client
//import java.io.*;
//import java.net.*;
//
//
////Client class
//public class Client {
//	
//	private Socket cSocket;
//	public ObjectInputStream input;
//	public ObjectOutputStream output;
//	public String address;
//	public Object rob;
//	
//
//	// Make connection to server
//	public void startClient() {
//		try {
//		//get Local Host address 	
//		address = Inet4Address.getLocalHost().getHostAddress(); 
//		
//			//Inizialise socket and connect to ServerSocket
//			cSocket = new Socket("localhost", 5000);
//			System.out.println("Client gestartet");
//			
//			//Instanciate Object input and output stream
//			
//			input = new ObjectInputStream(cSocket.getInputStream());
//					
//			output = new ObjectOutputStream(cSocket.getOutputStream());
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			rob = input.readObject();
//			if (rob!= null){
//							
//			System.out.println("Listenelement: "+ rob);
//		}
//		
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//		
//		public static void main(String args[]) {
//		
//			Client c = new Client ();
//			c.startClient();
//			
//				
//			
//		
//	}
//
//
//}