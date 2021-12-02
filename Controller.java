import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Controller class manages 2D cellular automata
 * 
 * @author Chris Gunter
 * @version 1.0
 */

public class Controller
{
	//private attributes set to final
	//represents percentages used to determine a cells life
	final private double DEAD_PERCENT = 0.1; //original 0.26
	final private double HEALTHY_PERCENT = 0.6; //original 0.75
	
	//private attributes to represent a view, grid, cell,
	//diseased or dead percent, healthy percent, healthy count,
	//diseased or dead count, borders or the total amount of 
	//bordering cells
	private View window;
	private Grid grd;
	private Cell[][] grdCell;
	private double dPercent;
	private double hPercent;
	private int hCount;
	private int dCount;
	private int borders;
	
	/**
	 * Constructor for the Controller class
	 */
	public Controller() 
	{	
		//new instance of View class
		window = new View();
		
		//new instance of Grid class
		grd = new Grid();
		
		//new instance of a 2D Cell array
		grdCell = new Cell[60][60];
		
		//sets grdCell equal to grds array
		grdCell = grd.getGrid(grdCell);
		
		//adds grdCell to JPanel in window
		window.addGrid(grdCell);
		
		//initiates all counts and percents to zero
		hPercent = 0.0;
		dPercent = 0.0;
		hCount = 0;
		dCount = 0;
		borders = 0;
	}
	
	/**
	 * sets the loop for the automata and prints when the loop is done
	 */
	public void go()
	{
		int x = 0;
		while(x != 5000) //original 1000
		{
			update();
			x++;
		}
		System.out.println("Done.");
	}
	
	/**
	 * Updates all cells and the main loop for the automata
	 */
	private void update()
	{
		try
		{
			//initiates a search through grdCell
			for(int g = 0; g < grdCell.length; g++)
			{
				for(int k = 0; k < grdCell[g].length; k++)
				{
					//two ints to represent g and k
					int a = g;
					int b = k;
				
					//calls checkDisease to check if this cell has been dead or diseased for five iterations
					checkDisease(a, b);
					//Thread.sleep(1);
				
					//a loop that checks a cell bordering cells credit: Dr Joe Chase
					//I could not think of a better solution to check bordering cells
					for(int i=-1; i <= 1; i++)
					{
						for(int j=-1; j <= 1; j++)
						{
							//checks if the coordinates are valid
							//another good method I could not improve upon
							if(valid(i,j,g,k))
							{
								//checks the cells state and adds a count to the appropriate counter
								//dCount is dead or diseased and hCount is healthy and borders is total cells bordering
								if((grdCell[i+g][j+k].getState() == 1) || (grdCell[i+g][j+k].getState() == 2))
								{
									dCount++;
								}
								else
								{
									hCount++;
								}
								borders++;
							}
						}
					}
					//checks if borders is greater than zero then calls
					//the change method determining a cells state
					if(borders > 0)
					{
						change(a,b);
						//Thread.sleep(1);
					}
				//adds an iteration to cell x y
				rounder(a,b);
				//Thread.sleep(10);
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	/**
	 * Checks if a cell has been diseased or dead for five iterations
	 * @param two integers representing a coordinate in an array
	 */
	private void checkDisease(int i, int j)
	{
		grdCell[i][j].isDisease();
		grdCell[i][j].isDead();
		grdCell[i][j].isLive(); //added on code from cell not apart of original
	}
	
	/**
	 * Changes a cells state based on its bordering cells states
	 * @param two integers representing a coordinate in an array
	 */
	private void change(int x, int y)
	{
		
		hPercent = percent(hCount, borders);
		dPercent = percent(dCount, borders);
		try
		{
				//Thread.sleep(0); // not original code.
					if(grdCell[x][y].getState() == 0)
					{
						if(dPercent > DEAD_PERCENT) //original dcount
						{
							grdCell[x][y].setState(1);
							Thread.sleep(0);
						}
					}
				else if(grdCell[x][y].getState() == 1)
				{
					if(hPercent > HEALTHY_PERCENT && dPercent < DEAD_PERCENT) //original hcount
					{
						grdCell[x][y].setState(0);
						Thread.sleep(0);
					}
					else if(dPercent > DEAD_PERCENT && hPercent < HEALTHY_PERCENT) //original dcount
					{
						grdCell[x][y].setState(2);
						Thread.sleep(0);
					}
				}
				else if(grdCell[x][y].getState() == 2)
				{
					if(hPercent > HEALTHY_PERCENT && dPercent < DEAD_PERCENT) //original hcount
					{
						grdCell[x][y].setState(0);
						Thread.sleep(0);
					}
				}
			reset();
		}
		catch(Exception e)
		{
			
		}
	}
	
	/**
	 * Returns a boolean representing if a location is viable in an 2D array
	 * Credit: Dr Joe Chase
	 * @return boolean representing a viable coordinate in a 2D array
	 */
	private boolean valid(int i, int j, int x, int y)
	{
		boolean result = true;
		if(((i+x)<0) || ((i+x) >= 50))
		{
			result = false;
		}
		else if (((j+y)<0) || ((j+y) >= 30))
		{
			result = false;
		}
		return result;
	}
	
	/**
	 * resets all variables used in change method
	 */
	private void reset()
	{
		hPercent = 0;
		dPercent = 0;
		hCount = 0;
		dCount = 0;
		borders = 0;
	}
	
	/**
	 * returns a double to represent a percentage of x out of y
	 * @return double representing a percentage of x out of y
	 */
	private double percent(int x, int y)
	{
		double percnt = 0;
		percnt = x/y;
		return percnt;
	}
	
	/**
	 * Adds an iteration to a specific cell in the grdCell array
	 */
	public void rounder(int i, int j)
	{
		grdCell[i][j].round();
	}
}