package ch.fhnw.haggis.server;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * @author Madeleine Schär
 *
 */
public class JokerDeck {
	private ArrayList<Card> joker = new ArrayList<Card>();

	public JokerDeck()
    {
		//Alle Joker karten importieren
		/**
		 * @author Sven Hämmerli - Bilder der jeweiligen Karte zuweisen
		 */
    	
    	ImageIcon bube = new ImageIcon(getClass().getResource("images/Bube.jpg"));
    	bube.setImage(bube.getImage().getScaledInstance(64, 100,
				Image.SCALE_DEFAULT));
    	ImageIcon dame = new ImageIcon(getClass().getResource("images/Dame.jpg"));
    	dame.setImage(dame.getImage().getScaledInstance(64, 100,
				Image.SCALE_DEFAULT));
    	ImageIcon koenig = new ImageIcon(getClass().getResource("images/Koenig.jpg"));
    	koenig.setImage(koenig.getImage().getScaledInstance(64, 100,
				Image.SCALE_DEFAULT));
    	
    	/**
    	 * @author Madeleine Schär
    	 */
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
	
	public Card findByName(String name)
    {
        for (Card card : joker)
        {
            if (card.getName().equals(name))
            {
                return card;
            }
        }
        return null;
    }

	public ArrayList<Card> getJoker() {
		return joker;
	}

	public void setJoker(ArrayList<Card> joker) {
		this.joker = joker;
	}

}
