package ch.fhnw.haggis.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Communication for the Server.
 */
public class ServerCommunication
{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ServerCommunication(Socket socket)
    {
        try
        {
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            this.socket = socket;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Send the SpieldatenResponse to the client.
     */
    public void sendToClient(SpieldatenResponse response) throws IOException
    {
        output.writeObject(response);
        output.flush();
        output.reset();
    }

    /**
     * Read the SpieldatenRequest from the client.
     */
    public SpieldatenRequest readFromClient() throws IOException, ClassNotFoundException
    {
        return (SpieldatenRequest) input.readObject();
    }

    /**
     * Close the socket.
     */
    public void close()
    {
        try
        {
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
