package view;

import java.awt.Dimension;
import javax.swing.JFrame;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import model.Node;

/**
 * This class is used to show a new window that will contain the map to edit
 * @author Carlos Gaitán Mora && Edward Jiménez Martínez
 */
@SuppressWarnings("serial")
public class MapWindow extends JFrame{
	
	private MapPanel map;
	private Dimension mapDimension;
	private DimensionsWindow dimensionWindow;
	
	
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
	
	public void newSize(int width, int height, int gridSize){
		 
	    map.resize(width,height, gridSize);
	    
	    mapDimension = new Dimension (width+gridSize,height+gridSize);
	    setSize(mapDimension);
	    setResizable(false);
	    setEnabled(true);
	    
	}
	
	public void setDimensionWindow(DimensionsWindow dimensionWindow){
		this.dimensionWindow = dimensionWindow;
	}
	
	public void resize(){
		dimensionWindow.beVisible();
	}

	public void setBackgroundImage(String imgFile2) {
		
		map.setBackground(imgFile2);
		
	}

	public void compileMap() {
		map.compileMap();
	}

	public void startSimulation() {
		map.startSimulation();
	}
}
