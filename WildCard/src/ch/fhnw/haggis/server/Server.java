package ch.fhnw.haggis.server;

import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{
    private Player[] players;
    private int currentPlayer;

    private ServerGui serverGui;
    private Gameplay gameplay;

    public static void main(String args[])
    {
        try
        {
            Server server = new Server();
            server.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Server()
    {
        // max 3 players
        players = new Player[3];
        // starting with player 0
        currentPlayer = 0;

        serverGui = new ServerGui();
        gameplay = new Gameplay(serverGui);
    }

    public void run() throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(6789);
        logToServer("Server running on IP: " + Inet4Address.getLocalHost().getHostAddress());
        logToServer("Waiting for connections...");

        // creating the 3 connections
        for (int i = 0; i < players.length; i++)
        {
            int userId = i;
            logToServer("Waiting to create connection for user " + userId);

            Socket connectionSocket = serverSocket.accept();
            players[i] = new Player(connectionSocket, this, userId);
            logToServer("Created connection for user " + userId);
            players[i].start();

            logToServer("Started thread for user " + userId);
        }
        // as soon as all players are connected we start with player zero
        synchronized (players[0])
        {
            // release the thread
            players[0].setThreadSuspended(false);
            // notify the thread of the player to continue
            players[0].notify();
            logToServer("Notify");
        }
    }

    // // valid / invalid
    public synchronized boolean validMove(SpieldatenRequest request, int userId)
    {
        logToServer("Valid move, user=" + userId);
        // boolean moveDone = false;

        // only proceed if request if from current user
        while (userId != currentPlayer)
        {
            try
            {
                logToServer("Waiting userId=" + userId);
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        logToServer("Process gameplay request, userId=" + userId);

        // logik des spiels
        boolean ok = gameplay.processRequest(request);

        if (ok)
        {
            // notify players that there was a move
            players[0].playerMoved(currentPlayer);
            players[1].playerMoved(currentPlayer);
            players[2].playerMoved(currentPlayer);

            // find the next player
            currentPlayer = (currentPlayer + 1) % 3;
            notify();
            return true;
        }
        else
            return false;
    }

    // public boolean isOccupied(int loc)
    // {
    // logToServer("isOccupied");
    // // if (board[loc] == 'X' || board[loc] == 'O')
    // // return true;
    // // else
    // return false;
    // }

    public boolean gameOver()
    {

        return false;
    }

    /**
     * Write a message to the GUI of the server.
     */
    public void logToServer(String message)
    {
        serverGui.writeLog(message);
    }

}