import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Cell class represents a JButton
 */
public class Cell extends JButton
{
	//Constants to represent a cells state and array of colors
	final static private int LIVE = 0;
	final static private int DISEASE = 1;
	final static private int DEAD = 2;
	final private Color[] COLORS = new Color[3];
	
	//private attributes to represent state, previous state, and iterations or rounds
	private int state;
	private int previous;
	private int iterations;
	
	/**
	 * Constructor for Cell class
	 * @param int to represent the state of the new cell object
	 */
	public Cell(int status)
	{
		initColors();
		this.state = status;
		this.setState(state);
		this.iterations = 0;
	}
	
	/**
	 * sets a new state for the cell object
	 * @param int to represent the new state of the cell object
	 */
	public void setState(int newState)
	{
		this.previous = state;
		this.state = newState;
		this.setBackground(COLORS[newState]);
		this.iterations = 0;
	}
	
	/**
	 * returns the cell object
	 * @return a cell object
	 */
	public Cell getCell()
	{
		return this;
	}
	
	/**
	 * returns the state of the cell object
	 * @return int representing cells state
	 */
	public int getState()
	{
		return state;
	}
	
	/**
	 * returns the previous state of the cell object
	 * @return int representing cells previous state
	 */
	public int getPrevious()
	{
		return this.previous;
	}

	public int getIts()
	{
		return this.iterations;
	}
	
	/**
	 * adds to iterations to represent rounds
	 */
	public void round()
	{
		this.iterations++;
	}
	
	/**
	 * resets the iterations for a cell
	 */
	public void resIts()
	{
		this.iterations = 0;
	}
	
	/**
	 * checks if a cell has been diseased for five iterations
	 * if true it will change the state to DEAD and reset iterations
	 */
	public void isDisease()
	{
		if(this.getState() == DISEASE && this.iterations >= 5)
		{
			this.setState(DEAD); //original dead
			this.iterations = 0;
		}
	}
	
	/**
	 * checks if a cell has been dead for five iterations
	 * if true then it will change the state to LIVE and reset iterations
	 */
	public void isDead()
	{
		if(this.getState() == DEAD && this.iterations >= 5)
		{
			this.setState(LIVE);
			this.iterations = 0;
		}
	}
	
	/**
	 * added on code not original
	 */
	public void isLive()
	{
		if(this.getState() == LIVE && this.iterations >= 5)
		{
			this.setState(DISEASE);
			this.iterations = 0;
		}
	}
	
	/**
	 * initiates the COLORS array
	 */
	public void initColors()
	{
		final Color PURPLE = new Color(134,0,187);
		final Color RED = new Color(209,0,33);
		final Color GRN = new Color(0,157,10);
		
		COLORS[0] = GRN;
		COLORS[1] = PURPLE;
		COLORS[2] = RED;
	}
	
}
