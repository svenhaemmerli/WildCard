package ch.fhnw.haggis.server;

import java.util.ArrayList;


public class Deck
{
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck()
    {
        deck.add(new Card("red_2", 0, 2, "red"));
        deck.add(new Card("red_3", 1, 3, "red"));
        deck.add(new Card("red_4", 0, 4, "red"));
        deck.add(new Card("red_5", 1, 5, "red"));
        deck.add(new Card("red_6", 0, 6, "red"));
        deck.add(new Card("red_7", 1, 7, "red"));
        deck.add(new Card("red_8", 0, 8, "red"));
        deck.add(new Card("red_9", 1, 9, "red"));
        deck.add(new Card("red_10", 0, 10, "red"));

        deck.add(new Card("grey_2", 0, 2, "grey"));
        deck.add(new Card("grey_3", 1, 3, "grey"));
        deck.add(new Card("grey_4", 0, 4, "grey"));
        deck.add(new Card("grey_5", 1, 5, "grey"));
        deck.add(new Card("grey_6", 0, 6, "grey"));
        deck.add(new Card("grey_7", 1, 7, "grey"));
        deck.add(new Card("grey_8", 0, 8, "grey"));
        deck.add(new Card("grey_9", 1, 9, "grey"));
        deck.add(new Card("grey_10", 0, 10, "grey"));

        deck.add(new Card("green_2", 0, 2, "green"));
        deck.add(new Card("green_3", 1, 3, "green"));
        deck.add(new Card("green_4", 0, 4, "green"));
        deck.add(new Card("green_5", 1, 5, "green"));
        deck.add(new Card("green_6", 0, 6, "green"));
        deck.add(new Card("green_7", 1, 7, "green"));
        deck.add(new Card("green_8", 0, 8, "green"));
        deck.add(new Card("green_9", 1, 9, "green"));
        deck.add(new Card("green_10", 0, 10, "green"));

        deck.add(new Card("orange_2", 0, 2, "orange"));
        deck.add(new Card("orange_3", 1, 3, "orange"));
        deck.add(new Card("orange_4", 0, 4, "orange"));
        deck.add(new Card("orange_5", 1, 5, "orange"));
        deck.add(new Card("orange_6", 0, 6, "orange"));
        deck.add(new Card("orange_7", 1, 7, "orange"));
        deck.add(new Card("orange_8", 0, 8, "orange"));
        deck.add(new Card("orange_9", 1, 9, "orange"));
        deck.add(new Card("orange_10", 0, 10, "orange"));

        deck.add(new Card("yellow_2", 0, 2, "yellow"));
        deck.add(new Card("yellow_3", 1, 3, "yellow"));
        deck.add(new Card("yellow_4", 0, 4, "yellow"));
        deck.add(new Card("yellow_5", 1, 5, "yellow"));
        deck.add(new Card("yellow_6", 0, 6, "yellow"));
        deck.add(new Card("yellow_7", 1, 7, "yellow"));
        deck.add(new Card("yellow_8", 0, 8, "yellow"));
        deck.add(new Card("yellow_9", 1, 9, "yellow"));
        deck.add(new Card("yellow_10", 0, 10, "yellow"));
    }

    public Card findByName(String name)
    {
        for (Card card : deck)
        {
            if (card.getName().equals(name))
            {
                return card;
            }
        }
        return null;
    }

    public ArrayList<Card> getDeck()
    {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck)
    {
        this.deck = deck;
    }
}
