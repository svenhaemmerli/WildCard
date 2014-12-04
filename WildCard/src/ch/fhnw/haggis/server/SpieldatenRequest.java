package ch.fhnw.haggis.server;

import java.io.Serializable;


/**
 * Klasse um Spieldaten vom Client zum Server zu schicken.
 */
public class SpieldatenRequest
    implements Serializable
{
    private static final long serialVersionUID = 3635384963538773512L;

    private String message;

    @Override
    public String toString()
    {
        return "SpieldatenRequest [message=" + message + "]";
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}