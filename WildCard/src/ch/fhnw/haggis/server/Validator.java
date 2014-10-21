package ch.fhnw.haggis.server;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.haggis.server.rules.IRule;
import ch.fhnw.haggis.server.rules.Pair;
import ch.fhnw.haggis.server.rules.Single;

public class Validator {

	private List<IRule> rules;
	private IRule ruleForCurrentDraw;

	public Validator() {
		// all rules
		rules = new ArrayList<IRule>();
		rules.add(new Pair());
		rules.add(new Single());
	}

	public void defineFirstDraw(List<Card> cards) {

		for (IRule rule : rules) {
			if (rule.matchesRule(cards)) {
				ruleForCurrentDraw = rule;
			}
		}
	}
	
	public void validateDraw(List<Card> cardsPreviousDraw, List<Card> cardsCurrentDraw)
	{
		// 1. check if rule matches
		ruleForCurrentDraw.matchesRule(cardsCurrentDraw);
		// 2. check ob höher oder was auch immer...
	}
}
