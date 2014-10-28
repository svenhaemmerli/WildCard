package ch.fhnw.haggis.server;

public class Card {

	private String name;
	private int value;
	private int points;
	private String suit;

	public String getName() { //getter & setter methods
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	
	
	/**
	 * @param name
	 * @param value
	 * @param points
	 * @param suit
	 */
	public Card(String name, int value, int points, String suit) {
		super();
		this.name = name;
		this.value = value;
		this.points = points;
		this.suit = suit;
	}
	
	public Card () {
		
	}

	public static void main(String[] args) {
	
		int maxcards = 54; //Max Anzahl Karten
		
		Card[] cardarray = new Card[maxcards]; //Anlegen des Arrays
		
		for (int i=0; i<maxcards; i++){ //Befüllen des Arrays mit leerwerten
			cardarray[i] = new Card ();
			cardarray[0] = new Card ("red_2",0,2,"red");
			cardarray[1] = new Card ("red_3",0,3,"red");
			cardarray[2] = new Card ("joker_queen1",4,12,"joker");
		}
		
		for (int i=0;i<maxcards;i++){
			System.out.println("Card"+i+ cardarray[i].name);
	}
		
		}
	}
