package ch.fhnw.haggis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class wb_playtable extends JFrame {

	private JPanel contentPane;
	private JPanel panelCardsWest;
	private JLabel lblCardsPlayer2;
	private JLabel lblImgCards2;
	private JPanel panelCardsEast;
	private JLabel lblCardsPlayer3;
	private JLabel lblImgCards3;
	private JPanel panelScoreboard;
	private JLabel lblNameUser1;
	private JLabel lblNameUser2;
	private JLabel lblNameUser3;
	private JLabel lblScoreUser1;
	private JLabel lblScoreUser2;
	private JLabel lblScoreUser3;
	private JPanel panelPlayDesk;
	private JLabel lblImgPlaydesk;
	private JPanel panelCardsSouth;
	private JLabel lblCopyright;
	private JPanel panelAction;
	private JButton btnLegen;
	private JButton btnPassen;
	private JPanel panelPlayerCard;
	
	private ImageIcon playdesk = new ImageIcon(getClass().getResource("img/playtable.png"));
	private ImageIcon icon = new ImageIcon(getClass().getResource("img/hand_otherplayer_s.png"));
	private JPanel panelJokerCards;
	private JButton btnJack;
	private JButton btnQueen;
	private JButton btnKing;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	wb_playtable frame = new wb_playtable();
					
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public wb_playtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Haggis - WILDCARD");
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height-65; //-65 otherwise the taskbar cannot be seen
		setSize(w,h);
		setLocationRelativeTo(null); //place it in the center of the screen
		setResizable(false);
		
		//setup a new container for the other players cards
		panelCardsWest = new JPanel();
		contentPane.add(panelCardsWest, BorderLayout.WEST);
		panelCardsWest.setLayout(new BorderLayout());
		
		//place the number of cards onto the panelWestCards
		lblCardsPlayer2 = new JLabel("Anzahl Karten");
		//horizontal and vertical alignment
		lblCardsPlayer2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCardsPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		//set the font to arial, size 13
		lblCardsPlayer2.setFont(new Font("Arial", Font.PLAIN, 13));
		panelCardsWest.add(lblCardsPlayer2, BorderLayout.SOUTH);
		
		//put the image of the otherplayers cards onto the label
		/**
		 * @params Image icon is loaded previously and now put onto the JLabel
		 */
		lblImgCards2 = new JLabel(icon);
		lblImgCards2.setPreferredSize(new Dimension(170, 100)); //set the size of the Label
		panelCardsWest.add(lblImgCards2, BorderLayout.CENTER);
		
		panelCardsEast = new JPanel();
		contentPane.add(panelCardsEast, BorderLayout.EAST);
		panelCardsEast.setLayout(new BorderLayout());
		
		lblCardsPlayer3 = new JLabel("Anzahl Karten");
		lblCardsPlayer3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCardsPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardsPlayer3.setFont(new Font("Arial", Font.PLAIN, 13));
		panelCardsEast.add(lblCardsPlayer3, BorderLayout.SOUTH);
		
		lblImgCards3 = new JLabel(icon);
		lblImgCards3.setPreferredSize(new Dimension(170, 100));
		panelCardsEast.add(lblImgCards3, BorderLayout.CENTER);
		
		panelScoreboard = new JPanel();
		contentPane.add(panelScoreboard, BorderLayout.NORTH);
		panelScoreboard.setLayout(new GridLayout(2, 3));
		
		//Add the name of the player and his score onto the scoreboard
		lblNameUser1 = new JLabel("User1");
		lblNameUser1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelScoreboard.add(lblNameUser1);
		
		lblNameUser2 = new JLabel("User2");
		lblNameUser2.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblNameUser2);
		
		lblNameUser3 = new JLabel("User3");
		lblNameUser3.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblNameUser3);
		
		lblScoreUser1 = new JLabel("Score User1");
		lblScoreUser1.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblScoreUser1);
		
		lblScoreUser2 = new JLabel("Score User2");
		lblScoreUser2.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblScoreUser2);
		
		lblScoreUser3 = new JLabel("Score User3");
		lblScoreUser3.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblScoreUser3);
		
		panelPlayDesk = new JPanel();
		panelPlayDesk.setBackground(Color.GREEN);
		contentPane.add(panelPlayDesk, BorderLayout.CENTER);
		panelPlayDesk.setLayout(new BorderLayout());
		
		lblImgPlaydesk = new JLabel(playdesk);
		lblImgPlaydesk.setPreferredSize(new Dimension(500, 500));
		panelPlayDesk.add(lblImgPlaydesk, BorderLayout.CENTER);
		
		panelCardsSouth = new JPanel();
		contentPane.add(panelCardsSouth, BorderLayout.SOUTH);
		panelCardsSouth.setLayout(new BorderLayout());
		
		lblCopyright = new JLabel("\u00a9 WILDCARD - 19.12.2014"); // \u00a9 is the code for copyright
		panelCardsSouth.add(lblCopyright, BorderLayout.SOUTH);
		lblCopyright.setFont(new Font("Arial", Font.BOLD, 13));
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panelAction = new JPanel(); //the panel to place the buttons
		panelCardsSouth.add(panelAction, BorderLayout.EAST);
		
		/**
		 * @btnLegen the button to place your selected cards
		 * @btnPassen if you cannot play, go to the next player
		 */
		
		btnLegen = new JButton("legen");
		panelAction.add(btnLegen);
		
		btnPassen = new JButton("passen");
		panelAction.add(btnPassen);
		
		//The panel for the user to display his cards
		panelPlayerCard = new JPanel();
		panelCardsSouth.add(panelPlayerCard, BorderLayout.CENTER);
		panelPlayerCard.setLayout(new GridLayout(1, 14));
		
		panelJokerCards = new JPanel();
		panelCardsSouth.add(panelJokerCards, BorderLayout.NORTH);
		
		btnJack = new JButton("Jack");
		btnJack.setPreferredSize(new Dimension(100,220));
		panelJokerCards.add(btnJack);
		
		btnQueen = new JButton("Queen");
		btnQueen.setPreferredSize(new Dimension(100,220));
		panelJokerCards.add(btnQueen);
		
		btnKing = new JButton("King");
		btnKing.setPreferredSize(new Dimension(100,220));
		panelJokerCards.add(btnKing);
		
		
		GridBagConstraints gbcPlayercards = new GridBagConstraints();//Use GridBagConstraints to place the components
		gbcPlayercards.insets = new Insets(0,0,0,0);//top, left, bottom, right representation of the borders of a container. It specifies the space that a container must leave at each of its edges
		
		//es gibt die Knöpfe aus, aber unter welchem Namen? kann es 14mal den button btn geben?
		for(int i = 1;i<=14;i++){
			JButton btn = new JButton("");
			btn.setPreferredSize(new Dimension(100,220));
			gbcPlayercards.gridx = i-1;
			gbcPlayercards.gridy = 0;
			panelPlayerCard.add(btn,gbcPlayercards);
		}
		
		contentPane.setVisible(true);
	}

}
