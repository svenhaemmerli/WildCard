package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

public class Single implements IRule {

	@Override
	public String description() {
		return "Single";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		return cards.size() == 1;
	}
}
