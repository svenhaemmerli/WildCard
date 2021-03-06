package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class Sevenset extends Sets implements IRule {

	@Override
	public String description() {
		return "Sevenset";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		
		return super.matchesRule(cards, 7);
	}

	@Override
	public int getSequenceLength() {
		return 0;
	}
}