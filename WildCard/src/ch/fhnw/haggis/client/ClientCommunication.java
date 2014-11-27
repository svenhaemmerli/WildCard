package ch.fhnw.haggis.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


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
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ObjectInputStream getInput()
    {
        return input;
    }

    public void setInput(ObjectInputStream input)
    {
        this.input = input;
    }

    public ObjectOutputStream getOutput()
    {
        return output;
    }

    public void setOutput(ObjectOutputStream output)
    {
        this.output = output;
    }
}
