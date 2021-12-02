import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Driver class represents the driver for 2D cellular automata
 * Program will not work well with other strenuous programs running
 * 
 * @author Chris Gunter
 * @version 1.0
 */

public class Driver
{
	
	public static void main(String[] args) throws java.lang.Exception
	{
		Controller prgm = new Controller();
		try{
			Thread.sleep(1000);
			prgm.go();
		}
		catch(Exception e)
		{
		}
	}
}