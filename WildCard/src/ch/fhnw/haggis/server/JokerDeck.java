package ch.fhnw.haggis.server;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class JokerDeck {
	private ArrayList<Card> joker = new ArrayList<Card>();

	public JokerDeck()
    {
		//Alle Joker karten importieren
    	
    	ImageIcon bube = new ImageIcon(getClass().getResource("images/Bube.jpg"));
    	ImageIcon dame = new ImageIcon(getClass().getResource("images/Dame.jpg"));
    	ImageIcon koenig = new ImageIcon(getClass().getResource("images/König.jpg"));
    	
        joker.add(new Card("joker_jack1", 2, 11, "joker", bube));
        joker.add(new Card("joker_queen1", 3, 12, "joker", dame));
        joker.add(new Card("joker_king1", 5, 13, "joker", koenig));

        joker.add(new Card("joker_jack2", 2, 11, "joker", bube));
        joker.add(new Card("joker_queen2", 3, 12, "joker", dame));
        joker.add(new Card("joker_king2", 5, 13, "joker", koenig));

        joker.add(new Card("joker_jack3", 2, 11, "joker", bube));
        joker.add(new Card("joker_queen3", 3, 12, "joker", dame));
        joker.add(new Card("joker_king3", 5, 13, "joker", koenig));
    }

	public ArrayList<Card> getJoker() {
		return joker;
	}

	public void setJoker(ArrayList<Card> joker) {
		this.joker = joker;
	}

}
