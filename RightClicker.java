import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RightClicker extends MouseAdapter {
	
	private int x, y;
	private MinesweeperInterfaceArray grid;
	private String bg = "graphics/flag.png";
	
	public RightClicker(int x, int y, MinesweeperInterfaceArray grid) {
		super(); //JButton-konstruktor kors
		this.x = x;
		this.y = y;
		this.grid = grid;
	}
	
   	public void mousePressed( MouseEvent e ) {
        if ( e.isMetaDown() ) {
/*	        	if(grid.buttons[x][y].getIcon() == bg){
        		grid.buttons[x][y].setBackground(Color.BLACK);
        	}
        	else*/
				grid.buttons[x][y].setIcon(new ImageIcon("graphics/flag.png"));
				grid.rightClicks++;
				grid.mineTA.setText(grid.rightClicks + "/10");
			//grid.buttons[x][y].setEnabled(false);
			//System.out.println(grid.buttons[x][y].getIcon());
        }
    }
}