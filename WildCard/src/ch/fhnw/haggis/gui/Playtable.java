package ch.fhnw.haggis.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import ch.fhnw.haggis.client.ClientCommunication;
import ch.fhnw.haggis.server.Hand;
import ch.fhnw.haggis.server.SpieldatenRequest;
import ch.fhnw.haggis.server.SpieldatenResponse;

@SuppressWarnings("serial")
public class Playtable extends JFrame implements Runnable, ActionListener {

	private JPanel contentPane;
	private JPanel panelCardsWest;
	private JLabel lblCardsPlayer2;
	private JLabel lblImgCards2;
	private JPanel panelCardsEast;
	private JLabel lblCardsPlayer3;
	private JLabel lblImgCards3;
	private JPanel panelPlayDesk;
	private JLabel lblImgPlaydesk;
	private JPanel panelCardsSouth;
	private JLabel lblCopyright;
	private JPanel panelAction;
	private JButton btnLegen;
	private JButton btnPassen;
	private JPanel panelPlayerCard;
	private JPanel panelJokerCards;
	private JToggleButton btnJack;
	private JToggleButton btnQueen;
	private JToggleButton btnKing;
	private JPanel panelUserInfo2;
	private JLabel lblUser2;
	private JLabel lblScoreUser2Static;
	private JPanel panelUserInfo3;
	private JLabel lblUser3;
	private JLabel lblScoreUser3Static;
	private JLabel lblUser2Score;
	private JLabel lblUser2Name;
	private JLabel lblAmtCardsUser2;
	private JLabel lblUser3Name;
	private JLabel lblAmtCardsUser3;
	private JLabel lblUser3Score;
	private JLabel lblIsgeber2;
	private JLabel lblIsGeber3;
	private JPanel panelInfoUser1;
	private JPanel panelInfo;
	private JLabel lblUsername;
	private JLabel lblUserName1;
	private JLabel lblScore;
	private JLabel lblScoreUser1;
	private JLabel lblIsGeber1;
	private JLabel lblTitle;
	private JToggleButton[] cards;
	private JButton[] playedCards;
	private JToggleButton[] jokers;
	
	GridBagConstraints gbcPlayercards = new GridBagConstraints();
	GridBagConstraints gbcJokerCards = new GridBagConstraints();

	private ImageIcon icon = new ImageIcon(getClass().getResource(
			"img/hand_otherplayer_s.png"));

	private ClientCommunication clientCommunication;
	private Thread communicationThread;

