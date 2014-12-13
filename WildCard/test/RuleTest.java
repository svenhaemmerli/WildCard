import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.haggis.server.Card;
import ch.fhnw.haggis.server.Deck;
import ch.fhnw.haggis.server.JokerDeck;
import ch.fhnw.haggis.server.rules.Eightset;
import ch.fhnw.haggis.server.rules.IRule;
import ch.fhnw.haggis.server.rules.MultipleEightset;
import ch.fhnw.haggis.server.rules.MultiplePair;
import ch.fhnw.haggis.server.rules.MultipleQuadruplet;
import ch.fhnw.haggis.server.rules.MultipleQuintuplet;
import ch.fhnw.haggis.server.rules.MultipleSequences;
import ch.fhnw.haggis.server.rules.MultipleSevenset;
import ch.fhnw.haggis.server.rules.MultipleSixset;
import ch.fhnw.haggis.server.rules.MultipleTriplet;
import ch.fhnw.haggis.server.rules.Pair;
import ch.fhnw.haggis.server.rules.Quadruplet;
import ch.fhnw.haggis.server.rules.Quintuplet;
import ch.fhnw.haggis.server.rules.Sevenset;
import ch.fhnw.haggis.server.rules.Single;
import ch.fhnw.haggis.server.rules.SingleSequence;
import ch.fhnw.haggis.server.rules.Sixset;
import ch.fhnw.haggis.server.rules.Triplet;


public class RuleTest
{

    List<IRule> rules = new ArrayList<IRule>();

    Deck deck = new Deck();
    JokerDeck jokerDeck = new JokerDeck();

    @Before
    public void setUp()
    {
        rules.add(new Single());
        rules.add(new Pair());
        rules.add(new Triplet());
        rules.add(new Quadruplet());
        rules.add(new Quintuplet());
        rules.add(new Sixset());
        rules.add(new Sevenset());
        rules.add(new Eightset());

        // sequence
        rules.add(new SingleSequence());

        rules.add(new MultiplePair());
        rules.add(new MultipleTriplet());
        rules.add(new MultipleQuadruplet());
        rules.add(new MultipleQuintuplet());
        rules.add(new MultipleSixset());
        rules.add(new MultipleSevenset());
        rules.add(new MultipleEightset());

        rules.add(new MultipleSequences());
    }

    public boolean matches(List<Card> cards)
    {
        for (IRule rule : rules)
        {
            if (rule.matchesRule(cards))
            {
                return true;
            }
        }
        return false;
    }

    public IRule findeRegel(List<Card> cards)
    {

        for (IRule rule : rules)
        {
            if (rule.matchesRule(cards))
            {
                return rule;
            }
        }

        return null;
    }

    @Test
    public void testTwoCards()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_2"));
        cards.add(deck.findByName("grey_2"));

        IRule rule = findeRegel(cards);

