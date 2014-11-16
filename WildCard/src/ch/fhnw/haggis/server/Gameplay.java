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
		
		if (d.deck.isEmpty()==true){
			return "Deck leer";
		}
		else {
			return "Deck voll";
		}
		
	}
	
	public Hand distributeCard (Deck d, Hand h){
		
		for (int i = 0; i<=14;i++){
			h.hand.add(d.deck.get(i)); //Karten von Deck zu Hand hinzufügen
			d.deck.remove(d.deck.get(i)); // Karten aus Deck löschen

		}
		
		Iterator<Card> a = h.hand.iterator(); //Hand Ausgabe
		while (a.hasNext()){
			System.out.println("Listenelement: "+a.next().getName());
		}
		
			System.out.println("Ende hand");
		
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
		
		h1 = g.distributeCard(d,h1);
		h2 = g.distributeCard(d,h2);
		h3 = g.distributeCard(d,h3);
		
		Iterator<Card> c = d.deck.iterator(); //Restkarten im Deck
		while (c.hasNext()){
			System.out.println("Listenelement: "+c.next().getName());
		}
		
		
		
		
		
		
		
	}


}
