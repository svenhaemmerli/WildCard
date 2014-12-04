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
    
    private int score;

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

}
