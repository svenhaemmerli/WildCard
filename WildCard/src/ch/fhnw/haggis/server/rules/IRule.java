package ch.fhnw.haggis.server.rules;

import java.util.List;
import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public interface IRule
{

    /**
     * Description.
     * 
     * @return the description of the draw.
     */
    public String description();

    /**
     * Check if the list of cards matches the given rule.
     * 
     * @param cards
     *            The cards.
     * @return true if the cards match the rule.
     */
    public boolean matchesRule(List<Card> cards);

    /**
     * Get the lowest rank for the current match.
     * 
     * @return the lowest rank of the matching rule.
     */
    public int getLowestRank();
    /**
     * Get the lowest rank for the current match.
     * 
     * @return the lowest rank of the matching rule.
     */
    public int getSequenceLength();
    
    

}
