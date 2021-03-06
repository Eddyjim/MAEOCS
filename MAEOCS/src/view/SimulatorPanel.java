package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.RoadsDirectory;

@SuppressWarnings("serial")
public class SimulatorPanel extends JFrame {
	
	private JLabel[][] simulatorGrid;
	
	private JLabel grid;
	private JPanel panel;
	private RoadsDirectory roads;
	
	private int width;
	private int height;
	
	/**
	 * Creates a simulation window and the choices windows
	 * @param width the width of the simulation panel
	 * @param height the height of the simulation panel
	 * @param gridSize the size of the cells in the simulation panel
	 * @param grid is the actual grid to be added
	 * @param gridArray is a 2-dimensional array that contains labels to show the roads
	 * @param directory is a directory that contains the locals-nodesId information
	 * @param roads a directory that contains the roads organized by locals
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SimulatorPanel (int width, int height,int gridSize, JLabel grid, JLabel[][] gridArray, Hashtable<String, String> directory, RoadsDirectory roads){
		
		super();
		this.roads = roads;
		this.panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		panel.setOpaque(true);
		this.width = width/gridSize;
		this.height = height/gridSize;
		simulatorGrid = gridArray;
		
		JFrame choicesFrame = new JFrame();
		choicesFrame.setSize(Theme.simulatorLocalSelector);
		final JComboBox pointA = new JComboBox();
		final JComboBox pointB = new JComboBox();
		JButton showRoadButton = new JButton("Road");
		
		choicesFrame.setLayout(new GridLayout(3,1));
		choicesFrame.add(pointA);
		choicesFrame.add(pointB);
		choicesFrame.add(showRoadButton);
		
		choicesFrame.setVisible(true);
		
		choicesFrame.setLocation(Theme.choicesLocation);
		
		for (Entry<String, String> entry : directory.entrySet()) {
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
		panel.add(this.grid);
		this.setSize(width,height);
		this.add(panel);
		grid.setVisible(true);
		this.setResizable(false);
		this.setLocation(Theme.simulationFrameLocation);
		
	}
	
	/**
	 * This method paints a road that communicates two points
	 * @param localA is the first point
	 * @param localB is the second point
	 */
	public void paintRoad(String localA, String localB) {
		
		ArrayList<String> road = roads.getRoad(localA, localB);
		
		Iterator<String> i = road.iterator();
		while (i.hasNext()) {
			String n[] = ((String) i.next()).split(",");
			simulatorGrid[Integer.parseInt(n[0])][Integer.parseInt(n[1])].setBackground(Theme.simulationRoadColor);
			simulatorGrid[Integer.parseInt(n[0])][Integer.parseInt(n[1])].setOpaque(true);
		}
		
		
	}
	
	/**
	 * This method cleans the simulation panel, an set it ready for a new simulation
	 */
	private void cleanSimulation() {

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				simulatorGrid[i][j].setBackground(Theme.background);
				simulatorGrid[i][j].setOpaque(false);
				
			}
		}
	}

}
