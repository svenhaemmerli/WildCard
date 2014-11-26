package ch.fhnw.haggis.server;

public class playerWildcard {
	
	private String Username;
	private int totalScore;
	private int gameScore;
	private int ID;
	private boolean giver;
	private Hand hand;
	
	
	
	
	//constructor username, number 
	public playerWildcard(int number, int gameScore, boolean giver, Hand hand) {
		super();
		this.gameScore = gameScore;
		ID = number;
		this.giver = giver;
		this.hand = hand;
	}

	

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public boolean isGiver() {
		return giver;
	}

	public void setGiver(boolean giver) {
		this.giver = giver;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
