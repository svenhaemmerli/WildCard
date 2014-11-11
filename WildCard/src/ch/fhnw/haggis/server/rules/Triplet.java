package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

public class Triplet implements IRule {

	@Override
	public String description() {
		return "Triplet";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		Card c1 = cards.get(0);
		Card c2 = cards.get(1);
		Card c3 = cards.get(2);

		return cards.size() == 3
				
				&& (c1.getValue() == c2.getValue() && c2.getValue() == c3.getValue()
				// eine Karte nicht Joker
				|| CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && CardHelper.isJoker(c3)
				// zwei Karten nicht Joker
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3));
			
	}
}