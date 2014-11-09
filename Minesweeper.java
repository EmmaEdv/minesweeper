/**
 * MinesweeperInterface.java
 * Karjo och Slemma
 * 2014/11/09
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.applet.*; //to handle sounds
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Minesweeper extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu gameMenu, themeMenu, helpMenu, infoMenu, languageMenu;
	private JMenuItem newGameItem, quitItem, aboutItem, rulesItem, highscoreItem; //Language here or as a flag?
	private JRadioButtonMenuItem beginnerItem, intermediateItem, expertItem, bombItem, catItem, sweItem, engItem; //multiple themes?
	private ButtonGroup difficultyGroup, themeGroup, languageGroup;
	private JLabel bgLabel, mineLabel, timeLabel, volumeLabel;
	private ImageIcon bgImage01, bgImage02, flag;
	public int theme; 
	private int counter, left;
	private JSlider volumeBar;
	public JTextField mineTA, timeTA;
	private String difficulty = "beginner"; 
	private int size = 9;

	private Color myRed = new Color(185,2,1);
	private Color myBlack = new Color(0,0,0);
	private Color myBlue = new Color(0,75,200);
	
	final int FPS_MIN = 0;
	final int FPS_MAX = 20;
	final int FPS_INIT = 10;

	public Timer clock;
	public int secs = 0;
	public int mins = 0;
	public int hrs = 0;
	public JLabel display;
	private DecimalFormat dFormat = new DecimalFormat("00");
	public Board board;

	public int rightClicks = 0;

	public Minesweeper() {
    	Container c = getContentPane();
		c.setLayout(null);

		if(difficulty == "beginner") size = 9;
		if(difficulty == "intermediate") size = 16;
		if(difficulty == "expert") size = 22;

		//counter = 0;
		//Load backgrounds
		bgImage01 = new ImageIcon("graphics/BombBackground2.png");
		bgImage02 = new ImageIcon("graphics/Cat-sweeper.png");
		
		//Default theme: Regular mine sweeper
		theme = 1;
		bgLabel = new JLabel();
		bgLabel.setIcon(bgImage01);
		bgLabel.setBounds(0,0,580,800);

		//Timer
		clock = new Timer(17, this);				
		timeLabel = new JLabel("Time:");
		timeLabel.setBounds(440,330,385,30);
		timeLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
		timeLabel.setForeground(myRed);
		timeTA = new JTextField();
		timeTA.setBounds(440, 360, 100, 30);
		timeTA.setEditable(false);
		timeTA.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
		timeTA.setHorizontalAlignment(timeTA.RIGHT);
		
		//Nr of mines swept
		mineLabel = new JLabel("Bombs:");
		mineLabel.setBounds(440,400,160,30);
		mineLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
		mineLabel.setForeground(myRed);
		mineTA = new JTextField(rightClicks + "/10");
		mineTA.setBounds(440, 430, 60, 30);
		mineTA.setEditable(false);
		mineTA.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
		mineTA.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);  
		
		//Volume slider
		volumeLabel = new JLabel("Volume:");
		volumeLabel.setBounds(440,470,150,30);
		volumeLabel.setForeground(myRed);
		/*http://download.oracle.com/javase/tutorial/uiswing/components/slider.html*/
		JSlider volumeBar = new JSlider(JSlider.HORIZONTAL,FPS_MIN, FPS_MAX, FPS_INIT);
		volumeBar.setBounds(440,500,125,20);
		volumeBar.setOpaque(false);
		volumeLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));

		//flag = new ImageIcon("graphics/flag.png");
		
		//Menu
		menuBar = new JMenuBar();
		gameMenu = new JMenu("Game");
		newGameItem = new JMenuItem("New Game");
		newGameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.ALT_MASK));
		newGameItem.addActionListener(this);

		difficultyGroup = new ButtonGroup();
		themeGroup= new ButtonGroup();
		languageGroup = new ButtonGroup();
		
		beginnerItem = new JRadioButtonMenuItem("Beginner");
		beginnerItem.setSelected(true);
		intermediateItem = new JRadioButtonMenuItem("Intermediate");

		expertItem = new JRadioButtonMenuItem("Expert");
		quitItem = new JMenuItem("Quit");
		quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));

		difficultyGroup.add(beginnerItem);
		difficultyGroup.add(intermediateItem);
		difficultyGroup.add(expertItem);
		
		highscoreItem = new JMenuItem("Highscore");
		highscoreItem.addActionListener(this);
		
		themeMenu = new JMenu("Theme");
		bombItem = new JRadioButtonMenuItem("Bomb");
		bombItem.setSelected(true);
		bombItem.addActionListener(this);
		catItem = new JRadioButtonMenuItem("Cat");
		catItem.setSelected(true);
		catItem.addActionListener(this);
		
		themeGroup.add(bombItem);
		themeGroup.add(catItem);
		
    languageMenu = new JMenu("Language");
    sweItem = new JRadioButtonMenuItem("Svenska");
    sweItem.addActionListener(this);
    engItem = new JRadioButtonMenuItem("English");
    engItem.setSelected(true);
    engItem.addActionListener(this);
         
    languageGroup.add(sweItem);
		languageGroup.add(engItem);
		
		helpMenu = new JMenu("Help");
		rulesItem = new JMenuItem("Rules");
		rulesItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    rulesItem.addActionListener(this);

		infoMenu = new JMenu("Info");
		aboutItem = new JMenuItem("About");
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    aboutItem.addActionListener(this);

    //Add to container
		c.add(gameMenu);
		c.add(themeMenu);
		c.add(languageMenu);
		c.add(helpMenu);
		c.add(infoMenu);
		c.add(volumeBar);
		c.add(volumeLabel);
		c.add(timeLabel);
		c.add(mineLabel);
		c.add(mineTA);
		c.add(timeTA);
		
		menuBar.add(gameMenu);
		menuBar.add(themeMenu);
		menuBar.add(languageMenu);
		menuBar.add(helpMenu);
		menuBar.add(infoMenu);
		setJMenuBar(menuBar);

		gameMenu.add(newGameItem);
		gameMenu.add(beginnerItem);
		gameMenu.add(intermediateItem);
		gameMenu.add(expertItem);
		gameMenu.add(highscoreItem);
		gameMenu.add(quitItem);
		themeMenu.add(bombItem);
		themeMenu.add(catItem);
		languageMenu.add(engItem);
		languageMenu.add(sweItem);
		helpMenu.add(rulesItem);
		infoMenu.add(aboutItem);
		
		newGame();

		for(int j=0; j<size; j++){
			for(int i=0; i<size; i++){	
				c.add(board.buttons[i][j]);
			}
		}

		quitItem.addActionListener(this);
		c.add(bgLabel);
		addWindowListener(frameListener);
		setSize(580,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setTitle("Sweeper!");
    }
    
    public void newGame(){  
    	    
	   	//clock = new Timer(10, this);				//Skapa klocka, nollstall klocka, starta klocka.
			secs = 0;
			mins = 0;
			hrs = 0;
			rightClicks = 0;
		    stopClock();
			timeTA.setText("00:00:00");
		    mineTA.setText(rightClicks + "/10");
	    	board = new Board(difficulty, theme, this);			
	}
	    
	public void startClock(){
		clock.start();
	}
		
	public void stopClock(){
		clock.stop();
	}
    
    public void disableAll(){
    	for(int i=1; i<10; i++) for(int j=1; j<10; j++){
    		if(board.buttons[i][j].investigate()==false){
    			board.buttons[i][j].setEnabled(false);
    		}
    	}
    }

    public void youWin(){
    	stopClock();    	
        JOptionPane.showMessageDialog(this, "CONGRATULATIONS,\n you won!");
		disableAll(); //det gar inte att trycka pa nan knapp						
    }

    public void youLose(){
    	stopClock();

    	for(int j=1; j<10; j++){ //kolumn
				for(int i=1; i<10; i++){ //rad
					board.buttons[i][j].showBomb(theme);
				}
			}
    	disableAll(); //det gar inte att trycka pa nan knapp
    }

    WindowListener frameListener = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	};

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==quitItem){
			System.exit(0);
		}

		if(e.getSource()==rulesItem){
			JOptionPane.showMessageDialog(this, "The rules in Minesweeper are simple: \n Uncover a mine, and the game ends." +
												"\n Uncover an empty square, and you keep playing. \n Uncover a number, and it tells you how many mines lay hidden in the eight surrounding \n" +
												" squares information you use to deduce which nearby squares are safe to click.", "Rules", 1);
		}

		if(e.getSource()==aboutItem){
			JOptionPane.showMessageDialog(this, "Copyright: Emma Edvardsson, Karolin Jonsson", "About Sweeper", 1);
		}

		Object o = e.getSource();

		if(o instanceof GridButton){
			startClock();
			GridButton b = (GridButton) o;
			if (b.investigate()){
				youLose();
				if(theme == 1)
					b.setIcon(new ImageIcon("Bakgrunder/bangWhite.png"));
				else
					b.setIcon(new ImageIcon("Bakgrunder/redPaw3.png"));
				JOptionPane.showMessageDialog(this, "You lose!"); //ruta med you lose kommer upp.
			}
			else if(b.win()){
				System.out.println("win");
				youWin();
			}
			
/*			for(int i=1; i<10; i++){
    			for(int j=1; j<10; j++){

    			System.out.println(facit[i][j]);
    			
    			}
    		} */
    		System.out.println(":");
		}
		
		if (e.getSource() == clock){
		  secs++;
		}
		
		if (secs == 60){
		  mins++;
		  secs = 0;
		}
		
		if (mins == 60){
		  hrs++;
		  mins = 0;
		  secs = 0;
		}
		
		if (hrs == 24){
		  hrs = 0;
		  mins = 0;
		  secs = 0;
		}
	
		timeTA.setText(dFormat.format(hrs) + ":" + dFormat.format(mins) + ":" + dFormat.format(secs));
		
		if(e.getSource()==newGameItem){ //Maste uppdatera fonstret pa nagot satt
			newGame();
			//super.update(); //HUR UPPDATERAR MAN fonstret???
		}
		
		if(e.getSource()==bombItem){
			stopClock();
			int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to switch theme? \nA new game will start.", "Warning", JOptionPane.YES_NO_OPTION);
			
			if(reply == JOptionPane.YES_OPTION){
				startClock();
				newGame();
				mineLabel.setText("Bombs:");
				timeLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
				timeTA.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
				timeLabel.setForeground(myRed);
				mineLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
				mineTA.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
				mineLabel.setForeground(myRed);
				volumeLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
				volumeLabel.setForeground(myRed);
				bgLabel.setIcon(bgImage01);
				theme = 1;
			}
			else {
				catItem.setSelected(true);
				startClock();
			}
		}
		if(e.getSource()==catItem){
			stopClock();
			int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to switch theme? \nA new game will start.", "Warning", JOptionPane.YES_NO_OPTION);
			
			if(reply == JOptionPane.YES_OPTION){
				startClock();
				newGame();
				bgLabel.setIcon(bgImage02);
				timeLabel.setForeground(Color.BLACK);
				timeLabel.setFont(new Font("Gill Sans", Font.BOLD, 25));
				timeTA.setFont(new Font("Gill Sans", Font.BOLD, 15));
				mineLabel.setForeground(Color.BLACK);
				mineLabel.setFont(new Font("Gill Sans", Font.BOLD, 25));
				mineLabel.setText("Cats:");
				mineTA.setFont(new Font("Gill Sans", Font.BOLD, 15));
				volumeLabel.setFont(new Font("Gill Sans", Font.BOLD, 25));
				volumeLabel.setForeground(Color.BLACK);
				theme = 2;
			}
			else {
				bombItem.setSelected(true);
				startClock();
			}
		}
		
		if(e.getSource()==highscoreItem){
			JOptionPane.showMessageDialog(this, "Highscore \nHar sta vem som har fatt mest poang \nnagonsin i MinesweeperInterfaceArrays historia!", "Highscore", 1);
		}

	}

  
  public static void main(String[] args) {
		Minesweeper game = new Minesweeper();

	}
}