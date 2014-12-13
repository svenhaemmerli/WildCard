package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;


public class MultiplePair
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Pair(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 2; // one pair has 2 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }
}
