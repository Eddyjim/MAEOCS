package view;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * This class is used to show a new window that will contain the map to edit
 * @author Carlos Gaitán Mora && Edward Jiménez Martínez
 */
@SuppressWarnings("serial")
public class MapWindow extends JFrame{
	
	private MapPanel map;
	private Dimension mapDimension;
	private DimensionsWindow dimensionWindow;
	
	/**
	 * Creates a new map window to communicate the map panel and the main application
	 * @param state is an control variable to check which tool is being selected
	 * @param selectedNode is a controller to manage the locals added
	 */
	public MapWindow(State state, LocalAtributesManager selectedNode) {
		 setLocation(Theme.mapWindowLocation);
	     getContentPane().setBackground(Theme.background);
	     setForeground(Theme.foreground);
	     setBackground(Theme.background);
	     getContentPane().setBackground(Theme.background);
	     map = new MapPanel(state,selectedNode);
	     this.add(map);
	     setEnabled(true);
	     setVisible(true);
	     
	}
	
	/**
	 * Creates a new window map to load a saved file into the application
	 * @param selectedState is an control variable to check which tool is being selected
	 * @param selectedNode is a controller to manage the locals added
	 * @param saveFile is the absolute path of the file
	 * @throws IOException if a file exception happens 
	 * @throws ClassNotFoundException in case of a class not to be found
	 */
	public MapWindow(State selectedState, LocalAtributesManager selectedNode,
		String saveFile) throws IOException, ClassNotFoundException {
		setLocation(Theme.mapWindowLocation);
		getContentPane().setBackground(Theme.background);
		setForeground(Theme.foreground);
		setBackground(Theme.background);
	    getContentPane().setBackground(Theme.background);
	    map = new MapPanel(selectedState,selectedNode, saveFile);
	    this.add(map);
	    this.setSize(map.getDimensions());
	    this.setResizable(false);
	    setEnabled(true);
	    setVisible(true);
	}

	/**
	 * Changes the size of the window
	 * @param width is an integer with the new width
	 * @param height is an integer with the new height
	 * @param gridSize is an integer with the new size for the cells
	 */
	public void newSize(int width, int height, int gridSize){
		 
	    map.resize(width,height, gridSize);
	    
	    mapDimension = new Dimension (width+gridSize,height+gridSize);
	    setSize(mapDimension);
	    setResizable(false);
	    setEnabled(true);
	    
	}
	
	/**
	 * Sets the dimension window for the map window
	 * @param dimensionWindow
	 */
	public void setDimensionWindow(DimensionsWindow dimensionWindow){
		this.dimensionWindow = dimensionWindow;
	}
	
	/**
	 * Shows the dimension window to change the size of the window
	 */
	public void resize(){
		dimensionWindow.beVisible();
	}

	/**
	 * Sets a background image on the map
	 * @param imgFile2
	 */
	public void setBackgroundImage(String imgFile2) {
		map.setBackground(imgFile2);
	}

	/**
	 * Compiles the map on the window
	 */
	public void compileMap() {
		map.compileMap();
	}

	/**
	 * Starts the simulation windows in the map
	 */
	public void startSimulation() {
		map.startSimulation();
	}

	/**
	 * Saves the map on a file path
	 * @param saveFile is the path of the new file
	 * @throws IOException in case of a file exception
	 */
	public void saveFile(String saveFile) throws IOException {
		map.saveMap(saveFile);
		
	}

	/**
	 * Export the map to an android file
	 * @param saveFile is the path of the new file
	 * @throws IOException in case of a file exception
	 */
	public void exportFile(String saveFile) throws IOException {
		map.exportMap(saveFile);
		
	}
}
