package ch.fhnw.haggis.server;



public class Gameplay
{
   
    public boolean rules;
    public int countEmpty; 
    

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
