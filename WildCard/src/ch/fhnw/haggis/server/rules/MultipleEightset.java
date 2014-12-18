package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class MultipleEightset
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Eightset(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 8; // one eightset has 8 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }
}
