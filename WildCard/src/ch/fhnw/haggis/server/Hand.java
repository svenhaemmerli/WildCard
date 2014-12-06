package ch.fhnw.haggis.server;

import java.io.Serializable;
import java.util.*;


public class Hand implements Serializable {
   
	private static final long serialVersionUID = 4660817019770190530L;

	public ArrayList<Card> hand = new ArrayList<Card>(); // given cards, later istanciated as myHand

    public ArrayList<Card> win = new ArrayList<Card>(); // won cards
    
    public ArrayList<Card> pot = new ArrayList<Card>(); // pod cards
    
    
    public Hand (Deck d, JokerDeck a){
    	
    	while (d.getDeck().isEmpty() != true && this.hand.size() < 14)
        {
            this.hand.add(d.getDeck().get(0)); // Cards removed from deck to hand
            d.getDeck().remove(d.getDeck().get(0)); 

        }

//        Iterator<Card> b = this.hand.iterator(); // Hand Ausgabe
//        while (b.hasNext())
//        {
//            System.out.println("Listenelement: " + b.next().getName());
//        }
//
//        System.out.println("Ende hand ohne Joker");
        
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



	public Hand() {
		// leere Hand, damit ich diese anschliessend im playtable befüllen kann.
	}



	public void processCardsPlayed(Hand myHand){ //Add cards to pot, remove form myHand
    	
        while (myHand.hand.isEmpty()==false)
        {
        	pot.add(myHand.hand.get(0));
        	myHand.hand.remove(myHand.hand.get(0));
        }
    }
    public void addCardsWon(ArrayList<Card> pot) { // Add cards to the won, remove from pot
    	Iterator<Card> b = pot.iterator();
        int count = 0;
        while (b.hasNext())
        {
        	win.add(b.next());
        	pot.remove(b.next());
            count++;
        }
    }
    
    public int countCards(ArrayList <Card> deck) { // count remaining cards in deck
        Iterator c = hand.iterator();
        int count = 0;
        while (c.hasNext())
        {
            count++;
        }
        return count;
    }
    
    public void distributeNewCards (ArrayList<Card> hand){
    	
    	JokerDeck jdeck2 = new JokerDeck();
    	Deck deck2 = new Deck();
    	
    	
    	while (deck2.getDeck().isEmpty() != true && this.hand.size() < 14)
        {
            this.hand.add(deck2.getDeck().get(0)); // Cards removed from deck to hand
            deck2.getDeck().remove(deck2.getDeck().get(0)); 

        }

//        Iterator<Card> b = this.hand.iterator(); // Hand Ausgabe
//        while (b.hasNext())
//        {
//            System.out.println("Listenelement: " + b.next().getName());
//        }
//
//        System.out.println("Ende hand ohne Joker");
        
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
    

    
   //-------------------------------------------getter & setter -------------------------------------------------------------------------//


	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getWin() {
		return win;
	}

	public void setWin(ArrayList<Card> win) {
		this.win = win;
	}
	

	public ArrayList<Card> getPot() {
		return pot;
	}

}
