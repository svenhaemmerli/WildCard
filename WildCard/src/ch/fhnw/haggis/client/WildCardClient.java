package ch.fhnw.haggis.client;

//Client
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Client class
public class WildCardClient extends JApplet implements Runnable {
	private static final long serialVersionUID = 3292250972481524657L;

	private JTextField id;
	private JTextArea display;
	// private JPanel boardPanel, panel2;
	// private Square board[][], currentSquare;
	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private Thread outputThread;
	private char myMark;
	private boolean myTurn;

	// Set up user-interface and board
	public void init() {
		display = new JTextArea(3, 30);
		display.setEditable(false);
		getContentPane().add(new JScrollPane(display), BorderLayout.SOUTH);

		// boardPanel = new JPanel();
		// GridLayout layout = new GridLayout(3, 3, 0, 0);
		// boardPanel.setLayout(layout);

		// board = new Square[3][3];

		// Creating a Square
		// for (int row = 0; row < board.length; row++) {
		// for (int col = 0; col < board[row].length; col++) {
		// board[row][col] = new Square(' ', row * 3 + col);
		// board[row][col].addMouseListener(new SquareListener(this,
		// board[row][col]));
		//
		// boardPanel.add(board[row][col]);
		// }
		// }

		 id = new JTextField();
		 id.setEditable(false);
		//
		// getContentPane().add(id, BorderLayout.NORTH);
		//
		// panel2 = new JPanel();
		// panel2.add(boardPanel, BorderLayout.CENTER);
		// getContentPane().add(panel2, BorderLayout.CENTER);
	}

	// Make connection to server
	public void start() {

		// read the servers IP
		String serverIp = JOptionPane.showInputDialog(null,
				"Your server's IP:", "Server IP",
				JOptionPane.PLAIN_MESSAGE);

		try {
			connection = new Socket(InetAddress.getByName(serverIp), 5000);
			input = new DataInputStream(connection.getInputStream());
			output = new DataOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		outputThread = new Thread(this);
		outputThread.start();
	}

	// Control thread t
	public void run() {
		// X or O
		try {
			myMark = input.readChar();
			id.setText("You are player \"" + myMark + "\"");
			myTurn = (myMark == 'X' ? true : false);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				String s = input.readUTF();
				// processMessage(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// public void processMessage(String s) {
	// if (s.equals("ok")) {
	// display.append("Valid move, please wait.\n");
	// currentSquare.setMark(myMark);
	// currentSquare.repaint();
	// } else if (s.equals("invalid move")) {
	// display.append(s + "\n");
	// myTurn = true;
	// } else if (s.equals("Opponent moved")) {
	// try {
	// int loc = input.readInt();
	//
	// board[loc / 3][loc % 3].setMark((myMark == 'X' ? 'O' : 'X'));
	// board[loc / 3][loc % 3].repaint();
	//
	// display.append("Opponent moved. It's your turn.\n");
	// myTurn = true;
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// } else
	// display.append(s + "\n");
	//
	// display.setCaretPosition(display.getText().length());
	// }
	//
	// public void sendClickedSquare(int loc) {
	// if (myTurn)
	// try {
	// output.writeInt(loc);
	// myTurn = false;
	// } catch (IOException ie) {
	// ie.printStackTrace();
	// }
	// }
	//
	// public void setCurrentSquare(Square s) {
	// currentSquare = s;
	// }
}