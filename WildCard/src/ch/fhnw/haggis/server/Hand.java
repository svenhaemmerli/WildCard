package ch.fhnw.haggis.server;

import java.util.*;


public class Hand
{
    public ArrayList<Card> hand = new ArrayList<Card>(); // given cards

    public ArrayList<Card> win = new ArrayList<Card>(); // won cards
    
    public ArrayList<Card> pod = new ArrayList<Card>(); // pod cards
    
    public Hand (Deck d){
    	
    	while (d.getDeck().isEmpty() != true && this.hand.size() < 14)
        {
            this.hand.add(d.getDeck().get(0)); // Karten von Deck zu Hand hinzuf�gen
            d.getDeck().remove(d.getDeck().get(0)); // Karten aus Deck l�schen

        }

        Iterator<Card> b = this.hand.iterator(); // Hand Ausgabe
        while (b.hasNext())
        {
            System.out.println("Listenelement: " + b.next().getName());
        }

        System.out.println("Ende hand ohne Joker");
    }

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
}
