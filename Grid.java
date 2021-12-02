import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Grid class creates a 2D array of Cells
 * 
 * @author Chris Gunter
 * @version 1.0
 */
public class Grid
{
	//private attribute representing a 2D array of Cells
	private Cell[][] buttons;
	
	/**
	 * Constructor for Grid class.
	 * Initiates 2D array of Cells called buttons and assigns each 
	 * cells state by using random.
	 */
	public Grid()
	{
		buttons = new Cell[60][60];
		
		Random rnd = new Random();
		for(int i = 0; i < 60; i++)
		{
			for(int j = 0; j < 60; j++)
			{
				buttons[i][j] = new Cell(rnd.nextInt(3));
			}
		}
	}
	
	/**
	 * Returns a copy of the buttons array
	 * @param a 2D array that will copy the buttons array
	 * @return a 2D array copy of buttons
	 */
	public Cell[][] getGrid(Cell[][] a)
	{
		for(int i = 0; i < buttons.length; i++)
		{
			for(int j = 0; j < buttons[i].length; j++)
			{
				a[i][j] = buttons[i][j];
			}
		}
		return a;
	}
}
