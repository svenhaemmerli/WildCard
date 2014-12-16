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


public class Gameplay {
	
	public boolean rules;
    public int countEmpty;

    private List<IRule> allRules = new ArrayList<IRule>();
    private IRule regelFuerSpiel = null;

    private ServerGui serverGui;
    
    // pot für ganzes spiel
    private ArrayList<Card> pot = new ArrayList<Card>();
    public ArrayList<Card> potActual = new ArrayList<Card>(); // podActual contains only recently played cards
    
    private int lowestRankLastTurn;
    private int lowestRank;
 

    // private List<Integer> connectedClients = new ArrayList<Integer>();

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
    //hier muesste die Hand ins win transferiert werden 
    public int resetAfterPass(Hand h){
    	
    	int score = 0;
    	
        regelFuerSpiel = null; //reset rules
        UserData.trickPunkte = 0;
        UserData.trick.clear();
        lowestRank = 0;
        lowestRankLastTurn = 1;
        
        for (int i =0; i<pot.size();i++)
        {
        	UserData.trick.add(pot.get(i));
        	score = score + pot.get(i).getValue();
        	System.out.println(pot.get(i).getValue());
        	
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
            // für
            // die neue Runde die neue Regel gefunden werden kann.
            if (regelFuerSpiel == null)
            {
                regelFuerSpiel = findeRegel(spieldaten.getMyHand().getHand());
                
                serverGui.writeLog("Regel für Spielrunde bestimmt: " + regelFuerSpiel.description());
                System.out.println("Regel für Spielrunde bestimmt: " + regelFuerSpiel.description());

                // falls für diese hand keine regelgefunden werden konnte
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
                // TODO zusätzliche Prüfungen, ob aktuelle hand höher ist als hand aus letzer spielrunde.
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
               
                // TODO distribute new cards
//                if (myHand.hand.isEmpty())
//                {
//                    // Player.this.setThreadSuspended(true);
//                    System.out.println("Hand leer");
//
//                }
//                else if (countEmpty == 2)
//                {
//                    myHand.distributeNewCards(myHand.hand);
//                }

            }
            else
            {
                return false;
            }
            
            
//            if (rules && countEmpty < 2)
//            {
//
//                spieldaten.getMyHand().processCardsPlayed(myHand);
//
//                if (myHand.hand.isEmpty())
//                {
//                    // Player.this.setThreadSuspended(true);
//                    System.out.println("Hand leer");
//
//                }
//                else if (rules && countEmpty == 2)
//                {
//
//                    myHand.distributeNewCards(myHand.hand);
//                }
//
//                return true;
//            }
        }
        else if(spieldaten.getStep().equals("pass"))
        {     				
//        	resetAfterPass(myHand);
        	UserData.trickPunkte = resetAfterPass(myHand);
        	return true;
        }
                
        // it was an invalid move
        return false;
    }

    // suche nach einer regel für die gelieferten karten (nur nötig bei der ersten hand einer spielrunde)
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
    
    

    // public static void main(String[] args)
    // {
    //
    // Deck d = new Deck(); // Deck und Hands werden instanziert
    // Hand h1 = new Hand();
    // Hand h2 = new Hand();
    // Hand h3 = new Hand();
    //
    // Gameplay g = new Gameplay(); // Gameplay wird instanziert
    //
    // String s = g.shuffleCards(d); //
    // System.out.println(s);
    //
    // JokerDeck a = new JokerDeck();
    //
    // // Karten in Hand f�llen, Methode aufrufen
    // h1 = g.distributeCard(d, h1);
    // h2 = g.distributeCard(d, h2);
    // h3 = g.distributeCard(d, h3);
    //
    // // Joker in Hand f�llen, Methode aufrufen
    // h1 = g.distributeJoker(a, h1);
    // h2 = g.distributeJoker(a, h2);
    // h3 = g.distributeJoker(a, h3);
    //
    // Iterator<Card> c = d.getDeck().iterator(); // Restkarten im Deck
    // while (c.hasNext())
    // {
    // System.out.println("Listenelement: " + c.next().getName());
    // }
    // }

}
