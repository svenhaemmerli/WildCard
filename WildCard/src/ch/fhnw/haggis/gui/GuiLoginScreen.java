package ch.fhnw.haggis.gui;
/*
 * Haggis - WILDCARD
 * GUI - Login Screen
 * @author Sven Hämmerli
 */


import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GuiLoginScreen extends JFrame implements ActionListener{
	
	JLabel username = new JLabel();
	JTextArea eingabe = new JTextArea();
	JLabel lblBackground;

	public GuiLoginScreen (){
		setTitle("Haggis - WILDCARD");
		setSize(500, 500);
		setLocationRelativeTo(null); //place it in the center of the screen
		setResizable(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon background = new ImageIcon(getClass().getResource("img/0101_wildcard_logo.png"));
		lblBackground = new JLabel(background);
		getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(25, 30, background.getIconWidth(), background.getIconHeight());
		
		
		username.setOpaque(false);
		username.setForeground(Color.black);
		username.setText("Username");
		username.setBackground(Color.white);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(username, BorderLayout.CENTER);
		
		/*
		eingabe.setOpaque(false);
		eingabe.setForeground(Color.BLACK);
		eingabe.setBackground(Color.white);
		
		this.add(eingabe);
		*/
		
		setVisible(true);
	}
	
	
	// zum Testen
	public static void main(String[] args){
		GuiLoginScreen gui = new GuiLoginScreen();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
