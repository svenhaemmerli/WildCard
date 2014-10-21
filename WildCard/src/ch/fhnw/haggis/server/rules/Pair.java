package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

public class Pair implements IRule {

	@Override
	public String description() {
		return "Pair";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		Card c1 = cards.get(0);
		Card c2 = cards.get(1);

		return cards.size() == 2
				&& (c1.getValue() == c2.getValue() || CardHelper.isJoker(c1)
						&& !CardHelper.isJoker(c2) || !CardHelper.isJoker(c1)
						&& CardHelper.isJoker(c2));
	}
}
