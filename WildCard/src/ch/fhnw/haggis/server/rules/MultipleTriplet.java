package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class MultipleTriplet
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Triplet(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 3; // one triplet has 3 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }
}
