package ch.fhnw.haggis.server.rules;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.haggis.server.Card;


// abstract class to not be able to instanciate
public abstract class MultipleSets
    extends Sets
{

    private int lowestRank = 0;
    private int numberOfSets = 0;

    protected boolean matchesRule(List<Card> cards, int numberOfCardsInSet)
    {
        int numberOfCards = cards.size();

        // muss eine n-kombination sein (bei pair z.B. anzahl modulo 2 == 0), ansonsten kanns
        // gar kein multiple pair sein
        if (numberOfCards % numberOfCardsInSet != 0)
        {
            return false;
        }

        // anzahl sets bestimmen (total anzahl karten / anzahl pro set. z.B. 6 / 2 = 3)
        numberOfSets = numberOfCards / numberOfCardsInSet;

        // aufteilung der liste in sublisten
        for (int i = 0; i < numberOfCards; i = i + numberOfCardsInSet)
        {
            int von = i;
            int bis = i + numberOfCardsInSet;
            List<Card> pair = cards.subList(von, bis);

            // falls eine der kombinationen kein n-paar ist, brechen wir ab
            if (!super.matchesRule(pair, numberOfCardsInSet))
            {
                return false;
            }
            // bei der ersten kombination merken wir uns der tiefste wert der paarkombinationen
            if (i == 0)
            {
                lowestRank = super.getLowestRank();
            }
        }

        // farben sammeln
        List<String> farben = new ArrayList<String>();
        for (Card card : cards)
        {
            String farbe = card.getSuit();
            // nur farben hinzufügen, die noch nicht in der liste sind, auch keine joker
            if (!farben.contains(farbe) && !farbe.equals("joker"))
            {
                farben.add(card.getSuit());
            }
        }

        // falls es mehr Farben gibt als die anzahl karten in einem paar, haben wir einen fehler.
        // Bsp:
        // paar1: rot, gelb
        // paar2: rot, orange
        // --> fehler
        if (farben.size() > numberOfCardsInSet)
        {
            return false;
        }

        return true;
    }

    @Override
    public int getLowestRank()
    {
        return lowestRank;
    }

    public int getNumberOfSets()
    {
        return numberOfSets;
    }
}
