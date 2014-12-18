package ch.fhnw.haggis.server;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * @author Sven Hämmerli
 * The server GUI.
 */
public class ServerGui
    extends JFrame
{
    private static final long serialVersionUID = 1L; //identifier for a serializable class

    private JTextArea textArea;

    public ServerGui()
    {
        this.setLocationRelativeTo(null);// place at center of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Haggis-Server");

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(scrollPane, BorderLayout.CENTER);

        textArea.setText("Starting server...");

        this.setContentPane(content);
        this.pack();
    }

    public void writeLog(String msg)
    {
        textArea.setText(textArea.getText() + "\n" + msg);
    }
}