	public Playtable(String userName, ClientCommunication clientCommunication,
			String message, Hand myHand) {
		
		// TODO message und myHand auf Playtable anzeigen

		
		
		this.clientCommunication = clientCommunication;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Haggis - WILDCARD");
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height - 65; // -65
																			// otherwise
																			// the
																			// taskbar
																			// cannot
																			// be
																			// seen
		setSize(w, h);
		setLocationRelativeTo(null); // place it in the center of the screen
		setResizable(false);

		// setup a new container for the other players cards
		panelCardsWest = new JPanel();
		contentPane.add(panelCardsWest, BorderLayout.WEST);
		panelCardsWest.setLayout(new BorderLayout());

		// put the image of the otherplayers cards onto the label
		/**
		 * @params Image icon is loaded previously and now put onto the JLabel
		 */
		lblImgCards2 = new JLabel(icon);
		panelCardsWest.add(lblImgCards2, BorderLayout.CENTER);
		lblImgCards2.setPreferredSize(new Dimension(250, 100));

		panelUserInfo2 = new JPanel();
		panelCardsWest.add(panelUserInfo2, BorderLayout.SOUTH);
		panelUserInfo2.setLayout(new GridLayout(4, 2, 0, 0));

		lblUser2 = new JLabel("Username:");
		lblUser2.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUserInfo2.add(lblUser2);

		lblUser2Name = new JLabel("Name User2");
		lblUser2Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser2Name.setFont(new Font("Arial", Font.PLAIN, 13));
		panelUserInfo2.add(lblUser2Name);

		// place the number of cards onto the panelWestCards
		lblCardsPlayer2 = new JLabel("Anzahl Karten:");
		panelUserInfo2.add(lblCardsPlayer2);
		// horizontal and vertical alignment
		lblCardsPlayer2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCardsPlayer2.setHorizontalAlignment(SwingConstants.RIGHT);
		// set the font to arial, size 13

		lblAmtCardsUser2 = new JLabel("Anz. Karten");
		lblAmtCardsUser2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmtCardsUser2.setFont(new Font("Arial", Font.PLAIN, 13));
		panelUserInfo2.add(lblAmtCardsUser2);

		lblScoreUser2Static = new JLabel("Score:");
		lblScoreUser2Static.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUserInfo2.add(lblScoreUser2Static);

		lblUser2Score = new JLabel("Score User2");
		lblUser2Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser2Score.setFont(new Font("Arial", Font.PLAIN, 13));
		panelUserInfo2.add(lblUser2Score);

		lblIsgeber2 = new JLabel("isGeber()");
		lblIsgeber2.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUserInfo2.add(lblIsgeber2);

		panelCardsEast = new JPanel();
		contentPane.add(panelCardsEast, BorderLayout.EAST);
		panelCardsEast.setLayout(new BorderLayout());

		lblImgCards3 = new JLabel(icon);
		lblImgCards3.setPreferredSize(new Dimension(250, 100));
		panelCardsEast.add(lblImgCards3, BorderLayout.CENTER);

		panelUserInfo3 = new JPanel();
		panelCardsEast.add(panelUserInfo3, BorderLayout.SOUTH);
		panelUserInfo3.setLayout(new GridLayout(4, 2, 0, 0));

		lblUser3 = new JLabel("Username:");
		lblUser3.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUserInfo3.add(lblUser3);

		lblUser3Name = new JLabel("Name User3");
		lblUser3Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser3Name.setFont(new Font("Arial", Font.PLAIN, 13));
		panelUserInfo3.add(lblUser3Name);

		lblCardsPlayer3 = new JLabel("Anzahl Karten:");
		panelUserInfo3.add(lblCardsPlayer3);
		lblCardsPlayer3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCardsPlayer3.setHorizontalAlignment(SwingConstants.RIGHT);

		lblAmtCardsUser3 = new JLabel("anz. Karten");
		lblAmtCardsUser3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmtCardsUser3.setFont(new Font("Arial", Font.PLAIN, 13));
		panelUserInfo3.add(lblAmtCardsUser3);

		lblScoreUser3Static = new JLabel("Score:");
		lblScoreUser3Static.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUserInfo3.add(lblScoreUser3Static);

		lblUser3Score = new JLabel("Score User3");
		lblUser3Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser3Score.setFont(new Font("Arial", Font.PLAIN, 13));
		panelUserInfo3.add(lblUser3Score);

		lblIsGeber3 = new JLabel("isGeber()");
		lblIsGeber3.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUserInfo3.add(lblIsGeber3);

		// Spieltisch in der Mitte, mit den gespielten Karten darauf
		panelPlayDesk = new JPanel();
		panelPlayDesk.setBackground(new Color(0, 100, 0));
		contentPane.add(panelPlayDesk, BorderLayout.CENTER);
		GridBagLayout gblPanelPlayDesk = new GridBagLayout();
		panelPlayDesk.setLayout(gblPanelPlayDesk);

		GridBagConstraints gbcPlayedCards = new GridBagConstraints();// Use
																		// GridBagConstraints
																		// to
																		// place
																		// the
																		// components
		gbcPlayedCards.insets = new Insets(0, 0, 0, 0);// top, left, bottom,
														// right representation
														// of
														// the borders of a
														// container. It
														// specifies
														// the space that a
														// container must leave
														// at
														// each of its edges

		playedCards = createPlayedCardButtons(playedCards, 8);
		for (int i = 0; i < playedCards.length; i++) {
			// playedCards[i].setPreferredSize(new Dimension(100,200));
			panelPlayDesk.add(playedCards[i], gbcPlayedCards);
		}

		panelCardsSouth = new JPanel();
		contentPane.add(panelCardsSouth, BorderLayout.SOUTH);
		panelCardsSouth.setLayout(new BorderLayout());

		lblCopyright = new JLabel("\u00a9 WILDCARD - 19.12.2014"); // \u00a9 is
																	// the code
																	// for
																	// copyright
		panelCardsSouth.add(lblCopyright, BorderLayout.SOUTH);
		lblCopyright.setFont(new Font("Arial", Font.BOLD, 13));
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);

