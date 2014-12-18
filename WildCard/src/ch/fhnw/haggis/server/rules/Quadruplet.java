package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class Quadruplet extends Sets implements IRule {

	@Override
	public String description() {
		return "Quadruplet";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		
		return super.matchesRule(cards, 4);
	}

	@Override
	public int getSequenceLength() {
		return 0;
	}
}