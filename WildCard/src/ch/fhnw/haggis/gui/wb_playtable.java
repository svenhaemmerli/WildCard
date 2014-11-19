package ch.fhnw.haggis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.GridLayout;

public class wb_playtable extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon = new ImageIcon(wb_playtable.class.getResource("/ch/fhnw/haggis/gui/hand_otherplayer_s.png"));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wb_playtable frame = new wb_playtable();
					//frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public wb_playtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height-65; //-65 otherwise the taskbar cannot be seen
		setSize(w,h);
		setLocationRelativeTo(null); //place it in the center of the screen
		setResizable(false);
		
		JPanel panelCardsWest = new JPanel();
		contentPane.add(panelCardsWest, BorderLayout.WEST);
		panelCardsWest.setLayout(new BorderLayout());
		
		JLabel lblCardsPlayer2 = new JLabel("Anzahl Karten");
		lblCardsPlayer2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCardsPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardsPlayer2.setFont(new Font("Arial", Font.PLAIN, 13));
		panelCardsWest.add(lblCardsPlayer2, BorderLayout.SOUTH);
		
		JLabel lblImgCards2 = new JLabel(icon);
		lblImgCards2.setPreferredSize(new Dimension(170, 100));
		panelCardsWest.add(lblImgCards2, BorderLayout.CENTER);
		
		JPanel panelCardsEast = new JPanel();
		contentPane.add(panelCardsEast, BorderLayout.EAST);
		panelCardsEast.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCardsPlayer3 = new JLabel("Anzahl Karten");
		lblCardsPlayer3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCardsPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardsPlayer3.setFont(new Font("Arial", Font.PLAIN, 13));
		panelCardsEast.add(lblCardsPlayer3, BorderLayout.SOUTH);
		
		JLabel lblImgCards3 = new JLabel(icon);
		lblImgCards3.setPreferredSize(new Dimension(170, 100));
		panelCardsEast.add(lblImgCards3, BorderLayout.CENTER);
		
		JPanel panelScoreboard = new JPanel();
		contentPane.add(panelScoreboard, BorderLayout.NORTH);
		panelScoreboard.setLayout(new GridLayout(2, 3));
		
		JLabel lblNameUser1 = new JLabel("User1");
		lblNameUser1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelScoreboard.add(lblNameUser1);
		
		JLabel lblNameUser2 = new JLabel("User2");
		lblNameUser2.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblNameUser2);
		
		JLabel lblNameUser3 = new JLabel("User3");
		lblNameUser3.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblNameUser3);
		
		JLabel lblScoreUser1 = new JLabel("Score User1");
		lblScoreUser1.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblScoreUser1);
		
		JLabel lblScoreUser2 = new JLabel("Score User2");
		lblScoreUser2.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblScoreUser2);
		
		JLabel lblScoreUser3 = new JLabel("Score User3");
		lblScoreUser3.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreboard.add(lblScoreUser3);
		
		JPanel panelPlayDesk = new JPanel();
		panelPlayDesk.setForeground(Color.PINK);
		contentPane.add(panelPlayDesk, BorderLayout.CENTER);
		panelPlayDesk.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImgPlaydesk = new JLabel((new ImageIcon(wb_playtable.class.getResource("/ch/fhnw/haggis/gui/playtable.png"))));
		lblImgPlaydesk.setPreferredSize(new Dimension(500, 500));
		panelPlayDesk.add(lblImgPlaydesk, BorderLayout.CENTER);
		
		JPanel panelCardsSouth = new JPanel();
		contentPane.add(panelCardsSouth, BorderLayout.SOUTH);
		panelCardsSouth.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCopyright = new JLabel("\u00a9 WILDCARD - 19.12.2014");
		panelCardsSouth.add(lblCopyright, BorderLayout.SOUTH);
		lblCopyright.setFont(new Font("Arial", Font.BOLD, 13));
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panelAction = new JPanel();
		panelCardsSouth.add(panelAction, BorderLayout.NORTH);
		
		JButton btnLegen = new JButton("legen");
		panelAction.add(btnLegen);
		
		JButton btnPassen = new JButton("passen");
		panelAction.add(btnPassen);
		
		JPanel panelPlayerCard = new JPanel();
		panelCardsSouth.add(panelPlayerCard, BorderLayout.CENTER);
		panelPlayerCard.setLayout(new GridLayout(1, 14));
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
	}

}
