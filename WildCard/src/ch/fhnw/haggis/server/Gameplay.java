package ch.fhnw.haggis.server;

import java.util.*;

public class Gameplay{

	public int points;
	public int actualPlayer;

	
	public String shuffleCards (Deck d){
	
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
		
		for (int i = 0; i<11;i++){
			h.hand.add(d.deck.get(i));
			d.deck.remove(d.deck.get(i));

		}
		
		Iterator<Card> a = h.hand.iterator();
		while (a.hasNext()){
			System.out.println("Listenelement: "+a.next().getName());
		}
		
			System.out.println("Ende hand");
		
		return h; 
		
	}
	
	public static void main(String[] args) {
		
		
		Deck d = new Deck();
		Hand h1 = new Hand();
		Hand h2 = new Hand();
		Hand h3 = new Hand();
		
		Gameplay g = new Gameplay();		
		System.out.println("Hallo");
		
		String s = g.shuffleCards(d);
		System.out.println(s);
		
		h1 = g.distributeCard(d,h1);
		h2 = g.distributeCard(d,h2);
		h3 = g.distributeCard(d,h3);
		
		Iterator<Card> c = d.deck.iterator();
		while (c.hasNext()){
			System.out.println("Listenelement: "+c.next().getName());
		}
		
		
		
		
		
		
		
	}


}
