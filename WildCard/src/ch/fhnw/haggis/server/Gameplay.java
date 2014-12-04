package ch.fhnw.haggis.server;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import ch.fhnw.haggis.server.*;


public class Gameplay
{
    public int points;
    public int actualPlayer;

    private ServerGui serverGui;
    // private List<Integer> connectedClients = new ArrayList<Integer>();

    private Deck deck;
	
    

    public Gameplay(ServerGui serverGui)
    {
        this.serverGui = serverGui;

        initializeGame();
    }

    public void initializeGame()
    {
        serverGui.writeLog("Initializing game...");
        // prepare deck
        deck = new Deck();
        Collections.shuffle(deck.getDeck());
    }

    public boolean processRequest(SpieldatenRequest spieldaten)
    {
    	
    	if(spieldaten.getMessage().equals("bereit")){
    	
        deck = new Deck();
        Collections.shuffle(deck.getDeck());
        Hand myHand = new Hand(deck);
        Hand h = distributeCard(deck, myHand);
        spieldaten.setMyHand(h);
        serverGui.writeLog("hand: " + spieldaten.getMyHand().getHand().get(0).getName());
        serverGui.writeLog("ist im processRequest");
        
        return true;
    	}
        
        // do the business ...

        return false;
    }

    public Hand distributeCard(Deck d, Hand h)
    {

        while (d.getDeck().isEmpty() != true && h.hand.size() < 14)
        {
            h.hand.add(d.getDeck().get(0)); // Karten von Deck zu Hand hinzuf�gen
            d.getDeck().remove(d.getDeck().get(0)); // Karten aus Deck l�schen

        }

        /*Iterator<Card> b = h.hand.iterator(); // Hand Ausgabe
        while (b.hasNext())
        {
            System.out.println("Listenelement: " + b.next().getName());
        }

        */System.out.println("Ende hand ohne Joker");

        return h;

    }

    public Hand distributeJoker(JokerDeck a, Hand h)
    {

        while (a.getJoker().isEmpty() != true && h.hand.size() < 17)
        {
            h.hand.add(a.getJoker().get(0));
            a.getJoker().remove(a.getJoker().get(0));
        }

        Iterator<Card> c = h.hand.iterator(); // Hand Ausgabe
        while (c.hasNext())
        {
            System.out.println("Listenelement: " + c.next().getName());
        }

        System.out.println("Ende hand mit Joker");

        return h;

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
