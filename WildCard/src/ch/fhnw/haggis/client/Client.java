package ch.fhnw.haggis.client;

import java.io.IOException;

import ch.fhnw.haggis.gui.GuiLoginScreen;

/**
 *
 * @author Madeleine Sch�r
 *
 */

public class Client
{
    public static void main(String[] args) throws IOException
    {
        new GuiLoginScreen(new ClientCommunication());
    }
}
