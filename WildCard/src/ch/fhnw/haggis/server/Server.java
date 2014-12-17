package ch.fhnw.haggis.server;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Iterator;


public class Server {

	private Player[] players;
	private int aktiverSpieler;

	public ServerGui serverGui;
	public Gameplay gameplay;

	public Deck deck;
	public JokerDeck jdeck;
	public Hand myHand;
	public int score;
	public UserData data = new UserData();

	private int numberOfPlayers = 2;
	private boolean allPlayersConnected;

	public static void main(String args[])
	{
		try
		{
			Server server = new Server();
			server.run();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Server()
	{
		players = new Player[numberOfPlayers];      

		// first active player is the last one registred
		aktiverSpieler = numberOfPlayers - 1;

		serverGui = new ServerGui();
		gameplay = new Gameplay(serverGui);

		jdeck = new JokerDeck();
		deck = new Deck();
		Collections.shuffle(deck.getDeck());
		score = 0;
	}

	public void run() throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(6789);
		logToServer("Server running on IP: " + Inet4Address.getLocalHost().getHostAddress());
		logToServer("Waiting for connections...");

		// creating the connections
		for (int i = 0; i < players.length; i++)
		{
			int userId = i;

			myHand = new Hand(deck, jdeck);
			logToServer("Waiting to create connection for user " + userId);

			Socket connectionSocket = serverSocket.accept();
			players[i] = new Player(connectionSocket, this, userId, myHand, score);
			logToServer("Created connection for user " + userId);
			players[i].start();

			logToServer("Started thread for user " + userId);
		}
		// if all connections could be made we know that all players are connected
		allPlayersConnected = true;
	}

	// check ob user == active Player
	public boolean checkIfUsersTurn(int userId)
	{
		if (aktiverSpieler == userId)
		{
			return true;
		}
		return false;
	}

	// check if all users are connected
	public boolean checkAllUsersConnected()
	{
		return allPlayersConnected;
	}

	public boolean handleMove(SpieldatenRequest request, int requestUserId)	{
		
		// falls der request nicht vom aktivenSpieler kommt, brechen wir ab
		if (aktiverSpieler != requestUserId)
		{
			return false;
		}
		
		//        if (aktiverSpieler==numberOfPlayers-1){
		//        	gameplay.setCountPass(0);
		//        	
		//        }

		boolean ok = gameplay.processRequest(request);

		if (ok)  {

			players[(aktiverSpieler + 1) % numberOfPlayers].setScore(UserData.trickPunkte + players[(aktiverSpieler + 1) % numberOfPlayers].getScore());
			System.out.println("Spieler 0 Score: " + players[0].getScore());
			System.out.println("Spieler 1 Score: " + players[1].getScore());

			if(aktiverSpieler == 0){
				data.setScore(players[1].getScore());
				System.out.println("Player 1: " + data.getScore());
				data.setUsername(players[1].getUsername());
			}
			if(aktiverSpieler == 1){
				data.setScore(players[0].getScore());
				System.out.println("Player 2: " + data.getScore());
				data.setUsername(players[0].getUsername());
			}

			// notify every player that there was a move
			for (int i = 0; i < players.length; i++)
			{
				System.out.println("notify " + i + " that there was a move");
				players[i].playerMoved(aktiverSpieler, gameplay.potActual);
				//System.out.println(gameplay.potActual.get(0).getName());

			}
			//Remove played cards from hand player
			players[aktiverSpieler].getMyHand().removePlayedCardsFromHand(gameplay.getPot());

			if (players[aktiverSpieler].getMyHand().hand.isEmpty()){
				System.out.println("Score now=" + players[aktiverSpieler].getScore());
				players[aktiverSpieler].getMyHand().pot = gameplay.getPot();
				UserData.trickPunkte = gameplay.resetAfterPass(players[aktiverSpieler].getMyHand());
				System.out.println("Pot score berechnet");
				System.out.println("Neuer Score ="+UserData.trickPunkte);
				int neuerScore=0;
				neuerScore= players[aktiverSpieler].getScore()+UserData.trickPunkte;
				System.out.println(neuerScore);
				//Haeggis berechnen
				int haeggis = 0;
				int pointsHandOther = 0;

				for(int i=0;i<deck.getDeck().size();i++){

					haeggis = haeggis + deck.getDeck().get(i).getValue();
				}
				pointsHandOther = (players[((aktiverSpieler + 1) % numberOfPlayers)].getMyHand().getHand().size())*5;
				System.out.println("Points other hand=" + pointsHandOther);
				System.out.println("Häggis ="+haeggis);
				System.out.println("Haggis Size ="+deck.getDeck().size());
				players[aktiverSpieler].setScore(players[aktiverSpieler].getScore()+haeggis+pointsHandOther+UserData.trickPunkte);
				System.out.println("Neuer Score" + players[aktiverSpieler].getScore());

				//clear all
				gameplay.potActual.clear();
				players[0].getMyHand().hand.clear();
				players[1].getMyHand().hand.clear();
				players[0].getMyHand().pot.clear();
				players[1].getMyHand().pot.clear();
				players[0].getMyHand().potActual.clear();
				players[1].getMyHand().potActual.clear();
				deck.getDeck().clear();
				jdeck.getJoker().clear();

				jdeck = new JokerDeck();
				deck = new Deck();
				Collections.shuffle(deck.getDeck());

				for (int i=0;i<2;i++){
					Hand newHand = new Hand(deck,jdeck);
					players[i].setMyHand(newHand);
				}

				SpieldatenResponse response = new SpieldatenResponse();
				response.setMyHand(players[((aktiverSpieler + 1) % numberOfPlayers)].getMyHand());
				response.setStep("yourMove");

				try {
					players[((aktiverSpieler + 1) % numberOfPlayers)].getServerCommunication().sendToClient(response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


				// find the next player
				aktiverSpieler = (aktiverSpieler + 1) % numberOfPlayers;

				UserData.trickPunkte = 0;


				return true;
			
			
		}
		else
			return false;
		
	}

	public void returnUsername(String username) {
		if(!allPlayersConnected){
			data.setUsername(username);
		}
		else{
			data.setUsername(username);
			players[0].inform();
		}
	}

	public boolean gameOver()  {
		//when maxscore 250 is reached
		if (score >=100){
			players[aktiverSpieler].getMyHand().pot = gameplay.getPot();
			UserData.trickPunkte = gameplay.resetAfterPass(players[aktiverSpieler].getMyHand());
			int neuerScore=0;
			neuerScore= players[aktiverSpieler].getScore()+UserData.trickPunkte;

			players[aktiverSpieler].setScore(players[aktiverSpieler].getScore()+UserData.trickPunkte);
			//senden an GUI
			SpieldatenResponse response = new SpieldatenResponse();
			response.setMyHand(players[((aktiverSpieler + 1) % numberOfPlayers)].getMyHand());
			response.setStep("gameOver");
			System.out.println("Game Over");
			return true;
		}
	
		else 
			return false;
		}
		
	


	/**
	 * Write a message to the GUI of the server.
	 */
	public void logToServer(String message)
	{
		serverGui.writeLog(message);
	}

	public int getAktiverSpieler()
	{
		return aktiverSpieler;
	}

	public boolean isAllPlayersConnected()
	{
		return allPlayersConnected;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

}