		/**
		 * @btnLegen the button to place your selected cards
		 * @btnPassen if you cannot play, go to the next player
		 */

		// The panel for the user to display his cards
		panelPlayerCard = new JPanel();
		panelCardsSouth.add(panelPlayerCard, BorderLayout.CENTER);
		panelPlayerCard.setLayout(new GridLayout(1, 14));

		panelJokerCards = new JPanel();
		panelCardsSouth.add(panelJokerCards, BorderLayout.NORTH);
		GridBagLayout gblJockerCards = new GridBagLayout();
		panelJokerCards.setLayout(gblJockerCards);

		/**
		 * Platzhalter für JokerButtons
		 */
		gbcJokerCards.insets = new Insets(0, 0, 0, 0);
		
		/*
		btnJack = new JToggleButton("");
		btnJack.setIcon(null);
		btnJack.setPreferredSize(new Dimension(150, 220));
		panelJokerCards.add(btnJack);

		btnQueen = new JToggleButton("");
		btnQueen.setIcon(null);
		btnQueen.setPreferredSize(new Dimension(150, 220));
		panelJokerCards.add(btnQueen);

		btnKing = new JToggleButton("");
		btnKing.setIcon(null);
		btnKing.setPreferredSize(new Dimension(150, 220));
		panelJokerCards.add(btnKing);
		*/
		
		//Platzhalter für die Userinformationen - Container für InfoPanel und ActionPanel(Buttons)
		panelInfoUser1 = new JPanel();
		panelCardsSouth.add(panelInfoUser1, BorderLayout.EAST);
		panelInfoUser1.setLayout(new BorderLayout());

		panelAction = new JPanel();
		panelInfoUser1.add(panelAction, BorderLayout.SOUTH);

		/**
		 * @btnLegen Button Legen mit ActionListener versehen
		 */
		btnLegen = new JButton("play");
		btnLegen.addActionListener(this);
		panelAction.add(btnLegen);
		
		/**
		 * @btnPassen Button Passen mit Action Listener versehen
		 */
		btnPassen = new JButton("pass");
		btnPassen.addActionListener(this);
		panelAction.add(btnPassen);
		
		/**
		 * Userinformationen auf GUI anzeigen
		 */

		panelInfo = new JPanel();
		panelInfoUser1.add(panelInfo, BorderLayout.NORTH);
		panelInfo.setLayout(new GridLayout(4, 2, 0, 0));

		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInfo.add(lblUsername);

		lblUserName1 = new JLabel("");
		lblUserName1.setText(userName);
		lblUserName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName1.setFont(new Font("Arial", Font.PLAIN, 13));
		panelInfo.add(lblUserName1);

		lblScore = new JLabel("Score:");
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInfo.add(lblScore);

		lblScoreUser1 = new JLabel("your Score");
		lblScoreUser1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreUser1.setFont(new Font("Arial", Font.PLAIN, 13));
		panelInfo.add(lblScoreUser1);

		lblIsGeber1 = new JLabel("isGeber()");
		lblIsGeber1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInfo.add(lblIsGeber1);

