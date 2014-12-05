package ch.fhnw.haggis.server;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import ch.fhnw.haggis.server.*;


public class Gameplay
{
    public int points;
    

    private ServerGui serverGui;
    // private List<Integer> connectedClients = new ArrayList<Integer>();

    
	
    

    public Gameplay(ServerGui serverGui)
    {
        this.serverGui = serverGui;

        initializeGame();
    }

    public void initializeGame()
    {
        serverGui.writeLog("Initializing game...");
    }

    public boolean processRequest(SpieldatenRequest spieldaten, Hand myHand)
    {
    	
    	if(spieldaten.getMessage().equals("ready")){
    	
//        Hand myHand = new Hand(deck);
//        Hand h = distributeCard(deck, myHand);
//        spieldaten.setMyHand(h);
    	
        //serverGui.writeLog("hand: " + spieldaten.getMyHand().getHand().get(0));
        serverGui.writeLog("Hand ist im processRequest");
        spieldaten.setMessage("ready");
        spieldaten.setMyHand(myHand);
        
        
        return true;
    	}
       
    	else if (spieldaten.getMessage().equals("pass")){
        	
    	serverGui.writeLog("Spieler passt");
    	spieldaten.setMessage("valid move");
    	spieldaten.setMyHand(myHand);
        
    	return true;
    	
        }

        return false;
    }

    
    // public static void main(String[] args)
    // {
    //
    // Deck d = new Deck(); // Deck und Hands werden instanziert
    // Hand h1 = new Hand();
    // Hand h2 = new Hand();
    // Hand h3 = new Hand();
    //
    // Gameplay g = new Gameplay(); // Gameplay wird instanziert
    //
    // String s = g.shuffleCards(d); //
    // System.out.println(s);
    //
    // JokerDeck a = new JokerDeck();
    //
    // // Karten in Hand f�llen, Methode aufrufen
    // h1 = g.distributeCard(d, h1);
    // h2 = g.distributeCard(d, h2);
    // h3 = g.distributeCard(d, h3);
    //
    // // Joker in Hand f�llen, Methode aufrufen
    // h1 = g.distributeJoker(a, h1);
    // h2 = g.distributeJoker(a, h2);
    // h3 = g.distributeJoker(a, h3);
    //
    // Iterator<Card> c = d.getDeck().iterator(); // Restkarten im Deck
    // while (c.hasNext())
    // {
    // System.out.println("Listenelement: " + c.next().getName());
    // }
    // }

}
