package ch.fhnw.haggis.server.rules;

import java.util.List;
import ch.fhnw.haggis.server.Card;
import ch.fhnw.haggis.server.rules.IRule;

/**
 * 
 * @author Ivo Hausammann
 *
 */

public class Pair extends Sets implements IRule {

	@Override
	public String description() {
		return "Pair";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		
		return super.matchesRule(cards, 2);
	}

	@Override
	public int getSequenceLength() {
		return 0;
	}
}
