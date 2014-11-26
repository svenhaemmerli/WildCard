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



@SuppressWarnings("serial")
public class GuiLoginScreen extends JFrame implements ActionListener{
	
	//JLabel username = new JLabel();
	JTextField username;
	JLabel lblBackground;
	
	private JPanel panelSouth;
	private JPanel panelSouthNorth;
	private JPanel panelSouthCenter;
	private JPanel panelSouthEast;
	private JButton btnLogin;
	private JLabel copyright;
	private String checkname;

	public GuiLoginScreen (){
		setTitle("Haggis - WILDCARD");
		setSize(500, 500);
		setLocationRelativeTo(null); //place it in the center of the screen
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon background = new ImageIcon(getClass().getResource("img/0101_wildcard_logo.png"));
		lblBackground = new JLabel(background);
		getLayeredPane().add(lblBackground, new Integer(Integer.MIN_VALUE));
		lblBackground.setBounds(25, 30, background.getIconWidth(), background.getIconHeight());
		
		//panel south create
		panelSouth = new JPanel();
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setSize(new Dimension(300,500));
		getContentPane().add(panelSouth, BorderLayout.SOUTH); //put panel south into the south of the content pane
		
		panelSouthNorth = new JPanel(); //create panel southCenter
		panelSouth.add(panelSouthNorth, BorderLayout.NORTH); //add the panelSouthCenter to the center of panelSouth
		
		//create a JTextfield
		username = new JTextField("Username",10); //set title and size of the jtextfield possibly a test afterwards with Username max. 16 characters
		username.setOpaque(false);
		username.setForeground(Color.black);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		panelSouthNorth.add(username);
		
		
		panelSouthCenter = new JPanel();
		panelSouth.add(panelSouthCenter, BorderLayout.CENTER);
		
		btnLogin = new JButton("login");
		btnLogin.addActionListener(this);
		panelSouthCenter.add(btnLogin);
		
		//copyright information
		panelSouthEast = new JPanel();
		panelSouth.add(panelSouthEast, BorderLayout.EAST);
		copyright = new JLabel("\u00a9 WILDCARD - 19.12.2014"); //setLabel text
		copyright.setHorizontalAlignment(SwingConstants.RIGHT); //set Horizontal Alignment to right
		copyright.setFont(new Font("Arial", Font.PLAIN,10)); //set the labels new font, bold, int size
		panelSouth.add(copyright, BorderLayout.SOUTH);
		
		//make window visible
		setVisible(true);
	}
	
	
	// zum Testen
	public static void main(String[] args){
		GuiLoginScreen gui = new GuiLoginScreen();
		}
	//Method to get the content of username
	String getUserInput() {
		return username.getText();
		}
	
	//the input is set through the user
	void setUserInput(String string){
		username.setText(string);
		}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String user = username.getText();
		//testInput(user);
		//System.out.println(user);
		//User myUser = new User(user);
		//System.out.println(myUser.getName());
		dispose();
		wb_playtable deskview = new wb_playtable(user);
	}

	/*möglicher Test ob eingegebner Name max. 15 Zeichen ist */
	/*
	public void testInput(String name){
		
		this.checkname = name;
		if(checkname.length() > 15){
			System.out.println("Geben Sie einen Usernamen mit max. 15 Zeichen ein");
		}
		else{
			String user = username.getText();
			dispose();
			wb_playtable deskview = new wb_playtable(user);
		}
	}
	*/
}
