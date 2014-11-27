package ch.fhnw.haggis.server;

import java.util.ArrayList;


public class JokerDeck
{
    private ArrayList<Card> joker = new ArrayList<Card>();

    public JokerDeck()
    {
        joker.add(new Card("joker_jack1", 2, 11, "joker"));
        joker.add(new Card("joker_queen1", 3, 12, "joker"));
        joker.add(new Card("joker_king1", 5, 13, "joker"));

        joker.add(new Card("joker_jack2", 2, 11, "joker"));
        joker.add(new Card("joker_queen2", 3, 12, "joker"));
        joker.add(new Card("joker_king2", 5, 13, "joker"));

        joker.add(new Card("joker_jack3", 2, 11, "joker"));
        joker.add(new Card("joker_queen3", 3, 12, "joker"));
        joker.add(new Card("joker_king3", 5, 13, "joker"));
    }

    public ArrayList<Card> getJoker()
    {
        return joker;
    }

    public void setJoker(ArrayList<Card> joker)
    {
        this.joker = joker;
    }

}
