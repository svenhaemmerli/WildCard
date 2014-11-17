package ch.fhnw.haggis.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class GuiPlaytable extends JFrame implements  ActionListener,MouseListener {
	
	public JPanel playdesk;
	public JPanel glassPane;
	private JPanel playercards;
	private JPanel playercardsJoker;
	private JLabel username1;
	private JLabel username2;
	private JLabel username3;
	private JPanel table;
	private JLabel playerOne;
	private JLabel playerTwo;
	private JLabel playerThree;
	private JPanel scoreboard;
	
	private JLabel copyright;
	

	public GuiPlaytable(){
	//JFrame frame = new JFrame(); create a frame object
	setTitle("Haggis Playtable - Wildcard");
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	getContentPane().setLayout(new BorderLayout());
	//set the playable desk into the center of the content pane
	int w = Toolkit.getDefaultToolkit().getScreenSize().width;
	int h = Toolkit.getDefaultToolkit().getScreenSize().height-50; //-50 otherwise the taskbar cannot be seen
	setSize(w,h);
	setLocationRelativeTo(null); //place it in the center of the screen
	setResizable(false);
	playdesk = new JPanel();
	playdesk.setLayout(new BorderLayout());
	getContentPane().add(playdesk, BorderLayout.CENTER);
	
	
	table = new JPanel();
	table.setBackground(Color.ORANGE);
	table.setLayout(new BorderLayout());
	playdesk.add(table, BorderLayout.CENTER);

	
	//copyright information
	copyright = new JLabel("\u00a9 WILDCARD - 19.12.2014"); //setLabel text
	copyright.setHorizontalAlignment(SwingConstants.RIGHT); //set Horizontal Alignment to right
	copyright.setFont(new Font("Arial", Font.BOLD,18)); //set the labels new font, bold, int size
	getContentPane().add(copyright, BorderLayout.SOUTH);
	
	//cards for the player
	playercards = new JPanel(new GridLayout(1,14)); //one line with 14 cards
	playercards.setOpaque(false);
	playercards.setPreferredSize(new Dimension(900,200));
	//playercards.setBorder(new LineBorder(Color.cyan, 2));
	playdesk.add(playercards, BorderLayout.SOUTH);
	
	
	GridBagConstraints gbcPlayercards = new GridBagConstraints();//Use GridBagConstraints to place the components
	gbcPlayercards.insets = new Insets(0,0,0,0);//top, left, bottom, right representation of the borders of a container. It specifies the space that a container must leave at each of its edges
	
	
	//es gibt die Knöpfe aus, aber unter welchem Namen? kann es 14mal den button btn geben?
	for(int i = 1;i<=14;i++){
		JButton btn = new JButton("");
		gbcPlayercards.gridx = i-1;
		gbcPlayercards.gridy = 0;
		playercards.add(btn,gbcPlayercards);
	}

	
	
		
		
	setVisible(true);
	
	
	}
	
	public static void main(String[] args) {
		GuiPlaytable gui = new GuiPlaytable();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
