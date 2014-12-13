package ch.fhnw.haggis.server.rules;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.haggis.server.Card;


// abstract class to not be able to instanciate
public abstract class Sets
    implements IRule
{
    private int lowestRank;

    protected boolean matchesRule(List<Card> cards, int anzahlKartenFuerReihe)
    {
        // Diese Regel trifft nur zu wenn genau anzahlKartenFuerReihe Karten exisitieren
        if (cards.size() != anzahlKartenFuerReihe)
        {
            return false;
        }

        List<Card> kartenOhneJoker = new ArrayList<Card>();

        for (Card card : cards)
        {
            if (!CardHelper.isJoker(card))
            {
                kartenOhneJoker.add(card);
            }
        }

        // Kombination darf nicht nur aus Joker bestehen, ausser einem einzelnen Joker (Singleset)
        int anzahlJoker = cards.size() - kartenOhneJoker.size();
        if (anzahlJoker == cards.size() && cards.size() != 1)
        {
            return false;
        }

        lowestRank = 0;

        for (Card card : kartenOhneJoker)
        {

            // Bestimmung des aktuellen Ranks beim ersten Element in der Schlaufe
            if (lowestRank == 0)
            {
                lowestRank = card.getPoints();
            }

            // Wir brechen ab sobald ein anderer Rank gefunden wurde
            if (card.getPoints() != lowestRank)
            {
                return false;
            }
        }

        return true;

    }

    @Override
    public int getLowestRank()
    {
        return lowestRank;
    }

}
