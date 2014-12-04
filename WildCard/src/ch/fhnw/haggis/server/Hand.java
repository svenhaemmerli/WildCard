package ch.fhnw.haggis.server;

import java.io.Serializable;
import java.util.*;


public class Hand implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4660817019770190530L;

	public ArrayList<Card> hand = new ArrayList<Card>(); // given cards

    public ArrayList<Card> win = new ArrayList<Card>(); // won cards

    public void playCard(Card c)
    { // play a card

        hand.remove(c);
    }

    public int countCards()
    { // count remaining cards
        Iterator c = hand.iterator();
        int count = 0;
        while (c.hasNext())
        {

            count++;
        }
        return count;
    }

    public void addCards(Card d)
    { // Add cards to the won staple

        win.add(d);
    }

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getWin() {
		return win;
	}

	public void setWin(ArrayList<Card> win) {
		this.win = win;
	}
    
}
