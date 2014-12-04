package ch.fhnw.haggis.server;

import java.io.Serializable;


/**
 * Klasse um Spieldaten vom Server zum Client zu schicken.
 */
public class SpieldatenResponse
    implements Serializable
{
   

	private static final long serialVersionUID = 3635384963538773512L;

    private String message;

    private Hand myHand;
    private Hand pot;
    
    private int score;
    private int amtCards;
    private boolean giver;
    
    
    private String username1;
    private String username2;

    @Override
    public String toString()
    {
        return "SpieldatenResponse [message=" + message + "]";
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Hand getMyHand()
    {
        return myHand;
    }

    public void setMyHand(Hand myHand)
    {
        this.myHand = myHand;
    }

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	 public Hand getPot() {
			return pot;
		}

		public void setPot(Hand pot) {
			this.pot = pot;
		}

		public int getAmtCards() {
			return amtCards;
		}

		public void setAmtCards(int amtCards) {
			this.amtCards = amtCards;
		}

		public boolean isGiver() {
			return giver;
		}

		public void setGiver(boolean giver) {
			this.giver = giver;
		}

		public String getUsername1() {
			return username1;
		}

		public void setUsername1(String username1) {
			this.username1 = username1;
		}

		public String getUsername2() {
			return username2;
		}

		public void setUsername2(String username2) {
			this.username2 = username2;
		}

}
