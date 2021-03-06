package ch.fhnw.haggis.server.rules;

import java.util.List;
import ch.fhnw.haggis.server.Card;


/**
 * 
 * @author Ivo Hausammann
 *
 */

public class SingleSequence
    implements IRule
{
    public int sequenceLength = 0;
    private int lowestRank = 0;

    @Override
    public String description()
    {
        return "1 Sequence";
    }

    @Override
    public boolean matchesRule(List<Card> cards)
    {

        // muss mindestens 3 oder mehr Einzelkarten sein.
        if (cards.size() < 3)
        {
            return false;
        }

        sequenceLength = 0;

        // initialize rank and suit
        int rank = 1;
        // suit anhand erster karte bestimmen
        String suit = null;

        for (Card card : cards)
        {
            // for all regular cards
            if (!CardHelper.isJoker(card))
            {
                // falls farbe nicht gleich ist, wird abgebrochen
                if (suit != null && !suit.equals(card.getSuit()))
                {
                    return false;
                }
                // farbe bestimmen wenn noch nicht gesetzt
                if (suit == null)
                {
                    suit = card.getSuit();
                }

                // falls rank in schlaufe groesser oder gleich ist, wird abgebrochen
                if (rank >= card.getPoints())
                {
                    return false;
                }

                // update values
                rank = card.getPoints();
            }
            // joker ist platzhalter fuer andere karte
            else
            {
                // joker an position >= 10 muessen auch in folge sein
                if (rank >= 10)
                {
                    // joker wird nicht fuer eine beliebige tiefere karte eingesetzt.
                    if (rank >= card.getPoints())
                    {
                        return false;
                    }
                }
                // wir zaehlen rank um 1 hoch um forcieren zu koennen, dass die naechste karte
                // eines hoeher ist als dieser Joker
                rank++;
            }

            sequenceLength++;
        }

        // tiefster rank von dieser runde festhalten fuer naechsten spielzug
        lowestRank = rank - sequenceLength + 1;

        return true;
    }

    public int getSequenceLength()
    {
        return sequenceLength;
    }
	@Override
    public int getLowestRank()
    {
        return lowestRank;
    }

}
