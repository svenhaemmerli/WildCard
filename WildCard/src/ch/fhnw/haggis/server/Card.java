package ch.fhnw.haggis.server;

public class Card
{
    private String name;
    private int value;
    private int points;
    private String suit;

    /**
     * @param name
     * @param punktwert
     * @param rang
     * @param farbe
     */
    public Card(String name, int punktwert, int rang, String farbe)
    {
        super();
        this.name = name;
        this.value = punktwert;
        this.points = rang;
        this.suit = farbe;
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
}
