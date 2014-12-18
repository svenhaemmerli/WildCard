package ch.fhnw.haggis.server;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Madeleine Schär, Sven Hämmerli
 *
 */
public class UserData implements Serializable{

	private String username;
	private int score;
	private int amtCards;
	private int giver; //int because of the id of the player
	public static int trickPunkte;
	private String jack;
	private String queen;
	private String king;
	
	public String getJack() {
		return jack;
	}

	public void setJack(String jack) {
		this.jack = jack;
	}

	public String getQueen() {
		return queen;
	}

	public void setQueen(String queen) {
		this.queen = queen;
	}

	public String getKing() {
		return king;
	}

	public void setKing(String king) {
		this.king = king;
	}
	
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
