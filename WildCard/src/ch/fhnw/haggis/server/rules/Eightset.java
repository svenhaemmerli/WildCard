package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class Eightset extends Sets implements IRule {

	@Override
	public String description() {
		return "Eightset";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		
		return super.matchesRule(cards, 8);
	}

	@Override
	public int getSequenceLength() {
		return 0;
	}

}