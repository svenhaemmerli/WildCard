package ch.fhnw.haggis.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ch.fhnw.haggis.server.SpieldatenRequest;
import ch.fhnw.haggis.server.SpieldatenResponse;


/**
 * Communication for the Client.
 */
public class ClientCommunication
{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ClientCommunication()
    {
        try
        {
            socket = new Socket("localhost", 6789);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Send the SpieldatenRequest to the server.
     */
    public void sendToServer(SpieldatenRequest request) throws IOException
    {
        output.writeObject(request);
        output.flush();
    }

    /**
     * Read the SpieldatenResponse from the server.
     */
    public SpieldatenResponse readFromServer() throws IOException, ClassNotFoundException
    {
        return (SpieldatenResponse) input.readObject();
    }

}
