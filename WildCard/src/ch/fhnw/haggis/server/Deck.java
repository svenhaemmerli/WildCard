package ch.fhnw.haggis.server;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Deck implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1704089689189312874L;
	private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck()
    {
    	/** @author Sven
    	 * Bilder als Image importieren
    	 */
    	
    	
    	//Alle Bilder der roten karten imporitern
    	ImageIcon ired2 = new ImageIcon(getClass().getResource("images/rot02.jpg"));
    	ired2.setImage(ired2.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired3 = new ImageIcon(getClass().getResource("images/rot03.jpg"));
    	ired3.setImage(ired3.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired4 = new ImageIcon(getClass().getResource("images/rot04.jpg"));
    	ired4.setImage(ired4.getImage().getScaledInstance(150, 220,
    			Image.SCALE_DEFAULT));
    	ImageIcon ired5 = new ImageIcon(getClass().getResource("images/rot05.jpg"));
    	ired5.setImage(ired5.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired6 = new ImageIcon(getClass().getResource("images/rot06.jpg"));
    	ired6.setImage(ired6.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired7 = new ImageIcon(getClass().getResource("images/rot07.jpg"));
    	ired7.setImage(ired7.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired8 = new ImageIcon(getClass().getResource("images/rot08.jpg"));
    	ired8.setImage(ired8.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired9 = new ImageIcon(getClass().getResource("images/rot09.jpg"));
    	ired9.setImage(ired9.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon ired10 = new ImageIcon(getClass().getResource("images/rot10.jpg"));
    	ired10.setImage(ired10.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	
    	//alle Bilder der gelben Karten importieren
    	ImageIcon iyel2 = new ImageIcon(getClass().getResource("images/gelb02.jpg"));
    	iyel2.setImage(iyel2.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel3 = new ImageIcon(getClass().getResource("images/gelb03.jpg"));
    	iyel3.setImage(iyel3.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel4 = new ImageIcon(getClass().getResource("images/gelb04.jpg"));
    	iyel4.setImage(iyel4.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel5 = new ImageIcon(getClass().getResource("images/gelb05.jpg"));
    	iyel5.setImage(iyel5.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel6 = new ImageIcon(getClass().getResource("images/gelb06.jpg"));
    	iyel6.setImage(iyel6.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel7 = new ImageIcon(getClass().getResource("images/gelb07.jpg"));
    	iyel7.setImage(iyel7.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel8 = new ImageIcon(getClass().getResource("images/gelb08.jpg"));
    	iyel8.setImage(iyel8.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel9 = new ImageIcon(getClass().getResource("images/gelb09.jpg"));
    	iyel9.setImage(iyel9.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iyel10 = new ImageIcon(getClass().getResource("images/gelb10.jpg"));
    	iyel10.setImage(iyel10.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	
    	//alle Bilder der grauen Karten importieren
    	ImageIcon igrey2 = new ImageIcon(getClass().getResource("images/grau02.jpg"));
    	igrey2.setImage(igrey2.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey3 = new ImageIcon(getClass().getResource("images/grau03.jpg"));
    	igrey3.setImage(igrey3.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey4 = new ImageIcon(getClass().getResource("images/grau04.jpg"));
    	igrey4.setImage(igrey4.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey5 = new ImageIcon(getClass().getResource("images/grau05.jpg"));
    	igrey5.setImage(igrey5.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey6 = new ImageIcon(getClass().getResource("images/grau06.jpg"));
    	igrey6.setImage(igrey6.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey7 = new ImageIcon(getClass().getResource("images/grau07.jpg"));
    	igrey7.setImage(igrey7.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey8 = new ImageIcon(getClass().getResource("images/grau08.jpg"));
    	igrey8.setImage(igrey8.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey9 = new ImageIcon(getClass().getResource("images/grau09.jpg"));
    	igrey9.setImage(igrey9.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igrey10 = new ImageIcon(getClass().getResource("images/grau10.jpg"));
    	igrey10.setImage(igrey10.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	
    	
    	//alle Bilder der gruenen Karten importieren
    	ImageIcon igreen2 = new ImageIcon(getClass().getResource("images/gruen02.jpg"));
    	igreen2.setImage(igreen2.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen3 = new ImageIcon(getClass().getResource("images/gruen03.jpg"));
    	igreen3.setImage(igreen3.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen4 = new ImageIcon(getClass().getResource("images/gruen04.jpg"));
    	igreen4.setImage(igreen4.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen5 = new ImageIcon(getClass().getResource("images/gruen05.jpg"));
    	igreen5.setImage(igreen5.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen6 = new ImageIcon(getClass().getResource("images/gruen06.jpg"));
    	igreen6.setImage(igreen6.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen7 = new ImageIcon(getClass().getResource("images/gruen07.jpg"));
    	igreen7.setImage(igreen7.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen8 = new ImageIcon(getClass().getResource("images/gruen08.jpg"));
    	igreen8.setImage(igreen8.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen9 = new ImageIcon(getClass().getResource("images/gruen09.jpg"));
    	igreen9.setImage(igreen9.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon igreen10 = new ImageIcon(getClass().getResource("images/gruen10.jpg"));
    	igreen10.setImage(igreen10.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	
    	//alle Bilder der orangen Karten importieren
    	ImageIcon iorange2 = new ImageIcon(getClass().getResource("images/orange02.jpg"));
    	iorange2.setImage(iorange2.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange3 = new ImageIcon(getClass().getResource("images/orange03.jpg"));
    	iorange3.setImage(iorange3.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange4 = new ImageIcon(getClass().getResource("images/orange04.jpg"));
    	iorange4.setImage(iorange4.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange5 = new ImageIcon(getClass().getResource("images/orange05.jpg"));
    	iorange5.setImage(iorange5.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange6 = new ImageIcon(getClass().getResource("images/orange06.jpg"));
    	iorange6.setImage(iorange6.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange7 = new ImageIcon(getClass().getResource("images/orange07.jpg"));
    	iorange7.setImage(iorange7.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange8 = new ImageIcon(getClass().getResource("images/orange08.jpg"));
    	iorange8.setImage(iorange8.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange9 = new ImageIcon(getClass().getResource("images/orange09.jpg"));
    	iorange9.setImage(iorange9.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    	ImageIcon iorange10 = new ImageIcon(getClass().getResource("images/orange10.jpg"));
    	iorange10.setImage(iorange10.getImage().getScaledInstance(150, 220,
				Image.SCALE_DEFAULT));
    
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
        deck.add(new Card("grey_9", 1, 9, "grey", igrey9));
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