        assertTrue(rule.matchesRule(cards));
        assertEquals(2, rule.getLowestRank());
    }

    @Test
    public void testTwoCardsFehler()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_2"));
        cards.add(deck.findByName("red_3"));

        IRule rule = findeRegel(cards);
        Assert.assertNull(rule);
    }

    @Test
    public void testSequence3()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_2"));
        cards.add(deck.findByName("red_3"));
        cards.add(deck.findByName("red_4"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(3, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(2, sequence.getLowestRank());
    }

    @Test
    public void testSequence3WithJokerOn2()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_2"));
        cards.add(jokerDeck.findByName("joker_jack1"));
        cards.add(deck.findByName("red_4"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(3, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(2, sequence.getLowestRank());
    }

    @Test
    public void testSequence3WithJokerOn1()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(jokerDeck.findByName("joker_queen1"));
        cards.add(deck.findByName("red_3"));
        cards.add(deck.findByName("red_4"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(3, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(2, sequence.getLowestRank());
    }

    @Test
    public void testSequence7_8_9()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_7"));
        cards.add(deck.findByName("red_8"));
        cards.add(deck.findByName("red_9"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(3, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(7, sequence.getLowestRank());
    }

    @Test
    public void testSequence10_J_Q()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_10"));
        cards.add(jokerDeck.findByName("joker_jack1"));
        cards.add(jokerDeck.findByName("joker_queen1"));

        Triplet t = new Triplet();
        assertTrue(t.matchesRule(cards));

        SingleSequence sequence = new SingleSequence();
        assertTrue(sequence.matchesRule(cards));
        
        MultipleSequences multisequence = new MultipleSequences();
        assertFalse(multisequence.matchesRule(cards));
    }

    @Test
    public void testSequence6_7_Q_9_10_J()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_6"));
        cards.add(deck.findByName("red_7"));
        cards.add(jokerDeck.findByName("joker_queen1"));
        cards.add(deck.findByName("red_9"));
        cards.add(deck.findByName("red_10"));
        cards.add(jokerDeck.findByName("joker_jack1"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(6, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(6, sequence.getLowestRank());
    }

    @Test
    public void testSequence6_7_Q_9_10_K()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_6"));
        cards.add(deck.findByName("red_7"));
        cards.add(jokerDeck.findByName("joker_queen1"));
        cards.add(deck.findByName("red_9"));
        cards.add(deck.findByName("red_10"));
        cards.add(jokerDeck.findByName("joker_king1"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(6, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(6, sequence.getLowestRank());
    }

    @Test
    public void testSequence4()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_2"));
        cards.add(deck.findByName("red_3"));
        cards.add(deck.findByName("red_4"));
        cards.add(deck.findByName("red_5"));

        IRule sequence = findeRegel(cards);

        assertTrue(sequence.matchesRule(cards));
        assertEquals(4, ((SingleSequence) sequence).getSequenceLength());
        assertEquals(2, sequence.getLowestRank());
    }

    @Test
    public void testPaerchenStrasse()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_8"));
        cards.add(deck.findByName("grey_8"));
        cards.add(deck.findByName("red_9"));
        cards.add(deck.findByName("grey_9"));

        IRule rule = findeRegel(cards);
        MultiplePair multiplePair = (MultiplePair) rule;

        assertEquals(2, multiplePair.getNumberOfSets());
        assertEquals("2 Pair(s)", rule.description());
        assertEquals(8, rule.getLowestRank());
    }

    @Test
    public void testDrillingStrasse()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_7"));
        cards.add(deck.findByName("red_8"));
        cards.add(deck.findByName("red_9"));

        cards.add(deck.findByName("grey_7"));
        cards.add(deck.findByName("grey_8"));
        cards.add(deck.findByName("grey_9"));

        IRule rule = findeRegel(cards);
        MultipleSequences multipleSequence = (MultipleSequences) rule;

        assertEquals(2, multipleSequence.getNumberOfSets());
        assertEquals("2 Sequence(s)", rule.description());
        assertEquals(7, rule.getLowestRank());
    }
    
    @Test
    public void testDrillingStrasse2()
    {
        List<Card> cards = new ArrayList<Card>();
        
        cards.add(deck.findByName("red_7"));
        cards.add(deck.findByName("grey_7"));
        cards.add(deck.findByName("red_8"));
        cards.add(deck.findByName("grey_8"));
        cards.add(deck.findByName("red_9"));
        cards.add(deck.findByName("grey_9"));
        
        IRule rule = findeRegel(cards);
        MultiplePair multiplePair = (MultiplePair) rule;
        
        assertEquals(3, multiplePair.getNumberOfSets());
        assertEquals("3 Pair(s)", rule.description());
        assertEquals(7, rule.getLowestRank());
    }

    @Test
    public void testZweifachVierling()
    {
        List<Card> cards = new ArrayList<Card>();

        cards.add(deck.findByName("red_8"));
        cards.add(deck.findByName("green_8"));
        cards.add(deck.findByName("orange_8"));
        cards.add(deck.findByName("yellow_8"));

        cards.add(deck.findByName("red_9"));
        cards.add(deck.findByName("green_9"));
        cards.add(deck.findByName("orange_9"));
        cards.add(deck.findByName("yellow_9"));

        IRule rule = findeRegel(cards);
        MultipleQuadruplet multiQuadruplet = (MultipleQuadruplet) rule;

        assertEquals(2, multiQuadruplet.getNumberOfSets());
        assertEquals("2 Quadruplet(s)", rule.description());
        assertEquals(8, rule.getLowestRank());
    }

}
