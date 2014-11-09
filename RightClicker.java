import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RightClicker extends MouseAdapter {
	
	private int x, y;
	private Minesweeper grid;
	private Board board;
//	private String bg = "graphics/flag.png";
	
	public RightClicker(int x, int y, Minesweeper grid, Board board) {
		super(); //JButton-konstruktor kors
		this.x = x;
		this.y = y;
		this.grid = grid;
		this.board = board;
	}
	
   	public void mousePressed( MouseEvent e ) {
        if ( e.isMetaDown() ) {
        		if(grid.theme == 0)	board.buttons[x][y].setIcon(new ImageIcon("graphics/flag_black.png"));
				if(grid.theme == 1)	board.buttons[x][y].setIcon(new ImageIcon("graphics/flag_white.png"));
        		
				grid.rightClicks++;
				grid.mineTA.setText(grid.rightClicks + "/" + board.noBombs);
        }
    }
}