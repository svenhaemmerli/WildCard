package ch.fhnw.haggis.server;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Card implements Serializable
{
	
    /**
	 * @author Madeleine Schär
	 */
	private static final long serialVersionUID = 8118435653047467973L;
	private String name;
    private int value;
    private int points;
    private String suit;
    private ImageIcon icon;

    /**
     * @param name
     * @param punktwert
     * @param rang
     * @param farbe
     */
    public Card(String name, int punktwert, int rang, String farbe, ImageIcon icon)
    {
        super();
        this.name = name;
        this.value = punktwert;
        this.points = rang;
        this.suit = farbe;
        this.icon = icon;
    }

    public Card()
    {

    }
    
   
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String getSuit()
    {
        return suit;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

    @Override
    public String toString()
    {
        return "Card [name=" + name + ", value=" + value + ", points=" + points + ", suit=" + suit
            + ", icon=" + icon + "]";
    }
}
