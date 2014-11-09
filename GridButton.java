/**
 * GridButton.java
 * Karjo o Emmed
 * 2011/9/28
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridButton extends JButton{

	private int x, y;
	private boolean bomb = false;
//	private Minesweeper grid;
    //allt som heter board nu, hette grid nyss
    private Board board;
	private ImageIcon bang;
	private Color grey;
	//private int [][] facit = new int[10][10];;

    public GridButton(int x, int y, Board board) {
    	super(); //JButton-konstruktor kors
    	this.x = x;
    	this.y = y;
    	this.board = board;
    	setMargin(new Insets(0,0,0,0));
    	grey = new Color(200, 200, 200);
    }

	public void reset(int t){			//Nollstaller knapp
		bomb = false;
		//remove pictures and text, por favor!
		setEnabled(true);
		setLabel("");
		setIcon(null);
		if (t==1){
			setBackground(Color.BLACK);
		}
		else if(t==2) {
			setBackground(Color.WHITE);
		}
	}

    public boolean plantBomb(){	//planterar bomb
    	if (bomb)
    		return false;
    	bomb = true;
    	return true;
    }
	
	/*public void setFacit(int[][] f)
	{
		facit = f;
	}

	public int[][] getFacit()
	{
		return facit;
	}*/
	
	public boolean win(){
		for(int i=1; i<10; i++){
    		for(int j=1; j<10; j++){
    			if(board.facit[i][j] < 9){
    				System.out.println(board.facit[i][j]);
    				return false;
    			}
   			   			
    		}
    	}
    	return true;
	}
	
    public boolean hasBomb(){	//berattar ifall det finns bomb
    	return bomb;
    }

    public int checkNeighbours(){		//kollar de runtikring knappen
    	int n = 0;
    	for(int i=y-1; i<=y+1; i++) for(int j=x-1; j<=x+1; j++) {
    		if (i<1 || i>9 || j<1 || j>9)
    			continue;
    		if (board.buttons[j][i] != this && board.buttons[j][i].hasBomb()) n++;
    	}
    	return n;
    }

    public void allCloseGray(){ //kollar ifall det finns graa runt ikring egna knappen
    	for(int g=1; g<10; g++) for(int r=1; r<10; r++){
    		if(board.buttons[g][r].checkNeighbours()==0){
    			for(int h=x-1; h<=x+1; h++) for(int f=y-1; f<=y+1; f++) { //h=rad, f=kolumn	    			
	    			if (h<1 || h>9 || f<1 || f>9)
	    				continue;
	    			if(board.buttons[h][f].checkNeighbours()!=0) //om det inte ar en gra ruta som granne, hoppa over rutan
	    				continue;
	    				
	    			if(board.buttons[h][f].checkNeighbours()==0 && board.facit[h][f] < 9){ //om grannen ar gra, satt den som gra
	    				board.buttons[h][f].setBackground(grey);
	    				board.facit[h][f] = 10;

	    			}	    			
    			}
    		}
    	}
    }

    public boolean investigate(){   //Undersoker: Ar det en bomb?
    	if (bomb) return true;
    	else {
    		int closeBombs = checkNeighbours();
    		if(closeBombs==0){
    			setLabel("");
    			allCloseGray();				//FA DEN ATT GORA SA ATT ALLA TOMMA RUTOR BLIR SYNLIGA OM MAN KLICKAR PA EN. GOR EN METOD FOR DETTA
    		}
    		else{
    		//	allCloseGray();
    			String s = Integer.toString(closeBombs);
    			setLabel(s);
    		}
    		setForeground(new Color(Math.min(closeBombs*75, 255), 0, Math.min((9-closeBombs)*75,255)));
    		setBackground(new Color(200, 200, 200));
    		board.facit[x][y]=10;
    		return false;
    	}
    }

    public void showBomb(int t){		//Visar bomb
    	if (bomb)
    		if (t==0){
    			setIcon(new ImageIcon("graphics/bang.png"));
    		}
    		else if (t==1) {
    			setIcon(new ImageIcon("graphics/blackPaw3.png"));
    		}
    }
}

