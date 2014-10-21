package ch.fhnw.haggis.server;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WildCardServer extends JFrame {

//	private byte board[];
	private boolean xMove;
	private JTextArea output;
	private Player players[];
	private ServerSocket server;
	private int currentPlayer;

	public WildCardServer() {
		super("WildCard Server");

//		board = new byte[9];
		xMove = true;
		players = new Player[2];
		currentPlayer = 0;

		// ServerSocket
		try {
			server = new ServerSocket(5000, 2);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		output = new JTextArea();
		getContentPane().add(output, BorderLayout.CENTER);
		output.setText("Server awaiting connections\n");
		try {
			output.setText("Listening for connections on " + Inet4Address.getLocalHost().getHostAddress() + "\n");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setSize(300, 300);
		show();
	}

	// Wait for connections
	public void execute() {
		for (int i = 0; i < players.length; i++) {
			try {
				players[i] = new Player(server.accept(), this, i);
				players[i].start();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		// Two player
		synchronized (players[0]) {
			players[0].threadSuspended = false;
			players[0].notify();
		}

	}

	public void display(String s) {
		output.append(s + "\n");
	}

	// // valid / invalid
	public synchronized boolean validMove(int loc, int player) {
		boolean moveDone = false;

		while (player != currentPlayer) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return false;

//		if (!isOccupied(loc)) {
////			board[loc] = (byte) (currentPlayer == 0 ? 'X' : 'O');
//			currentPlayer = (currentPlayer + 1) % 2;
//			players[currentPlayer].otherPlayerMoved(loc);
//			notify();
//			return true;
//		} else
//			return false;
	}

//	public boolean isOccupied(int loc) {
//		if (board[loc] == 'X' || board[loc] == 'O')
//			return true;
//		else
//			return false;
//	}

	public boolean gameOver() {

		return false;
	}

	public static void main(String args[]) {
		WildCardServer game = new WildCardServer();

		game.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		game.execute();
	}
}