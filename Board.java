/**
 * Board.java
 * Karjo o Emmed
 * 2014/11/09
 */

import java.util.*;
import java.awt.*;


public class Board implements ActionListener{
	public GridButton [][] buttons;
	public int [][] facit;
	private int size;
	private Minesweeper grid;
	private Color buttonBGcolour;
	private int theme;
	//Number of bombs
	public int noBombs = 10;

	public Board(String difficulty, int theme, Minesweeper grid) {

		this.theme = theme;
		this.grid = grid; 
		if(theme == 0) buttonBGcolour = Color.BLACK;
		if(theme == 1) buttonBGcolour = Color.WHITE;
		
		if(difficulty == "beginner"){
			size = 9;
			noBombs = 9;
		}
		if(difficulty == "intermediate"){
			size = 16;
			noBombs = 18;
		}
		if(difficulty == "expert"){
			size = 22;
			noBombs = 32;
		}

		buttons = new GridButton[size][size];
		facit = new int[size][size];

		int nrOfMines = 0;

		for(int i=0; i<size; i++){
	  		for(int j=0; j<size; j++){
	  			buttons[i][j].reset(theme);
	  			
	  		}
	  	}
	    	
		while(nrOfMines <= size) {
			Random r = new Random();
			int x = r.nextInt(size);
			int y = r.nextInt(size);
			//ta fram random pos
				
				if (buttons[x][y].plantBomb()) {
					nrOfMines++;
					facit[x][y] = size;
				}
			}
					
		for(int i=0; i<size; i++){
    		for(int j=0; j<size; j++){
    			if(!buttons[i][j].hasBomb())
    				facit[i][j] = buttons[i][j].checkNeighbours();
    				
    			System.out.println(facit[i][j]);
    			
    		}
    	}

		//Create all buttons 
		//Change grid to this if moving back to Minesweeper.java
		for(int j=0; j<size; j++){
			for(int i=0; i<size; i++){
				buttons[i][j]= new GridButton(i, j, this);
				buttons[i][j].setBackground(buttonBGcolour);
				buttons[i][j].addActionListener(grid);
				buttons[i][j].addMouseListener(new RightClicker(i, j, grid, this));
				buttons[i][j].setBounds(j*30+125,i*30+295,30,30);
				//Minesweeper.c.add(buttons[i][j]);
				
			}
		}
		

	}

}
