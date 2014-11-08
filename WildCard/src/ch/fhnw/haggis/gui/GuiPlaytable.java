package ch.fhnw.haggis.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class GuiPlaytable extends JFrame implements  ActionListener,MouseListener {
	
	public JPanel playdesk = new JPanel();
	public JLabel lblBackground;
	public JPanel glassPane;
	private JPanel playercards;

	public GuiPlaytable(){
	setTitle("Haggis Playtable - Wildcard");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	playdesk.setLayout(new BorderLayout());
	getContentPane().add(playdesk, BorderLayout.CENTER);
	setSize(1280, 847);
	setLocationRelativeTo(null); //place it in the center of the screen
	setResizable(false);
	
	JPanel left = new JPanel();
	left.setOpaque(false);
	playdesk.add(left,BorderLayout.WEST);
	//set Background Image
	/*
	getContentPane().setLayout(new BorderLayout());
	((JPanel)getContentPane()).setOpaque(false);
	ImageIcon background = new ImageIcon(getClass().getResource("img/playtable.jpg"));
	lblBackground = new JLabel(background);
	getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
	lblBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
	*/
	
	
	//cards for the player
	playercards = new JPanel(new GridLayout(1,14)); //one line with 14 cards
	playercards.setOpaque(false);
	playercards.setPreferredSize(new Dimension(300,200));
	playercards.setBorder(new LineBorder(Color.cyan, 4));
	playdesk.add(playercards, BorderLayout.SOUTH);
	
	
	GridBagConstraints gbcPlayercards = new GridBagConstraints();//Use GridBagConstraints to place the components
	gbcPlayercards.insets = new Insets(0,0,0,0);//top, left, bottom, right

	
	JButton test1 = new JButton("");
	
	gbcPlayercards.gridx = 0;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test1,gbcPlayercards);
	
	JButton test2 = new JButton("");
	gbcPlayercards.gridx = 1;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test2,gbcPlayercards);
	
	JButton test3 = new JButton("");
	gbcPlayercards.gridx = 2;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test3,gbcPlayercards);
	
	JButton test4 = new JButton("");
	gbcPlayercards.gridx = 3;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test4,gbcPlayercards);
	
	JButton test5 = new JButton("");
	gbcPlayercards.gridx = 4;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test5,gbcPlayercards);
	
	JButton test6 = new JButton("");
	gbcPlayercards.gridx = 5;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test6,gbcPlayercards);
	
	JButton test7 = new JButton("");
	gbcPlayercards.gridx = 6;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test7,gbcPlayercards);
	
	JButton test8 = new JButton("");
	gbcPlayercards.gridx = 7;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test8,gbcPlayercards);
	
	JButton test9 = new JButton("");
	gbcPlayercards.gridx = 8;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test9,gbcPlayercards);
	
	JButton test10 = new JButton("");
	gbcPlayercards.gridx = 9;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test10,gbcPlayercards);
	
	JButton test11 = new JButton("");
	gbcPlayercards.gridx = 10;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test11,gbcPlayercards);
	
	JButton test12 = new JButton("");
	gbcPlayercards.gridx = 11;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test12,gbcPlayercards);
	
	JButton test13 = new JButton("");
	gbcPlayercards.gridx = 12;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test13,gbcPlayercards);
	
	JButton test14 = new JButton("");
	gbcPlayercards.gridx = 13;
	gbcPlayercards.gridy = 0;
	
	playercards.add(test14,gbcPlayercards);
	
	
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
