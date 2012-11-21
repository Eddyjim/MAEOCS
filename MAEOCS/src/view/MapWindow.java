package view;

import java.awt.Dimension;
import java.io.File;
import java.nio.channels.FileChannel.MapMode;

import javax.swing.JFrame;

import model.MapModel;

/**
 * This class is used to show a new window that will contain the map to edit
 * @author Carlos Gait�n Mora && Edward Jim�nez Mart�nez
 */
@SuppressWarnings("serial")
public class MapWindow extends JFrame{
	
	private MapPanel map;
	private Dimension mapDimension;
	private DimensionsWindow dimensionWindow;
	private String imgFile;
	
	
	public MapWindow(State state) {
		 setLocation(Theme.mapWindowLocation);
	     getContentPane().setBackground(Theme.background);
	     setForeground(Theme.foreground);
	     setBackground(Theme.background);
	     getContentPane().setBackground(Theme.black);
	     map = new MapPanel(state);
	     this.add(map);
	     setEnabled(true);
	     setVisible(true);
	     
	}
	
	public void newSize(int width, int height, int gridSize){
		 
	    map.resize(width,height, gridSize);
	    
	    mapDimension = new Dimension (width+8,height+32);
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
		
		this.imgFile = imgFile2;
		
		map.setBackground(imgFile2);
		
	}
}
