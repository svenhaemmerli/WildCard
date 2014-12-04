package ch.fhnw.haggis.server;

import java.io.IOException;
import java.net.Socket;


public class Player
    extends Thread
{
    private ServerCommunication serverCommunication;
    private Server server;
    private boolean threadSuspended = true;
    private Hand myHand;

    private int userId;

    public Player(Socket socket, Server server, int userId, Hand myHand)
    {
        this.userId = userId;
        this.server = server;
        this.myHand = myHand;
        serverCommunication = new ServerCommunication(socket);
    }

    /**
     * Method to notify this Player that an opponent moved.
     */
    public void playerMoved(int playerWithLastMove)
    {
        server.logToServer("playerMoved " + playerWithLastMove + ", userId=" + userId);
        if (userId != playerWithLastMove)
        {
            try
            {
            	//alles was an die inaktiven Spieler geschickt werden muss
                SpieldatenResponse response = new SpieldatenResponse();
                response.setMessage("Player " + playerWithLastMove + " moved");
                serverCommunication.sendToClient(response);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void run()
    {
        try
        {
        	
            SpieldatenResponse response = new SpieldatenResponse();
            
            server.logToServer("Player " + userId + " connected");

            response.setMessage("Next Player connected. Waiting for another player.");
            serverCommunication.sendToClient(response);
        	
            server.logToServer("Player " + userId + " connected");
        	
        
            // wait for other player to join
            // if (server. == 'X') {
            

            try
            {
                synchronized (this)
                {
                    server.logToServer("Suspending thread " + threadSuspended + ", userId=" + userId);
                    while (threadSuspended)
                        wait();
                }
                server.logToServer("Thread released, userId=" + userId);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        	
            
            	
            		//SpieldatenResponse response1 = new SpieldatenResponse();
                    response.setMessage("All players connected. Your move.");
                    server.logToServer(response.getMessage());
                    serverCommunication.sendToClient(response);
                    server.logToServer("All players connected, userId=" + userId);
            	
            	
            
            
        	
            // Play game
        	
            while  (!server.gameOver())
            {
            	//synchronized(this){
                SpieldatenRequest request = serverCommunication.readFromClient();
                
                
                // spieler wählt karten

                if (server.validMove(request, userId))
                {
                    server.logToServer("loc: " + request);
                    //response.setMessage("Valid move.");
                    response.setMessage(request.getMessage());
                    response.setMyHand(request.getMyHand());
                    serverCommunication.sendToClient(response);
                    server.logToServer("message wurde an client geschickt");
                }
                else
                {
                    response.setMessage("Invalid move, try again");
                    serverCommunication.sendToClient(response);
                    server.logToServer("invalid move");
                }
            	//}
            
            
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