package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

public class Quintuplet implements IRule {

	@Override
	public String description() {
		return "Quintuplet";
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		Card c1 = cards.get(0);
		Card c2 = cards.get(1);
		Card c3 = cards.get(2);
		Card c4 = cards.get(3);
		Card c5 = cards.get(4);

		return cards.size() == 5
				
				&& (c1.getValue() == c2.getValue() && c2.getValue() == c3.getValue()
				&& c3.getValue() == c4.getValue() && c4.getValue() == c5.getValue()

				// zwei Karten nicht Joker
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				//drei Karten nicht Joker
				|| CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5)
				//vier Karten nicht Joker
				|| CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && CardHelper.isJoker(c4) && !CardHelper.isJoker(c5)
				|| !CardHelper.isJoker(c1) && !CardHelper.isJoker(c2) && !CardHelper.isJoker(c3) && !CardHelper.isJoker(c4) && CardHelper.isJoker(c5));
	}
}