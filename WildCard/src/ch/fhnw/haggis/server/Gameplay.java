package ch.fhnw.haggis.server;

import java.util.*;

public class Gameplay{

	public int points;
	public int actualPlayer;

	
	public String shuffleCards (Deck d){ //Deck mischen
	
		Collections.shuffle(d.deck);
		
		Iterator<Card> b = d.deck.iterator();
		while (b.hasNext()){
			System.out.println("Listenelement: "+b.next().getName());
		}
		
		return "Deck shuffled";
	}
	
	public Hand distributeCard (Deck d, Hand h){
		
		while (d.deck.isEmpty()!=true && h.hand.size()<14){
			h.hand.add(d.deck.get(0)); //Karten von Deck zu Hand hinzufügen
			d.deck.remove(d.deck.get(0)); // Karten aus Deck löschen

		}
		
		Iterator<Card> b = h.hand.iterator(); //Hand Ausgabe
		while (b.hasNext()){
			System.out.println("Listenelement: "+b.next().getName());
		}
		
			System.out.println("Ende hand ohne Joker");
		
		return h; 
		
	}
	
public Hand distributeJoker (JokerDeck a, Hand h){
		
			
		while (a.joker.isEmpty()!=true && h.hand.size()<17){
			h.hand.add(a.joker.get(0));
			a.joker.remove(a.joker.get(0));
		}
		
		Iterator<Card> c = h.hand.iterator(); //Hand Ausgabe
		while (c.hasNext()){
			System.out.println("Listenelement: "+c.next().getName());
		}
		
			System.out.println("Ende hand mit Joker");
		
		return h; 
		
	}
	
	public static void main(String[] args) {
		
		
		Deck d = new Deck(); //Deck und Hands werden instanziert
		Hand h1 = new Hand();
		Hand h2 = new Hand();
		Hand h3 = new Hand();
		
		Gameplay g = new Gameplay();		//Gameplay wird instanziert
				
		String s = g.shuffleCards(d);		//
		System.out.println(s);
		
		JokerDeck a = new JokerDeck();
		
		//Karten in Hand füllen, Methode aufrufen
		h1 = g.distributeCard(d,h1); 
		h2 = g.distributeCard(d,h2);
		h3 = g.distributeCard(d,h3);
		
		//Joker in Hand füllen, Methode aufrufen
		h1 = g.distributeJoker(a,h1);
		h2 = g.distributeJoker(a,h2);
		h3 = g.distributeJoker(a,h3);
		
		Iterator<Card> c = d.deck.iterator(); //Restkarten im Deck
		while (c.hasNext()){
			System.out.println("Listenelement: "+c.next().getName());
		}
		
		
		
		
		
		
		
	}


}
