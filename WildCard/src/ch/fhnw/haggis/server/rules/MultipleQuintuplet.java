package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;


public class MultipleQuintuplet
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Quintuplet(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 5; // one quintuplet has 5 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }
}
