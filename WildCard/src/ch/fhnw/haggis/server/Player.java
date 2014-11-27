package ch.fhnw.haggis.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Player
    extends Thread
{
    private Socket connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Server server;
    private boolean threadSuspended = true;

    private int userId;

    public Player(Socket socket, Server server, int userId)
    {
        this.userId = userId;

        connection = socket;

        try
        {
            input = new ObjectInputStream(connection.getInputStream());
            output = new ObjectOutputStream(connection.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        this.server = server;
    }

    /**
     * Method to notify this Player that an opponent moved.
     */
    public void playerMoved(int playerWithLastMove)
    {
        System.out.println("playerMoved " + playerWithLastMove + ", userId=" + userId);
        if (userId != playerWithLastMove)
        {
            try
            {
                output.writeObject("Player " + playerWithLastMove + " moved");
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
            
            server.display("Player " + userId + " connected");
            System.out.println("Player " + userId + " connected");

            // output.writeChar(mark);
            response.setMessage("Next Player connected please wait\n");
            output.writeObject(response);
            System.out.println("Player " + userId + " connected");

            // wait for other player to join
            // if (mark == 'X') {
            response.setMessage("Waiting for another player");
            output.writeObject(response);
            System.out.println("Waiting for another player");

            try
            {
                synchronized (this)
                {
                    System.out.println("Suspending thread " + threadSuspended  + ", userId=" + userId);
                    while (threadSuspended)
                        wait();
                }
                System.out.println("Thread released, userId=" + userId);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            response.setMessage("All players connected. Your move.");
            output.writeObject(response);
            System.out.println("All players connected, userId=" + userId);
            // }

            // Play game
            while (!server.gameOver())
            {
                SpieldatenRequest request = (SpieldatenRequest) input.readObject();

                // spieler wählt karten

                if (server.validMove(request, userId))
                {
                    server.display("loc: " + request);
                    output.writeObject("Valid move.");
                }
                else
                {
                    output.writeObject("Invalid move, try again");
                }

            }

            connection.close();
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