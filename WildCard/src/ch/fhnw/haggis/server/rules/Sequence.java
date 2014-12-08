package ch.fhnw.haggis.server.rules;

import java.util.List;

import ch.fhnw.haggis.server.Card;

public class Sequence implements IRule {

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matchesRule(List<Card> cards) {
		int rank = 0;
		for (Card card : cards) {
			if(!CardHelper.isJoker(card))
			{
				
				// Bestimmung des aktuellen Ranks beim ersten Element in der Schlaufe
				if(rank == 0)
				{
					rank = card.getPoints();
				}				
				rank = card.getPoints();				
			}
		}
		return false;
	}
	
	

}
