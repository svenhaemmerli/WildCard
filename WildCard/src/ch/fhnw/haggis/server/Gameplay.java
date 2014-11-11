package ch.fhnw.haggis.server;

import java.util.*;

public class Gameplay{

	public int points;
	public int actualPlayer;
	public ArrayList<Card> deck;
	
	public String shuffleCards (){
	
		Collections.shuffle(deck);
		if (deck.isEmpty()==true){
			return "Deck leer";
		}
		else {
			return "Deck voll";
		}
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Hallo");
		
		
		
	}


}
