package ch.fhnw.haggis.server;

import java.util.*;


public class JokerDeck {

	ArrayList<Card> joker = new ArrayList<Card>(); 
	
	public JokerDeck () {
				

			joker.add(new Card ("joker_jack1",2,11,"joker"));
			joker.add(new Card ("joker_queen1",3,12,"joker"));
			joker.add(new Card ("joker_king1",5,13,"joker"));
			
			joker.add(new Card ("joker_jack2",2,11,"joker"));
			joker.add(new Card ("joker_queen2",3,12,"joker"));
			joker.add(new Card ("joker_king2",5,13,"joker"));
			
			joker.add(new Card ("joker_jack3",2,11,"joker"));
			joker.add(new Card ("joker_queen3",3,12,"joker"));		
			joker.add(new Card ("joker_king3",5,13,"joker"));
			

			Iterator<Card> j = joker.iterator();
			while (j.hasNext()){
				System.out.println("Listenelement: "+j.next().getName());
			}
			System.out.println("joker gef�llt");
	}
			
	public static void main(String[] args) {
	
			
			}
							
	}	
