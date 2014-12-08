package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

public class Quadruplet extends Sets implements IRule {

	@Override
	public String description() {
		return "Quadruplet";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		
		return super.matchesRule(cards, 4);
	}
}