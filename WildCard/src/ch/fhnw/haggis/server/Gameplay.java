package ch.fhnw.haggis.server;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.haggis.server.rules.Eightset;
import ch.fhnw.haggis.server.rules.IRule;
import ch.fhnw.haggis.server.rules.MultipleEightset;
import ch.fhnw.haggis.server.rules.MultiplePair;
import ch.fhnw.haggis.server.rules.MultipleQuadruplet;
import ch.fhnw.haggis.server.rules.MultipleQuintuplet;
import ch.fhnw.haggis.server.rules.MultipleSequences;
import ch.fhnw.haggis.server.rules.MultipleSevenset;
import ch.fhnw.haggis.server.rules.MultipleSixset;
import ch.fhnw.haggis.server.rules.MultipleTriplet;
import ch.fhnw.haggis.server.rules.Pair;
import ch.fhnw.haggis.server.rules.Quadruplet;
import ch.fhnw.haggis.server.rules.Quintuplet;
import ch.fhnw.haggis.server.rules.Sevenset;
import ch.fhnw.haggis.server.rules.Single;
import ch.fhnw.haggis.server.rules.SingleSequence;
import ch.fhnw.haggis.server.rules.Sixset;
import ch.fhnw.haggis.server.rules.Triplet;

/**
 * 
 * @author Ivo Hausammann
 *
 */
public class Gameplay {
	
	public boolean rules;
    public int countEmpty;

    private List<IRule> allRules = new ArrayList<IRule>();
    private IRule regelFuerSpiel = null;

    private ServerGui serverGui;
    
    // pot für ganzes spiel
    private ArrayList<Card> pot = new ArrayList<Card>();
    public ArrayList<Card> potActual = new ArrayList<Card>(); // potActual enthält nur kürzlich gespielte Karten
    
    private int lowestRankLastTurn;
    private int lowestRank;
 

    public Gameplay(ServerGui serverGui)
    {
        this.serverGui = serverGui;

        initializeGame();
    }

    public void initializeGame()
    {
        serverGui.writeLog("Initializing game...");
       
        // alle Regeln für das Spiel
        allRules.add(new Single());
        allRules.add(new Pair());
        allRules.add(new Triplet());
        allRules.add(new Quadruplet());
        allRules.add(new Quintuplet());
        allRules.add(new Sixset());
        allRules.add(new Sevenset());
        allRules.add(new Eightset());
        allRules.add(new SingleSequence());
        allRules.add(new MultiplePair());
        allRules.add(new MultipleTriplet());
        allRules.add(new MultipleQuadruplet());
        allRules.add(new MultipleQuintuplet());
        allRules.add(new MultipleSixset());
        allRules.add(new MultipleSevenset());
        allRules.add(new MultipleEightset());
        allRules.add(new MultipleSequences());
    }
    
    // nach einer Spielrunde muss zurückgesetzt werden.
    public int resetAfterPass(Hand h){
    	
    	int score = 0;
    	
        regelFuerSpiel = null; //regeln zuruecksetzen
        lowestRank = 0;
        lowestRankLastTurn = 1;
        
        for (int i =0; i<pot.size();i++)
        {
        	score = score + pot.get(i).getValue();
        	System.out.println(pot.get(i).getValue());
        	System.out.println("Score = " +score);
        }
        
        pot.clear(); // delete pot
        return score;
    }

    public boolean processRequest(SpieldatenRequest spieldaten) {
    	
        Hand myHand = spieldaten.getMyHand();

        // client is playing
        if (spieldaten.getStep().equals("play")) {
        	
            // bei der ersten Hand der Runde muss festgestellt werden welche Regel zum Zug kommt.
            // TODO regelFuerSpiel muss null gesetzt werden nachdem eine Runde gespielt wurde, damit
            // fuer die neue Runde die neue Regel gefunden werden kann.
            if (regelFuerSpiel == null)
            {
                regelFuerSpiel = findeRegel(spieldaten.getMyHand().getHand());
                
                serverGui.writeLog("Regel fuer Spielrunde bestimmt: " + regelFuerSpiel.description());
                System.out.println("Regel fuer Spielrunde bestimmt: " + regelFuerSpiel.description());

                // falls fuer diese hand keine regelgefunden werden konnte
                if (regelFuerSpiel == null)
                {
                    // TODO meldung, dass keine Regel gefunden wurde
                    System.out.println("Keine Regel gefunden!");
                    serverGui.writeLog("Keine Regel gefunden!");
                    return false;
                }
            }
            
            if(regelFuerSpiel.matchesRule(myHand.getHand()))
            {
                // TODO zusaetzliche Pruefungen, ob aktuelle gespielt hand hoeher ist als hand aus letzer spielrunde.
                regelFuerSpiel.getLowestRank();
                potActual.clear();
                
                if(lowestRankLastTurn < regelFuerSpiel.getLowestRank())
                {
                	// gespielte karten in pot setzen
                    pot.addAll(myHand.getHand());
                    potActual.addAll(myHand.getHand());
                    lowestRankLastTurn = regelFuerSpiel.getLowestRank();
                	return true;               	
                }
                
                else
                {
                	return false;
                }
               
            }
            else
            {
                return false;
            }
            
        }
        else if(spieldaten.getStep().equals("pass"))
        {     				
        	UserData.trickPunkte = resetAfterPass(myHand);
        	return true;
        }
                
        // it was an invalid move
        return false;
    }

    // suche nach einer regel fuer die gelieferten karten (nur noetig bei der ersten hand einer spielrunde)
    public IRule findeRegel(List<Card> cards)
    {
        for (IRule rule : allRules)
        {
            if (rule.matchesRule(cards))
            {
                return rule;
            }
        }
        return null;
    }    
    
    public ArrayList<Card> getPot()
    {
        return pot;
    }
}