		lblTitle = new JLabel("Haggis - Spieltisch");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setPreferredSize(new Dimension(200, 85));
		contentPane.add(lblTitle, BorderLayout.NORTH);

		//GridBagConstraints gbcPlayercards = new GridBagConstraints();// Use
																		// GridBagConstraints
																		// to
																		// place
																		// the
																		// components
		gbcPlayercards.insets = new Insets(0, 0, 0, 0);// top, left, bottom,
														// right representation
														// of
														// the borders of a
														// container. It
														// specifies
														// the space that a
														// container must leave
														// at
														// each of its edges

		
		
		/* Versuch ohne Serveranbindung
		cards = createToggleCardButtons(cards, 14);
		for (int i = 0; i < cards.length; i++) {
			// Cards[i].setPreferredSize(new Dimension(100,200));
			panelPlayerCard.add(cards[i], gbcPlayercards);
		}
		*/

		
		setVisible(true);

		communicationThread = new Thread(this);
		communicationThread.start();
	}

	// Method generates a JButton-Array it needs an array to fill and an int
	// with the number of
	// buttons
	private JToggleButton[] createToggleCardButtons(JToggleButton[] karten,
			int anzahl) {
		karten = new JToggleButton[anzahl];
		for (int i = 0; i < anzahl; i++) {
			karten[i] = new JToggleButton((""+anzahl));
			karten[i].setPreferredSize(new Dimension(100, 200));

		}
		return karten;
	}

	private JButton[] createPlayedCardButtons(JButton[] karten, int anzahl) {
		karten = new JButton[anzahl];
		for (int i = 0; i < anzahl; i++) {
			karten[i] = new JButton();
			karten[i].setPreferredSize(new Dimension(100, 200));

		}
		return karten;
	}

	// Methode zum legen der Karten
	public void actionPerformed (ActionEvent ae){

//		int norKart = cards.length;
//		int jokKart = jokers.length;
//		int alleKarten = norKart + jokKart;
//		for(int y = 0; y < alleKarten; y++ ){
//			
//		}
			
		
	        if(ae.getActionCommand().equals("play"))
	        {
	        	
	        	for(int z = 0; z < cards.length; z++){
	        		if(cards[z].isSelected()){
	        			System.out.println(cards[z].getText());
	        		}
	        		if(jokers[z].isSelected()){
	        			System.out.println(jokers[z].getText());
	        		}
	        	}
	        	
	        	
	        	SpieldatenRequest request = new SpieldatenRequest();
	        	request.setMessage("olla");
	        	try{
	        		clientCommunication.sendToServer(request);
	        	}
	        	catch (IOException e){
	        		e.printStackTrace();
	        	}
	        	System.out.println("legen");
	        	
	        }
	        
	        
	        if(ae.getActionCommand().equals("pass"))
	        {
	        	SpieldatenRequest request = new SpieldatenRequest();
	        	request.setMessage("pass");
	        	request.setMyHand(null);
	        	try {
					clientCommunication.sendToServer(request);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	System.out.println("passen");
	        	
	        }
		}


	/**
	 * Wartet auf Antworten vom Server (Endlosschlaufe). Mit diesen Antworten
	 * kann dann die Logik im GUI entsprechend behandelt werden.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				SpieldatenResponse response = new SpieldatenResponse();
				response = clientCommunication
						.readFromServer();

				System.out.println("Message from server " + response);
				
				
				/**
				 * Start to display all the cards
				 */
				
				//Get the message from the server, if the message is ready, display the hand you get on the buttons
				if(response.getMessage().equals("ready")){
					
					/**
					 * Message in Konsole Schreiben, Score beim aktiven user setzen
					 */
					System.out.println("Message from server " + response);
					//JOptionPane.showMessageDialog(null, "Ready. Your Turn");
					lblScoreUser1.setText(""+response.getScore());
		
					
					/**
					 * @params anzahlNormalCards, anzahlJokerCards
					 * zuerst zählen, wie viele Buttons jeweils erstellt werden müssen
					 */
					int anzahlNormalCards = 0;
					int anzahlJokerCards = 0;
					for(int i = 0; i < response.getMyHand().getHand().size(); i++){
						if(response.getMyHand().getHand().get(i).getPoints() < 11){
							anzahlNormalCards++;
						}
						
						else{
							anzahlJokerCards++;
						}
					}
					/**
					 * @params cards, jokers
					 * anhand der Anzahl Karten (normal, Joker) die Buttons erstellen
					 */
					cards = createToggleCardButtons(cards, anzahlNormalCards);
					jokers = createToggleCardButtons(jokers, anzahlJokerCards);
					
					/**
					 * @params countNormal, countJoker
					 * werden gebraucht, um das Bild das geladen wird, an die richtige stelle zu schreiben (falls der König auf Stelle 15 gefunden wird (i = 15) könnte der button
					 * sonst nicht zugewiesen werden
					 */
					int countNormal = 0;
					int countJoker = 0;
					
					for(int i = 0; i < response.getMyHand().getHand().size(); i++){
						if(response.getMyHand().getHand().get(i).getPoints() < 11){
							cards[countNormal].setIcon(response.getMyHand().getHand().get(i).getIcon());
							cards[countNormal].setText(response.getMyHand().getHand().get(i).getName());
							panelPlayerCard.add(cards[countNormal], gbcPlayercards);
							countNormal++;
						}
						else{
							jokers[countJoker].setIcon(response.getMyHand().getHand().get(i).getIcon());
							panelJokerCards.add(jokers[countJoker], gbcJokerCards);
							countJoker++;
						}
					}
					
					/**
					 * Alle karten in der Konsole ausgeben - zur Kontrolle ob alles richtig gemacht wurde
					 **/
					
					for(int m = 0; m <= response.getMyHand().getHand().size()-1; m++){
					System.out.println("Karte von Hand: " + response.getMyHand().getHand().get(m).getName());
					}
					
					
					/*
						int jokersAmount = 3;
						jokers = createToggleCardButtons(jokers, jokersAmount);
						for(int b = 0; b < jokersAmount; b++){
							jokers[b].setIcon(null);
							imageloop:
							
							for(int k = 0; k < response.getMyHand().getHand().size(); k++){
								if(response.getMyHand().getHand().get(k).getPoints() == 11){
								jokers[b].setIcon(response.getMyHand().getHand().get(k).getIcon());
								
								break imageloop;
								}
								else if(response.getMyHand().getHand().get(k).getPoints() == 12){
								jokers[b].setIcon(response.getMyHand().getHand().get(k).getIcon());
								break imageloop;
								}
								else if(response.getMyHand().getHand().get(k).getPoints() == 13){
								jokers[b].setIcon(response.getMyHand().getHand().get(k).getIcon());	
								break imageloop;
								}
							
								
							}
							panelJokerCards.add(jokers[b], gbcJokerCards);
						}
						
						*/
					
					/**
					 * Karten ohne Joker - auf GUI platzieren
					 */
						/*
					int i = response.getMyHand().getHand().size();
					cards = createToggleCardButtons(cards, i ); //i-3 damit es die Joker nicht dort ausgibt
					for (int j = 0; j < i; j++) {
						cards[j].setIcon(response.getMyHand().getHand().get(j).getIcon());
						panelPlayerCard.add(cards[j], gbcPlayercards);
					}
					*/
				}
				/**
				 * Handle an invalid move	
				 */
				
				//get the message from the server, if the message is invalid move, open a dialogbox	
				if(response.getMessage().equals("invalid move"))
				{
					JOptionPane.showMessageDialog(null, "Your Move was invalid, try again."); // Dialogbox
				}
					
					
				

				// response.getMyCards();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/*
	 * //Zum testen public static void main(String[] args) { wb_playtable frame
	 * = new wb_playtable();
	 */
}
// }
