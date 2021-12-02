import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * View class initiates a JFrame and JPanel with a Grid of JButtons
 * 
 * @author Chris Gunter
 * @version 1.0
 */
public class View
{
	//private attributes represent JFrame and JPanel
	private JFrame frm;
	private JPanel pnl;
	
	/**
	 * The constructor for View class
	 */
	public View()
	{
		//initiates a new JFrame and sets size to 1000,1000
		frm = new JFrame("");
		frm.setSize(1000,1000);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initiates a new JPanel and sets color to white and opaque to true
		pnl = new JPanel();
		pnl.setBackground(Color.white);
		pnl.setOpaque(true);
		
		//sets a gridLayout on the JPanel
		pnl.setLayout(new GridLayout(60,60));
				
	}
	
	/**
	 * adds a 2D cell array to the grid in JPanel and sets frame to visible
	 * @param a 2D cell array to be added to JPanel
	 */
	public void addGrid(Cell[][] a)
	{
		for(int i = 0; i < 60; i++)
		{
			for(int j = 0; j < 60; j++)
			{
				pnl.add(a[i][j]);
			}
		}
		frm.add(pnl);
		frm.setVisible(true);
	}
}