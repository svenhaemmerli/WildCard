package ch.fhnw.haggis.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class Player
    extends Thread
{

    private ServerCommunication serverCommunication;
    private Server server;
    private boolean threadSuspended = true;
    private Hand myHand;
    private int score;
    private int userId;

    // Constructor Player
    public Player(Socket socket, Server server, int userId, Hand myHand, int score)
    {
        this.userId = userId;
        this.server = server;
        this.myHand = myHand;
        serverCommunication = new ServerCommunication(socket);
        this.score = score;
    }

    // -----------------------------getter & setter
    // ----------------------------------------------------------------------------//
    public Hand getMyHand()
    {
        return myHand;
    }

    public void setMyHand(Hand myHand)
    {
        this.myHand = myHand;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    // -------------------------------------------getter & setter end--------------------------------------------------------//
    /**
     * Method to notify this Player that an opponent moved.
     */
    public void playerMoved(int playerWithLastMove, ArrayList<Card> potActual)
    {
        try
        {
        	
            server.logToServer("playerMoved " + playerWithLastMove + ", userId=" + userId);
            if (userId != playerWithLastMove)
            {
            	myHand.setPotActual(potActual); //set the current pot to the hand
                // alles was an die inaktiven Spieler geschickt werden muss
                SpieldatenResponse response = new SpieldatenResponse();
                response.setStep("yourMove");
                response.setMessage("Player " + playerWithLastMove + " moved. Your turn.");
                response.setMyHand(myHand);
                serverCommunication.sendToClient(response);
                myHand.getPotActual().clear();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            SpieldatenResponse response = new SpieldatenResponse();

            server.logToServer("Player " + userId + " connected");

            // wenn alle user connected sind, kann der letzte der sich angemeldet hat beginnen
            if (server.checkAllUsersConnected())
            {
                response.setStep("yourMove");
                response.setMessage("All players connected. Your move.");
                response.setMyHand(myHand); // initiale hand für diesen player
                serverCommunication.sendToClient(response);

                server.logToServer("All players connected. Player to move " + userId);
            }
            // es haben sich noch nicht alle angemeldet
            else
            {
                response.setStep("waitingForOtherPlayers");
                response.setMessage("Waiting for another player.");
                response.setMyHand(myHand); // initial hand für diesen player
                serverCommunication.sendToClient(response);
            }

            // Play game
            while (!server.gameOver())
            {
                // synchronized(this){
                SpieldatenRequest request = serverCommunication.readFromClient();

                // falls eine Anfrage von einem client kam, aber der Spieler gar nicht an der Reihe
                // ist, brechen wir ab.
                if (!server.checkIfUsersTurn(userId))
                {
                    response.setStep("notYourTurn");
                    response.setMessage("Not your turn!");
                    serverCommunication.sendToClient(response);
                    server.logToServer("Not your turn user " + userId);
                    continue;// skip rest of loop
                }

                // spieler wählt karten
                boolean ok = server.handleMove(request, userId);

                // falls gepasst wurde, senden wir nicht noch eine zusätzliche message
                if (!request.getStep().equals("pass"))
                {
                    if (ok)
                    {
                        
                        myHand.pot = server.gameplay.getPot();
                        myHand.removePlayedCardsFromHand(server.gameplay.getPot());// entferne alle gespielten aus der hand
                        
                        myHand.setPotActual(request.getMyHand().getHand());
                        // sends response
                        response.setStep("validMove");
                        response.setMessage("valid move");
                        response.setMyHand(myHand);
                        response.setScore(score);
                        //response.setPot(myHand.getPot());

                        serverCommunication.sendToClient(response);
                        server.logToServer("message wurde an client geschickt");
                        server.logToServer(myHand.getPotActual().get(0).getName());
                        server.logToServer("pot actual in player");
                        myHand.getPotActual().clear();
                    }
                    // falls nicht ok und nicht pass
                    else
                    {
                        response.setStep("invalidMove");
                        response.setMessage("invalid move");
                        serverCommunication.sendToClient(response);
                        server.logToServer("invalid move");
                    }
                }

            }
            serverCommunication.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void setThreadSuspended(boolean threadSuspended)
    {
        this.threadSuspended = threadSuspended;
    }

    @Override
    public String toString()
    {
        return "Player [threadSuspended=" + threadSuspended + ", userId=" + userId + "]";
    }

}