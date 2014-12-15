package ch.fhnw.haggis.server;

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
    
    public boolean handleMove(SpieldatenRequest request, int requestUserId)
    {
        // falls der request nicht vom aktivenSpieler kommt, brechen wir ab
        if (aktiverSpieler != requestUserId)
        {
            return false;
        }
        
        if (aktiverSpieler==numberOfPlayers-1){
        	gameplay.setCountPass(0);
        	
        }

        boolean ok = gameplay.processRequest(request);

        if (ok)  {
        	
            // notify every player that there was a move
            for (int i = 0; i < players.length; i++)
             {
                System.out.println("notify " + i + " that there was a move");
                players[i].playerMoved(aktiverSpieler, gameplay.getPot());
            }
            // find the next player
            aktiverSpieler = (aktiverSpieler + 1) % numberOfPlayers;
            
            return true;
        }
        else
            return false;

    }

    public boolean gameOver()  {
    	if (score>250){
        return true;
    }
    else {
    	return false;
    	}
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
