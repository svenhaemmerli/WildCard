package ch.fhnw.haggis.server;

public class UserData {
	
	private String username;
	private int score;
	private int amtCards;
	private int giver; //int because of the id of the player
	
	public UserData (){
		
	}
	
	public UserData (String username){
		
	}
	
	public UserData (int score, int amtCards, int giver){
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAmtCards() {
		return amtCards;
	}

	public void setAmtCards(int amtCards) {
		this.amtCards = amtCards;
	}

	public int getGiver() {
		return giver;
	}

	public void setGiver(int giver) {
		this.giver = giver;
	}
	

}
