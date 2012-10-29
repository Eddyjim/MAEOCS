package view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MapWindow extends JFrame{
	
	private MapPanel map;
	private Dimension mapDimension;

	public MapWindow() {
		 setLocation(10, 100);
	     getContentPane().setBackground(Theme.background);
	     setForeground(Theme.foreground);
	     setBackground(Theme.background);
	     getContentPane().setBackground(Theme.black);
	     map = new MapPanel();
	     setEnabled(true);
	}
	
	public void newSize(int width, int height, int gridSize){
		 
	    map.resize(width,height, gridSize);
	    getContentPane().add(map);
	    mapDimension = new Dimension (width+8,height+32);
	    setSize(mapDimension);
	    setResizable(false);
	    setEnabled(true);
	}
}
