package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.RoadsDirectory;

@SuppressWarnings("serial")
public class SimulatorPanel extends JFrame {
	
	private JLabel[][] simulatorGrid;
	
	@SuppressWarnings("unused")
	private JLabel grid;
	private RoadsDirectory roads;
	
	private int width;
	private int height;
	
	
	public SimulatorPanel (int width, int height,int gridSize, JLabel grid, JLabel[][] gridArray, Hashtable<String, String> directory, RoadsDirectory roads){
		
		super();
		this.roads = roads;
		this.simulatorGrid = gridArray;
		this.width = width/gridSize;
		this.height = height/gridSize;
		
		JFrame choicesFrame = new JFrame();
		final JComboBox pointA = new JComboBox();
		final JComboBox pointB = new JComboBox();
		JButton showRoadButton = new JButton("Road");
		
		choicesFrame.setLayout(new GridLayout(3,1));
		choicesFrame.add(pointA);
		choicesFrame.add(pointB);
		choicesFrame.add(showRoadButton);
		
		choicesFrame.setVisible(true);
		
		choicesFrame.setLocation(Theme.choicesLocation);
		
		for (java.util.Map.Entry<String, String> entry : directory.entrySet()) {
			pointA.addItem(entry.getKey());
			pointB.addItem(entry.getKey());
		}
		
		showRoadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cleanSimulation();
				paintRoad((String)pointA.getSelectedItem(), (String)pointB.getSelectedItem());
				
			}

		});
		
		this.grid = grid;
		this.setSize(width,height);
		this.add(grid);
		this.setResizable(false);
		this.setLocation(Theme.simulationFrameLocation);
		
	}
	
	public void paintRoad(String localA, String localB) {
		
		ArrayList<String> road = roads.getRoad(localA, localB);
		
		Iterator<String> i = road.iterator();
		while (i.hasNext()) {
			String n[] = ((String) i.next()).split(",");
			simulatorGrid[Integer.parseInt(n[0])][Integer.parseInt(n[1])].setBackground(Theme.simulationRoadColor);
		}
		
		
	}
	
	private void cleanSimulation() {

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				simulatorGrid[i][j].setBackground(Theme.background);
				
			}
		}
		
	}

}
