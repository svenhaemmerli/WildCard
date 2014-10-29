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
			cardarray[1] = new Card ("red_3",1,3,"red");
			cardarray[2] = new Card ("red_4",0,4,"red");
			cardarray[3] = new Card ("red_5",1,5,"red");
			cardarray[4] = new Card ("red_6",0,6,"red");
			cardarray[5] = new Card ("red_7",1,7,"red");
			cardarray[6] = new Card ("red_8",0,8,"red");
			cardarray[7] = new Card ("red_9",1,9,"red");
			cardarray[8] = new Card ("red_10",0,10,"red");
			
			cardarray[9] = new Card ("grey_2",0,2,"grey");
			cardarray[10] = new Card ("grey_3",1,3,"grey");
			cardarray[11] = new Card ("grey_4",0,4,"grey");
			cardarray[12] = new Card ("grey_5",1,5,"grey");
			cardarray[13] = new Card ("grey_6",0,6,"grey");
			cardarray[14] = new Card ("grey_7",1,7,"grey");
			cardarray[15] = new Card ("grey_8",0,8,"grey");
			cardarray[16] = new Card ("grey_9",1,9,"grey");
			cardarray[17] = new Card ("grey_10",0,10,"grey");
			
			cardarray[18] = new Card ("green_2",0,2,"green");
			cardarray[19] = new Card ("green_3",1,3,"green");
			cardarray[20] = new Card ("green_4",0,4,"green");
			cardarray[21] = new Card ("green_5",1,5,"green");
			cardarray[22] = new Card ("green_6",0,6,"green");
			cardarray[23] = new Card ("green_7",1,7,"green");
			cardarray[24] = new Card ("green_8",0,8,"green");
			cardarray[25] = new Card ("green_9",1,9,"green");
			cardarray[26] = new Card ("green_10",0,10,"green");
			
			cardarray[27] = new Card ("orange_2",0,2,"orange");
			cardarray[28] = new Card ("orange_3",1,3,"orange");
			cardarray[29] = new Card ("orange_4",0,4,"orange");
			cardarray[30] = new Card ("orange_5",1,5,"orange");
			cardarray[31] = new Card ("orange_6",0,6,"orange");
			cardarray[32] = new Card ("orange_7",1,7,"orange");
			cardarray[33] = new Card ("orange_8",0,8,"orange");
			cardarray[34] = new Card ("orange_9",1,9,"orange");
			cardarray[35] = new Card ("orange_10",0,10,"orange");
			
			cardarray[36] = new Card ("yellow_2",0,2,"yellow");
			cardarray[37] = new Card ("yellow_3",1,3,"yellow");
			cardarray[38] = new Card ("yellow_4",0,4,"yellow");
			cardarray[39] = new Card ("yellow_5",1,5,"yellow");
			cardarray[40] = new Card ("yellow_6",0,6,"yellow");
			cardarray[41] = new Card ("yellow_7",1,7,"yellow");
			cardarray[42] = new Card ("yellow_8",0,8,"yellow");
			cardarray[43] = new Card ("yellow_9",1,9,"yellow");
			cardarray[44] = new Card ("yellow_10",0,10,"yellow");

			cardarray[45] = new Card ("joker_jack1",2,11,"joker");
			cardarray[46] = new Card ("joker_jack2",2,11,"joker");
			cardarray[47] = new Card ("joker_jack3",2,11,"joker");
			
			cardarray[48] = new Card ("joker_queen1",3,12,"joker");
			cardarray[49] = new Card ("joker_queen2",3,12,"joker");
			cardarray[50] = new Card ("joker_queen3",3,12,"joker");
			
			cardarray[51] = new Card ("joker_king1",5,13,"joker");
			cardarray[52] = new Card ("joker_king2",5,13,"joker");
			cardarray[53] = new Card ("joker_king3",5,13,"joker");


		}
		
		for (int i=0;i<maxcards;i++){
			System.out.println("Card"+i+ cardarray[i].name);
	}
		
		}
	}
