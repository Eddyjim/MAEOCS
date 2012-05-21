package view;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class SimulatorPanel extends JPanel {
	
	private JTextField origin;
	private JTextField destiny;
	private JLabel[][] simulatorGrid;
	private JLabel simulatorWindow;
	private JButton simulate;
		
	public SimulatorPanel (int width, int height, Image img){
		super();
		origin = new JTextField();
		destiny = new JTextField();
		simulatorGrid = new JLabel[width][height];
		simulatorWindow = new JLabel();
		JButton simulate = new JButton("Simulate");
		
		this.add(origin);
		this.add(destiny);
	}
	
	
	
}
