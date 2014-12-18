package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class MultipleSequences
    extends SingleSequence
{
    private int numberOfSets;

    @Override
    public String description()
    {
        return "Sequences";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {
        // strassen aufteilen
        // strassen muessen daher wie folgt daherkommen:
        // r7,r8,r9,y7,y8,y9...
        int previousPoints = 0;
        int anzahlStrassen = 1;
        for (Card card : cards)
        {
            // wenn vorhergehendes element groesser als aktuelles -> neuer beginn einer strasse
            if (previousPoints > card.getPoints())
            {
                anzahlStrassen++;
            }
            previousPoints = card.getPoints();
        }

        int anzahlKartenInEinerStrasse = cards.size() / anzahlStrassen;
        numberOfSets = anzahlStrassen;
        
        // ein multisequence muss mehr als 1 set haben
        if(numberOfSets < 2)
        {
            return false;
        }

        for (int i = 0; i < cards.size(); i += anzahlKartenInEinerStrasse)
        {
            int von = i;
            int bis = i + anzahlKartenInEinerStrasse;
            List<Card> einzelneStrasse = cards.subList(von, bis);

            if (!super.matchesRule(einzelneStrasse))
            {
                return false;
            }
        }

        return true;
    }

    public int getNumberOfSets()
    {
        return numberOfSets;
    }
}
