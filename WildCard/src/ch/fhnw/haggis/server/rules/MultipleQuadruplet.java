package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;


public class MultipleQuadruplet
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Quadruplet(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 4; // one quadruplet has 4 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }
}
