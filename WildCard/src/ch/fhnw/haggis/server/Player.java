package ch.fhnw.haggis.server;

import java.io.IOException;
import java.net.Socket;


public class Player
    extends Thread
{
    private ServerCommunication serverCommunication;
    private Server server;
    private boolean threadSuspended = true;

    private int userId;

    public Player(Socket socket, Server server, int userId)
    {
        this.userId = userId;
        this.server = server;
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

            response.setMessage("All players connected. Your move.");
            serverCommunication.sendToClient(response);
            server.logToServer("All players connected, userId=" + userId);
            // }

            // Play game
            while (!server.gameOver())
            {
                SpieldatenRequest request = serverCommunication.readFromClient();

                // spieler wählt karten

                if (server.validMove(request, userId))
                {
                    server.logToServer("loc: " + request);
                    response.setMessage("Valid move.");
                    serverCommunication.sendToClient(response);
                }
                else
                {
                    response.setMessage("Invalid move, try again");
                    serverCommunication.sendToClient(response);
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