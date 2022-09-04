
import javax.swing.*;
import java.awt.*;

/*
 * Gumball Machine canvas
 */
public class GumballMachinePanel extends JPanel{

	private GumballMachine gumballMachine;
	
	
	public GumballMachinePanel(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	/*
	 * Used to draw the gumball machine on the panel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		gumballMachine.draw(g2);
	}
	
}
