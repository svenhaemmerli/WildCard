package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class Single extends Sets implements IRule {

	@Override
	public String description() {
		return "Single";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		
		return super.matchesRule(cards, 1);
	}

	@Override
	public int getSequenceLength() {
		return 0;
	}
}
