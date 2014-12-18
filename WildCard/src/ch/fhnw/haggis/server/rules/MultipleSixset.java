package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class MultipleSixset
    extends MultipleSets
{

    @Override
    public String description()
    {
        return super.getNumberOfSets() + " Sixset(s)";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        int numberOfCardsInSet = 6; // one sixset has 6 cards
        return super.matchesRule(cards, numberOfCardsInSet);
    }

	@Override
	public int getSequenceLength() {
		return 0;
	}
}
