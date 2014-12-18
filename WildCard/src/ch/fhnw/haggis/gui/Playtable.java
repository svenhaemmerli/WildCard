package ch.fhnw.haggis.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import ch.fhnw.haggis.client.ClientCommunication;
import ch.fhnw.haggis.server.Card;
import ch.fhnw.haggis.server.Deck;
import ch.fhnw.haggis.server.Hand;
import ch.fhnw.haggis.server.JokerDeck;
import ch.fhnw.haggis.server.SpieldatenRequest;
import ch.fhnw.haggis.server.SpieldatenResponse;

/**
 * @author Sven Hämmerli
 *
 */
@SuppressWarnings("serial")
public class Playtable
    extends JFrame
    implements Runnable, ActionListener, ItemListener
{

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
    private JPanel JokerInfo2;
    private JLabel hatJoker2;
    private JLabel hatBube2;
    private JLabel hatDame2;
    private JLabel hatKoenig2;
    private JPanel JokerInfo3;
    private JLabel hatJoker3;
    private JLabel hatBube3;
    private JLabel hatDame3;
    private JLabel hatKoenig3;

    GridBagConstraints gbcPlayedCards = new GridBagConstraints();

    private ImageIcon icon = new ImageIcon(getClass().getResource("img/hand_otherplayer_s.png"));
    
    Deck selectedDeck = new Deck();
    JokerDeck selectedJokerDeck = new JokerDeck();
	ArrayList<Card> selectedCards = new ArrayList<Card>();
	Hand selectedHand = new Hand(selectedCards);

    private ClientCommunication clientCommunication;
    private Thread communicationThread;

    public Playtable(String userName, ClientCommunication clientCommunication)
    {
    	//übergebene clientCommunication auch hier weiterhin verwenden
        this.clientCommunication = clientCommunication;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Haggis - WILDCARD");
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        setSize(1200, 800);
        setLocationRelativeTo(null); // place it in the center of the screen
        setResizable(false);

        // <----------------------------- Informationen für User 2 -------------------------->

        // Container für die Infos der 2 Spielers + KartenIcon erstellen
        panelCardsWest = new JPanel();
        contentPane.add(panelCardsWest, BorderLayout.WEST);
        panelCardsWest.setLayout(new BorderLayout());
        
        /**
         * @params Image icon wird vorher geladen und nun aufs Label geschrieben
         */

        lblImgCards2 = new JLabel(icon);
        panelCardsWest.add(lblImgCards2, BorderLayout.CENTER);
        lblImgCards2.setPreferredSize(new Dimension(250, 100)); //Grösse des Bildes bestimmen

        //Info über die vorhanenden Joker
        //GridBagConstraints und GridBagLayout damit man die Labels jeweils schön untereinander ausgeben kann
        JokerInfo2 = new JPanel();
        panelCardsWest.add(JokerInfo2, BorderLayout.NORTH);
        JokerInfo2.setLayout(new GridBagLayout());
        GridBagConstraints gbcJoker2 = new GridBagConstraints();
        hatJoker2 = new JLabel("vorhandene Joker");
        hatJoker2.setHorizontalAlignment(SwingConstants.LEFT);
        gbcJoker2.gridx = 0;
        gbcJoker2.gridy = 0;
        JokerInfo2.add(hatJoker2, gbcJoker2);
        hatBube2 = new JLabel("test_bube");
        hatBube2.setHorizontalAlignment(SwingConstants.LEFT);
        hatBube2.setFont(new Font("Arial", Font.PLAIN, 13));
        gbcJoker2.gridx = 0;
        gbcJoker2.gridy = 1;
        JokerInfo2.add(hatBube2, gbcJoker2);
        hatDame2 = new JLabel("test_dame");
        hatDame2.setHorizontalAlignment(SwingConstants.LEFT);
        hatDame2.setFont(new Font("Arial", Font.PLAIN, 13));
        gbcJoker2.gridx = 0;
        gbcJoker2.gridy = 2;
        JokerInfo2.add(hatDame2, gbcJoker2);
        hatKoenig2 = new JLabel("test_koenig");
        hatKoenig2.setHorizontalAlignment(SwingConstants.LEFT);
        hatKoenig2.setFont(new Font("Arial", Font.PLAIN, 13));
        gbcJoker2.gridx = 0;
        gbcJoker2.gridy = 3;
        JokerInfo2.add(hatKoenig2, gbcJoker2);

        //sonstige Infos zum Player
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

       
        /*
         * Sofern ein 3ter Spieler implementiert werden würde, könnte man dies bereits so verwenden
        // <------------------ Informationen für User 3 --------------------->

        panelCardsEast = new JPanel();
        contentPane.add(panelCardsEast, BorderLayout.EAST);
        panelCardsEast.setLayout(new BorderLayout());

        JokerInfo3 = new JPanel();
        panelCardsEast.add(JokerInfo3, BorderLayout.NORTH);
        JokerInfo3.setLayout(new GridBagLayout());
        GridBagConstraints gbcJoker3 = new GridBagConstraints();
        hatJoker3 = new JLabel("vorhandene Joker");
        hatJoker3.setHorizontalAlignment(SwingConstants.LEFT);
        gbcJoker3.gridx = 0;
        gbcJoker3.gridy = 0;
        JokerInfo3.add(hatJoker3, gbcJoker3);
        hatBube3 = new JLabel("test_bube");
        hatBube3.setHorizontalAlignment(SwingConstants.LEFT);
        hatBube3.setFont(new Font("Arial", Font.PLAIN, 13));
        gbcJoker3.gridx = 0;
        gbcJoker3.gridy = 1;
        JokerInfo3.add(hatBube3, gbcJoker3);
        hatDame3 = new JLabel("test_dame");
        hatDame3.setHorizontalAlignment(SwingConstants.LEFT);
        hatDame3.setFont(new Font("Arial", Font.PLAIN, 13));
        gbcJoker3.gridx = 0;
        gbcJoker3.gridy = 2;
        JokerInfo3.add(hatDame3, gbcJoker3);
        hatKoenig3 = new JLabel("test_koenig");
        hatKoenig3.setHorizontalAlignment(SwingConstants.LEFT);
        hatKoenig3.setFont(new Font("Arial", Font.PLAIN, 13));
        gbcJoker3.gridx = 0;
        gbcJoker3.gridy = 3;
        JokerInfo3.add(hatKoenig3, gbcJoker3);

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
		*/
        // <------------------------ Spieltisch ---------------------------------->

        // Spieltisch in der Mitte, mit den gespielten Karten darauf
        panelPlayDesk = new JPanel();
        panelPlayDesk.setBackground(new Color(0, 100, 0));
        contentPane.add(panelPlayDesk, BorderLayout.CENTER);
        GridBagLayout gblPanelPlayDesk = new GridBagLayout();
        panelPlayDesk.setLayout(gblPanelPlayDesk);

        // <------------------------------ Copyrightinfos ------------------------------------------>

        panelCardsSouth = new JPanel();
        contentPane.add(panelCardsSouth, BorderLayout.SOUTH);
        panelCardsSouth.setLayout(new BorderLayout());

        lblCopyright = new JLabel("\u00a9 WILDCARD - 19.12.2014"); // \u00a9 is the code for copyright
        panelCardsSouth.add(lblCopyright, BorderLayout.SOUTH);
        lblCopyright.setFont(new Font("Arial", Font.BOLD, 13));
        lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);

        // The panel for the user to display his cards
        panelPlayerCard = new JPanel();
        panelCardsSouth.add(panelPlayerCard, BorderLayout.CENTER);

        // Die JokerKarten werden in der run-methode erstellt - und anschliessend dann auf dem PanelJokerCards platziert
        panelJokerCards = new JPanel();
        panelCardsSouth.add(panelJokerCards, BorderLayout.NORTH);

        // Platzhalter für die Userinformationen - Container für InfoPanel und ActionPanel(Buttons)
        panelInfoUser1 = new JPanel();
        panelCardsSouth.add(panelInfoUser1, BorderLayout.EAST);
        panelInfoUser1.setLayout(new BorderLayout());

        // <------------------------------ Buttons für die Aktionen hinzufügen ---------------------->
        /**
         * @btnLegen play wird verwendet um die ausgewählten Karten an den Server zu senden
         * @btnPassen wenn ein Spielr passt wird auch das zum Server übermittelt
         */
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
         * Userinformationen zum aktuellen Spieler auf GUI anzeigen
         */
        // <----------------------------------- Informationen für User 1 ---------------------------------------------->

        panelInfo = new JPanel();
        panelInfoUser1.add(panelInfo, BorderLayout.NORTH);
        panelInfo.setLayout(new GridLayout(3, 2, 0, 0));

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

        // <------------------------------- Spieltisch beschrieb ------------------------------------------------------------>

        lblTitle = new JLabel("Haggis - Team WildCard");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setPreferredSize(new Dimension(200, 85));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        setVisible(true);

        // --------------------------logical part-------------------------------------------

        communicationThread = new Thread(this);
        communicationThread.start();
    }

    // <-------------------------------------Methoden zum Karten erstellen ------------------------>

    /**
     * 
     * @param karten ist ein JToggleButton array das übermittelt wird und dann mit der übergebenen Anzahl an Karten befüllt wird
     * @param anzahl, ist die Anzahl der Karten (Buttons), die erstellt werden sollen
     * @return befülltes Kartenarray
     */
    private JToggleButton[] createToggleCardButtons(JToggleButton[] karten, int anzahl)
    {
        karten = new JToggleButton[anzahl];
        for (int i = 0; i < anzahl; i++)
        {
            karten[i] = new JToggleButton();
            karten[i].setBorder(new LineBorder(Color.BLACK, 2));
            karten[i].setMaximumSize(new Dimension(10, 20));

        }
        return karten;
    }

    /**
     * Diese Methode dient dazu, die Karten für den Spieltisch(pot) zu generieren, nicht die des Users selbst
     */
    private JButton[] createPlayedCardButtons(JButton[] karten, int anzahl)
    {
        karten = new JButton[anzahl];
        for (int i = 0; i < anzahl; i++)
        {
            karten[i] = new JButton();
            karten[i].setBorder(new LineBorder(Color.BLACK, 2));
            karten[i].setMaximumSize(new Dimension(10, 20));

        }
        return karten;
    }

    // <-------------------------- Action Listeners -------------------------------------->

    // Methode zum legen der Karten
    public void actionPerformed(ActionEvent ae)
    {
    	//Request objekt erzeugen, damit die Daten dann übermittelt werden können an den Server
        SpieldatenRequest request = new SpieldatenRequest();

        if (ae.getActionCommand().equals("play"))
        {
            Hand myHand = new Hand(selectedCards);
            
            request.setStep("play");
            request.setMessage("play");
            myHand.setHand(selectedCards); //selectedCards = ArrayList, die gefüllt wird, sobald ein Button gecklickt wird
            request.setMyHand(myHand);
            
            //Verbindung zum Server
            try
            {
                clientCommunication.sendToServer(request);
                selectedCards.clear(); //zurücksetzen, ansonsten werden zuviele Karten übermittelt
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("legen"); //Kontrolle welcher Button geklickt wurde

        }

        else if (ae.getActionCommand().equals("pass"))
        {

            request.setStep("pass");
            request.setMessage("pass");
            request.setMyHand(null); //der Server braucht eine Hand, diese ist null, da er keine Karten bei der Hand des Users abziehen muss

            try
            {
                clientCommunication.sendToServer(request);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("passen");
        }
        else
        {
            System.out.println("invalid Move");
        }
    }

    // <------------------------------ ItemListener für die Karten ------------------->

    // hervorheben der Buttons, damit man weiss, welcher Button gedrückt
    // wurde (JToggleButton) wird von Icon überdeckt, deshalb so gelöst

    public void itemStateChanged(ItemEvent e)
    {
	
        // Listener für die normalen Karten [die länge von cards[] wird bestimmt, sobald die Karten vom Server befüllt werden]
        for (int x = 0; x < cards.length; x++)
        {
            if (e.getSource() == cards[x]){ //da das Array nicht sortiert wird, kann man auf die Kartenpostion zugreifen
                if (e.getStateChange() == ItemEvent.SELECTED){ 		// was passiert wenn der button selektiert ist
                    Border borderButtonSelected = new LineBorder(Color.ORANGE, 2);
                    cards[x].setBorder(borderButtonSelected);
                    Card card = new Card();
                    card = selectedDeck.findByName(cards[x].getName());
                    selectedCards.add(card);
                    System.out.println("Selected norm. Karte:" + cards[x].getName()); //zum testen, ob der richtige
                    // Button selektiert wurde
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED){ // was passiert, wenn der button deselektiert wird
                    Border borderButtonDeselected = new LineBorder(Color.BLACK, 2);
                    cards[x].setBorder(borderButtonDeselected);
                    Card card = new Card();
                    card = selectedDeck.findByName(cards[x].getName());
                    selectedCards.remove(card);
                    System.out.println("Deselected norm. Karte:" + cards[x].getName());
                }
            }
        }
        // Listener für die Joker karten
        for (int y = 0; y < jokers.length; y++){
            if (e.getSource() == jokers[y]){
                if (e.getStateChange() == ItemEvent.SELECTED){
                    Border borderButtonSelected = new LineBorder(Color.ORANGE, 2);
                    jokers[y].setBorder(borderButtonSelected);
                    Card card = new Card();
                    card = selectedJokerDeck.findByName(jokers[y].getName());
                    selectedCards.add(card);
                    System.out.println("Selected Joker Karte:" + cards[y].getName());
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    Border borderButtonDeselected = new LineBorder(Color.BLACK, 2);
                    jokers[y].setBorder(borderButtonDeselected);
                    Card card = new Card();
                    card = selectedJokerDeck.findByName(jokers[y].getName());
                    selectedCards.remove(card);
                    System.out.println("Deselected Joker Karte:" + cards[y].getName());
                }
            }
        }
    }
    /**
     * @McreateButtons - Methode zum erstellen der effektiven Buttons
     * @param response - antwort des Servers
     */
    
    public void createButtons(SpieldatenResponse response)
    {
        // Inhalte der Panels löschen
        panelPlayerCard.removeAll();
        panelJokerCards.removeAll();
        panelPlayDesk.removeAll();
        
        // <----------------------------- Kartenbuttons erstellen ------------------------------------->

        /**
         * @params anzahlNormalCards, anzahlJokerCards zuerst zählen, wie viele Buttons
         *         jeweils erstellt werden müssen
         */
        int anzahlNormalCards = 0;
        int anzahlJokerCards = 0;
        for (int i = 0; i < response.getMyHand().hand.size(); i++)
        {
            if (response.getMyHand().hand.get(i).getPoints() < 11)
            {
                anzahlNormalCards++;
            }

            else
            {
                anzahlJokerCards++;
            }
        }
        /**
         * @params cards, jokers anhand der Anzahl Karten (normal, Joker) die Buttons
         *         erstellen
         */
        cards = createToggleCardButtons(cards, anzahlNormalCards);
        jokers = createToggleCardButtons(jokers, anzahlJokerCards);

        // <--------------------------- Buttons mit Bildern füllen --------------------------------------->

        /**
         * @params countNormal, countJoker werden gebraucht, um das Bild das geladen
         *         wird, an die richtige stelle zu schreiben (falls der Koenig auf Stelle
         *         15 gefunden wird (i = 15) könnte der button sonst nicht zugewiesen
         *         werden
         */
        int countNormal = 0;
        int countJoker = 0;

        for (int i = 0; i < response.getMyHand().hand.size(); i++){
            if (response.getMyHand().hand.get(i).getPoints() < 11){
                cards[countNormal].setIcon(response.getMyHand().hand.get(i).getIcon());
                cards[countNormal].setName(response.getMyHand().hand.get(i).getName());
                cards[countNormal].addItemListener(this); // (listener)
                panelPlayerCard.add(cards[countNormal]);
                countNormal++;
            }
            else
            {
                jokers[countJoker].setIcon(response.getMyHand().hand.get(i).getIcon());
                jokers[countJoker].setName(response.getMyHand().hand.get(i).getName());
                jokers[countJoker].addItemListener(this); // (listener)
                panelJokerCards.add(jokers[countJoker]);
                countJoker++;
            }
        }

        /**
         * Alle karten in der Konsole ausgeben - zur Kontrolle ob alles richtig gemacht
         * wurde
         **/
        for (int m = 0; m <= response.getMyHand().hand.size() - 1; m++){
            System.out.println("Karte von Hand: "
                + response.getMyHand().hand.get(m).getName());
        }

        // <------------------------------------ Buttons für Pot generieren ----------------------------->
        
        playedCards = createPlayedCardButtons(playedCards, response.getMyHand().getPotActual().size());

        // Bilder laden und den Text des buttons setzen
        for (int i = 0; i < response.getMyHand().getPotActual().size(); i++)
        {
            playedCards[i].setIcon(response.getMyHand().getPotActual().get(i).getIcon());
            playedCards[i].setName(response.getMyHand().getPotActual().get(i).getName());
            panelPlayDesk.add(playedCards[i], gbcPlayedCards);
        }
        
        // Inhalte neu zeichnen um Oberfläche upzudaten
        contentPane.revalidate(); 
        contentPane.repaint();
    }

    // <----------------------------------- Run Methode zum Bearbeiten der Serverantworten ----------------------------->

    /**
     * Wartet auf Antworten vom Server (Endlosschlaufe). Mit diesen Antworten kann dann die Logik im
     * GUI entsprechend behandelt werden.
     */
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                System.out.println("playtable:waiting for server");
                
                SpieldatenResponse response = new SpieldatenResponse();
                response = clientCommunication.readFromServer();
                
                System.out.println("playtable:received response from server");
                System.out.println("Message from server " + response);

                // your move (spieler der als erster spielen kann)
                if (response.getStep().equals("yourMove"))
                {
                    JOptionPane.showMessageDialog(null, response.getMessage()); //JOptionPane zum ausgeben von Messages
                    // Buttons für Karten erstellen
                    createButtons(response);
                }
                
                // we are waiting for other players
                else if (response.getStep().equals("waitingForOtherPlayers"))
                {
                    JOptionPane.showMessageDialog(null, response.getMessage());
                    
                    // Buttons für Karten erstellen
                    createButtons(response);
                }
                
                // user submitted something but was not his turn 
                else if (response.getStep().equals("notYourTurn"))
                {
                    JOptionPane.showMessageDialog(null, response.getMessage());
                }

                /**
                 * Start to display all the cards
                 */

                // Get the message from the server, if the message is ready,
                // display the hand you get on the buttons
                else if (response.getStep().equals("validMove"))
                {

                    /**
                     * Message in Konsole Schreiben, Score beim aktiven user setzen + amtCards
                     */
                    System.out.println("Message from server " + response);
                    lblScoreUser1.setText("" + response.getScore());
                    lblUser2Score.setText("" + response.getData().getScore());
                    lblUser2Name.setText("" + response.getData().getUsername());
                    hatBube2.setText("" + response.getData().getJack());
                    hatDame2.setText("" + response.getData().getQueen());
                    hatKoenig2.setText("" + response.getData().getKing());
                    lblAmtCardsUser2.setText("" + response.getData().getAmtCards());
                    
                    // Buttons für Karten erstellen
                    createButtons(response);
                }

                /**
                 * Handle an invalid move
                 */

                // get the message from the server, if the message is invalid
                // move, open a dialogbox
                else if (response.getStep().equals("invalidMove"))
                {
                    JOptionPane.showMessageDialog(null, "Your Move was invalid, try again."); // Dialogbox
                }
                else if (response.getStep().equals("gameOver")){
                	JOptionPane.showMessageDialog(null,  response.getMessage());
                	dispose();
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
