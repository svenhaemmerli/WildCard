package ch.fhnw.haggis.server.rules;

import ch.fhnw.haggis.server.Card;

public class CardHelper {

	/**
	 * Checks if given card is a Joker. A joker has a value between 11 and 13.
	 * 
	 * @param card
	 * @return true if card is a joker.
	 */
	public static boolean isJoker(Card card) {
		if (card.getPoints() >= 11 && card.getPoints() <= 13) {
			return true;
		}
		return false;
	}
}
