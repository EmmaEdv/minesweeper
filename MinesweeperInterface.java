/**
 * @(#)MinesweeperInterface.java
 *
 *
 * @Karjo och Slemma 
 * @version 1.00 2011/9/19
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*; //to handle sounds
import java.io.*;

public class MinesweeperInterface extends JFrame implements ActionListener {
    	
	private JMenuBar menuBar;
	private JMenu gameMenu, themeMenu, helpMenu, infoMenu;
	private JMenuItem newGameItem, quitItem, aboutItem, rulesItem; //Språk här eller som flagga? 
	private JRadioButtonMenuItem beginnerItem, intermediateItem, expertItem, bombItem; //fler teman?
	private ButtonGroup difficultyGroup;
	private JButton button11, button12, button13, button14, button15, button16, button17, button18, button19; //, button110, button111, button112, button113, button114, button115, button116, button117, button118, button119, button120, button121, button122, button123, button124, button125, button126, button127, button128, button129, button130;
	private JButton button21, button22, button23, button24, button25, button26, button27, button28, button29; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button31, button32, button33, button34, button35, button36, button37, button38, button39; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button41, button42, button43, button44, button45, button46, button47, button48, button49; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button51, button52, button53, button54, button55, button56, button57, button58, button59; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button61, button62, button63, button64, button65, button66, button67, button68, button69; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button71, button72, button73, button74, button75, button76, button77, button78, button79; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button81, button82, button83, button84, button85, button86, button87, button88, button89; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JButton button91, button92, button93, button94, button95, button96, button97, button98, button99; //, button210, button211, button212, button213, button214, button215, button216, button217, button218, button219, button220, button221, button222, button223, button224, button225, button226, button227, button228, button229, button230;
	private JLabel bgLabel;
	private ImageIcon bgImage01;
    
    public MinesweeperInterface() {	
    	Container c = getContentPane();
		c.setLayout(null);
		
		bgImage01 = new ImageIcon("Bakgrunder/Cat-sweeper.png");
		bgLabel = new JLabel();
		bgLabel.setIcon(bgImage01);
		bgLabel.setBounds(0,0,576,800);
		c.add(bgLabel);
		
		menuBar = new JMenuBar();
		gameMenu = new JMenu("Game");
		newGameItem = new JMenuItem("New Game");
		
		difficultyGroup = new ButtonGroup(); //Varför gropar den inte? :(
		difficultyGroup.add(beginnerItem);
		difficultyGroup.add(intermediateItem);
		difficultyGroup.add(expertItem);
		
		beginnerItem = new JRadioButtonMenuItem("Beginner");
		beginnerItem.setSelected(true);
		intermediateItem = new JRadioButtonMenuItem("Intermediate");
		expertItem = new JRadioButtonMenuItem("Expert");
		quitItem = new JMenuItem("Quit");
		
		themeMenu = new JMenu("Theme"); 
		bombItem = new JRadioButtonMenuItem("Bomb");
		bombItem.setSelected(true);
		
		helpMenu = new JMenu("Help"); 
		rulesItem = new JMenuItem("Rules");
		
		infoMenu = new JMenu("Info");
		aboutItem = new JMenuItem("About");
	
		c.add(gameMenu);
		c.add(themeMenu);
		c.add(helpMenu);
		c.add(infoMenu);

		menuBar.add(gameMenu);
		menuBar.add(themeMenu);
		menuBar.add(helpMenu);
		menuBar.add(infoMenu);
		setJMenuBar(menuBar);
		
		gameMenu.add(newGameItem);
		gameMenu.add(beginnerItem);
		gameMenu.add(intermediateItem);
		gameMenu.add(expertItem);
		gameMenu.add(quitItem);
		themeMenu.add(bombItem);
		helpMenu.add(rulesItem);
		infoMenu.add(aboutItem);
		
		
		for(int i=1; i<=9; i++){
			String a = "button1"+i;
			a = new JButton();
			for(int b=144; i<=384; i=+30){
				
				a.setBounds(b,330,30,30);
			}
			button1i.setBackground(Color.BLACK);
			c.add(button1i);
		}
		/*
		button11 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		button14 = new JButton();
		button15 = new JButton();
		button16 = new JButton();
		button17 = new JButton();
		button18 = new JButton();
		button19 = new JButton();
		button11.setBackground(Color.BLACK);
		button12.setBackground(Color.BLACK);
		button13.setBackground(Color.BLACK);
		button14.setBackground(Color.BLACK);
		button15.setBackground(Color.BLACK);
		button16.setBackground(Color.BLACK);
		button17.setBackground(Color.BLACK);
		button18.setBackground(Color.BLACK);
		button19.setBackground(Color.BLACK);
		button11.setBounds(144,330,30,30);
		button12.setBounds(174,330,30,30);
		button13.setBounds(204,330,30,30);
		button14.setBounds(234,330,30,30);
		button15.setBounds(264,330,30,30);
		button16.setBounds(294,330,30,30);
		button17.setBounds(324,330,30,30);
		button18.setBounds(354,330,30,30);
		button19.setBounds(384,330,30,30);
		c.add(button11);
		c.add(button12);
		c.add(button13);
		c.add(button14);
		c.add(button15);
		c.add(button16);
		c.add(button17);
		c.add(button18);
		c.add(button19);
		*/
		button21 = new JButton();
		button22 = new JButton();
		button23 = new JButton();
		button24 = new JButton();
		button25 = new JButton();
		button26 = new JButton();
		button27 = new JButton();
		button28 = new JButton();
		button29 = new JButton();
		button21.setBackground(Color.BLACK);
		button22.setBackground(Color.BLACK);
		button23.setBackground(Color.BLACK);
		button24.setBackground(Color.BLACK);
		button25.setBackground(Color.BLACK);
		button26.setBackground(Color.BLACK);
		button27.setBackground(Color.BLACK);
		button28.setBackground(Color.BLACK);
		button29.setBackground(Color.BLACK);
		button21.setBounds(144,360,30,30);
		button22.setBounds(174,360,30,30);
		button23.setBounds(204,360,30,30);
		button24.setBounds(234,360,30,30);
		button25.setBounds(264,360,30,30);
		button26.setBounds(294,360,30,30);
		button27.setBounds(324,360,30,30);
		button28.setBounds(354,360,30,30);
		button29.setBounds(384,360,30,30);
		c.add(button21);
		c.add(button22);
		c.add(button23);
		c.add(button24);
		c.add(button25);
		c.add(button26);
		c.add(button27);
		c.add(button28);
		c.add(button29);
		
		button31 = new JButton();
		button32 = new JButton();
		button33 = new JButton();
		button34 = new JButton();
		button35 = new JButton();
		button36 = new JButton();
		button37 = new JButton();
		button38 = new JButton();
		button39 = new JButton();
		button31.setBackground(Color.BLACK);
		button32.setBackground(Color.BLACK);
		button33.setBackground(Color.BLACK);
		button34.setBackground(Color.BLACK);
		button35.setBackground(Color.BLACK);
		button36.setBackground(Color.BLACK);
		button37.setBackground(Color.BLACK);
		button38.setBackground(Color.BLACK);
		button39.setBackground(Color.BLACK);
		button31.setBounds(144,390,30,30);
		button32.setBounds(174,390,30,30);
		button33.setBounds(204,390,30,30);
		button34.setBounds(234,390,30,30);
		button35.setBounds(264,390,30,30);
		button36.setBounds(294,390,30,30);
		button37.setBounds(324,390,30,30);
		button38.setBounds(354,390,30,30);
		button39.setBounds(384,390,30,30);
		c.add(button31);
		c.add(button32);
		c.add(button33);
		c.add(button34);
		c.add(button35);
		c.add(button36);
		c.add(button37);
		c.add(button38);
		c.add(button39);
		
		button41 = new JButton();
		button42 = new JButton();
		button43 = new JButton();
		button44 = new JButton();
		button45 = new JButton();
		button46 = new JButton();
		button47 = new JButton();
		button48 = new JButton();
		button49 = new JButton();
		button41.setBackground(Color.BLACK);
		button42.setBackground(Color.BLACK);
		button43.setBackground(Color.BLACK);
		button44.setBackground(Color.BLACK);
		button45.setBackground(Color.BLACK);
		button46.setBackground(Color.BLACK);
		button47.setBackground(Color.BLACK);
		button48.setBackground(Color.BLACK);
		button49.setBackground(Color.BLACK);
		button41.setBounds(144,420,30,30);
		button42.setBounds(174,420,30,30);
		button43.setBounds(204,420,30,30);
		button44.setBounds(234,420,30,30);
		button45.setBounds(264,420,30,30);
		button46.setBounds(294,420,30,30);
		button47.setBounds(324,420,30,30);
		button48.setBounds(354,420,30,30);
		button49.setBounds(384,420,30,30);
		c.add(button41);
		c.add(button42);
		c.add(button43);
		c.add(button44);
		c.add(button45);
		c.add(button46);
		c.add(button47);
		c.add(button48);
		c.add(button49);
		
		button51 = new JButton();
		button52 = new JButton();
		button53 = new JButton();
		button54 = new JButton();
		button55 = new JButton();
		button56 = new JButton();
		button57 = new JButton();
		button58 = new JButton();
		button59 = new JButton();
		button51.setBackground(Color.BLACK);
		button52.setBackground(Color.BLACK);
		button53.setBackground(Color.BLACK);
		button54.setBackground(Color.BLACK);
		button55.setBackground(Color.BLACK);
		button56.setBackground(Color.BLACK);
		button57.setBackground(Color.BLACK);
		button58.setBackground(Color.BLACK);
		button59.setBackground(Color.BLACK);
		button51.setBounds(144,450,30,30);
		button52.setBounds(174,450,30,30);
		button53.setBounds(204,450,30,30);
		button54.setBounds(234,450,30,30);
		button55.setBounds(264,450,30,30);
		button56.setBounds(294,450,30,30);
		button57.setBounds(324,450,30,30);
		button58.setBounds(354,450,30,30);
		button59.setBounds(384,450,30,30);
		c.add(button51);
		c.add(button52);
		c.add(button53);
		c.add(button54);
		c.add(button55);
		c.add(button56);
		c.add(button57);
		c.add(button58);
		c.add(button59);
		
		button61 = new JButton();
		button62 = new JButton();
		button63 = new JButton();
		button64 = new JButton();
		button65 = new JButton();
		button66 = new JButton();
		button67 = new JButton();
		button68 = new JButton();
		button69 = new JButton();
		button61.setBackground(Color.BLACK);
		button62.setBackground(Color.BLACK);
		button63.setBackground(Color.BLACK);
		button64.setBackground(Color.BLACK);
		button65.setBackground(Color.BLACK);
		button66.setBackground(Color.BLACK);
		button67.setBackground(Color.BLACK);
		button68.setBackground(Color.BLACK);
		button69.setBackground(Color.BLACK);
		button61.setBounds(144,480,30,30);
		button62.setBounds(174,480,30,30);
		button63.setBounds(204,480,30,30);
		button64.setBounds(234,480,30,30);
		button65.setBounds(264,480,30,30);
		button66.setBounds(294,480,30,30);
		button67.setBounds(324,480,30,30);
		button68.setBounds(354,480,30,30);
		button69.setBounds(384,480,30,30);
		c.add(button61);
		c.add(button62);
		c.add(button63);
		c.add(button64);
		c.add(button65);
		c.add(button66);
		c.add(button67);
		c.add(button68);
		c.add(button69);
		
		button71 = new JButton();
		button72 = new JButton();
		button73 = new JButton();
		button74 = new JButton();
		button75 = new JButton();
		button76 = new JButton();
		button77 = new JButton();
		button78 = new JButton();
		button79 = new JButton();
		button71.setBackground(Color.BLACK);
		button72.setBackground(Color.BLACK);
		button73.setBackground(Color.BLACK);
		button74.setBackground(Color.BLACK);
		button75.setBackground(Color.BLACK);
		button76.setBackground(Color.BLACK);
		button77.setBackground(Color.BLACK);
		button78.setBackground(Color.BLACK);
		button79.setBackground(Color.BLACK);
		button71.setBounds(144,510,30,30);
		button72.setBounds(174,510,30,30);
		button73.setBounds(204,510,30,30);
		button74.setBounds(234,510,30,30);
		button75.setBounds(264,510,30,30);
		button76.setBounds(294,510,30,30);
		button77.setBounds(324,510,30,30);
		button78.setBounds(354,510,30,30);
		button79.setBounds(384,510,30,30);
		c.add(button71);
		c.add(button72);
		c.add(button73);
		c.add(button74);
		c.add(button75);
		c.add(button76);
		c.add(button77);
		c.add(button78);
		c.add(button79);
		
		button81 = new JButton();
		button82 = new JButton();
		button83 = new JButton();
		button84 = new JButton();
		button85 = new JButton();
		button86 = new JButton();
		button87 = new JButton();
		button88 = new JButton();
		button89 = new JButton();
		button81.setBackground(Color.BLACK);
		button82.setBackground(Color.BLACK);
		button83.setBackground(Color.BLACK);
		button84.setBackground(Color.BLACK);
		button85.setBackground(Color.BLACK);
		button86.setBackground(Color.BLACK);
		button87.setBackground(Color.BLACK);
		button88.setBackground(Color.BLACK);
		button89.setBackground(Color.BLACK);
		button81.setBounds(144,540,30,30);
		button82.setBounds(174,540,30,30);
		button83.setBounds(204,540,30,30);
		button84.setBounds(234,540,30,30);
		button85.setBounds(264,540,30,30);
		button86.setBounds(294,540,30,30);
		button87.setBounds(324,540,30,30);
		button88.setBounds(354,540,30,30);
		button89.setBounds(384,540,30,30);
		c.add(button81);
		c.add(button82);
		c.add(button83);
		c.add(button84);
		c.add(button85);
		c.add(button86);
		c.add(button87);
		c.add(button88);
		c.add(button89);
		
		button91 = new JButton();
		button92 = new JButton();
		button93 = new JButton();
		button94 = new JButton();
		button95 = new JButton();
		button96 = new JButton();
		button97 = new JButton();
		button98 = new JButton();
		button99 = new JButton();
		button91.setBackground(Color.BLACK);
		button92.setBackground(Color.BLACK);
		button93.setBackground(Color.BLACK);
		button94.setBackground(Color.BLACK);
		button95.setBackground(Color.BLACK);
		button96.setBackground(Color.BLACK);
		button97.setBackground(Color.BLACK);
		button98.setBackground(Color.BLACK);
		button99.setBackground(Color.BLACK);
		button91.setBounds(144,570,30,30);
		button92.setBounds(174,570,30,30);
		button93.setBounds(204,570,30,30);
		button94.setBounds(234,570,30,30);
		button95.setBounds(264,570,30,30);
		button96.setBounds(294,570,30,30);
		button97.setBounds(324,570,30,30);
		button98.setBounds(354,570,30,30);
		button99.setBounds(384,570,30,30);
		c.add(button91);
		c.add(button92);
		c.add(button93);
		c.add(button94);
		c.add(button95);
		c.add(button96);
		c.add(button97);
		c.add(button98);
		c.add(button99);
		
		quitItem.addActionListener(this);
		
		addWindowListener(frameListener);
		setSize(576,800);
		setVisible(true);
		setResizable(false);
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
	
	}
	
    public static void main(String[] args) {
		MinesweeperInterface robert = new MinesweeperInterface();
	}
}