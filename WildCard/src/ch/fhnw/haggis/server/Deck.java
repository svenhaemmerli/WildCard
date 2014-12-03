package ch.fhnw.haggis.server;

import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Deck
{
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck()
    {
    	/** @author Sven
    	 * Bilder als Image importieren
    	 */
    	
    	
    	//Alle Bilder der roten karten imporitern
    	ImageIcon ired2 = new ImageIcon(getClass().getResource("images/rot02.jpg"));
    	ImageIcon ired3 = new ImageIcon(getClass().getResource("images/rot03.jpg"));
    	ImageIcon ired4 = new ImageIcon(getClass().getResource("images/rot04.jpg"));
    	ImageIcon ired5 = new ImageIcon(getClass().getResource("images/rot05.jpg"));
    	ImageIcon ired6 = new ImageIcon(getClass().getResource("images/rot06.jpg"));
    	ImageIcon ired7 = new ImageIcon(getClass().getResource("images/rot07.jpg"));
    	ImageIcon ired8 = new ImageIcon(getClass().getResource("images/rot08.jpg"));
    	ImageIcon ired9 = new ImageIcon(getClass().getResource("images/rot09.jpg"));
    	ImageIcon ired10 = new ImageIcon(getClass().getResource("images/rot10.jpg"));
    	
    	//alle Bilder der gelben Karten importieren
    	ImageIcon iyel2 = new ImageIcon(getClass().getResource("images/gelb02.jpg"));
    	ImageIcon iyel3 = new ImageIcon(getClass().getResource("images/gelb03.jpg"));
    	ImageIcon iyel4 = new ImageIcon(getClass().getResource("images/gelb04.jpg"));
    	ImageIcon iyel5 = new ImageIcon(getClass().getResource("images/gelb05.jpg"));
    	ImageIcon iyel6 = new ImageIcon(getClass().getResource("images/gelb06.jpg"));
    	ImageIcon iyel7 = new ImageIcon(getClass().getResource("images/gelb07.jpg"));
    	ImageIcon iyel8 = new ImageIcon(getClass().getResource("images/gelb08.jpg"));
    	ImageIcon iyel9 = new ImageIcon(getClass().getResource("images/gelb09.jpg"));
    	ImageIcon iyel10 = new ImageIcon(getClass().getResource("images/gelb10.jpg"));
    	
    	//alle Bilder der grauen Karten importieren
    	ImageIcon igrey2 = new ImageIcon(getClass().getResource("images/grau02.jpg"));
    	ImageIcon igrey3 = new ImageIcon(getClass().getResource("images/grau03.jpg"));
    	ImageIcon igrey4 = new ImageIcon(getClass().getResource("images/grau04.jpg"));
    	ImageIcon igrey5 = new ImageIcon(getClass().getResource("images/grau05.jpg"));
    	ImageIcon igrey6 = new ImageIcon(getClass().getResource("images/grau06.jpg"));
    	ImageIcon igrey7 = new ImageIcon(getClass().getResource("images/grau07.jpg"));
    	ImageIcon igrey8 = new ImageIcon(getClass().getResource("images/grau08.jpg"));
    	ImageIcon igery9 = new ImageIcon(getClass().getResource("images/grau09.jpg"));
    	ImageIcon igrey10 = new ImageIcon(getClass().getResource("images/grau10.jpg"));
    	
    	//alle Bilder der gruenen Karten importieren
    	ImageIcon igreen2 = new ImageIcon(getClass().getResource("images/gruen02.jpg"));
    	ImageIcon igreen3 = new ImageIcon(getClass().getResource("images/gruen03.jpg"));
    	ImageIcon igreen4 = new ImageIcon(getClass().getResource("images/gruen04.jpg"));
    	ImageIcon igreen5 = new ImageIcon(getClass().getResource("images/gruen05.jpg"));
    	ImageIcon igreen6 = new ImageIcon(getClass().getResource("images/gruen06.jpg"));
    	ImageIcon igreen7 = new ImageIcon(getClass().getResource("images/gruen07.jpg"));
    	ImageIcon igreen8 = new ImageIcon(getClass().getResource("images/gruen08.jpg"));
    	ImageIcon igreen9 = new ImageIcon(getClass().getResource("images/gruen09.jpg"));
    	ImageIcon igreen10 = new ImageIcon(getClass().getResource("images/gruen10.jpg"));
    	
    	//alle Bilder der orangen Karten importieren
    	ImageIcon iorange2 = new ImageIcon(getClass().getResource("images/orange02.jpg"));
    	ImageIcon iorange3 = new ImageIcon(getClass().getResource("images/orange03.jpg"));
    	ImageIcon iorange4 = new ImageIcon(getClass().getResource("images/orange04.jpg"));
    	ImageIcon iorange5 = new ImageIcon(getClass().getResource("images/orange05.jpg"));
    	ImageIcon iorange6 = new ImageIcon(getClass().getResource("images/orange06.jpg"));
    	ImageIcon iorange7 = new ImageIcon(getClass().getResource("images/orange07.jpg"));
    	ImageIcon iorange8 = new ImageIcon(getClass().getResource("images/orange08.jpg"));
    	ImageIcon iorange9 = new ImageIcon(getClass().getResource("images/orange09.jpg"));
    	ImageIcon iorange10 = new ImageIcon(getClass().getResource("images/orange10.jpg"));
    
    	/**
    	 * @author Madeleine
    	 */
        deck.add(new Card("red_2", 0, 2, "red", ired2));
        deck.add(new Card("red_3", 1, 3, "red", ired3));
        deck.add(new Card("red_4", 0, 4, "red", ired4));
        deck.add(new Card("red_5", 1, 5, "red", ired5));
        deck.add(new Card("red_6", 0, 6, "red", ired6));
        deck.add(new Card("red_7", 1, 7, "red", ired7));
        deck.add(new Card("red_8", 0, 8, "red", ired8));
        deck.add(new Card("red_9", 1, 9, "red", ired9));
        deck.add(new Card("red_10", 0, 10, "red", ired10));

        deck.add(new Card("grey_2", 0, 2, "grey", igrey2));
        deck.add(new Card("grey_3", 1, 3, "grey", igrey3));
        deck.add(new Card("grey_4", 0, 4, "grey", igrey4));
        deck.add(new Card("grey_5", 1, 5, "grey", igrey5));
        deck.add(new Card("grey_6", 0, 6, "grey", igrey6));
        deck.add(new Card("grey_7", 1, 7, "grey", igrey7));
        deck.add(new Card("grey_8", 0, 8, "grey", igrey8));
        deck.add(new Card("grey_9", 1, 9, "grey", igery9));
        deck.add(new Card("grey_10", 0, 10, "grey", igrey10));

        deck.add(new Card("green_2", 0, 2, "green", igreen2));
        deck.add(new Card("green_3", 1, 3, "green", igreen3));
        deck.add(new Card("green_4", 0, 4, "green", igreen4));
        deck.add(new Card("green_5", 1, 5, "green", igreen5));
        deck.add(new Card("green_6", 0, 6, "green", igreen6));
        deck.add(new Card("green_7", 1, 7, "green", igreen7));
        deck.add(new Card("green_8", 0, 8, "green", igreen8));
        deck.add(new Card("green_9", 1, 9, "green", igreen9));
        deck.add(new Card("green_10", 0, 10, "green", igreen10));

        deck.add(new Card("orange_2", 0, 2, "orange", iorange2));
        deck.add(new Card("orange_3", 1, 3, "orange", iorange3));
        deck.add(new Card("orange_4", 0, 4, "orange", iorange4));
        deck.add(new Card("orange_5", 1, 5, "orange", iorange5));
        deck.add(new Card("orange_6", 0, 6, "orange", iorange6));
        deck.add(new Card("orange_7", 1, 7, "orange", iorange7));
        deck.add(new Card("orange_8", 0, 8, "orange", iorange8));
        deck.add(new Card("orange_9", 1, 9, "orange", iorange9));
        deck.add(new Card("orange_10", 0, 10, "orange", iorange10));

        deck.add(new Card("yellow_2", 0, 2, "yellow", iyel2));
        deck.add(new Card("yellow_3", 1, 3, "yellow", iyel3));
        deck.add(new Card("yellow_4", 0, 4, "yellow", iyel4));
        deck.add(new Card("yellow_5", 1, 5, "yellow", iyel5));
        deck.add(new Card("yellow_6", 0, 6, "yellow", iyel6));
        deck.add(new Card("yellow_7", 1, 7, "yellow", iyel7));
        deck.add(new Card("yellow_8", 0, 8, "yellow", iyel8));
        deck.add(new Card("yellow_9", 1, 9, "yellow", iyel9));
        deck.add(new Card("yellow_10", 0, 10, "yellow", iyel10));
    }

    public Card findByName(String name)
    {
        for (Card card : deck)
        {
            if (card.getName().equals(name))
            {
                return card;
            }
        }
        return null;
    }

    public ArrayList<Card> getDeck()
    {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck)
    {
        this.deck = deck;
    }
}
