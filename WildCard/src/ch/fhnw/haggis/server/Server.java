package ch.fhnw.haggis.server;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Collections;
import java.util.Iterator;

/**
 * 
 * @author Madeleine Sch�r (Klasse), Ivo Hausammann & Sven H�mmerli (Informationen an andere Clients)
 *
 */

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
		
		/**
		 * @author Ivo Hausammann
		 */
		// bevor gameplay aufgerufen wird, setzen wir der Variabel sequenceLengthLastTurn einmalig einen Wert fest.
		if (gameplay.getPot().size() == 0){
			gameplay.sequenceLengthLastTurn = request.getMyHand().getHand().size();
		}
		// Ende part Ivo Hausammann
		
		boolean ok = gameplay.processRequest(request);

		if (ok)  {

			/**
			 * @author Sven H�mmerli, Ivo Hausammann
			 * @params UserData wird als Informationen des Gegenspielers betrachtet
			 */
			//Berechnung des Scores, vorherige runde wird mit aktiver runde zusammengezaehlt
			players[(aktiverSpieler + 1) % numberOfPlayers].setScore(UserData.trickPunkte + players[(aktiverSpieler + 1) % numberOfPlayers].getScore());
			System.out.println("Spieler 0 Score: " + players[0].getScore());
			System.out.println("Spieler 1 Score: " + players[1].getScore());

			//wenn Player 1 an der Reihe ist
			if(aktiverSpieler == 0){
				//Werte der JokerKarten auf - setzen
				data.setJack("-");
				data.setQueen("-");
				data.setKing("-");
				//Score setzen
				data.setScore(players[1].getScore());
				System.out.println("Player 1: " + data.getScore());
				//Daten des 2 Players setzen
				data.setUsername(players[1].getUsername());
				//Groesse der Hand abfragen
				for(int i = 0; i < players[1].getMyHand().getHand().size(); i++){
					//Pruefen ob der Wert der Karte einem Joker entspricht
					if(players[1].getMyHand().getHand().get(i).getPoints() == 11){
            			String s = new String(players[1].getMyHand().getHand().get(i).getName());
            			data.setJack(s);
					}
					else if (players[1].getMyHand().getHand().get(i).getPoints() == 12){
        				String s = new String(players[1].getMyHand().getHand().get(i).getName());
        				data.setQueen(s);
        		}
					else if (players[1].getMyHand().getHand().get(i).getPoints() == 13){
        				String s = new String(players[1].getMyHand().getHand().get(i).getName());
        				data.setKing(s);
					}
				}
				//Groesse der Hand abfragen und auf die UserData schreiben
				data.setAmtCards(players[1].getMyHand().getHand().size());
			}
			//Falls spieler2 an der Reihe ist
			if(aktiverSpieler == 1){
				data.setJack("-");
				data.setQueen("-");
				data.setKing("-");
				data.setScore(players[0].getScore());
				System.out.println("Player 2: " + data.getScore());
				data.setUsername(players[0].getUsername());
				for(int i = 0; i < players[0].getMyHand().getHand().size(); i++){
					if(players[0].getMyHand().getHand().get(i).getPoints() == 11){
            			String s = new String(players[0].getMyHand().getHand().get(i).getName());
            			data.setJack(s);
					}
					else if (players[0].getMyHand().getHand().get(i).getPoints() == 12){
        				String s = new String(players[0].getMyHand().getHand().get(i).getName());
        				data.setQueen(s);
        		}
					else if (players[0].getMyHand().getHand().get(i).getPoints() == 13){
        				String s = new String(players[0].getMyHand().getHand().get(i).getName());
        				data.setKing(s);
					}
				}
				data.setAmtCards(players[0].getMyHand().getHand().size());
			}
			
			/**
			 * Ende Methode Ivo Hausammann & Sven H�mmerli
			 */
			
			/**
			 * @author Madeleine Sch�r
			 */

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
				System.out.println("H�ggis ="+haeggis);
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
				
				players[((aktiverSpieler + 1) % numberOfPlayers)].inform2();
				
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

	public boolean gameOver(int Endscore, int UserId)  {
		if (Endscore >=250){
			players[((UserId + 1) % numberOfPlayers)].inform3();
			System.out.println("Game Over");
			return true;
		}
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
