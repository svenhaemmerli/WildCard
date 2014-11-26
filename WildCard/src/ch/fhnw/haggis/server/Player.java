package ch.fhnw.haggis.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//Player class 
class Player extends Thread {
	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private WildCardServer control;
	private int number;
	private char mark;
	protected boolean threadSuspended = true;

	public Player(Socket s, WildCardServer t, int num) {
		mark = (num == 0 ? 'X' : 'O');

		connection = s;

		try {
			input = new DataInputStream(connection.getInputStream());
			output = new DataOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		control = t;
		number = num;
		public void otherPlayerMoved(int loc) {
			try {
				output.writeUTF("Opponent moved");
				output.writeInt(loc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			boolean done = false;

			try {
				control.display("Player " + (number == 0 ? 'X' : 'O')
						+ " connected");
				output.writeChar(mark);
				output.writeUTF("Player "
						+ (number == 0 ? "X connected\n"
								: "O connected, please wait\n"));

				// wait for other player to join
				if (mark == 'X') {
					output.writeUTF("Waiting for another player");

					try {
						synchronized (this) {
							while (threadSuspended)
								wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					output.writeUTF("Other player connected. Your move.");
				}

				// Play game
				while (!done) {
					int location = input.readInt();

					if (control.validMove(location, number)) {
						control.display("loc: " + location);
						output.writeUTF("Valid move.");
					} else
						output.writeUTF("Invalid move, try again");

					if (control.gameOver())
						done = true;
				}

				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}	public void otherPlayerMoved(int loc) {
			try {
				output.writeUTF("Opponent moved");
				output.writeInt(loc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			boolean done = false;

			try {
				control.display("Player " + (number == 0 ? 'X' : 'O')
						+ " connected");
				output.writeChar(mark);
				output.writeUTF("Player "
						+ (number == 0 ? "X connected\n"
								: "O connected, please wait\n"));

				// wait for other player to join
				if (mark == 'X') {
					output.writeUTF("Waiting for another player");

					try {
						synchronized (this) {
							while (threadSuspended)
								wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					output.writeUTF("Other player connected. Your move.");
				}

				// Play game
				while (!done) {
					int location = input.readInt();

					if (control.validMove(location, number)) {
						control.display("loc: " + location);
						output.writeUTF("Valid move.");
					} else
						output.writeUTF("Invalid move, try again");

					if (control.gameOver())
						done = true;
				}

				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			}

	public void otherPlayerMoved(int loc) {
		try {
			output.writeUTF("Opponent moved");
			output.writeInt(loc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		boolean done = false;

		try {
			control.display("Player " + (number == 0 ? 'X' : 'O')
					+ " connected");
			output.writeChar(mark);
			output.writeUTF("Player "
					+ (number == 0 ? "X connected\n"
							: "O connected, please wait\n"));

			// wait for other player to join
			if (mark == 'X') {
				output.writeUTF("Waiting for another player");

				try {
					synchronized (this) {
						while (threadSuspended)
							wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				output.writeUTF("Other player connected. Your move.");
			}

			// Play game
			while (!done) {
				int location = input.readInt();

				if (control.validMove(location, number)) {
					control.display("loc: " + location);
					output.writeUTF("Valid move.");
				} else
					output.writeUTF("Invalid move, try again");

				if (control.gameOver())
					done = true;
			}

			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}