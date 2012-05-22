package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	
	private int height;
	private int width;
	private int grid;
	
	
	public SimulatorPanel (int width, int height, int grid){
		super();
		
		this.height = height;
		this.width = width;
		this.grid = grid;
		
		this.setLayout(new GridLayout(4, 1));
		
		origin = new JTextField();
		destiny = new JTextField();
		simulatorGrid = new JLabel[width][height];
		simulatorWindow = new JLabel();
		simulate = new JButton("Simulate");
		createSimulatorWindow();
		this.add(simulatorWindow);
		this.add(origin);
		this.add(destiny);
		this.add(simulate);
	}

	private void createSimulatorWindow() {
		
		simulatorWindow.setLayout(new GridLayout (grid, grid));
		
		
		simulatorWindow.setSize(width,height);
		
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				simulatorGrid[i][j] = new JLabel ();
				simulatorGrid[i][j].setLayout(new GridLayout(1,1));
				simulatorWindow.add(simulatorGrid[i][j]);
			}
		}
		
	}
	
	public void setSimulateAction(ActionListener ls){
		simulate.addActionListener(ls);
	}
	
	public void paintAPoint (int i, int j){
		Label label = new Label();
		label.setBackground(Color.GREEN);
		System.out.println("toy pintando: "+i+" "+j);
		simulatorGrid[i][j].setText("o");
		simulatorGrid[i][j].add(label);
	}
	
	public void clearWindow (){
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				simulatorGrid[i][j].setText("");
				simulatorGrid[i][j].removeAll();
			}
		}
	}

	public void paintBackground(Image img) {
		simulatorWindow.setIcon(new ImageIcon(img.getScaledInstance(
				simulatorWindow.getSize().width, simulatorWindow.getSize().height, 1)));
	}
	
}
