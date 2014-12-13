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



public class Gameplay
{
   
    public boolean rules;
    public int countEmpty; 
    
    private List<IRule> allRules = new ArrayList<IRule>();
    private IRule regelFuerSpiel = null;
    

    private ServerGui serverGui;
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

    public boolean processRequest(SpieldatenRequest spieldaten, Hand myHand)
    {
    	//Abfrage if 2 hands empty
    	//for (int i=0;i<Player.;i++){
    	    		
    	//}
    	if(spieldaten.getMessage().equals("ready")){
    	
        serverGui.writeLog("ready");
        //Hier m�ssten die Usernamen der beiden anderen User gelesen werden
        
        return true;
    	}
       
    	else if (spieldaten.getMessage().equals("pass")){
        	
    	serverGui.writeLog("Spieler passt");
        
    	return true;
    	
        }
    	else if (spieldaten.getMessage().equals("play")){
    		
    		
    		//Ivos Regeln hier abrufen
    	    
    	    // bei der ersten Hand der Runde muss festgestellt werden welche Regel zum Zug kommt.
    	    // TODO regelFuerSpiel muss null gesetzt werden nachdem eine Runde gespielt wurde, damit für die neue Runde die neue Regel gefunden werden kann.
    	    if(regelFuerSpiel == null)
    	    {
    	        regelFuerSpiel = findeRegel(spieldaten.getMyHand().getHand());
    	        // falls für diese hand keine regelgefunden werden konnte
    	        if(regelFuerSpiel == null)
    	        {
    	            // TODO meldung, dass keine Regel gefunden wurde
    	        }
    	    }
    		
    		if(rules && countEmpty<2){
    		
    			spieldaten.getMyHand().processCardsPlayed(myHand);
    			
    			if(myHand.hand.isEmpty()){
    				//Player.this.setThreadSuspended(true);
    				System.out.println("Hand leer");
    				
    			}
    			else if (rules && countEmpty==2){
    				
    				myHand.distributeNewCards(myHand.hand);
    			}
    		
    			return true;
    		}
    		return false;
    	}

        return false;
    }
    
    // suche nach einer regel für die gelieferten karten
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
