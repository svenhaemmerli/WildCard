package ch.fhnw.haggis.server;

import java.io.Serializable;

/**
 * @author Madeleine Schär
 * Klasse um Spieldaten vom Client zum Server zu schicken.
 */
public class SpieldatenRequest
    implements Serializable
{
    private static final long serialVersionUID = 3635384963538773512L;

    private String step;
    private String message;
    private Hand myHand;
    private UserData data;
    

    @Override
    public String toString()
    {
        return "SpieldatenRequest [step=" + step + ", message=" + message + "]";
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

	public Hand getMyHand() {
		return myHand;
	}

	public void setMyHand(Hand myHand) {
		this.myHand = myHand;
		
	}

	public UserData getData() {
		return data;
	}

	public void setData(UserData data) {
		this.data = data;
	}

    public String getStep()
    {
        return step;
    }

    public void setStep(String step)
    {
        this.step = step;
    }
    
}
