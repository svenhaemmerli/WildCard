package ch.fhnw.haggis.server;

import java.util.*;


public class Hand{

	public ArrayList<Card> hand = new ArrayList<Card>(); //given cards
	
	public ArrayList<Card> win = new ArrayList<Card>(); //won cards
	
	
	
	public void playCard (Card c){ //play a card
		
		hand.remove(c);		
	}
	
	public int countCards (){ // count remaining cards
		Iterator c = hand.iterator();
		int count = 0;
		while (c.hasNext()){
			
			count ++;
		}
		return count;
	}
	
	public void addCards (Card d){ //Add cards to the won staple
		
		win.add(d);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}


}
