package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;


public class MultipleSevenset
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Sevenset(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 7; // one sevenset has 7 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }
}
