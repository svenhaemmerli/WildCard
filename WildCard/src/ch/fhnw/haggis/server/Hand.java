package ch.fhnw.haggis.server;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Madeleine Schär
 *
 */
public class Hand
    implements Serializable
{

    private static final long serialVersionUID = 4660817019770190530L;

    public ArrayList<Card> hand = new ArrayList<Card>(); // given cards, later istanciated as myHand

    public ArrayList<Card> pot = new ArrayList<Card>(); // pod cards
    
    public ArrayList<Card> potActual = new ArrayList<Card>(); // podActual contains only recently played cards
    

    public Hand(Deck d, JokerDeck a)
    {

        while (d.getDeck().isEmpty() != true && this.hand.size() < 14)
        {
            this.hand.add(d.getDeck().get(0)); // Cards removed from deck to hand
            d.getDeck().remove(d.getDeck().get(0));

        }

        while (a.getJoker().isEmpty() != true && this.hand.size() < 17)
        {
            this.hand.add(a.getJoker().get(0));
            a.getJoker().remove(a.getJoker().get(0));
        }

        Iterator<Card> c = this.hand.iterator();
        while (c.hasNext())
        {
            System.out.println("Listenelement: " + c.next().getName());
        }

        System.out.println("Ende hand mit Joker");
    }

    public Hand(ArrayList<Card> hand)
    {
        // leere Hand, damit ich diese anschliessend im playtable befï¿½llen kann.
        this.hand = hand;
    }

    // remove the played cards (the one in the pot) from the hand
    public void removePlayedCardsFromHand(ArrayList<Card> playedCards)
    {
        ArrayList<String> cardNamesToRemove = new ArrayList<String>();
        for (Card card : playedCards)
        {
            cardNamesToRemove.add(card.getName());
        }

        Iterator<Card> i = hand.iterator();
        while (i.hasNext())
        {
            Card card = i.next();
            if (cardNamesToRemove.contains(card.getName()))
            {
                i.remove();
            }
        }
    }

    public int countCards(ArrayList<Card> deck)
    { // count remaining cards in deck
        Iterator c = hand.iterator();
        int count = 0;
        while (c.hasNext())
        {
            count++;
        }
        return count;
    }

    public void distributeNewCards(ArrayList<Card> hand)
    {

        JokerDeck jdeck2 = new JokerDeck();
        Deck deck2 = new Deck();
        Collections.shuffle(deck2.getDeck());

        while (deck2.getDeck().isEmpty() != true && this.hand.size() < 14)
        {
            this.hand.add(deck2.getDeck().get(0)); // Cards removed from deck to hand
            deck2.getDeck().remove(deck2.getDeck().get(0));

        }

        while (jdeck2.getJoker().isEmpty() != true && this.hand.size() < 17)
        {
            this.hand.add(jdeck2.getJoker().get(0));
            jdeck2.getJoker().remove(jdeck2.getJoker().get(0));
        }

        Iterator<Card> c = this.hand.iterator();
        while (c.hasNext())
        {
            System.out.println("Listenelement: " + c.next().getName());
        }

        System.out.println("Ende hand mit Joker");
    }

    // -----------------getter & setter ---------------------//

    public void setHand(ArrayList<Card> hand)
    {
        this.hand = hand;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public ArrayList<Card> getPot() {
        return pot;
   }

	public ArrayList<Card> getPotActual() {
		return potActual;
	}

	public void setPotActual(ArrayList<Card> potActual) {
		this.potActual = potActual;
	}
}
