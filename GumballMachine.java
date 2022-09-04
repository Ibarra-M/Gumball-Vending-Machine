import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/*
 * The Gumball Machine
 * Assumed to have infinite change and infinite gumballs
 */
public class GumballMachine {
	
	private int change;
	private final int NICKEL = 5;
	private final int DIME = 10;
	private final int QUARTER = 25;
	
	private int redGumballs;
	private int yellowGumballs;
	
	private int x;
	private int y;
	private int width;
	
	/*
	 * The Gumball Machine Object
	 * @param x The x-coordinate
	 * @param y the y-coordinate
	 * @param width the size of the gumball machine
	 */
	public GumballMachine(int x, int y, int width) {
		this.x = x;
		this.x = y;
		this.width = width;
		
		change = 0;
		redGumballs = 0;
		yellowGumballs = 0;
	}
	
	/*
	 * Constructs the gumball machine
	 */
	public void draw(Graphics2D g2) {
		Ellipse2D.Double glassCase = new Ellipse2D.Double(x,y, width, width);
		g2.setPaint(Color.WHITE);
		g2.fill(glassCase);
		g2.setStroke(new BasicStroke(2));
    	g2.setPaint(new Color(102,68,0));
		g2.draw(glassCase);
		
		Rectangle2D.Double base = new Rectangle2D.Double(x,y+width,width,width);
		g2.setPaint(Color.RED);
		g2.fill(base);
		g2.setStroke(new BasicStroke(2));
    	g2.setPaint(new Color(102,68,0));
    	g2.draw(base);
		
	}
	
	/*
	 * Gets the change of the gumball machine
	 * @return returns the amount of change inside the gumball machine
	 */
	public int getChange() {
		return change;
	}
	
	/*
	 * Once a nickel is inserted into the gumball machine
	 * the change will increment by 5.
	 */
	public void insertNickel() {
		change = change + NICKEL;
	}
	
	/*
	 * Once a nickel is inserted into the gumball machine
	 * the change will increment by 5.
	 */
	public void insertDime() {
		change = change + DIME;
	}
	
	/*
	 * Once a nickel is inserted into the gumball machine
	 * the change will increment by 5.
	 */
	public void insertQuarter() {
		change = change + QUARTER;
	}
	
	
	/*
	 * Dispenses all the coins inserted into the gumball machine
	 */
	public void dispenseChange() {
		change = 0;
	}
	
	/*
	 * Buys a Red Gumball for 5 cents.
	 */
	public void pullRedLever() {
		if (change >= 5) {
			change = change - NICKEL;
			redGumballs++;
		}
	}
		
	/*
	 * Buys a Yellow Gumball for 10 cents.
	 */
	public void pullYellowLever() {
		if (change >= 10) {
			change = change - DIME;
			yellowGumballs++;
		}
	}
	
	/*
	 * Gets the red gumball count
	 * @return returns the amount of red gumballs bought
	 */
	public int getRedGumballCount() {
		return redGumballs;
	}
	
	/*
	 * Gets the yellow gumball count
	 * @return returns the amount of yellow gumballs bought
	 */
	public int getYellowGumballCount() {
		return yellowGumballs;
	}


}
