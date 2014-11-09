/**
 * Board.java
 * Karjo o Emmed
 * 2014/11/09
 */
public class Board{
	public GridButton [][] buttons;
	public int [][] facit;
	private Color myRed = new Color(185,2,1);
	private Color myBlack = new Color(0,0,0);
	private Color myBlue = new Color(0,75,200);
	private int size;

	public Board(String difficulty, int theme) {
		
		if(difficulty == beginner) size = 9;
		if(difficulty == intermediate) size = 16;
		if(difficulty == expert) size = 22;

		buttons = new GridButton[size][size];
		facit = new int[size][size];

		int nrOfMines = 0;

		for(int i=0; i<size; i++){
	  		for(int j=0; j<size; j++){
	  			buttons[i][j].reset(theme);
	  			
	  		}
	  	}
	    	
		while(nrOfMines < 10) {
			Random r = new Random();
			int x = r.nextInt(9) + 1;
			int y = r.nextInt(9) + 1;
			//ta fram random pos
				
				if (buttons[x][y].plantBomb()) {
					nrOfMines++;
					facit[x][y] = 9;
				}
			}
					
			for(int i=1; i<10; i++){
	    		for(int j=1; j<10; j++){
	    			if(!buttons[i][j].hasBomb())
	    				facit[i][j] = buttons[i][j].checkNeighbours();
	    				
	    			System.out.println(facit[i][j]);
	    			
	    		}
	    	}
	}

}
