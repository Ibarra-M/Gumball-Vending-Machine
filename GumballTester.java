import java.awt.*;
import javax.swing.*;

/*
 * 
 */
public class GumballTester {
	public static void main(String[] args) {
		
		//Creating the frame
		JFrame frame = new JFrame("Gumball");
		final int WIDTH = 500;
		final int HEIGHT = 600;
		frame.setSize(WIDTH, HEIGHT);
		
		//Creating the GumballMachine Object
		GumballMachine gumballMachine = new GumballMachine(0,WIDTH/2,100);
		GumballMachinePanel gPanel = new GumballMachinePanel(gumballMachine);
		
		
		
		//Creates text area to display the amount of change inserted and the amount of gumballs bought
		JTextArea gumballInfo = new JTextArea(5, 10);
		gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
				"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
				"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount());

		//Nickel button to insert 5 cents into the gumball machine
		JButton nickelButton = new JButton("Insert Nickel");
		nickelButton.addActionListener(event-> {
			gumballMachine.insertNickel();
			gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
					"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
					"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount());
		});
		
		//Dime button to insert 10 cents into the gumball machine
		JButton dimeButton = new JButton("Insert Dime");
		dimeButton.addActionListener(event-> {
			gumballMachine.insertDime();
			gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
					"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
					"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount());
		});
		
		//Quarter button to insert 25 cents into the gumball machine
		JButton quarterButton = new JButton("Insert quarter");
		quarterButton.addActionListener(event-> {
			gumballMachine.insertQuarter();
			gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
					"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
					"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount());
		});
		

		//Red lever buys the red gumball for 5 cents
		JButton redLever = new JButton("Red Gumball for 5 cents");
		redLever.setBackground(Color.RED);
		redLever.addActionListener(event-> {
			gumballMachine.pullRedLever();
			gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
					"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
					"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount());
			
		});
		
		//Yellow lever buys the yellow gumball for 10 cents
		JButton yellowLever = new JButton("Yellow Gumball for 10 cents");
		yellowLever.setBackground(Color.YELLOW);
		yellowLever.addActionListener(event-> {
			gumballMachine.pullYellowLever();
			gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
					"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
					"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount());
			
		});
		
		//Dispense lever removes all the change inserted into the gumball
		JButton dispenseLever = new JButton("Return My Change");
		dispenseLever.addActionListener(event-> {
			int beforeDispensed = gumballMachine.getChange();
			gumballMachine.dispenseChange();
			gumballInfo.setText("Change: "+ gumballMachine.getChange() + " cents" + "\n" +
					"Red Gumballs: "+ gumballMachine.getRedGumballCount() + "\n" +
					"Yellow Gumballs: "+ gumballMachine.getYellowGumballCount() + "\n" +
					"Dispensed: " + beforeDispensed + " cents");
		});
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(nickelButton);
		buttonPanel.add(dimeButton);
		buttonPanel.add(quarterButton);
		buttonPanel.add(redLever);
		buttonPanel.add(yellowLever);
		buttonPanel.add(dispenseLever);
		buttonPanel.add(gumballInfo);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(gPanel);
		mainPanel.add(buttonPanel);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
	}

}
